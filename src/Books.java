import java.util.Scanner;

public class Books
{
    private String title;
    private String author;
    private int ISBN;
    protected double price;
    double discount;

    public String getTitle ()
    {
        return title;
    }

    public String getAuthor ()
    {
        return author;
    }

    public int getISBN ()
    {
        return ISBN;
    }

    public double getPrice ()
    {
        return price;
    }

    public String toString()
    {
        String s="Title: <" +getTitle() +">| Author: <" +getAuthor() +">| Price: <"+ getPrice() +">| ISBN: <"+getISBN()+">";
        return s;
    }

    Books()//default constructor for Books
    {

    }


    Books(Scanner in, int UniqueCode, double discount)
    {
        System.out.println("Enter Book Title: ");
        title = in.nextLine().toUpperCase();//taking input from the user

        while(title.isEmpty())//checkng if string is empty
        {
            System.out.println("Empty String entered. Enter Book Title: ");//outputting wrong input statement
            title = in.nextLine().toUpperCase();
        }

        System.out.println("Enter Author: ");
        author = in.nextLine();//taking input from the user

        while(author.isEmpty())//checkng if string is empty
        {
            System.out.println("Empty String entered. Enter Author: ");//outputting wrong input statement
            author = in.nextLine();

        }

        ISBN = UniqueCode;

        do
        {

            System.out.println("Enter Book Price: ");
            while(!in.hasNextDouble())
            {
                System.out.println("Invalid price");//outputting wrong input statement
                in.next();
            }
            price= in.nextDouble();
            price= price - (price*discount);
        }while(price <=0);//checking greater than zero

    }

}