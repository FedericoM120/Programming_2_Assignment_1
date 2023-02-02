/* This is part of the starter code! 
 * You need to complete this class yourself!*/
package util;
// Class Student represents a student with properties: first name, last name, panther id, and grade.
public class Student {
    // Instance variable to store the first name of the student
    private String firstName;
    // Instance variable to store the last name of the student
    private String lastName;
    // Constructor to initialize the first name, last name, panther id, and grade of the student.
    public Student(String firstName, String lastName, int pid, Grade grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }
    // Instance variable to store the panther id of the student.
    private int pid;
    // Method to set the grade of the student.
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    // Instance variable to store the grade of the student.
    private Grade grade;
    // Method to get the first name of the student.
    public String getFirstName() {
        return firstName;
    }
    // Method to get the last name of the student.
    public String getLastName() {
        return lastName;
    }
    // Method to get the panther id of the student.
    public int getPid() {
        return pid;
    }
    // Method to get the grade of the student.
    public Grade getGrade() {
        return grade;
    }
}
