import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class FileDemo
{   
    public static void main(String[] args) throws IOException
    {   
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
         
        if(areEqual)
        {
            System.out.println("Log In Successful! ");
        }
        else
        {
            System.out.println("Incorrect student ID or password");
             
            
        }
         
        reader1.close();
         
        reader2.close();
    }
}