/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Grade {
    private int score;    //integer score
    private String letterGrade;  //String letterGrade

    public void setScore(int score) {
        this.score = score;
    }

    public static String scoreToLetter(int score){   //converts score to Letter grade
        if(score > 100)
            System.out.println("Illegal");
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

    public Grade(int score) {  //Grade constructor which passes the score parameter to score field and assigns
                                //letter grade a letter by using the scoreToLetter method
        this.score = score;
        this.letterGrade = scoreToLetter(score);
    }
    public int getScore() {  //gets the score from the constructor

        return score;
    }
    public String getLetterGrade() {  //gets the letter grade from the constructor

        return letterGrade;
    }
}
