import java.util.*;

public class Prompts {
static Scanner in =new Scanner(System.in);
	public void MenuInitial() // initial prompts
	{
		System.out.println("** Welcome to the Comets Books and DVDs Store **\n\n");
		System.out.println("Please select your role \nA- Store Manger \nB- Customer \nC- Exit store");
		System.out.println("*******************************************************************************");
	}
	
	public static String credential() //asking user to enter username and password if he chose store manager option
	{
		String User = new String();
		System.out.println("Please enter your username : ");
		User = in.next();
		System.out.println("Please enter your password : ");
		User+=",";
		
		User+= in.next();
		
		return User;
		
		
		
	}
	
	public void Catalog() // showing the user the options available to the store manager
	{
		System.out.println("** Welcome to the Comets Books and DVDs Store (Catalog Section) **\n");
		System.out.println("1-Add Book");
		System.out.println("2-Add AudioBook");
		System.out.println("3-Add DVD");
		System.out.println("4-Remove Book");
		System.out.println("5-Remove DVD");
		System.out.println("6-Display Catalog");
		System.out.println("7-Create backup file");
		System.out.println("9-Exit Catalog section");
	
	}
	
	
	public void shoppingSection()  // showing the user the options available to the customer
	{
		System.out.println("1-Browse Books inventory (price low to high)");
		System.out.println("2-Browse DVDs inventory (price low to high)");
		System.out.println("3-Add a Book to the cart");
		System.out.println("4-Add a DVD to the cart");
		System.out.println("5-Delete a Book from cart");
		System.out.println("6-Delete a DVD from cart");
		System.out.println("7-View cart");
		System.out.println("8-Checkout");
		System.out.println("9-Done");
	}

}
