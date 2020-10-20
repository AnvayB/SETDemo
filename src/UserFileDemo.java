import java.util.*;
import java.io.File;

public class UserFileDemo {

	public static void sop(Object x) {
		System.out.println(x);
	}

	private Formatter f;

	public void openFile() {
		try {
			f = new Formatter("UserDB.txt");

		} catch (Exception e) {
			sop("there is an error");
		}
	}

	public void addRecords(long iD, String fName, String lName, String pass) {
		// add ID, fName, lName
		f.format("%s%s%s%s", iD + " ", "\n"+fName + " ", "\n"+lName + " ", "\n"+pass);
	}

	public void closeFile() {
		f.close();
	}

	
}
