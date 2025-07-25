interface paymentGateway {
    void pay(double amount);

}

class CrditCardPayments implements paymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    } 

}
class DebitCard implements paymentGateway{
    public void pay(double amount){
        System.out.println("Paid "+ amount + " using Debit card");
    }
}

public class Interface {
    public static void main(String[] args) {
        CrditCardPayments cc=new CrditCardPayments();
        DebitCard db=new DebitCard();
        db.pay(5000);
        cc.pay(100000);

    }

}
