# Task Manager CLI (Java)

A simple and efficient command-line application for managing personal tasks.  
Built in Java as part of a portfolio focused on clean code, modular design, and practical CLI development.

## Features
- Add new tasks
- List all tasks
- Mark tasks as completed
- Delete tasks
- Save and load tasks from a local file (JSON or TXT)
- Clean and simple text-based interface

## Tech Stack
- **Java 21+**
- **Maven** (optional)
- **IntelliJ IDEA Community Edition**

## Project Structure
```md
src/main/java/com/david/taskmanager/
├── Main.java
├── Task.java
├── TaskManager.java
└── FileHandler.java
```

## How to Run
1. Open the project in IntelliJ IDEA.
2. Make sure a valid JDK (21 or later) is configured.
3. Run the `Main` class.
4. The CLI will start in the terminal panel.

## Future Improvements
- Add support for categories and tags
- Improve file storage using JSON libraries (Gson/Jackson)
- Implement task search and filters
- Add colored console output
- Add JUnit tests

## Purpose
This project is part of a personal portfolio to strengthen programming fundamentals in Java and develop real, practical applications.


## Technical Highlights

- Fully object-oriented architecture:
  - Task
  - TaskManager
  - FileHandler
  - Main
- Clean project structure following Maven conventions
- Improved file storage using JSON libraries (Gson/Jackson)
- Custom TypeAdapter for LocalDateTime
- Pretty-printed JSON output
- Safe user input with custom integer reader
- Modular and extensible