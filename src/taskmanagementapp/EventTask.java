/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanagementapp;

/**
 *
 * @author lab_services_student
 */

public class EventTask extends Task {
    private String eventDate;

    public EventTask(String title, String description, int priority, String eventDate) {
        super(title, description, priority);
        this.eventDate = eventDate;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
