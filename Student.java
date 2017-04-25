public class Student {
	//attributes
	private String address;
	private Application a1;

    public Student(String name, int id, String address, Application a1) {
    	//super (name,id);
    	this.address = ((address.length()>0)?address: "Unknown");
    	this.a1=a1;
    }//end constuctor

    public void setaddress(String address){
		this.address=address;
    }
    public String getaddress(){
    	return address;
    }


	public String toString(){
    	return super.toString() + "\nAddress: " + address + a1.toString();
    }//end toString

}//end class