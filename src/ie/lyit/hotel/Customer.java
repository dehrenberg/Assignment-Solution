package ie.lyit.hotel;


// Author Dennis Ehrenberg

public class Customer extends Person implements java.io.Serializable{
	private int number;
	private static int nextNumber = 1;
	private String emailAdress;
	

	
	public Customer() {
		super();
		emailAdress = null;	
		//the following line had to be commented because it created an unexpected error
		//where the number wouldnt be increased by 1
		//number = nextNumber++;
	}
	
	//in this constructor only the id was added because now it is important to know the id,
	//of the last customer added and increasing it by one instead of increasing the number everytime
	//if this wouldnt be done the number would start by 1 everytime the program is started 
	public Customer(String t, String fn, String sn, String l, String tow, String
			street, int streetNr, String emailAdress, int phoneNr , int id) {
		super(t,fn,sn,l,tow,street,streetNr,phoneNr);
		
		this.emailAdress = emailAdress;
		number = id+1;
	}

	
	public String toString()
	{
		
		return super.toString() + " " + emailAdress + "," + number;
	}
	
	
	public boolean equals(Object obj)
	{
		super.equals(obj);
		
		if(obj instanceof Customer)
		{
			Customer checkedObj = (Customer)obj;
			if(	this.emailAdress.equals(checkedObj.getEmailAdress()) && 
				this.number == (checkedObj.getNumber()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	
	
}
