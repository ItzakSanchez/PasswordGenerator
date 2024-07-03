package EdgarItzak.PasswordGenerator;
import java.util.Random;

public class PasswordGenerator{
	
	public static String generatePassword(int passLenght, boolean includeLowercase,boolean includeUppercase,boolean includeDigits,boolean includeSpecialchars,String customSpecialChars) {
		final String  lowercase= "abcdefghijklmnopqrstuvwxyz";
		final String uppercase = lowercase.toUpperCase();;
		final String digits ="0123456789";
		final String specialChars ="_%@!$*~";
		String validChars="";
		String password="";
		Random random = new Random();
		
		if (includeLowercase) {
			validChars=validChars+lowercase;
		}
		if(includeUppercase) {
			validChars=validChars+uppercase;
		}
		if(includeDigits) {
			validChars=validChars+digits;
		}
		if(includeSpecialchars) {
			if(customSpecialChars.length()>0) {
				validChars=validChars+customSpecialChars;
			} else {
				validChars=validChars+specialChars;
			}
		}
	
				
		for(int i=0;i<passLenght;i++) {
			password = password+validChars.charAt(random.nextInt(validChars.length()));
		}
		return password;
	}
}
	
