import java.util.Scanner;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.lang.*;
import java.io.*;

public class MainUser {
	
	private static Scanner x;
	public static void sop(Object x) {
		System.out.println(x);
	}

	

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		//Balance bal = new Balance(0);
		

		sop("Welcome to the Spartan Expense Tracker!");
		sop("Press C to Create an Account or L to Log in: ");
		String mainResponse = scan.next();

		if (mainResponse.equals("C") || mainResponse.equals("c")) {
			sop("Enter student id: ");
			long ID = scan.nextLong();
			sop("Enter first name: ");
			String fName = scan.next();
			sop("Enter last name: ");
			String lName = scan.next();
			

			UserFileDemo f = new UserFileDemo();
			f.openFile();
			f.addRecords(ID, fName, lName);
			f.closeFile();

			sop("You will now have to restart this application and log in");
		}

		if (mainResponse.equals("L") || mainResponse.equals("l")) {
			sop("Enter student id: ");
			long ID = scan.nextLong();
			sop("Enter first name: ");
			String fName = scan.next();
			sop("Enter last name: ");
			String lName = scan.next();

			UserFile2Demo c = new UserFile2Demo();
			c.openFile();
			c.addRecords(ID, fName, lName);
			c.closeFile();

//			try (FileInputStream fin1 = new FileInputStream("UserDB.txt");
//					FileInputStream fin2 = new FileInputStream("UserDB2.txt")) {
//
//				int i = 0, j = 0;
//
//				while (i != -1 && j != -1) {
//
//					i = fin1.read();
//					j = fin2.read();
//
//					if (i != j) {
//						break;
//					}
//				}
//
//				if (i != j) {
//					System.out.println("Incorrect name or student ID\n Please try again.");
//				} else {
//					System.out.println("Log in Successful!");
			BufferedReader reader1 = new BufferedReader(new FileReader("UserDB.txt"));
	         
	        BufferedReader reader2 = new BufferedReader(new FileReader("UserDB2.txt"));
	         
	        String line1 = reader1.readLine();
	         
	        String line2 = reader2.readLine();
	         
	        boolean areEqual = true;
	         
	        int lineNum = 1;
	         
	        while (line1 != null || line2 != null)
	        {
	            if(line1 == null || line2 == null)
	            {
	                areEqual = false;
	                 
	                break;
	            }
	            else if(! line1.equalsIgnoreCase(line2))
	            {
	                areEqual = false;
	                 
	                break;
	            }
	             
	            line1 = reader1.readLine();
	             
	            line2 = reader2.readLine();
	             
	            lineNum++;
	        }
	         
	        if(!areEqual)
	        {
	        	System.out.println("Incorrect student ID or password"
	        						+ "\nPlease try again.");
	        }
	        else {
	            System.out.println("Log In Succesful!");

	         
	        reader1.close();
	         
	        reader2.close();
			
					sop("\nWhat would you like to do next? Please select a letter: "
							+ "\nA: Add to Balance    B: Set Balance   C: Check Balance");
					String response = scan.next();

					if (response.equals("A")) {
						sop("Enter the amount you want to add to your Balance: ");
						int amountAdd = scan.nextInt();
						//bal.addInput(amount);
						//doesn't work

					}

					if (response.equals("B")) {
						sop("enter balance: ");
						int amount = scan.nextInt();

//						
					
					}

					if (response.equals("C")) {
						//sop("Your current balance is " + bal.getBalance());
						//doesn't work
					}

				}

//			} catch (IOException e) {
//				System.out.println(e);
//			}

		}

	}
}
	


