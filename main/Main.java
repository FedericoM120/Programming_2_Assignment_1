/* This is part of the starter code!
 * You need to complete this class yourself!*/
package main;
import util.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static boolean checkFirstName(String given){
        if (Character.isUpperCase(given.charAt(0)) && given.matches("[a-zA-Z]+")
                && given.length() > 0) {
            return true;
        }
        return false;

        //if (given.matches("[a-zA-Z]+")) return true
    }
    private static boolean checkLastName(String given){
        int dotCount = given.length() - given.replace(".", "").length();
        if (Character.isUpperCase(given.charAt(0)) && given.matches("[a-zA-Z.]+")
                && given.length() > 0 && dotCount <= 1) {
            return true;
        }
        return false;
    }
    private static boolean checkID(String given){
        if (String.valueOf(given).length() == 7 && given.charAt(0) != 0 && given.length() > 0) {
            return true;
        }
        return false;
    }
    private static boolean checkScore(String given){
        int score = Integer.parseInt(given);
        if (score >= 0 && score <= 100 ){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();
        //input handling phase

        //ask user to enter info of first student via keyboard
        System.out.println("Welcome to my grade book!" + "\n" +
                "Please enter the information of the first student " +
                "using the following format:" + "\n" + "\t" + "\"firstName lastName PID grade\"." +
                "\n" + "Press Enter when you are done.");

        while(true){
            String line = keyboard.nextLine();
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
        while(true){
            System.out.println("Please enter a new command");
            String command = keyboard.nextLine();
            if(command.equals("quit"))
                break;
            if(command.equals("min score")){
                System.out.println(gradebook.minScore());
            }else if(command.equals("min letter")){
                System.out.println(gradebook.minLetter());
            }else if(command.equals("max score")){
                System.out.println(gradebook.maxScore());
            }else if(command.equals("max letter")){
                System.out.println(gradebook.maxLetter());
            }else if(command.equals("average score")){
                System.out.println(gradebook.calculateAvg());
            }else if(command.equals("average letter")){
                System.out.println(gradebook.averageLetter());
            }else if(command.equals("median score")){
                System.out.println(gradebook.calculateMedian());
            }else if(command.equals("median letter")){
                System.out.println(gradebook.getMedianLetter());
            }else if(command.equals("tab score")){
                System.out.println(gradebook.tabScores());
            }else if(command.equals("tab letter")){

            }else if(command.startsWith("change")){

            }else if(command.startsWith("name")){     //prints "please enter a new command" twice
                System.out.println("enter panther ID");
                int pantherID = keyboard.nextInt();
                System.out.println(gradebook.findName(pantherID));
            }else if(command.startsWith("letter")){    //prints "please enter a new command" twice
                System.out.println("enter panther ID");
                int pantherID = keyboard.nextInt();
                System.out.println(gradebook.findLetter(pantherID));
            }else{
                //print an error message "Illegal command, try again"...
            }
        }
    }
}
