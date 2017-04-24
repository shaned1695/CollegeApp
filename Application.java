public class Application {
	//attributes
	private String course_name;
	private int course_number;

    public Application(String course_name, int course_number) {
    	this.course_name = ((course_name.length()>0)?course_name: "Unknown");
    	this.course_number = ((course_number >0)?course_number: 1);
    }//end constructor

	//set and get methods 
    public void  setcourse_name(String course_name){
    	this.course_name = course_name;
    }
    public String getcourse_name(){
    	return course_name;
    }

    public void setcourse_number(int course_number){
    	this.course_number = course_number;
    }
    public int getcourse_number(){
    	return course_number;
    }

	public String toString(){
		return "\nCourse Name: " + course_name + "\nCourse Number: " + course_number;
	}//end toString

}//end class
