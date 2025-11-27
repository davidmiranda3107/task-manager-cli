package com.david.taskmanager;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        FileHandler fileHandler = new FileHandler();

        List<Task> loadedTasks = fileHandler.loadTasks();
        if (loadedTasks != null) {
            manager.setTasks(loadedTasks);
        }

        System.out.println("Task Manager CLI started...");

        while (true) {
            System.out.println("\n==== Task Manager ====");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Save Tasks");
            System.out.println("6. View Task Details");
            System.out.println("7. Exit");

            int option = readInt(scanner, "Choose an option: ");

            switch (option) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    manager.addTask(title, description);
                    break;

                case 2:
                    manager.listTasks();
                    break;

                case 3:

                    int completedId = readInt(scanner, "Enter task ID to mark completed: ");
                    manager.markAsCompleted(completedId);
                    break;

                case 4:
                    int removeId = readInt(scanner, "Enter task ID to remove: ");
                    manager.removeTask(removeId);
                    break;

                case 5:
                    fileHandler.saveTasks(manager.getTasks());
                    break;

                case 6:
                    int detailId = readInt(scanner, "Enter task ID to view details: ");
                    manager.viewTask(detailId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    fileHandler.saveTasks(manager.getTasks());
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                return number;
            } else {
                System.out.println("Invalid number. Please try again.");
                scanner.nextLine();
            }
        }
    }
}
