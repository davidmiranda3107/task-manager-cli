package com.david.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    public void addTask(String title, String description) {
        Task task = new Task(nextId, title, description, false);
        tasks.add(task);
        nextId++;
        System.out.println("Task added: " + title);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task.getId() + ". [" + (task.isCompleted() ? "X" : " ") + "] " + task.getTitle());
        }
    }

    public void markAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Task marked as completed: " + task.getTitle());
                return;
            }
        }
        System.out.println("Task not found with ID: " + id);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task removed with ID: " + id);
    }

    public void viewTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println("\n--- Task Details ---");
                System.out.println("ID: " + task.getId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
                System.out.println("Created: " + task.getCreatedAt());
                return;
            }
        }
        System.out.println("Task not found with ID: " + id);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        nextId = tasks.stream().mapToInt(Task::getId).max().orElse(0) + 1;
    }

}
