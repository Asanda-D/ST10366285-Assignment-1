/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegeeducation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */

public class Student {
    //declarations of variables
    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentCourse;

    // Constructor
    public Student(int id, String name, int age, String email, String course) 
    {
        studentId = id;
        studentName = name;
        studentAge = age;
        studentEmail = email;
        studentCourse = course;
    }

    // Save student method to capture details
    public static void saveStudent(ArrayList<Student> students, Scanner scanner)//list for an object/class 
    {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("****************************");
        
        //ask user to enter student details
        System.out.print("Enter the student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();//Consume new line
        
        System.out.print("Enter the student Name: ");
        String name = scanner.nextLine();

        int age = 0;//initializing variable
        while (true) 
        {
            try 
            {
                System.out.print("Enter the student Age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age < 16) 
                {
                    System.out.println("You have entered an incorrect student age!!!");
                    continue;
                }//end of if statement
                break;
            } catch (NumberFormatException e) 
            {
                System.out.println("You have entered an incorrect student age!!!");
            }//end of try catch statement
        }//end of while statement

        System.out.print("Enter the student Email: ");
        String email = scanner.nextLine();
        
        scanner.nextLine();//Consume new line

        System.out.print("Enter the student Course: ");
        String course = scanner.nextLine();

        Student newStudent = new Student(id, name, age, email, course);
        students.add(newStudent);//save student details into variable

        System.out.println("Student details saved successfully.");
    }//end of saveStudent method

    // Search student method by ID
    public static void searchStudent(ArrayList<Student> students, Scanner scanner)//list for an object/class  
    {
        System.out.print("Enter the student ID to search: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Student student : students) 
        {
            if (student.getStudentId() == id) 
            {
                System.out.println("STUDENT ID FOUND!!!");
                System.out.println("STUDENT ID: " + student.getStudentId());
                System.out.println("STUDENT NAME: " + student.getStudentName());
                System.out.println("STUDENT AGE: " + student.getStudentAge());
                System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
                System.out.println("STUDENT COURSE: " + student.getStudentCourse());
                found = true;
                break;
            }//end of if statement
        }//end of for loop

        if (!found) 
        {
            System.out.println("Student with Student ID: " + id + " was not found!!!");
        }//end of if statement

        System.out.println("- - - - - - - - - - - - - - - - - - - -");
    }//end of searchStudent method

    // Delete student method by ID
    public static void deleteStudent(ArrayList<Student> students, Scanner scanner)//list for an object/class  
    {
    System.out.print("Enter the student ID to delete: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consume the newline

    boolean found = false;
    for (Student student : students) 
    {
        if (student.getStudentId() == id) 
        {
            System.out.print("Are you sure you want to delete student " + id + " from the system? (Yes/No): ");
            String confirm = scanner.nextLine(); // Read the entire line

            if (confirm.equalsIgnoreCase("Yes") || confirm.equalsIgnoreCase("Y")) 
            {
                students.remove(student);
                System.out.println("Student with Student Id: " + id + " WAS deleted!");
            } else 
            {
                System.out.println("Deletion canceled.");
            }//end of if statement
            found = true;
            break;
        }//end of if statement
    }//end of for loop

    if (!found) 
    {
        System.out.println("Student with Student Id: " + id + " was not found!");
    }//end of if statement

    System.out.println("- - - - - - - - - - - - - - - - - - - -");
    }//end of deleteStudent method

    // Generate student report method
    public static void generateStudentReport(ArrayList<Student> students)//list for an object/class  
    {
        System.out.println("STUDENT REPORT");
        System.out.println("----------------------------");
        for (int i = 0; i < students.size(); i++) 
        {
            Student student = students.get(i);
            System.out.println("STUDENT " + (i + 1));
            System.out.println("----------------------------");
            System.out.println("STUDENT ID: " + student.getStudentId());
            System.out.println("STUDENT NAME: " + student.getStudentName());
            System.out.println("STUDENT AGE: " + student.getStudentAge());
            System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
            System.out.println("STUDENT COURSE: " + student.getStudentCourse());
            System.out.println("----------------------------");
        }//end of for loop
    }//end of generateStudentReport method

    // Getter methods for student attributes
    public int getStudentId() 
    {
        return studentId;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    public int getStudentAge() 
    {
        return studentAge;
    }

    public String getStudentEmail() 
    {
        return studentEmail;
    }

    public String getStudentCourse() 
    {
        return studentCourse;
    }
}//end of Student class