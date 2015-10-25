
public class employee {
	 private String firstName = "";
	 private String lastName = "";
	 private double rate = 0; 
	 private double ot = 0;
	 
	 
	 public employee( String f, String l, double rateb, double otb){

		 this.firstName = f;
		 this.lastName = l;
		 this.rate = rateb;
		 this.ot = otb;
	 }


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getOt() {
		return ot;
	}


	public void setOt(double ot) {
		this.ot = ot;
	}
	 
	 
	 
}
