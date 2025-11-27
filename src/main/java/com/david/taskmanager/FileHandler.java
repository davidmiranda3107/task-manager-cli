package com.david.taskmanager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "tasks.json";
    private final Gson gson;

    public FileHandler() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(
                        java.time.LocalDateTime.class,
                        (com.google.gson.JsonSerializer<java.time.LocalDateTime>) (src, typeOfSrc, context) ->
                                new com.google.gson.JsonPrimitive(src.toString())
                )
                .registerTypeAdapter(
                        java.time.LocalDateTime.class,
                        (com.google.gson.JsonDeserializer<java.time.LocalDateTime>) (json, typeOfT, context) ->
                                java.time.LocalDateTime.parse(json.getAsString())
                )
                .create();
    }

    public void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tasks, writer);
            System.out.println("Tasks saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public List<Task> loadTasks() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            return gson.fromJson(reader, taskListType);
        } catch (IOException e) {
            System.out.println("No existing tasks file found. Starting fresh.");
            return null;
        }
    }
}
