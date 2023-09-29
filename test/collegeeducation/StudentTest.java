/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package collegeeducation;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author lab_services_student
 */
public class StudentTest {
    
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    @Before
    public void setUpStreams() 
    {
        // Redirect System.in and System.out to capture user input/output
        System.setIn(new ByteArrayInputStream("".getBytes()));
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @After
    public void restoreStreams() 
    {
        // Restore original System.in and System.out
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testSaveStudent() 
    {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner("10111\nJ.Bloggs\n19\njbloggs@ymail.com\ndisd\n");

        // Prepare input for the test
        String input = "10111\nJ.Bloggs\n19\njbloggs@ymail.com\ndisd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run the saveStudent method
        Student.saveStudent(students, scanner);

        // Assert that the student is saved correctly
        assertEquals(1, students.size());
        Student savedStudent = students.get(0);
        assertEquals(10111, savedStudent.getStudentId());
        assertEquals("J.Bloggs", savedStudent.getStudentName());
        assertEquals(19, savedStudent.getStudentAge());
        assertEquals("jbloggs@ymail.com", savedStudent.getStudentEmail());
        assertEquals("disd", savedStudent.getStudentCourse());
    }

    @Test
    public void testSearchStudent() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd"));
        Scanner scanner = new Scanner("10111\nJ.Bloggs\n19\njbloggs@ymail.com\ndisd\n");

        // Prepare input for the test
        String input = "10111\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the searchStudent method
        Student.searchStudent(students, scanner);

        // Assert that the student details are correctly displayed
        String expectedOutput = "Enter the student ID to search: " +
                                "STUDENT ID FOUND!!!\n" +
                                "STUDENT ID: 10111\n" +
                                "STUDENT NAME: J.Bloggs\n" +
                                "STUDENT AGE: 19\n" +
                                "STUDENT EMAIL: jbloggs@ymail.com\n" +
                                "STUDENT COURSE: disd\n" +
                                "- - - - - - - - - - - - - - - - - - - -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    // Similar test methods can be implemented for the other scenarios

     @Test
    public void testSearchStudent_StudentNotFound() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd"));

        // Simulate user input with a student ID that doesn't exist
        String input = "10111\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the searchStudent method
        Student.searchStudent(students, new Scanner(System.in));

        // Assert that the student not found message is displayed
        String expectedOutput = "Enter the student ID to search: " +
                "Student with Student ID: 10111 was not found!!!\n" +
                "- - - - - - - - - - - - - - - - - - - -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDeleteStudent() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd"));

        // Simulate user input to confirm deletion
        String input = "Yes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the deleteStudent method
        Student.deleteStudent(students, new Scanner(System.in));

        // Assert that the student is deleted successfully
        assertEquals(0, students.size());
        String expectedOutput = "Enter the student ID to delete: " +
                "Are you sure you want to delete student 10111 from the system? (Yes/No): " +
                "Student with Student Id: 10111 WAS deleted!\n" +
                "- - - - - - - - - - - - - - - - - - - -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(10111, "J.Bloggs", 19, "jbloggs@ymail.com", "disd"));

        // Simulate user input with a student ID that doesn't exist for deletion
        String input = "10111\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the deleteStudent method
        Student.deleteStudent(students, new Scanner(System.in));

        // Assert that the student not found message is displayed
        String expectedOutput = "Enter the student ID to delete: " +
                "Student with Student ID: 10111 was not found!\n" +
                "- - - - - - - - - - - - - - - - - - - -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        ArrayList<Student> students = new ArrayList<>();

        // Simulate user input with a valid student age
        String input = "10111\nJ.Bloggs\n19\njbloggs@ymail.com\ndisd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the saveStudent method with a valid age
        Student.saveStudent(students, new Scanner(System.in));

        // Assert that the student is saved correctly
        assertEquals(1, students.size());
        Student savedStudent = students.get(0);
        assertEquals(19, savedStudent.getStudentAge());
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        ArrayList<Student> students = new ArrayList<>();

        // Simulate user input with an invalid (less than 16) student age
        String input = "10111\nJ.Bloggs\n15\njbloggs@ymail.com\ndisd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the saveStudent method with an invalid age
        Student.saveStudent(students, new Scanner(System.in));

        // Assert that the invalid age message is displayed
        String expectedOutput = "You have entered an incorrect student age!!!\n" +
                "Enter the student Age: ";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        ArrayList<Student> students = new ArrayList<>();

        // Simulate user input with an invalid character in student age
        String input = "10111\nJ.Bloggs\nInvalidAge\njbloggs@ymail.com\ndisd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Redirect output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the saveStudent method with an invalid character in age
        Student.saveStudent(students, new Scanner(System.in));

        // Assert that the invalid age message is displayed
        String expectedOutput = "You have entered an incorrect student age!!!\n" +
                "Enter the student Age: ";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
