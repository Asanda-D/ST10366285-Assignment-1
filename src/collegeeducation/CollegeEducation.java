/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collegeeducation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class CollegeEducation {

    /**
     * @param args the command line arguments
     */
    
    //main class
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean burner = true;

        while (burner) 
        {
            //menu options 
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            System.out.println("Please select one of the following menu items: ");
            System.out.println("(1). Capture a new student.");
            System.out.println("(2). Search for a student.");
            System.out.println("(3). Delete a student.");
            System.out.println("(4). Print student report.");
            System.out.println("(5). Exit application.");

            int choice = scanner.nextInt();
            
            //swicth case to allow user to choose and for simplicity
            switch (choice) 
            {
                case 1:
                    Student.saveStudent(students, scanner);//call all required methodz from Student class into main CollegeEducation class
                    break;
                case 2:
                    Student.searchStudent(students, scanner);
                    break;
                case 3:
                    Student.deleteStudent(students, scanner);
                    break;
                case 4:
                    Student.generateStudentReport(students);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }//end of switch case
            
        }//end of while loop 
        
    }//end of main

}//end of CollegeEducation class

/*
Bibliography
Farrel, J. (2016). JAVA PROGRAMMING. Boston: Cengage Learning.
Farrell, J. (2018). Programming Logic & Design, Comprehensive. Boston: Cengage Learning; 9th edition.
*/