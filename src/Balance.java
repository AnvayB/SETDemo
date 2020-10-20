import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Balance {

	int balance;
	BalanceFile b = new BalanceFile();

	public static void sop(Object x) {
		System.out.println(x);
	}

	public Balance() {

	}

	public void setBalance(int bal) {
		balance = bal;

		b.openFile();
		b.addRecord(bal);
		b.closeFile();

	}

	public void addInput(int in) {

		b.openFile();
		b.addRecord(balance += in);
		b.closeFile();

	}

	public int getBalance() {
		return balance;
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);

//		sop("What would you like to do next? Please select a letter: "
//				+ "\nA: Add to Balance    B: Set Balance   C: Check Balance");
//		String response = scan.next();
		Balance b = new Balance();

		// SET BALANCE
		sop("Set the balance: ");
		int amount = scan.nextInt();

//		
//		BalanceFile b = new BalanceFile();
//		b.openFile();
//		b.addRecord(amount);
//		b.closeFile();

		sop("Do you want to confirm this action? (y/n)");
		String confirmSet = scan.next();

		if (!(confirmSet.equals("y"))) {
			sop("Please restart application and enter correct amount.");
		} else {
			b.setBalance(amount);
			

			// ADD TO BALANCE
			sop("Add to balance: ");
			int addition = scan.nextInt();

			sop("Do you want to confirm this action? (y/n) ");
			String confirmAdd = scan.next();

			if (!(confirmAdd.equals("y"))) {
				sop("Please restart application and enter correct amount.");
			} else {
				b.addInput(addition);
				
				
				//CHECK BALANCE
				File file = new File("/Users/anvaybhanap/Desktop/Github/Spartan Expense Tracker/SETDemo/BalanceRecord.txt");
				Scanner sc = new Scanner(file);
				sop("\nTotal Balance in account: $" + sc.next());
				
				
				sop("\nThank you for using the Spartan Expense Tracker."
						+ "\nHave a nice day!");

//		
			}
		}
	}
}
