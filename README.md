**************************************Lab 5********************************************

package student;
import java.util.Scanner;

public class Command1 {
	 public static void main(String[] args) {

		 float score=0;
		String course;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your course name: ");
		course = sc.next();
		System.out.print("Enter your score: ");
		score = sc.nextFloat();

		Graduate John = new Graduate();

		John.setScore(course, score);
		John.computeGrade();

		System.out.println("You get Grade " + John.getGrade() + " in " + John.getCourse());
	}
}
***************************************************************************************
package student;

public class Graduate extends Student {

		 private char grade;
		 public void computeGrade() {
		 if (score >= 80) grade = 'A';
		 else grade = 'B';
		 }

		 public char getGrade() {
		 return grade;
		 }
		}

  ***************************************************************************************
package student;

public class Student {
	private String course;
	 protected float score;

	 public String getCourse() {
	 return course;
	 }
	 public void setScore(String stdCourse, float stdScore) {
	 course = stdCourse;
	 score = stdScore;
	 }
}


