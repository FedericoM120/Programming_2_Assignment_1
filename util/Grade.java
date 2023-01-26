/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Grade {
    private int score;
    private String letterGrade;
    public static String scoreToLetter(int score){
        if(score > 100)
            letterGrade = "Illegal";
        if(score >= 90)
            letterGrade = "A";
        if(score >= 85)
            letterGrade = "A-";
        if(score >= 80)
            letterGrade = "B+";
        if(score >= 75)
            letterGrade = "B";
        if(score >= 70)
            letterGrade = "B-";
        if(score >= 65)
            letterGrade = "C+";
        if(score >= 60)
            letterGrade = "C";
        if(score >= 50)
            letterGrade = "D";
        if(score >=0)
            letterGrade = "F";
        return "f"; //delete later
    }

    public Grade(int score) {
        this.score = score;
        this.letterGrade = scoreToLetter(score);
    }
    public int getScore() {
        return score;
    }
    public String getLetterGrade() {
        return letterGrade;
    }
}
