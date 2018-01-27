/*
 * Romeo Medoro.
 * Intro to Java
 * 11/17/2017
 * Creates a course, adds three students, removes one, and displays the 
 * students in the course. 
 */
package coursetest;
import java.util.*;

public class CourseTest {

    public static void main(String[] args) {
        // initialize a student list. 
        String[] studentList;
        // Create a course object.
        Course course = new Course("Intro to Java Programming");
        
        // Add students to the course.
        course.addStudent("Romeo Medoro");
        course.addStudent("John Doe");
        course.addStudent("Jane Smith");
        
        // Show the students in the course
        studentList = new String[course.getNumberOfStudents()];
        studentList = course.getStudents();
        
        System.out.println(course.getCourseName());
        System.out.println("------------------------");
        System.out.println("Students: ");
        
        // Display the students 
        for (int i = 0; i < studentList.length; i++){
            System.out.println("\t" + studentList[i]);
        }
     
        // Drop a student from the course.
        course.dropStudents("John Doe");
        
        // Clear the array and get the updated list.
        studentList = new String[course.getNumberOfStudents()];
        studentList = course.getStudents();
        // Show the students in the course.
        System.out.println("\n" + course.getCourseName());
        System.out.println("------------------------");
        System.out.println("Students: ");
        for (int i = 0; i < studentList.length; i++){
            System.out.println("\t" + studentList[i]);
        }
    }
    
}
/* The course class */
class Course{
    private String courseName;
    private String[] students = new String[0];
    private int numberOfStudents;
    
    // Constructor.
    public Course(String courseName){
        this.courseName = courseName;
    }
    
    /* add students method */
    public void addStudent(String student){
        if (numberOfStudents >= students.length){
            String[] temp = new String[students.length + 1];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        
        students[numberOfStudents++] = student;
    }
    
    /* getter for students */
    public String[] getStudents(){
        return students;
    }
    
    /* getter for number of students */
    public int getNumberOfStudents(){
        return numberOfStudents;
    }
    
    /* getter for course name */
    public String getCourseName(){
        return courseName;
    }
    
    /* drop students method */
    public void dropStudents(String student){
        // decrement number of students
        numberOfStudents--;
        // convert students to a temp list. 
        List<String> temp = new ArrayList<String>(Arrays.asList(students));
        // remove the selected student. 
        temp.remove(student);
        //replace students with the updated list. 
        students = temp.toArray(new String[numberOfStudents]);            
    }
    
    public void clear(){
        Arrays.fill(students, null);
        numberOfStudents = 0;
    }
}