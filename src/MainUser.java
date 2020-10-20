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

	//private static Scanner x;

	public static void sop(Object x) {
		System.out.println(x);
	}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		// Balance bal = new Balance(0);

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
			sop("Enter password: ");
			String pass = scan.next();

			UserFileDemo f = new UserFileDemo();
			f.openFile();
			f.addRecords(ID, fName, lName, pass);
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
			sop("Enter password: ");
			String pass = scan.next();

			UserFile2Demo c = new UserFile2Demo();
			c.openFile();
			c.addRecords(ID, fName, lName, pass);
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

			while (line1 != null || line2 != null) {
				if (line1 == null || line2 == null) {
					areEqual = false;

					break;
				} else if (!line1.equalsIgnoreCase(line2)) {
					areEqual = false;

					break;
				}

				line1 = reader1.readLine();

				line2 = reader2.readLine();

				lineNum++;
			}

			if (!areEqual) {
				System.out.println("Incorrect student ID or password" + "\nPlease try again.");
			} else {
				System.out.println("Log In Succesful!");

				reader1.close();

				reader2.close();


				Balance b = new Balance();

				// SET BALANCE
				sop("\nHow much would you like to set as your balance: ");
				int amount = scan.nextInt();

//					
//					BalanceFile b = new BalanceFile();
//					b.openFile();
//					b.addRecord(amount);
//					b.closeFile();

				sop("Do you want to confirm this action? (y/n)");
				String confirmSet = scan.next();

				if (!(confirmSet.equals("y"))) {
					sop("Please restart application and enter correct amount.");
				} else {
					b.setBalance(amount);

					// ADD TO BALANCE
					sop("Add amount to balance: ");
					int addition = scan.nextInt();

					sop("Do you want to confirm this action? (y/n) ");
					String confirmAdd = scan.next();

					if (!(confirmAdd.equals("y"))) {
						sop("Please restart application and enter correct amount.");
					} else {
						b.addInput(addition);

						// CHECK BALANCE
						File file = new File(
								"/Users/anvaybhanap/Desktop/Github/Spartan Expense Tracker/SETDemo/BalanceRecord.txt");
						Scanner sc = new Scanner(file);
						sop("\nTotal Balance in account: $" + sc.next());

						sop("\nYour balance has been saved."
								+ "\nThank you for using the Spartan Expense Tracker!" + "\nHave a nice day!");

					}

//			} catch (IOException e) {
//				System.out.println(e);
//			}

				}

			}
		}
	}
}
