
package javaexample102wordlinefileinput;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class JavaExample102WordLineFileInput {

   
    public static void main(String[] args) {
        
        String fileName = "myFile.txt";
        
        File fil = new File(fileName);
        
        try {
            
            // tool to output to a file
            PrintWriter filOutput = new PrintWriter(fil);
            
            // tool to input from file
            Scanner filInput = new Scanner(fil);
            
            // point as decimal separator
            filInput.useLocale(Locale.US);
            
            // default space char
            String space = filInput.delimiter() + "";
            
            // end-line-char
            String endLine = System.getProperty("line.separator");
            
            // write information (numbers and strings) to the fil 
            filOutput.print("The number: ");
            filOutput.println(234);
            filOutput.println(12312.987);
            filOutput.println("bye bye");
            filOutput.println(9876);
            filOutput.print(53.34);
            filOutput.println(" AbCd");
            
            // close
            filOutput.close();
            
            // word-by-word input
            String str1 = filInput.next();
            String str2 = filInput.next();
            int a = filInput.nextInt();
            System.out.println(str1 + " " + str2 + " " + a);
            
            // line-by-line input
            System.out.println("----------------");
            filInput.useDelimiter(endLine);
            String line1 = filInput.next();
            String line2 = filInput.next();
            System.out.println(line1);
            System.out.println(line2);
            int b = filInput.nextInt();
            System.out.println(b);
            
            // word-by-word input
            System.out.println("****************");
            filInput.useDelimiter(space);
            double d1 =filInput.nextDouble();
            String str = filInput.next();
            System.out.println(d1 + " " + str);
        
            // close
            filInput.close();
            
        }// end-try
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        catch(NoSuchElementException e)
        {
            /*
            Thrown by various accessor methods to indicate that the element
            being requested does not exist.
            */
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }// end-main
}
