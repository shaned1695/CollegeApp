public class MatureStudent extends Student {
	//attributes
	private String DoB;

	//constructor
    public MatureStudent(String name, int id, String address, Application a1, String DoB) {
    	super(name, id, address, a1);
    	this.DoB = DoB;
    }//end constructor

    public void setDoB(String DoB){
    	this.DoB = DoB;
    }
    public String getDoB(){
    	return DoB;
    }

    public String toString(){
    	return super.toString() + "\nDate of Birth: " + DoB;
    }//end toString


}//end class