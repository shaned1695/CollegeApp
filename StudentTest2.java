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
    				else{
	    				check1 = Date_Of_Birth.charAt(2);
	    				check2 = Date_Of_Birth.charAt(5);
	    				if ((check1=='/') && (check2 =='/')){
	    					System.out.println("Date of Birth has been entered Correctly");
	    					MatureFlag = true;
	    				}
	    				//If the 2'nd and 5'th characters are not "/", but it is 10 characters, make the user re-input the data.
	    				else{
	    					System.out.println("Error, invalid format\n\nPlease enter dd/mm/yyyy");
	    				}
	    			}//end else if dob.length != 10
    			}//end while
    			//Create Mature Student
    			s1[i] = new MatureStudent(Name,ID,Address,a1[i],Date_Of_Birth);
    		}//end if
    		else{
    			//Create Student
    			s1[i] = new Student(Name,ID,Address,a1[i]);
    		}//end if
		}//end forloop of inputting data

		//Reset Choice
    	choice =0;

    	//While loop,f keeps going until the user chooses to quit.
		while (choice !=3){
    		//Prompt the user for his choice
			System.out.println("\n\nEnter choice \n1: View Course/Personal Details \n2: Edit Course/Personal Details \n3: Exit\n ");
    		//Validate the next Input
			strchoice = input.next();
			choice = validate(strchoice,1);

			//User has chosen to View Course Info, Prompt him for ID
			if(choice == 1){
				System.out.print("Please enter that student's ID: ");
				struserID = input.next();
				userID = validate(struserID,2);
    			for(int i = 0;i<s1.length;i++){
    				//If user prompt matches ID
    				if(userID == s1[i].getid()){
    					//Change flag
	    				flag = true;
	    				System.out.println("ID Found");
	    				//Hold onto the position the array is on.
	    				sub = i;
	    				break;
    				}//end if
    			}//end for
    			//If flag = False, then ID not found
    			if (flag == false){
    				System.out.println("ID was not found, this program will now end");
    				System.exit(0);
    			}//end if
    			//If mature flag = true, then ID does match, and you can print the details.
    			else{
    				System.out.print(s1[sub].toString());
    				}//end else
			}//end if choice 1

			//If user chose to Edit Personal/
			else if(choice==2){
				//promt the user to enter ID
				System.out.print("Please enter the applicants ID: ");
				struserID = input.nextLine();
				userID = validate(struserID,4);

				//if useID and ID- match print users details outside the loop
    			for(int i = 0;i<s1.length;i++){
    				if(userID == s1[i].getid()){
    					//change the value of the flag
	    				flag = true;
	    				System.out.println("ID Found");
	    				//hold onto i, this is where the users details are stored in the array
	    				sub = i;
	    				//break out of the loop
	    				break;

    				}//end if userID == ID[i]
    			}//end for
    			//If id's do not match, then exit the program
    			if (flag == false){
    				System.out.println("ID was not found, this program will now end");
    				System.exit(0);
    			}//end if

    			else{
					while(menu != 5){
    					//Show the menu, and Prompt the user for input
    					System.out.print("\n\nSelect An Option\n\n1: View Application Details\n2: View Personal Details\n3: Change Application Details\n4: Change Personal Details\n5: Exit\n");
						strmchoice = input.nextLine();

						mchoice = validate(strmchoice,3);

						if(mchoice == 1){
							System.out.print(a1[sub].toString());
						}//end choice = 1
						else if(mchoice == 2){
							System.out.print(s1[sub].toString());
						}//end choice = 2
						else if(mchoice == 3){
							System.out.print("Enter 1 to Change Course Or 2 to Change Course ID : ");
							strchangeap = input.nextLine();
							changeap = validate(strchangeap,5);
							if(changeap == 1){
								System.out.print("Enter Course Name :");
								NewCourseName = input.nextLine();
								a1[sub].setcourse_name(NewCourseName);
							}//end if
							if(changeap == 2){
								System.out.print("Enter Course ID : ");
								strnewcourseID = input.nextLine();
								NewCourseID = validate(strnewcourseID,4);
								a1[sub].setcourse_number(NewCourseID);
							}//end if
						}//end choice = 3

						else if(mchoice == 4){
							System.out.print("Enter 1 to Change Student Name Or 2 to Change Student ID : ");
							strchangest = input.nextLine();
							changest = validate(strchangest,5);
							if(changest == 1){
								System.out.print("Enter Course Name :");
								NewStudentName = input.nextLine();
								s1[sub].setname(NewStudentName);
							}//end if
							if(changest == 2){
								System.out.print("Enter Student ID : ");
								strnewstudentID = input.nextLine();
								NewStudentID = validate(strnewstudentID,2);
								s1[sub].setid(NewStudentID);
							}//end if
						}//end choice = 4


    }


}