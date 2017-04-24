public class Applicant {
	//attributes
	private String name;
	private int id;

    public Applicant(String name, int id) {
    	this.name = ((name.length()>0)?name: "Unknown");
    	this.id = ((id >0)?id: 1);
    }//end constructor

    public String toString(){
    	return "\nName: " + name + "\nID: " + id;
    }//toString


}//end class

