/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;
//class grade stores a students score and letter grade
public class Grade {
    //private integer variable to store the score
    private int score;
    //private String variable to store the letter grade
    private String letterGrade;
    //method that allows to set the score value
    public void setScore(int score) {
        this.score = score;
    }
//static method which takes an integer score input and returns the matching letter grade
    public static String scoreToLetter(int score){
        //uses if statements to determine the letter grade based on the score
        if(score > 100)
            System.out.println("Score must not be greater than 100");
        if(score >= 90){
            return "A";
        }
        if(score >= 85) {
            return "A-";
        }
        if(score >= 80) {
            return "B+";
        }
        if(score >= 75) {
            return "B";
        }
        if(score >= 70) {
            return "B-";
        }
        if(score >= 65) {
            return "C+";
        }
        if(score >= 60) {
            return "C";
        }
        if(score >= 50) {
            return "D";
        }
            return "F";
    }
    //grade constructor take integer score as input and tset the score value to the score field
    public Grade(int score) {  //Grade constructor which passes the score parameter to score field and assigns
                                //letter grade a letter by using the scoreToLetter method
        this.score = score;
        this.letterGrade = scoreToLetter(score);
    }
    //returns the score
    public int getScore() {  //gets the score from the constructor

        return score;
    }
    //returns the letter grade
    public String getLetterGrade() {  //gets the letter grade from the constructor

        return letterGrade;
    }
    //returns the score as a string
    public String toString() {
        return  Integer.toString(score);
    }
}
