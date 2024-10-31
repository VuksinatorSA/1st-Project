/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject8;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author RC_Student_lab
 */
public class Mavenproject8 {

    public static class Login {

        public static void main(String[] args) {
            String Username = "";
            String password = "";
            String register = "";
            String login = "";
            String name = "";
            String surname = "";

            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to Stratcom Solutions. To successfully register your profile with us, kindly fill in the required information.");

            System.out.print("Please enter your first name: ");
            name = sc.nextLine();
            System.out.print("Please enter your last name: ");
            surname = sc.nextLine();
            System.out.print("Please enter your username (must contain an underscore): ");
            Username = sc.nextLine();

            if (checkUserName(Username) && checkPasswordComplexity(password)) {
                registerUser(register);
                loginUser(login);
            }
        }

        public static boolean checkUserName(String username) {
            if (username.contains("_") && username.length() >= 3) {
                System.out.println("Username successfully captured.");
                return true;
            } else {
                System.out.println("Username is not correctly formatted. Please ensure that the username contains an underscore and is no less than 3 characters in length.");
                return false;
            }
        }

        public static boolean checkPasswordComplexity(String password) {
            String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,}$";
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your password: ");
            password = sc.nextLine();

            if (password.matches(regex)) {
                System.out.println("Password successfully captured.");
                return true;
            } else {
                System.out.println("Password is not correctly formatted. Ensure it has at least 8 characters, a capital letter, a number, and a special character.");
                return false;
            }
        }

        public static String registerUser(String user) {
            String Username = "";
            String pass = "";

            if (checkUserName(Username) && checkPasswordComplexity(pass)) {
                System.out.println("User successfully registered.");
                return Username;
            } else {
                System.out.println("User cannot be registered!");
                return "";
            }
        }

        public static boolean loginUser(String user) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Welcome back! Please enter your username: ");
            String Username = sc.nextLine();

            System.out.print("Please enter your password: ");
            String password = sc.nextLine();

            if (checkUserName(Username) && checkPasswordComplexity(password)) {
                System.out.println("Successful login!");
                return true;
            } else {
                System.out.println("Incorrect username or password.");
                return false;
            }
        }

        public static String returnLoginStatus() {
            String names = "";
            String surname = "";

            if (checkUserName(names)) {
                System.out.println("Welcome " + names + " " + surname + ", it is great to see you again.");
                return names;
            } else {
                System.out.println("Username or password incorrect. Please try again.");
                return "";
            }
        }
    }

    public static class Task {
        private final String taskName;
        private final int taskNumber;
        private final String taskDescription;
        private final String developerFirstName;
        private final String developerLastName;
        private final int taskDuration;
        private String taskStatus;

        public Task(String taskName, int taskNumber, String taskDescription,
                    String developerFirstName, String developerLastName, int taskDuration) {
            this.taskName = taskName;
            this.taskNumber = taskNumber;
            this.taskDescription = taskDescription;
            this.developerFirstName = developerFirstName;
            this.developerLastName = developerLastName;
            this.taskDuration = taskDuration;
        }

        public boolean checkTaskDescription() {
            return taskDescription.length() <= 50;
        }

        public String createTaskID() {
            String firstTwoLettersOfTaskName = taskName.substring(0, 2).toUpperCase();
            String lastThreeLettersOfDeveloper = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3).toUpperCase() : "XXX";
            return firstTwoLettersOfTaskName + ":" + taskNumber + ":" + lastThreeLettersOfDeveloper;
        }

        public String printTaskDetails() {
            return "Task Status: " + taskStatus + "\n" +
                   "Developer: " + developerFirstName + " " + developerLastName + "\n" +
                   "Task Number: " + taskNumber + "\n" +
                   "Task Name: " + taskName + "\n" +
                   "Task Description: " + taskDescription + "\n" +
                   "Task ID: " + createTaskID() + "\n" +
                   "Task Duration: " + taskDuration + " hours";
        }

        public int returnTotalHours() {
            return taskDuration;
        }

        public void setTaskStatus(String status) {
            this.taskStatus = status;
        }
    }
}
