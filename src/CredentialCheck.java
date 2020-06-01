import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// class to check the username and password the user entered
public class CredentialCheck {
	File a  = new File("src/Credentials.txt");
	private Scanner scanner;
	public boolean found(String cred) throws FileNotFoundException
	{
	scanner = new Scanner(a);
	
	while(scanner.hasNextLine())
	{
		String line = scanner.nextLine();
		
		if(cred.equals(line)) //credentials exist
			 return true;
	}
	return false;
	
	}
	
}
