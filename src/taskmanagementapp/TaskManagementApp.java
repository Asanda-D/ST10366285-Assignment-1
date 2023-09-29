/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmanagementapp;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class TaskManagementApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean value = true;

        while (value) {
            System.out.println("WELOCOME TO TASK MANAGEMENT SYSTEM");
            System.out.println("-----------------------------------");
            System.out.print("Please enter your choice: \n");
            System.out.println("1 - Add Task");
            System.out.println("2 - List Tasks");
            System.out.println("3 - Remove Task");
            System.out.println("4 - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Please enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Please enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Please enter task priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Please Select Task Type:");
                    System.out.println("1. ToDo Task");
                    System.out.println("2. Event Task");
                    int taskTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (taskTypeChoice == 1) {
                        System.out.print("Enter due date (YYYY-MM-DD): ");
                        String dueDate = scanner.nextLine();
                        ToDoTask todoTask = new ToDoTask(title, description, priority, dueDate);
                        taskManager.addTask(todoTask);
                    } else if (taskTypeChoice == 2) {
                        System.out.print("Enter event date (YYYY-MM-DD): ");
                        String eventDate = scanner.nextLine();
                        EventTask eventTask = new EventTask(title, description, priority, eventDate);
                        taskManager.addTask(eventTask);
                    } else {
                        System.out.println("Invalid task type choice.");
                    }
                    System.out.println("Task successfully ");
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to remove: ");
                    int indexToRemove = scanner.nextInt();
                    taskManager.removeTask(indexToRemove - 1);
                    System.out.println("Task: " + indexToRemove + " has been successfully removed");
                    break;
                case 4:
                    System.out.println("Exiting Task Management System.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
/*
Bibliography
Farrel, J. (2016). JAVA PROGRAMMING. Boston: Cengage Learning.
Farrell, J. (2018). Programming Logic & Design, Comprehensive. Boston: Cengage Learning; 9th edition.
*/