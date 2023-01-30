/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
	public Gradebook(){			// constructor for Gradebook which assigns the arraylsit listofStudents to new
								// instances of Gradebook?
		listOfStudents = new ArrayList<Student>();
	}
	private ArrayList<Student> listOfStudents;
	public void addStudent(Student student){
		listOfStudents.add(student);
	}
	public double calculateAvg() {
		double sum = 0;
		for(Student s: listOfStudents)
			sum += s.getGrade().getScore();
		return sum / listOfStudents.size();
	}

	public String averageLetter() {
		int sum = 0;
		for(Student s: listOfStudents)
			sum += s.getGrade().getScore();
		int average = sum / listOfStudents.size();
		return Grade.scoreToLetter(average);
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

	public float getMedianLetter() {
		int i = 0, n = listOfStudents.size();
		int[] scores = new int[n];
		float medianLetter;
		for(Student s: listOfStudents)
			scores[i++] = s.getGrade().getScore();
		Arrays.sort(scores);
		if (n % 2 == 0) {
			medianLetter = (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
		}
		else {
			medianLetter =  scores[n / 2];
		}
		return medianLetter;
	}
	public void printAllStudents() {
		for(Student s: listOfStudents)
			System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
	}

	public double minScore() {
		int minScore = 100;
		for (Student s: listOfStudents) {
			if (minScore > s.getGrade().getScore()) {
				minScore = s.getGrade().getScore();
			}
		}
		return minScore;
	}

	public double maxScore() {
		int maxScore = 0;
		for (Student s: listOfStudents) {
			if (maxScore < s.getGrade().getScore()){
				maxScore = s.getGrade().getScore();
			}
		}
		return maxScore;
	}

	public String minLetter() {
		int minScore = 100;
		for (Student s: listOfStudents) {
			int currentScore = s.getGrade().getScore();
			if (minScore > s.getGrade().getScore()) {
				minScore = s.getGrade().getScore();
			}
		}
		return Grade.scoreToLetter(minScore);
	}

	public String maxLetter(){
		int maxScore = 0;
		for (Student s: listOfStudents) {
			if (maxScore < s.getGrade().getScore()){
				maxScore = s.getGrade().getScore();
			}
		}
		return Grade.scoreToLetter(maxScore);
	}
	public String findName(int studentID) {
		String pidFound = "s";
		for (Student s: listOfStudents) {
			if (studentID == s.getPid()) {
				pidFound = s.getFirstName() + " " + s.getLastName();
			}
		}
		return pidFound;
	}

	public String findLetter(int studentID) {
		String pidFound = "s";
		for (Student s: listOfStudents) {
			if (studentID == s.getPid()) {
				pidFound = s.getGrade().getLetterGrade();
			}
		}
		return pidFound;
	}

	public void change(int apantherID, int score){
		Grade newGrade = new Grade(score);

		for (Student s: listOfStudents){
			if (apantherID == s.getPid()) {
				s.setGrade(newGrade);
			}
		}
	}

	public String tabScores() {
		for(Student s: listOfStudents){
			System.out.printf("%-10.10s\t%-10.10s\t%d\t%d\n", s.getFirstName(),
					s.getLastName(), s.getPid(), s.getGrade()).toString();
		}

	}



}
