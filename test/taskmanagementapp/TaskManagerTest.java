/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package taskmanagementapp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author lab_services_student
 */
public class TaskManagerTest {
    
     @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("Test Task", "Test Description", 3);
        
        taskManager.addTask(task);
        
        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Test Task 1", "Test Description 1", 3);
        Task task2 = new Task("Test Task 2", "Test Description 2", 2);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeTask(0); // Remove the first task

        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testListTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Test Task 1", "Test Description 1", 3);
        Task task2 = new Task("Test Task 2", "Test Description 2", 2);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Capture the output of listTasks() for testing
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        taskManager.listTasks();

        String expectedOutput = "Tasks:\n" +
                "Task 1\n" +
                "Title: Test Task 1\n" +
                "Description: Test Description 1\n" +
                "Priority: 3\n\n" +
                "Task 2\n" +
                "Title: Test Task 2\n" +
                "Description: Test Description 2\n" +
                "Priority: 2\n\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}
