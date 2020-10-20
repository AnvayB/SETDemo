import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LogInwPassword {
	public static void sop(Object x) {
		System.out.println(x);
	}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		Scanner scan = new Scanner(System.in);

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
//			sop("Enter first name: ");
//			String fName = scan.next();
//			sop("Enter last name: ");
//			String lName = scan.next();
			sop("Enter password: ");
			String pass = scan.next();

			UserFile2Demo c = new UserFile2Demo();
			c.openFile();
			c.addRecords(ID, pass);
			c.closeFile();
			boolean areEqual = true;

			String line1 = Files.readAllLines(Paths.get("UserDB.txt")).get(1);
			String line4 = Files.readAllLines(Paths.get("UserDB.txt")).get(4);

			String DB2line1 = Files.readAllLines(Paths.get("UserDB2.txt")).get(1);
			String DB2line2 = Files.readAllLines(Paths.get("UserDB2.txt")).get(2);

			sop(!(line1.equals(DB2line1)) || !(line4.equals(DB2line2))); 
				//areEqual = false;

//				lineNum++;
			

			if (!areEqual) {
				System.out.println("Incorrect student ID or password" + "\nPlease try again.");
			} else {
				System.out.println("Log In Succesful!");

			}
		}
	}
}
