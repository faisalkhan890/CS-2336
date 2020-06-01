import java.awt.print.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Main {

	private static Scanner in;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Prompts menus = new Prompts();
		CredentialCheck cCheck = new CredentialCheck();
		 
		in = new Scanner(System.in);
		  Scanner sc= new Scanner(System.in);
	       ArrayList<Books> books = new ArrayList<>();//array list for books and audiobooks
	        ArrayList<DVDs> dvds = new ArrayList<>();//array list for DVds

	    int BookCount=0,DVDcount=0;//setting the number of books/audiobooks and Dvds to 0
	    boolean run = true;
	    while(run) {
	   
	    menus.MenuInitial();
		String choice = in.next();
		
		
		if(choice.equals("A") || choice.equals("a")) {
			int choiceNum = 0;
			String user = Prompts.credential();
			 if(cCheck.found(user))
			 {
				 int cont = 10;
				 while(cont != 9) {
				 menus.Catalog();
				
				do {
					 try {
						 choiceNum = in.nextInt();
						 if(!(choiceNum<=9 && choiceNum>0))
						 {
							 System.out.println("Invalid Entry");
						 }
					 }
					 catch(InputMismatchException a)
					 {
						 System.out.println("Must Enter  a Number");
						 in.next();
						
					 }
				}while(!(choiceNum<=9 && choiceNum>0));
				
				 int UniqueCode=0;
				 boolean check;
				 switch (choiceNum)
		            { // switch for the choices
		                case 1:
		                    check=true;
		                    while(check)
		                    {
		                        check = false;

		                        do
		                        {
		                            System.out.println("Enter Book ISBN");
		                            while(!sc.hasNextInt())//checking for valid input
		                            {
		                                System.out.println("Invalid  number");
		                                sc.next();//clearing the buffer
		                            }
		                            UniqueCode= sc.nextInt();
		                        }while(UniqueCode <=0);//checking for positive



		                        sc.nextLine();//checking for existing ISBN number
		                        for (int i = 0; i < books.size(); i++)
		                        {
		                            if (UniqueCode == books.get(i).getISBN())
		                            {
		                                System.out.println("The Book already exists. Re-enter a different ISBN: ");
		                                check = true;
		                                break;
		                            }
		                        }
		                    }
		                    Books objt = new Books(sc, UniqueCode, .9);//creating new object for books
		                    books.add(objt);
		                    ++BookCount;
		                    break;


		                case 2:      check=true;
		                    while(check)
		                    {
		                        check = false;

		                        do
		                        {
		                            System.out.println("Enter Audio Book ISBN: ");
		                            while(!sc.hasNextInt())//checking for valid input
		                            {
		                                System.out.println("Invalid  number ");
		                                sc.next();
		                            }
		                            UniqueCode= sc.nextInt();
		                        }while(UniqueCode <=0);//checking for positive

		                        sc.nextLine();//checking for existing ISBN number
		                        for (int i = 0; i < books.size(); i++)
		                        {
		                            if (UniqueCode == books.get(i).getISBN())
		                            {
		                                System.out.println("The Audio Book already exists. Re-enter a different Audio Book ISBN: ");
		                                check = true;
		                                break;
		                            }
		                        }
		                    }
		                    AudioBooks objt1 = new AudioBooks(sc, UniqueCode,.5);//creating new object for Audio books
		                    books.add(objt1);
		                    ++BookCount;
		                    break;


		                case 3:  check=true;//adding DVD to the DVD array list
		                    while(check)
		                    {
		                        check = false;
		                        do
		                        {
		                            System.out.println("Enter DVD code: ");
		                            while(!sc.hasNextInt()) //checking for valid input
		                            {
		                                System.out.println("Invalid  number ");
		                                sc.next();
		                            }
		                            UniqueCode= sc.nextInt();
		                        }while(UniqueCode <=0);

		                        sc.nextLine();
		                        for (int i = 0; i < dvds.size(); i++)//checking for existing DVDs
		                        {
		                            if (UniqueCode == dvds.get(i).getDvdCode())
		                            {
		                                System.out.println("The DVD already exists. Re-enter a different DVD Code: ");
		                                check = true;
		                                break;
		                            }
		                        }
		                    }
		                    DVDs objt2 = new DVDs(sc,UniqueCode,.8);//creating new object for DVDs
		                    dvds.add(objt2);
		                    ++DVDcount;
		                    break;

		                case 4: //remove books
		                    System.out.println("Enter Book title : ");
		                   String titleIn=sc.next().toUpperCase();
		                    check=false;
		                    for(int i=0; i<books.size();i++)
		                    {
		                        if(titleIn.equals(books.get(i).getTitle()))//checking if the similar Book/Audiobook is found
		                        {
		                            books.remove(i);//removing book
		         
		                            check=true;
		                            break;
		                        }

		                    }
		                    if(!check)
		                    {
		                        System.out.println("The Book does not exist in the Catalog");
		                    }
		                    break;

		                case 5://remove DVDs
		                    System.out.println("Enter DVD Title  number: ");
		                   String dvdTitle = in.next().toUpperCase();
		                    check=false;
		                    for(int i=0; i<dvds.size();i++)
		                    {
		                        if (dvdTitle.equals(dvds.get(i).getTitle()))//checking if the similar DVD is found
		                        {
		                            dvds.remove(i);//removing DVD
		                            
		                            check=true;
		                            break;
		                        }

		                    }
		                    if(!check)
		                    {
		                        System.out.println("The DVD does not exist in the Catalog");
		                    }
		                    
		                case 6: // display catalog
		                    for(int i=0;i<books.size();i++)
		                    {
		                        //if else for book or audiobook
		                        System.out.println(books.get(i).toString());//calling the toString function to display
		                    }
		                    System.out.println("-----------------------------------------------------------------------------------------------------------------");

		                    for(int i=0;i<dvds.size();i++)
		                    {
		                        System.out.println(dvds.get(i).toString());//calling the toString function to display
		                    }

		                    break;
		                    
		                case 7:
		                	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		                	   LocalDateTime now = LocalDateTime.now();  //to get the time and date
		                	   String titleOfTxt="catalog_backup_"+dtf.format(now);
		                	   File file = new File(titleOfTxt + ".txt") ;
		                	   BufferedWriter out = new BufferedWriter(new FileWriter(file));//writing to the file
		                	   
		                	   out.write("BOOKS\n");
		                	   Books tempBook ;
		                	   for(int z=0; z<books.size();z++ )
			                	  {
		                		   tempBook= books.get(z);
		                		   out.write(tempBook.getISBN() + "  "+ tempBook.getTitle()+"  "+ tempBook.getAuthor()+"  "+ tempBook.getPrice()+"\n");
			                	  }
		                	   out.write("\nDVDS\n");
		                	   DVDs tempDvd;
		                	   for(int z=0; z<dvds.size();z++ )
			                	  {
		                		   tempDvd = dvds.get(z);
		                		   out.write(tempDvd.getDvdCode()+ "    "+ tempDvd.getTitle()+"  "+tempDvd.getDirector()+"  "+ tempDvd.getPrice()+"\n");
			                	  }
		                	  
		                	   out.close();//closing the file
		                	   break;
		               
		                case 9: System.out.println("Exiting Catalog Section");
		                	cont=9;//exiting the manager catalog
		                    break;

		                default:
		                    System.out.println("This option is not acceptable. Re-enter your choice");// choice to end the program


		            	}
					 }

				 }
			
				 
			 }
		else if(choice.equals("B") || choice.equals("b")) {
			int cont= 10;
			int choiceNum=0;
			while(cont!=9) {
			 menus.shoppingSection();
		
				do {
					 try {
						 choiceNum = in.nextInt();
						 if(!(choiceNum<=9 && choiceNum>0))
						 {
							 System.out.println("Invalid Entry");
						 }
					 }
					 catch(InputMismatchException a)
					 {
						 System.out.println("Must Enter  a Number");
						 in.next();
						
					 }
				}while(!(choiceNum<=9 && choiceNum>0));
	           switch (choiceNum) { // switch for the choices
	               case 1:
	            	   if(!books.isEmpty()) {
	            	   List<Books> tempList = new ArrayList<>(books);
	            	   
	            	   for(int i=0;i<tempList.size()-1;i++)
	            	   {
	            		   for(int j=i+1;j<tempList.size();j++)
	            		   {
	            			   if(tempList.get(i).getPrice() > tempList.get(j).getPrice())
	            			   {
	            				   Books tmp = tempList.get(i);
	            				   tempList.set(i, tempList.get(j));
	            				   tempList.set(j, tmp);
	            			   }
	            		   }
	            	   }
	            	   
	            	   System.out.println("ISBN\t\t"+"Title\t\t"+"Author\t\t"+"Price" );
	            	   for(int i=0;i<tempList.size();i++)
	            	   {
	            		   Books info=tempList.get(i);
	            		   System.out.print(info.getISBN()+"\t\t");
	            		   System.out.print(info.getTitle()+"\t\t");
	            		   System.out.print(info.getAuthor()+"\t\t");
	            		   System.out.print(info.getPrice()+"\n");
	            		   
	            	   }
	            	   }
	            	   else
	            		   System.out.println("No books currently");
	                   break;

	               case 2:
	            	   if(!dvds.isEmpty()) {
		            	   List<DVDs> tempList = new ArrayList<>(dvds);
		            	  
		            	   for(int i=0;i<tempList.size()-1;i++)
		            	   {
		            		   for(int j=i+1;j<tempList.size();j++)
		            		   {
		            			   if(tempList.get(i).getPrice() > tempList.get(j).getPrice())
		            			   {
		            				   DVDs tmp = tempList.get(i);
		            				   tempList.set(i, tempList.get(j));
		            				   tempList.set(j, tmp);
		            			   }
		            		   }
		            	   }
		            	   
		            	   System.out.println("Code\t\t"+"Title\t\t"+"Author\t\t"+"Year\t\t"+"Price" );
		            	   for(int i=0;i<tempList.size();i++)
		            	   {
		            		   DVDs info=tempList.get(i);
		            		   System.out.print(info.getDvdCode()+"\t\t");
		            		   System.out.print(info.getTitle()+"\t\t");
		            		   System.out.print(info.getDirector()+"\t\t");
		            		   System.out.print(info.getYear()+"\t\t");
		            		   System.out.print(info.getPrice()+"\n");
		            		   
		            	   }
		            	   }
		            	   else
		            		   System.out.println("No DVDs currently");
	                    break;

	               case 3:				//adding book or audio books with their title
	            	   System.out.println("Enter the Title of the book you wish to add to cart");
	            	   String titlebook= in.next().toUpperCase().trim();
	            	   System.out.println(titlebook);
	            	   boolean status = true;
	            	   for (int i =0 ;i<books.size();i++)
	            	   {
	            		  
	            		 if(titlebook.equals( books.get(i).getTitle().trim()))
	            		 {
	            			 Boption.addBook(books.get(i));
	            			 status=false;
	            			 break;
	            		 }
	            	  }
	            	   if(status)
	            	   {
	            		   System.out.println("No Book with that title");
	            	   }
	            	  
	                   break;

	               case 4:		//adding DVD with their title
	                      System.out.println("Enter the DVD Title you wish to add to cart");
	                     String dvdTitle= in.next().toUpperCase().trim();
	                     status = true;
	                      for (int i =0 ;i<dvds.size();i++)
		            	   {
		            		 if(dvdTitle.equals(dvds.get(i).getTitle().trim()))
		            		 {
		            			 Boption.addDvd(dvds.get(i));
		            			 status=false;
		            			 break;
		            		 }
		            		
		            		
		            	   }
	                      if(status)
		            	   System.out.println("DVD Title not found");
	                      
	                   break;



	               case 5:							//deleting Book if in cart
	            	   System.out.println("Enter the Title of the Book you wish to Delete");
	            	   String titleBook= in.next().toUpperCase().trim();
	            	   boolean stat = true;
	            	   if(Boption.ifInCart(titleBook)) {
	            	   for (int i =0 ;i<books.size();i++)
	            	   {
	            		 if(titleBook.equals(books.get(i).getTitle().trim()))
	            		 {
	            			 Boption.deleteCart(books.get(i).getTitle());
	            			 stat=false;
	            			 break;
	            		 }
	            		
	            		
	            	   }
	            	   }
	            	   if(stat)
	            		   System.out.println("book not in cart");
	            	  break;

	               case 6:					//deleting DVD if in cart
	            	   System.out.println("Enter the Title of the Dvd you wish to Delete");
	            	   String titleDvd= in.next().toUpperCase().trim();
	            	    stat = true;
	            	   if(Boption.ifInCart(titleDvd)) {
	            	   for (int i =0 ;i<dvds.size();i++)
	            	   {
	            		 if(titleDvd.equals(dvds.get(i).getTitle().trim()))
	            		 {
	            			 Boption.deleteCart(dvds.get(i).getTitle());
	            			 stat=false;
	            			 break;
	            		 }
	            		
	            		
	            	   }
	            	   }
	            	   if(stat)
	            		   System.out.println("Dvd not in cart");
	            	  break;

	               case 7:					//displaying the contents of the cart
	            	   Boption.displayCart();
	            	   break;

	               case 8:System.out.println("Total :" + Boption.getTotal()); // giving the total amount
	                       break;
	               case 9:
	            	   cont=9;
	            	   break;

	               default:
	                   System.out.println("This option is not acceptable ");// choice to end the program



	           }

	     	}
		}
		else if(choice.equals("C")|| choice.equals("c")) // choice to end the program and exit the store
		{
			run = false;
		}
			
		}
	    
	    System.out.println("Have a Good day!!" );
		
	 }

}

