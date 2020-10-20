import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFromFile {
	
	public static void main (String [] args) throws FileNotFoundException{

		File file = new File ("/Users/anvaybhanap/Desktop/Github/Spartan Expense Tracker/SET2/BalanceRecord.txt");
		Scanner scan = new Scanner(file);
		System.out.println(scan.next());
	}

}
