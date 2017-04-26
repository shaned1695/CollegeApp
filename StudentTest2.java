import java.io.*;
import java.util.Date;
import java.util.Scanner;
public class StudentTest2 {

	static Scanner input = new Scanner(System.in);
	static int sub = 0;


    public static void main(String args[]) {

    	//declare variables
    	int ID,Course_Number,userID,choice = 0,numrecords,menu = 0,mchoice = 0,changeap = 0,NewCourseID,changest = 0,NewStudentID;
    	String Name,Course_Name,Address,mstudent,Date_Of_Birth="",NewCourseName = "",NewStudentName = "",strID,strCourse_Number;
    	String struserID,strchoice,strnumrecords,strmenu,strmchoice,strchangeap,strnewcourseID,strchangest,strnewstudentID;

    	char check1,check2;
    	boolean MatureFlag = false;
    	boolean flag = false;

    	//prompt the user to enter the number of students
    	System.out.print("Please enter the number of students: ");
    	strnumrecords = input.next();
    	//validate the entered data.
    	numrecords = validate(strnumrecords,4);
    	//Create new student and application.
    	Student s1[] = new Student[numrecords];
    	Application a1[] = new Application[numrecords];

		//take in details for each student
    	for(int i = 0;i<numrecords;i++){

    		//Prompt the user for the information
			input.nextLine();
			System.out.println("\nEnter Student " + (i + 1) + "\n");
    		System.out.print("Please enter student name: ");
    		Name = input.nextLine();
    		System.out.print("Please enter id: ");
    		strID = input.nextLine();
    		ID = validate(strID,4);
    		System.out.print("Please enter course name: ");
    		Course_Name = input.nextLine();
    		System.out.print("Please enter course id: ");
    		strCourse_Number = input.nextLine();
    		Course_Number = validate(strCourse_Number,4);
    		System.out.print("Please enter address: ");
    		Address = input.nextLine();

    		//create application
    		a1[i] = new Application(Course_Name,Course_Number);
    		System.out.print("Is the applicant a mature student <y/n>: ");
    		mstudent = input.next();
    		mstudent = mstudent.toLowerCase();
    		System.out.println("Option Chosen = " + mstudent);

    		//While loop, validation for mature student Y/N
    		while(!mstudent.matches("y") && (!mstudent.matches("n"))){
    			System.out.println("Error, Please enter y or n");
    			System.out.print("Is the applicant a mature student <y/n>: ");
				mstudent = input.next();
				mstudent = mstudent.toLowerCase();
    		}//End while Loop

    		//reset MatureFlag
    		MatureFlag = false;

    		//If the matrueFlag is Yes, Then Make the user enter Date_Of_Birth
    		if(mstudent.matches("y")){
    			while(MatureFlag == false){
    				System.out.print("Enter date of birth dd/mm/yyyy : ");
    				Date_Of_Birth = input.next();
    				if (Date_Of_Birth.length()!=10){
    				System.out.println("Error, invalid format\n\nPlease enter dd/mm/yyyy");
    				}

    }


}