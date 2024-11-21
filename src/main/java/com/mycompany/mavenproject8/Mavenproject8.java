
import java.util.ArrayList; 

import java.util.Scanner; 

  

public class TaskManager { 

  

    // Arrays to store task information 

    private static ArrayList<String> developers = new ArrayList<>(); 

    private static ArrayList<String> taskNames = new ArrayList<>(); 

    private static ArrayList<String> taskIDs = new ArrayList<>(); 

    private static ArrayList<Integer> taskDurations = new ArrayList<>(); 

    private static ArrayList<String> taskStatuses = new ArrayList<>(); 

  

    // Method to add a new task 

    public static void addTask() { 

        Scanner scanner = new Scanner(System.in); 

  

        System.out.print("Enter developer name: "); 

        String developerName = scanner.nextLine(); 

  

        System.out.print("Enter task name: "); 

        String taskName = scanner.nextLine(); 

  

        System.out.print("Enter task duration (in hours): "); 

        int taskDuration = scanner.nextInt(); 

        scanner.nextLine(); // Consume newline 

  

        System.out.print("Enter task status (e.g., To Do, In Progress, Done): "); 

        String taskStatus = scanner.nextLine(); 

  

        // Generate a unique task ID 

        String taskID = taskName.substring(0, 2).toUpperCase() + "_" + (taskIDs.size() + 1); 

  

        // Add data to the arrays 

        developers.add(developerName); 

        taskNames.add(taskName); 

        taskIDs.add(taskID); 

        taskDurations.add(taskDuration); 

        taskStatuses.add(taskStatus); 

  

        System.out.println("Task '" + taskName + "' added successfully with ID: " + taskID); 

    } 

  

    // a. Display all tasks with status "Done" 

    public static void displayTasksWithStatusDone() { 

        System.out.println("\nTasks with Status 'Done':"); 

        System.out.printf("%-20s %-20s %-10s%n", "Developer", "Task Name", "Duration"); 

        System.out.println("-----------------------------------------------"); 

  

        for (int i = 0; i < taskStatuses.size(); i++) { 

            if (taskStatuses.get(i).equalsIgnoreCase("Done")) { 

                System.out.printf("%-20s %-20s %-10d%n", developers.get(i), taskNames.get(i), taskDurations.get(i)); 

            } 

        } 

    } 

  

    // b. Display the Developer and Duration of the task with the longest duration 

    public static void displayLongestTask() { 

        if (taskDurations.isEmpty()) { 

            System.out.println("No tasks available."); 

            return; 

        } 

  

        int maxDurationIndex = 0; 

        for (int i = 1; i < taskDurations.size(); i++) { 

            if (taskDurations.get(i) > taskDurations.get(maxDurationIndex)) { 

                maxDurationIndex = i; 

            } 

        } 

  

        System.out.println("\nTask with Longest Duration:"); 

        System.out.println("Developer: " + developers.get(maxDurationIndex)); 

        System.out.println("Duration: " + taskDurations.get(maxDurationIndex) + " hours"); 

    } 

  

    // c. Search for a task by name and display its details 

    public static void searchTaskByName() { 

        Scanner scanner = new Scanner(System.in); 

  

        System.out.print("Enter the task name to search: "); 

        String searchName = scanner.nextLine(); 

  

        for (int i = 0; i < taskNames.size(); i++) { 

            if (taskNames.get(i).equalsIgnoreCase(searchName)) { 

                System.out.println("\nTask Found:"); 

                System.out.println("Task Name: " + taskNames.get(i)); 

                System.out.println("Developer: " + developers.get(i)); 

                System.out.println("Status: " + taskStatuses.get(i)); 

                return; 

            } 

        } 

  

        System.out.println("Task not found."); 

    } 

  

    // d. Search for tasks assigned to a developer 

    public static void searchTasksByDeveloper() { 

        Scanner scanner = new Scanner(System.in); 

  

        System.out.print("Enter the developer name to search: "); 

        String developerName = scanner.nextLine(); 

  

        System.out.println("\nTasks Assigned to " + developerName + ":"); 

        System.out.printf("%-20s %-15s%n", "Task Name", "Status"); 

        System.out.println("--------------------------------"); 

  

        boolean found = false; 

        for (int i = 0; i < developers.size(); i++) { 

            if (developers.get(i).equalsIgnoreCase(developerName)) { 

                System.out.printf("%-20s %-15s%n", taskNames.get(i), taskStatuses.get(i)); 

                found = true; 

            } 

        } 

  

        if (!found) { 

            System.out.println("No tasks found for this developer."); 

        } 

    } 

  

    // e. Delete a task by its name 

    public static void deleteTaskByName() { 

        Scanner scanner = new Scanner(System.in); 

  

        System.out.print("Enter the task name to delete: "); 

        String taskNameToDelete = scanner.nextLine(); 

  

        for (int i = 0; i < taskNames.size(); i++) { 

            if (taskNames.get(i).equalsIgnoreCase(taskNameToDelete)) { 

                // Remove task details from all arrays 

                developers.remove(i); 

                taskNames.remove(i); 

                taskIDs.remove(i); 

                taskDurations.remove(i); 

                taskStatuses.remove(i); 

  

                System.out.println("Task '" + taskNameToDelete + "' deleted successfully."); 

                return; 

            } 

        } 

  

        System.out.println("Task not found."); 

    } 

  

    // f. Display all captured tasks 

    public static void displayAllTasks() { 

        System.out.println("\nAll Captured Tasks:"); 

        System.out.printf("%-10s %-20s %-20s %-10s %-15s%n", "Task ID", "Developer", "Task Name", "Duration", "Status"); 

        System.out.println("-----------------------------------------------------------------------------------"); 

  

        for (int i = 0; i < taskIDs.size(); i++) { 

            System.out.printf("%-10s %-20s %-20s %-10d %-15s%n", 

                    taskIDs.get(i), developers.get(i), taskNames.get(i), taskDurations.get(i), taskStatuses.get(i)); 

        } 

    } 

  

    // Main menu 

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

  

        while (true) { 

            System.out.println("\nTask Manager"); 

            System.out.println("1. Add Task"); 

            System.out.println("2. Display Tasks with Status 'Done'"); 

            System.out.println("3. Display Longest Task"); 

            System.out.println("4. Search Task by Name"); 

            System.out.println("5. Search Tasks by Developer"); 

            System.out.println("6. Delete Task by Name"); 

            System.out.println("7. Display All Tasks"); 

            System.out.println("8. Exit"); 

            System.out.print("Enter your choice: "); 

  

            int choice = scanner.nextInt(); 

            scanner.nextLine(); // Consume newline 

  

            switch (choice) { 

                case 1: 

                    addTask(); 

                    break; 

                case 2: 

                    displayTasksWithStatusDone(); 

                    break; 

                case 3: 

                    displayLongestTask(); 

                    break; 

                case 4: 

                    searchTaskByName(); 

                    break; 

                case 5: 

                    searchTasksByDeveloper(); 

                    break; 

                case 6: 

                    deleteTaskByName(); 

                    break; 

                case 7: 

                    displayAllTasks(); 

                    break; 

                case 8: 

                    System.out.println("Exiting Task Manager. Goodbye!"); 

                    return; 

                default: 

                    System.out.println("Invalid choice. Please try again."); 

            } 

        } 

    } 

} 
