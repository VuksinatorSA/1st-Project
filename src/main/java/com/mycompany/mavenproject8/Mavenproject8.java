import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {

    // Login class for user authentication
    public static class Login {

        private static String username = "";
        private static String password = "";

        public static boolean login() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to Stratcom Solutions Task Manager!");

            System.out.print("Register - Enter username (must contain an underscore): ");
            username = sc.nextLine();
            if (!checkUserName(username)) {
                return false;
            }

            System.out.print("Register - Enter password (8+ characters, include uppercase, digit, special char): ");
            password = sc.nextLine();
            if (!checkPasswordComplexity(password)) {
                return false;
            }

            System.out.println("Registration successful!");

            // Simulate Login
            System.out.print("Login - Enter username: ");
            String loginUsername = sc.nextLine();
            System.out.print("Login - Enter password: ");
            String loginPassword = sc.nextLine();

            if (username.equals(loginUsername) && password.equals(loginPassword)) {
                System.out.println("Login successful! Welcome " + username + ".");
                return true;
            } else {
                System.out.println("Login failed. Incorrect username or password.");
                return false;
            }
        }

        private static boolean checkUserName(String username) {
            if (username.contains("_") && username.length() >= 3) {
                return true;
            } else {
                System.out.println("Invalid username. It must contain an underscore and be at least 3 characters long.");
                return false;
            }
        }

        private static boolean checkPasswordComplexity(String password) {
            String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,}$";
            if (password.matches(regex)) {
                return true;
            } else {
                System.out.println("Invalid password. It must have at least 8 characters, a capital letter, a number, and a special character.");
                return false;
            }
        }
    }

    // TaskManager class for task operations
    public static class TaskManager {

        // Arrays to store task information
        private static ArrayList<String> developers = new ArrayList<>();
        private static ArrayList<String> taskNames = new ArrayList<>();
        private static ArrayList<String> taskIDs = new ArrayList<>();
        private static ArrayList<Integer> taskDurations = new ArrayList<>();
        private static ArrayList<String> taskStatuses = new ArrayList<>();

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

            String taskID = taskName.substring(0, 2).toUpperCase() + "_" + (taskIDs.size() + 1);

            developers.add(developerName);
            taskNames.add(taskName);
            taskIDs.add(taskID);
            taskDurations.add(taskDuration);
            taskStatuses.add(taskStatus);

            System.out.println("Task '" + taskName + "' added successfully with ID: " + taskID);
        }

        public static void displayTasksWithStatusDone() {
            System.out.println("\nTasks with Status 'Done':");
            for (int i = 0; i < taskStatuses.size(); i++) {
                if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                    System.out.printf("Developer: %s, Task: %s, Duration: %d hours%n",
                            developers.get(i), taskNames.get(i), taskDurations.get(i));
                }
            }
        }

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

            System.out.printf("Task with Longest Duration: Developer: %s, Duration: %d hours%n",
                    developers.get(maxDurationIndex), taskDurations.get(maxDurationIndex));
        }

        public static void searchTaskByName() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the task name to search: ");
            String searchName = scanner.nextLine();

            for (int i = 0; i < taskNames.size(); i++) {
                if (taskNames.get(i).equalsIgnoreCase(searchName)) {
                    System.out.printf("Task Found: Task: %s, Developer: %s, Status: %s%n",
                            taskNames.get(i), developers.get(i), taskStatuses.get(i));
                    return;
                }
            }
            System.out.println("Task not found.");
        }

        public static void searchTasksByDeveloper() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the developer name to search: ");
            String developerName = scanner.nextLine();

            boolean found = false;
            for (int i = 0; i < developers.size(); i++) {
                if (developers.get(i).equalsIgnoreCase(developerName)) {
                    System.out.printf("Task: %s, Status: %s%n", taskNames.get(i), taskStatuses.get(i));
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No tasks found for this developer.");
            }
        }

        public static void deleteTaskByName() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the task name to delete: ");
            String taskNameToDelete = scanner.nextLine();

            for (int i = 0; i < taskNames.size(); i++) {
                if (taskNames.get(i).equalsIgnoreCase(taskNameToDelete)) {
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

        public static void displayAllTasks() {
            System.out.println("\nAll Captured Tasks:");
            for (int i = 0; i < taskIDs.size(); i++) {
                System.out.printf("Task ID: %s, Developer: %s, Task: %s, Duration: %d hours, Status: %s%n",
                        taskIDs.get(i), developers.get(i), taskNames.get(i), taskDurations.get(i), taskStatuses.get(i));
            }
        }

        public static void mainMenu() {
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
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addTask();
                    case 2 -> displayTasksWithStatusDone();
                    case 3 -> displayLongestTask();
                    case 4 -> searchTaskByName();
                    case 5 -> searchTasksByDeveloper();
                    case 6 -> deleteTaskByName();
                    case 7 -> displayAllTasks();
                    case 8 -> {
                        System.out.println("Exiting Task Manager. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        if (Login.login()) {
            TaskManager.mainMenu();
        } else {
            System.out.println("Exiting application. Registration/Login failed.");
        }
    }
}
