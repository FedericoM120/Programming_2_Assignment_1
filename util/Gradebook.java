/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;

import java.util.*;

public class Gradebook {
	// constructor to initialize the list of students
	public Gradebook(){
		listOfStudents = new ArrayList<Student>();
	}
	// list to store all the students
	private ArrayList<Student> listOfStudents;
	// method to add a student to the list of students
	public void addStudent(Student student){
		listOfStudents.add(student);
	}
	// method to calculate the average score of all students
	public double calculateAvg() {
		double sum = 0;
		for(Student s: listOfStudents)
			sum += s.getGrade().getScore();
		return sum / listOfStudents.size();
	}
	// method to calculate the average letter grade of all students
	public String averageLetter() {
		int sum = 0;
		for(Student s: listOfStudents)
			sum += s.getGrade().getScore();
		int average = sum / listOfStudents.size();
		return Grade.scoreToLetter(average);
	}
	// method to calculate the median score of all students
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
	// method to calculate the median letter grade of all students
	public String getMedianLetter() {
		int i = 0, n = listOfStudents.size();
		int[] scores = new int[n];
		int median;
		for(Student s: listOfStudents)
			scores[i++] = s.getGrade().getScore();
		Arrays.sort(scores);
		if (n % 2 == 0) {
			median = (scores[n / 2] + scores[n / 2 - 1]) / 2;
		}
		else {
			median =  scores[n / 2];
		}
		return Grade.scoreToLetter(median);
	}
	// method to print all students' information (first name, last name, panther ID, and score)
	public void printAllStudents() {
		for(Student s: listOfStudents)
			System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
	}
	// method to find the minimum score of all students
	public double minScore() {
		int minScore = 100;
		for (Student s: listOfStudents) {
			if (minScore > s.getGrade().getScore()) {
				minScore = s.getGrade().getScore();
			}
		}
		return minScore;
	}
	// method to find the maximum score of all students
	public double maxScore() {
		int maxScore = 0;
		for (Student s: listOfStudents) {
			if (maxScore < s.getGrade().getScore()){
				maxScore = s.getGrade().getScore();
			}
		}
		return maxScore;
	}
	// method to find the minimum letter grade of all students
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
	// method to find the maximum letter grade of all students
	public String maxLetter(){
		int maxScore = 0;
		for (Student s: listOfStudents) {
			if (maxScore < s.getGrade().getScore()){
				maxScore = s.getGrade().getScore();
			}
		}
		return Grade.scoreToLetter(maxScore);
	}
	// method to find the name of a student via their panther ID
	public String findName(int studentID) {
		String pidFound = "s";
		for (Student s: listOfStudents) {
			if (studentID == s.getPid()) {
				pidFound = s.getFirstName() + " " + s.getLastName();
			}
		}
		return pidFound;
	}
	// method to find the letter grade of a student via their panther ID
	public String findLetter(int studentID) {
		String pidFound = "s";
		for (Student s: listOfStudents) {
			if (studentID == s.getPid()) {
				pidFound = s.getGrade().getLetterGrade();
			}
		}
		return pidFound;
	}
	// method changes the grade of a student with given panther ID
	public void change(int apantherID, int score){
		//new grade object is created with given score
		Grade newGrade = new Grade(score);
		//interates through listOfStudents to find student with matching panther ID
		for (Student s: listOfStudents){
		// if match is found, the student's grade is set to the new grade
			if (apantherID == s.getPid()) {
				s.setGrade(newGrade);
			}
		}
	}
	// method to tabulate scores of all student in the list
	public void tabScores() {
		// for loop through all students in the list
		for(Student s: listOfStudents){
			// print the first name, last name, pantehr ID, and score of each student
			System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
		}
	}
	// Method to tabulate the letter grades of all students in the list
	public void tabLetter() {
		// Loop through all students in the list
		for(Student s: listOfStudents){
			// Print the first name, last name, Panther ID, and letter grade of each student
			System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
		}
	}
}
