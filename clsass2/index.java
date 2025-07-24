// package clsass2;

// import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double total=0;
        double taxrate=0.05;
        System.out.println("Enter number of items: ");
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            System.out.println("Enter item name: ");
            String item = sc.next();
            System.out.println("Enter the price of "+item +":");
            double price = sc.nextDouble();
            System.out.println("Enter quantity of " +item +":");
            int qty =sc.nextInt();
            double amount=price*qty;
            total=amount+(amount*0.05);
            System.out.println(total+ "  ");


        }
        

        
    }
}