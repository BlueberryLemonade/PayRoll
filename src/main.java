import java.io.*;
import java.util.*;
import java.lang.Object;


public class main {
	
	
	public static void main(String[] args){
		
		//Check for an existing employee file, and read if so
		String fileName= "Employees.txt";
		ArrayList<employee> list = new ArrayList<employee>();
		BufferedReader fileReader = null;
		
		//File reader
		try{
		fileReader = new BufferedReader(new FileReader(fileName));
		
		String line = "";
		
		//reading startings
		while((line = fileReader.readLine()) != null)
		{
			String[] tokens = line.split(",");
			if(tokens.length > 0){
				employee existingEmp = new employee(tokens[0], tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
				list.add(existingEmp);
			}
		}
		
		
		} catch(Exception e){
			System.out.println("Error while attempting to read file.");
		}
	
	System.out.println("***Welcome to the Payroll system.***");
	int input = 0;
	
	do{
		input = options();
		int size = list.size();
	
	switch(input) {
	case 1 : list.add(addEmployee());
			 
			 System.out.println("Employee Added!");
			 break;
	case 2 :
///////////////Calculate Pay
	
	//check for employees
	if(list.isEmpty()){
		System.out.println("No employees found!");
	}
	//pick an employee
		System.out.println("Which Employee do you need to calculate? ");
		//print list
		for(int i = 0; i < size; i++){
			System.out.println((i + 1) +") " + list.get(i).getFirstName() + " "+ list.get(i).getLastName());
		
		}
		//get input
		Scanner sc = new Scanner(System.in);
		//Get Choice
		int choice = 0;
		do{
		if(sc.hasNextInt()){
			
			int storage = sc.nextInt();
			if(storage > size || storage < 0){
				System.out.println("Please enter a valid employee #");
				
			} else {
				choice = storage;
			}
		} else {
			sc.next();
		}
		} while(choice == 0);
		//Get hours worked for employee

			choice--;
			System.out.println("How many hours did " + list.get(choice).getFirstName() + " work this week?");
			double hours = -1;
			do{
			if(sc.hasNextDouble()){
				double dstorage = sc.nextDouble();
				if(dstorage < 0){
					System.out.println("Please enter more than 0 hours");
					
				} else {
					hours = dstorage;
				}
			} else {
				sc.next();
			}
			} while(hours < 0);
			
			double ot = 0;
			double payrate = list.get(choice).getRate();
			if(hours > 40){
				ot = hours - 40;
				hours = 40;
			}
			
			double pay = (payrate * hours) + (ot * payrate * list.get(choice).getOt());
			
			
		
			
			System.out.printf(list.get(choice).getFirstName() + " has earned $");
			System.out.printf("%.2f", pay);
			System.out.printf(" this week.\n");
			
		
			 break;
	case 3 : 
///////////////////// Show Info

		if(list.isEmpty()){
			System.out.println("No employees found!");
		}
		for(int i = 0; i < size; i++){
			System.out.println("Employee " + (i + 1));
			System.out.println("----------------");
			System.out.println("First: " + list.get(i).getFirstName());
			System.out.println("Last: " + list.get(i).getLastName());
			System.out.println("Rate: " + list.get(i).getRate());
			System.out.println("OT: " + list.get(i).getOt());
		}
			 break;
		 
	case 4 :
////////////////////Quit
		try{
			
			FileWriter writer = new FileWriter(fileName);
			
			for(int i=0; i<size; i++){
				writer.write(list.get(i).getFirstName() + ",");
				writer.write(list.get(i).getLastName() + ",");
				String rateS = String.valueOf(list.get(i).getRate());
				writer.write(rateS + ",");
				String OtS = String.valueOf((list.get(i).getOt()));
				writer.write(OtS + System.lineSeparator());
			}
			
			writer.close();
			}catch (Exception e){
				System.err.println("Error: " + e.getMessage());
			}
	}
	
	
	} while (input != 4);
	
	
	
	}
	
	
	//Function for adding employees
	public static employee addEmployee(){
		Scanner sc = new Scanner(System.in);
		System.out.println("---Add Employee---");
		
		

		
		//Get First and Last Name
		
		System.out.println("Enter Employee's First Name: ");
		String f = sc.next();
		
		System.out.println("Enter Employee's Last Name: ");
		String l = sc.next();
		
		
		//Get Hourly Rate
		double rate = 0.00;
		do{
		System.out.println("Enter Employee's Hourly Rate ##.##");
		
		if(sc.hasNextDouble()){
			double dstore = sc.nextDouble();
			
			if (dstore > 0){
				rate = dstore;
				break;
			}
		} else {
			sc.next();
		}
		System.out.println("Please enter a valid rate of pay ##.##");
		} while(rate <=0 );
		
		
		
		//Get Overtime Rate
		double ot = 0;
		
		do{
			
		
			System.out.println("Enter Employee's Overtime Rate (1= 1x, 2=1.5x, 3= 2x)");
		
			if(sc.hasNextInt()){
				int otstore = sc.nextInt();
						if(otstore == 1 || otstore == 2 || otstore ==3){
							switch(otstore){
							case 1: ot = 1;
									break;
							case 2: ot = 1.5;
									break;
							case 3: ot = 2;
									break;
							}
							break;
						}
			} else {
				sc.next();
			}
			System.out.println("Please enter a valid OT Rate 1/2/3");
		} while(ot == 0);
		
		//Create employee and return
		employee newEmployee = new employee(f, l, rate, ot);
		
		return newEmployee;
	}
	
	
	
	
	//Function for calculating pay
	public static void calcPay(){
		System.out.println("Calculate Pay");
	}
	
	//Function for displaying info
	public static void showInfo(){
		System.out.println();
		
	}
	
	// Options Screen
	public static int options(){
		int input = 0;
	do{
		//Menu
		
		System.out.println("What would you like to do?");
		System.out.println("1) Add an employee");
		System.out.println("2) Calculate pay for employee");
		System.out.println("3) Show employee information");
		System.out.println("4) Save & Quit");
		
		//Input
		Scanner sc = new Scanner(System.in);
		
		if(sc.hasNextInt()){
		input = sc.nextInt();
		} 
		
	} while(input < 1 || input > 4);
	
	return input;
	}
}