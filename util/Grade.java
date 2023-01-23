/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Grade {
    private int score;
    private String letterGrade;
    public int getScore() {
        return score;
    }
    public String getLetterGrade() {
        return letterGrade;
    }

    public Grade(int score) {
        this.score = score;

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
    }

    //if score >50 = f then assign to lettergrade in grade constructor

    public void setScore(int score) {
        this.score = score;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
}
