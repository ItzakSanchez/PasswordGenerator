package EdgarItzak.PasswordGenerator;
import java.util.*; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*4. Generador de Contraseñas
		Descripción: Crea un programa que genere contraseñas aleatorias basadas en criterios como longitud, uso de mayúsculas, minúsculas, números y caracteres especiales.
		Permite al usuario guardar sus contraseñas generadas en un archivo.
		*/
		
		
		//VARIABLE DEFINITION
		int passLen = 0;
		String inputTextToCompare;
		Boolean includeLowercase = false, includeUppercase = false, includeDigits = false, includeSpecialChar = false;
		String customSpecialChars="";
		String password="";
		
		Scanner scanner = new Scanner(System.in);
		
		//OPTIONS INPUTS
		System.out.println("Please type the lenght of the password");
		passLen = scanner.nextInt(); //READ
		//LOWERCASE
		System.out.println("Include Lowercase? Y/N");
		inputTextToCompare = "";
		do {
			inputTextToCompare = scanner.next(); //READ
			if (inputTextToCompare.equalsIgnoreCase("y")){
				includeLowercase = true;
			}
			if (inputTextToCompare.equalsIgnoreCase("n")) {
				includeLowercase = false;
			}
		}
		while (!(inputTextToCompare.equalsIgnoreCase("n") || inputTextToCompare.equalsIgnoreCase("Y")));
		//UPPERCASE
		System.out.println("Include Uppercase? Y/N");
		inputTextToCompare = "";
		do {
			
			inputTextToCompare = scanner.next(); //READ
			if (inputTextToCompare.equalsIgnoreCase("y")){
				includeUppercase = true;
			}
			if (inputTextToCompare.equalsIgnoreCase("n")) {
				includeUppercase = false;
			}
		}
		while (!(inputTextToCompare.equalsIgnoreCase("n") || inputTextToCompare.equalsIgnoreCase("Y")));
		//DIGITS
		System.out.println("Include digits? Y/N");
		inputTextToCompare = "";
		do {
			inputTextToCompare = scanner.next(); //READ
			if (inputTextToCompare.equalsIgnoreCase("y")){	
				includeDigits=true;
			}
			if (inputTextToCompare.equalsIgnoreCase("n")) {
				includeDigits = false;
			}
		}
		while (!(inputTextToCompare.equalsIgnoreCase("n") || inputTextToCompare.equalsIgnoreCase("Y")));
		//SPECIAL CHARACTERS
		System.out.println("Include Special Characters? (_%@!$*~) Y/N");
		inputTextToCompare = "";
		includeSpecialChar= false;
		do{
			
			inputTextToCompare = scanner.next();
			if (inputTextToCompare.equalsIgnoreCase("y")){
				includeSpecialChar = true;
			}
			if (inputTextToCompare.equalsIgnoreCase("n")) {
				includeSpecialChar = false;
			}
		}
		while (!(inputTextToCompare.equalsIgnoreCase("n") || inputTextToCompare.equalsIgnoreCase("Y")));
		//CUSTOM SPECIAL CHARS
		if (includeSpecialChar) {
			System.out.println("Select Custom Special Characters? \n Example:!#$%&,- \n Type 0 to skip");

			inputTextToCompare = scanner.next();
			if (inputTextToCompare.equals("0")) {
				customSpecialChars="";
			}
			else{
				customSpecialChars = inputTextToCompare;
				}
		}
		//CALL METHOD GENERATE PASSWORD
		password = PasswordGenerator.generatePassword(passLen,includeLowercase, includeUppercase, includeDigits, includeSpecialChar,customSpecialChars);
		System.out.println("Password: "+password);
		//CALL METHOD WRITE PASSWORD
		fileHandler.writeToFile(password);
		scanner.close();
		
		
	}
	
}
