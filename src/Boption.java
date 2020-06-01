import java.util.Scanner;
import java.util.*;


public class Boption {

      static  HashMap<String,Double> cartMap = new HashMap<>();
      static List<String> nameOfItem= new ArrayList<>();
      static List<Double> priceOfItem=new ArrayList<>();
      static int [] sortedBooks = {1,2,3,4,5};
      static   int [] sortedDVDs = {1,2,3,4,5};
      static  String BookOrDVD=""; //string to differentiate between books and dvds
      static  int Inventory;
      static  int choice; //for the user choice
      static  double Total=0; //total for the items in the cart
      static  int i=0;// counter for number of items in the cart
	  private static Scanner in;

   

	static void addBook(Books item)
	{
		cartMap.put(item.getTitle(), item.getPrice());
	}
	static void addDvd(DVDs item)
	{
		cartMap.put(item.getTitle(), item.getPrice());
	}
	static void deleteCart(String title)
	{
		cartMap.remove(title);
	}
	static  boolean ifInCart(String title)
	{
		if(cartMap.containsKey(title))
			return true;
		else
			return false;
	}
    static int getInventoryNumber( ) //getting inventory number of book the user wants to purchase
    {

        boolean run = true;
        int input=0;
      while(run)
      {
          in = new Scanner(System.in);
              System.out.print("Enter the inventory number you wish to purchase or type -1 to re-display the menu: ");

              try //validating the inputted inventory number
              {
                  input = in.nextInt();
                  run = false;
              }
              catch (Exception e)
              {
                  System.out.println("Invalid input");
                  input = 0;
              }
          }
        return input; //returning inventory number
    }

    static void displayCart()
    {
       System.out.println("Item\t\t Price");
    	cartMap.forEach((key, value) ->{
    		System.out.println(key+ " \t\t "+ value);
    	});

        //System.out.printf("Total + tax           " +getTotal(PriceOfItem,count, Total));
    }

    static double getTotal()
    {
    	double sum=0.0;
    	for(double f:cartMap.values())
    	{
    		sum+=f;
    	}
    double Tax; //to calculate the tax
    Tax=(8.25/100)*sum;
    
    	System.out.println("Subtotal :" +sum);
    	sum=Tax+sum;
        return sum;// returning the total of the shopping
    }

    static void clearArrays(List<String> NameOfItem,List<Double> PriceOfItem,int count)// function to clear the array so another user can purchase books and Dvds
    {
    	for (int i=0; i<count ;i++)
    	{
    		NameOfItem.set(i, null);
    		PriceOfItem.set(i,0.0); //declaring values as null and 0
    	}

    }


}
