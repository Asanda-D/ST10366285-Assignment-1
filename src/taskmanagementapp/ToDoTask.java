/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagementapp;

/**
 *
 * @author lab_services_student
 */


public class ToDoTask extends Task {
    private String dueDate;

    public ToDoTask(String title, String description, int priority, String dueDate) {
        super(title, description, priority);
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
