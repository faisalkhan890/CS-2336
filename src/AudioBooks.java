import java.util.Scanner;

class AudioBooks extends Books {//Audio books inheriting properties from Books using extend
    private double runningTime;
    
    //getter function for audio books
    public double getRunningTime ()
    {
        return runningTime;
    }

    AudioBooks()//default constructor for audio books
    {

    }

    AudioBooks(Scanner in, int UniqueCode, double discount)
    {
        super (in, UniqueCode,discount);//calling propeties of parent class using super

        System.out.println("Enter Running Time: ");//taking running time input and checking it
        runningTime = in.nextDouble();
        do
        {

            System.out.println("Enter Audio Book Price");
            while(!in.hasNextDouble())
            {
                System.out.println("Invalid price");//outputting wrong input statement
                in.next();
            }
            price= in.nextDouble();
            price=price-(price*discount);
        }while(runningTime <=0);//checking greater than zero
    }
    public double getPrice ()//overridden get Price function for Audio Books
    {
       
        return price;
    }

    public String toString()//overridden to String function for Audio Books
    {
        String s="Title: <" +getTitle() +">| Author: <" +getAuthor() +">| Price: <"+ getPrice() +">| ISBN: <"+getISBN()+">| RunningTime: <"+getRunningTime()+">";
        return s;
    }


}
