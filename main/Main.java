/* This is part of the starter code!
 * You need to complete this class yourself!*/
package main;
import util.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    //method to check if first name is valid
    private static boolean checkFirstName(String given){ //check if first letter is uppercase and that string is not empty
        if (Character.isUpperCase(given.charAt(0)) && given.matches("[a-zA-Z]+")
                && given.length() > 0) {
            return true;
        }
        //return false if any of the above conditions are not met
        return false;
    }
    //method to check if last name input is valid
    private static boolean checkLastName(String given){
        //count the number of dots in a string
        int dotCount = given.length() - given.replace(".", "").length();
        //Check if the first letter is an uppercase character, the string only contains alphabetical characters
        //and dots, and that the length of the string is not empty. Also, check if there are at most 1 dots
        if (Character.isUpperCase(given.charAt(0)) && given.matches("[a-zA-Z.]+")
                && given.length() > 0 && dotCount <= 1) {
            return true;
        }
        //return false if any of the above conditions are not met
        return false;
    }
    //method to check if the input ID is valid
    private static boolean checkID(String given){
        //Check if the string length is 7 and if the first character is not 0 and if the length of the string is not 0
        if (String.valueOf(given).length() == 7 && given.charAt(0) != 0 && given.length() > 0) {
            return true;
        }
        //Return false if any of the above conditions are not met
        return false;
    }
    //Method to check if the given score is valid
    private static boolean checkScore(String given){
        //Convert the score from string to integer
        int score = Integer.parseInt(given);
        //Check if the score is between 0 and 100
        if (score >= 0 && score <= 100 ){
            return true;
        }
        //Return false if the score is outside the range
        return false;
    }
    //main method
    public static void main(String[] args) {
        //Create a new Scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);
        //Create a new gradebook object
        Gradebook gradebook = new Gradebook();
        //input handling phase

        //ask user to enter info of first student via keyboard
        System.out.println("Welcome to my grade book!" + "\n" +
                "Please enter the information of the first student " +
                "using the following format:" + "\n" + "\t" + "\"firstName lastName PID grade\"." +
                "\n" + "Press Enter when you are done.");
        //While loop to continuously prompt the user to enter student information until they enter "DONE"
        while(true){
            //Get the line of input from the user
            String line = keyboard.nextLine();
            //If the user enters "DONE", break out of the loop
            if(line.equals("DONE"))
                break;
            String[] tokens = line.split(" ");
            if(tokens.length != 4){
                System.out.println("Please make sure there are no more than four spaces");
                continue;
            }
            if(!checkFirstName(tokens[0])){
                System.out.println("First name should be a single word containing only alphabetical characters starting" +
                        " with a capital letter and not include any white space.");
                continue;
            }
            if(!checkLastName(tokens[1])){
                System.out.println("Last name should be a single word containing only alphabetical characters starting" +
                        " with a capital letter and not include any white space. Last name may contain at most " +
                        "one dot ('.')");
                continue;
            }
            if(!checkID(tokens[2])){
                System.out.println("Panther ID must be 7 digits long with no leading zeros");
                continue;
            }
            if(!checkScore(tokens[3])){
                System.out.println("Grade must be a non-negative integer that is greater than or equal to 0" +
                        " or less than or equal to 100");
                continue;
            }
            Student student = new Student(tokens[0],tokens[1],Integer.parseInt(tokens[2]),
                    new Grade(Integer.parseInt(tokens[3])));
            gradebook.addStudent(student);

            System.out.println("Please enter the information of the next student using the same format." +
                    "\n" + "If there is no more students, please enter the keyword \"DONE\"" +
                    "\n" + "Press Enter when you are done.");
        }
        //command handling phase
        // Loop through and accept user commands until 'quit' is entered
        while(true){
            System.out.println("Please enter a new command, enter quit to exit");
            String command = keyboard.nextLine();
            // Check if user wants to exit
            if(command.equals("quit"))
                break;
            // Check if user wants to get the minimum score
            if(command.equals("min score")){
                System.out.println(gradebook.minScore());
                // Check if user wants to get the minimum letter grade
            }else if(command.equals("min letter")){
                System.out.println(gradebook.minLetter());
                // Check if user wants to get the maximum score
            }else if(command.equals("max score")){
                System.out.println(gradebook.maxScore());
                // Check if user wants to get the maximum letter grade
            }else if(command.equals("max letter")){
                System.out.println(gradebook.maxLetter());
                // Check if user wants to get the average score
            }else if(command.equals("average score")){
                System.out.println(gradebook.calculateAvg());
                // Check if user wants to get the average score
            }else if(command.equals("average letter")){
                System.out.println(gradebook.averageLetter());
                // Check if user wants to get the median score
            }else if(command.equals("median score")){
                System.out.println(gradebook.calculateMedian());
                // Check if user wants to get the median letter grade
            }else if(command.equals("median letter")){
                System.out.println(gradebook.getMedianLetter());
                // Check if user wants to tabulate scores
            }else if(command.equals("tab score")){
                gradebook.tabScores();
            }else if(command.equals("tab letter")){
                // Check if user wants to tabulate letter grades
                gradebook.tabLetter();
                // Check if user wants to change a student's grade
            }else if(command.startsWith("change")){
                System.out.println("Enter Panther ID and new grade");
                // Accept user input for the student's Panther ID and new grade
                String input = keyboard.nextLine();
                String[] values = input.split(" ");
                int pantherID;
                int newGrade;
                // Check if input is valid
                if (values.length < 2 || values[0].isEmpty() || Integer.parseInt(values[1]) > 100 || Integer.parseInt(values[1]) < 0) {
                    System.out.println("Please enter a grade less than or equal to 100 and greater than or " +
                            "equal to 0");
                } else {
                     pantherID = Integer.parseInt(values[0]);
                     newGrade = Integer.parseInt(values[1]);
                    gradebook.change(pantherID, newGrade);
                }
                // Check if user wants to find a student's name
            }else if(command.startsWith("name")){
                System.out.println("enter panther ID");
                int pantherID = keyboard.nextInt();
                System.out.println(gradebook.findName(pantherID));
                // check if user wants to find the letter grade of a user with given panther ID
            }else if(command.startsWith("letter")){
                System.out.println("enter panther ID");
                int pantherID = keyboard.nextInt();
                System.out.println(gradebook.findLetter(pantherID));
                // if no legal commands are given print "illegal command, try again..."
            }else{
                System.out.println("\"Illegal command, try again\"...");
            }
        }
    }
}
