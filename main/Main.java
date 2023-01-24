/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package main;
import util.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Gradebook for classA which stores the students in the class
        Gradebook classAGradeBook = new Gradebook();

        //arrayList which stores all students and returns the students
        ArrayList<Student> studentsClassA = classAGradeBook.getStudents();

        //ask user to enter info of first student via keyboard
        System.out.println("Welcome to my grade book!" + "\n" +
                "Please enter the information of the first student " +
                "using the following format:" + "\n" + "\t" + "\"firstName lastName PID grade\"." +
                "\n" + "Press Enter when you are done.");


        //1. first name needs to inputted by the user
        //2. need to check if first name meets criteria
        //3. if first name meets criteria move on to last name input move to step 5
        //   3B. if first name does not meet criteria ask user to re-input first name
        //4. repeat step 3
        //5. last name needs to be inputted by the user

        //asks user for first name
        String firstName = sc.nextLine();
        boolean exitFirstNameLoop = true;
        while (exitFirstNameLoop == true) {
            if (Character.isUpperCase(firstName.charAt(0)) && firstName.matches("[a-zA-Z]+") &&
            !firstName.contains(" ")) {
                exitFirstNameLoop = false;
                break;
            } else {
                System.out.println("first letter needs to be capitalized and name must contain only letters");
                firstName = sc.nextLine();
            }
        }
        //asks user for last name
        String lastName = sc.nextLine();
        boolean exitLastNameLoop = true;
        while (exitLastNameLoop == true) {
            if (Character.isUpperCase(lastName.charAt(0)) && lastName.matches("[a-zA-Z]+") &&
            !lastName.contains(" ")) {
                exitLastNameLoop = false;
                break;
            } else {
                System.out.println("first letter needs to be capitalized and name must contain only letters");
                lastName = sc.nextLine();
            }
        }

        //asks user for panther ID but if id isn't int then exception gets thrown
        boolean exitPantherIdLoop = true;
        int pantherID = sc.nextInt();
        while (exitPantherIdLoop == true){
            //int pantherID = sc.nextInt();
            String pantherIdString = String.valueOf(pantherID);
            if (String.valueOf(pantherID).length() == 7 && pantherIdString.charAt(0) != 0 &&
            pantherID > 0) {
                exitPantherIdLoop = false;
                break;
            } else {
                System.out.println("Panther ID must be 7 digits long with no leading zeros");
                pantherID = sc.nextInt();
            }
        }

        //asks user for student grade
        int score = sc.nextInt();
        boolean exitScoreLoop = true;
        while (exitScoreLoop == true) {
            if (score >= 0 && score <= 100) {
                exitScoreLoop = false;
                break;
            } else {
                System.out.println("Grade must be a non-negative integer that doesn't exceed 100");
                score = sc.nextInt();
            }
        }
        //assigns score from exitScoreLoop to the grade object
        Grade grade = new Grade(score);


        //creates newStudent object with the user input as its parameters
        Student newStudent = new Student(firstName, lastName, pantherID, grade);
        //adds the newStudent object to the arrayList comprimising of all the student(s)
        studentsClassA.add(newStudent);

        //asks for user to enter a new student repeatedly until "DONE" is entered
        boolean exitLoop = true;
        while (exitLoop == true){
            System.out.println("Please enter the information of the next student using the same format." +
                    "\n" + "If there is no more students, please enter the keyword \"DONE\"" +
                    "\n" + "Press Enter when you are done.");
            String name = sc.nextLine();
            if (name.equals("DONE")) {
                exitLoop = false;
            }

            //second prompt for first name
            firstName = sc.nextLine();
            exitFirstNameLoop = true;
            while (exitFirstNameLoop == true) {
                if (Character.isUpperCase(firstName.charAt(0)) && firstName.matches("[a-zA-Z]+") &&
                        !firstName.contains(" ")) {
                    exitFirstNameLoop = false;
                    break;
                } else {
                    System.out.println("first letter needs to be capitalized and name must contain only letters");
                    firstName = sc.nextLine();
                }
            }

            //second prompt user for last name
            lastName = sc.nextLine();
            exitLastNameLoop = true;
            while (exitLastNameLoop == true) {
                if (Character.isUpperCase(lastName.charAt(0)) && lastName.matches("[a-zA-Z]+") &&
                        !lastName.contains(" ")) {
                    exitLastNameLoop = false;
                    break;
                } else {
                    System.out.println("first letter needs to be capitalized and name must contain only letters");
                    lastName = sc.nextLine();
                }
            }

            //****!! asks user for panther ID but if id isn't int then exception gets thrown !!!!****
            exitPantherIdLoop = true;
            pantherID = sc.nextInt();
            while (exitPantherIdLoop == true){
                //int pantherID = sc.nextInt();
                String pantherIdString = String.valueOf(pantherID);
                if (String.valueOf(pantherID).length() == 7 && pantherIdString.charAt(0) != 0) {
                    exitPantherIdLoop = false;
                    break;
                } else {
                    System.out.println("Panther ID must be 7 digits long with no leading zeros");
                    //pantherID = sc.nextInt();
                }
            }

            //asks user for student grade
            score = sc.nextInt();
            exitScoreLoop = true;
            while (exitScoreLoop == true) {
                if (score >= 0 && score <= 100) {
                    exitScoreLoop = false;
                    break;
                } else {
                    System.out.println("Grade must be a non-negative integer that doesn't exceed 100");
                    score = sc.nextInt();
                }
            }
            //assigns score from exitScoreLoop to the grade object
            grade = new Grade(score);

            //creates newStudent object with the user input as its parameters
            newStudent = new Student(firstName, lastName, pantherID, grade);
            //adds the newStudent object to the arrayList comprimising of all the student(s)
            studentsClassA.add(newStudent);
        }
        classAGradeBook.printAllStudents();
    }
}
