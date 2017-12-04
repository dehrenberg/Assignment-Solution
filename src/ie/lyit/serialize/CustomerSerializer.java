package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ie.lyit.hotel.Adress;
import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;
//Author Dennis Ehrenberg
public class CustomerSerializer implements java.io.Serializable {
	

	private int id = 0;
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private Customer customer;
	
	//loading the file	
	public void fileLoader() throws FileNotFoundException, ClassNotFoundException {
		try {
			// a new fileinputstream is initialized and tries to open the file customer.txt
	        FileInputStream fileIn = new FileInputStream("Customer.txt");
	        // a new objectinputstream is initialized for reading objects out of a file
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	       //the next line is the object reading and saving (loading) into the customers arraylist
	       	 customers = (ArrayList<Customer>) in.readObject();	                 
	        in.close();
	     } catch (IOException i) {
	        i.printStackTrace();
	       	     
	     }
	}
	
	//saves List in file
	public void fileSaver() throws FileNotFoundException {
		try {
			//a new fileoutputstream is initialized and creates the text file with the name customer
	         FileOutputStream fileOut = new FileOutputStream("Customer.txt");
	         //the new initialized objectoutputstream is created to write objects to the text file
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(customers); 
	         out.close();
	      } catch (IOException i) 
		  {
	         i.printStackTrace();
	      }
	}
	
	
	//adds a new customer to the arraylist with the parameters which are data filled by the user
	public void addNewCustomer(String t,String fn,String sn,String l,String tow,String street,int streetNr,String emailAdress,int phoneNr) {
		
		if(customers.size() < 1) {
			id = 0;
		}else {
			Customer getLastCustomer = customers.get(customers.size()-1);
			id = getLastCustomer.getNumber();
		}
		Customer c = new Customer(t,fn,sn,l,tow,street,streetNr,emailAdress,phoneNr, id);
		customers.add(c);
		
	}
	
	//sets the new data of a customer which was selected by his id
	public void editingCustomer(int id, String title, String firstName, String surname,
			String country, String town, String street, int streetNr, 
			String emailAdress, int phoneNr) {
		for(int i = 0; i < customers.size(); i++) {
			if(id == customers.get(i).getNumber())
			{
				Adress a = new Adress(street, town, country, streetNr);
				Name n = new Name(title, firstName, surname);
				
				//sets the customers new data 
				customers.get(i).setAdress(a);
				customers.get(i).setName(n);
				customers.get(i).setEmailAdress(emailAdress);
				customers.get(i).setPhoneNr(phoneNr);
			}	 
		}
	}
	
	//removes a customer of the arraylist selected by the id
	public void removeCustomer(int id) {
		for(int i = 0; i < customers.size(); i++) {
			if(id == customers.get(i).getNumber())
			{
				customers.remove(i);
			}	 
		}
	}

	
	//prints out some data of a customer selected by the id
	public void showCustomer(int id) {
			
			for(int i = 0; i < customers.size(); i++) {
				if(id == customers.get(i).getNumber())
				{
					System.out.println("Title: " + customers.get(i).getName().getTitle());
					System.out.println("Firstname: " + customers.get(i).getName().getFirstName());
					System.out.println("Surstname: " + customers.get(i).getName().getSurname());
					System.out.println("Country: " + customers.get(i).getAdress().getLand());
					System.out.println("Town: " + customers.get(i).getAdress().getTown());				
				}			 
			}
	}

	//prints out every customer of the arraylist
	public void listCustomer() {
		for(int i = 0; i < customers.size(); i++) {
			
				System.out.print("Title: " + customers.get(i).getName().getTitle()+ " ");
				System.out.print("Firstname: " + customers.get(i).getName().getFirstName()+ " ");
				System.out.print("Surname: " + customers.get(i).getName().getSurname()+ " ");
				System.out.println("ID: " + customers.get(i).getNumber());
		}
	}

}
