package EdgarItzak.PasswordGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileHandler {

	public static void  writeToFile(String password) {
		boolean writen = false;
	//GET USERS PATH
			String path="";
	        String command="powershell -command \"[Environment]::GetFolderPath('\"Desktop\"')\"";
	        try {
	            Process process = Runtime.getRuntime().exec(command);
	            String line;
	            BufferedReader reader = new BufferedReader(
	                    new InputStreamReader(process.getInputStream()));
	            while ((line = reader.readLine()) != null) {
	                path= line;

	            }
	            reader.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
	        //WRITE ON FILE
	        
			try {
				 File myObj = new File(path+"\\Password.txt");
			      if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			      } else {
			        System.out.println("File already exists.");
			      }
			} catch (IOException e) {
			 System.out.println("An error occurred.");
		      e.printStackTrace();
			}
			System.out.println(path+"\\Password.txt");
		      try {
		    	  FileWriter fWrite = new FileWriter(path+"\\Password.txt");
		    	  fWrite.write(password);
		    	  fWrite.close();
		    	  writen = true;
		      } catch (IOException ee) {
		    	  System.out.println("An error ocurred.");
		    	  ee.printStackTrace();
		      }
		      	
	}
	
	
	
	
	
}
