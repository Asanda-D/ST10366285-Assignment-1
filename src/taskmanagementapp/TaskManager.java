/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagementapp;

import java.util.ArrayList;

/**
 *
 * @author lab_services_student
 */
public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Task " + (i + 1));
                tasks.get(i).displayTaskDetails();
                System.out.println();
            }
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }
    
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    
}

