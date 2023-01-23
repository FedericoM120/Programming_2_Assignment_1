/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
	public ArrayList<Student> getStudents(){
		return listOfStudents;
	}
    private ArrayList<Student> listOfStudents;

	public Gradebook() {
		listOfStudents = new ArrayList<Student>();
	}



	public double calculateAvg() {
	double sum = 0;
	for(Student s: listOfStudents)
	    sum += s.getGrade().getScore();
	return sum / listOfStudents.size();
    }
    public float calculateMedian() {
	int i = 0, n = listOfStudents.size();
	int[] scores = new int[n];
	for(Student s: listOfStudents)
	    scores[i++] = s.getGrade().getScore();
	Arrays.sort(scores);
	if (n % 2 == 0)
	    return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
	else
	    return scores[n / 2];
    }
    public void printAllStudents() {
	for(Student s: listOfStudents)
	    System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
}