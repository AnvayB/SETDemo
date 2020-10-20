import java.util.*;
import java.io.File;

public class BalanceFile {
	
	//this class just creates and adds the record to the file. nothing more

	public static void sop(Object x) {
		System.out.println(x);
	}

	private Formatter f;

	public void openFile() {
		try {
			f = new Formatter("BalanceRecord.txt");

		} catch (Exception e) {
			sop("there is an error");
		}
	}

	public void addRecord(int bal) {
		// add a balance record into BalanceRecord.txt
		f.format("%s", bal + " ");
	}

	public void closeFile() {
		f.close();
	}
}
