package ie.lyit.testers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import ie.lyit.serialize.CustomerSerializer;
public class CustomerSerializerTester {
 
	//Author Dennis Ehrenberg

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		CustomerSerializer customerSerializer = new CustomerSerializer();
	    BufferedReader br = new BufferedReader(isr);
	    int executableInt = 0;
	    boolean quit = false;
	    customerSerializer.fileLoader();
	    
	    //a do while loop was used so that the menu is printed at least once,
	    //the menu is created by a few systemouts and afterwards the number the user is typing in,
	    //is used in a switch-case where the class chooses which method from customSerializer is used,
	    //most of the methods are asking for an id because some methods use the id to search,
	    //for a specific customer
	    //the menu will continue to be printed out until the user changes the boolean value,
	    //by typing the number for the quit case
	    
	    do {    
		System.out.println("Menu:___________________");
		System.out.println("1. View a Customer");
		System.out.println("2. List all Customers");
		System.out.println("3. Create a new Customers");
		System.out.println("4. Delete a Customers");
		System.out.println("5. Change a Customers");	
		System.out.println("6. Quit the program");
		System.out.println("Please enter the number for the Operation you want to execute");
		System.out.println("__________________________");
		String executable = br.readLine();
		executableInt = Integer.parseInt(executable);
		
		switch (executableInt) 
		{
			case 1 : 
				System.out.println("Please enter the id: ");
				int id = Integer.parseInt(br.readLine());
				customerSerializer.showCustomer(id);
			break;
			
			case 2:
				customerSerializer.listCustomer();
			break;
			
			case 3:
				//The following is the interaction with the user to get the data of the customer
				System.out.println("Please enter the title: ");		
				String title = br.readLine();
				System.out.println("Please enter the firstname: ");	
				String fn = br.readLine();
				System.out.println("Please enter the surname: ");
				String sn = br.readLine();
				System.out.println("Please enter the country: ");
				String l = br.readLine();
				System.out.println("Please enter the town: ");
				String tow = br.readLine();
				System.out.println("Please enter the street: ");
				String street = br.readLine();
				System.out.println("Please enter the streetNumber: ");
				int streetNr = Integer.parseInt(br.readLine());
				System.out.println("Please enter the email adress: ");
				String emailAdress  = br.readLine();
				System.out.println("Please enter the phoneNumber: ");
				int phoneNr  = Integer.parseInt(br.readLine());
				customerSerializer.addNewCustomer(title, fn, sn, l, tow, street, streetNr, emailAdress, phoneNr);	 
			break;
			
			case 4:
				System.out.println("Please enter the id: ");
				id = Integer.parseInt(br.readLine());
				customerSerializer.removeCustomer(id);
			break;
			
			case 5:
				System.out.println("Please enter the id: ");
				id = Integer.parseInt(br.readLine());
				
				System.out.println("Please enter the title: ");		
				title = br.readLine();
				System.out.println("Please enter the firstname: ");	
				fn = br.readLine();
				System.out.println("Please enter the surname: ");
				sn = br.readLine();
				System.out.println("Please enter the country: ");
				l = br.readLine();
				System.out.println("Please enter the town: ");
				tow = br.readLine();
				System.out.println("Please enter the street: ");
				street = br.readLine();
				System.out.println("Please enter the streetNumber: ");
				streetNr = Integer.parseInt(br.readLine());
				System.out.println("Please enter the email adress: ");
				emailAdress  = br.readLine();
				System.out.println("Please enter the phoneNumber: ");
				phoneNr  = Integer.parseInt(br.readLine());
				
				customerSerializer.editingCustomer(id, title, fn, sn, l, tow, street, 
						streetNr, emailAdress, phoneNr);
				
			break;
			
			case 6:
			 quit = true;
			break;
		}
		
	    }while(quit == false);
	    
	    customerSerializer.fileSaver();
		
	}

}
