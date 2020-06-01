import java.util.Scanner;

class DVDs
{
    //class variables for DVDs
    private String director;
    private String title;
    private int year;
    private int dvdCode;
    private double price;

    //get functions for DVDs
    public String getTitle ()
    {
        return title;
    }

    public String getDirector ()
    {
        return director;
    }

    public int getYear ()
    {
        return year;
    }

    public int getDvdCode ()
    {
        return dvdCode;
    }

    public double getPrice ()
    {
        return price;
    }

    public String toString() //to string function for DVDs
    {
        String s="Title: <" +getTitle() +">| Director: <" +getDirector() +">| Price: <"+ getPrice() +">| Year: <"+getYear()+"> | DvdCode: <"+getDvdCode()+">";
        return s;
    }

    DVDs() // empty/default constructor
    {

    }

    DVDs(Scanner in,int UniqueCode,double discount)//parameter constructor
    {
        System.out.println("Enter DVD Title: ");
        title = in.nextLine().toUpperCase();
        while(title.isEmpty())//checking if string is empty
        {
            System.out.println("Empty String entered. Enter DVD Title: ");//outputting wrong input statement
            title = in.nextLine().toUpperCase();
        }

        System.out.println("Enter Director: ");
        director = in.nextLine();//taking input
        while(director.isEmpty())//checking if string is empty
        {
            System.out.println("Empty String entered. Enter Director: ");//outputting wrong input statement
            director = in.nextLine();
        }

        do
        {

            System.out.println("Enter Year");
            while(!in.hasNextDouble())
            {
                System.out.println("Invalid year");//outputting wrong input statement
                in.next();//clearing the buffer
            }
            year= in.nextInt();
        }while(year <=0);//checking greater than zero

        dvdCode = UniqueCode;

        do //input validation
        {

            System.out.println("Enter DVD Price");
            while(!in.hasNextDouble())
            {
                System.out.println("Invalid price");//outputting wrong input statement
                in.next();//clearing the buffer
                
            }
            price= in.nextDouble();
            price = price - (price*discount);
        }while(price <=0);//checking greater than zero

    }
}