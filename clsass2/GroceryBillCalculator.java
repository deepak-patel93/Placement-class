// package clsass2;
import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class GroceryBillCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grocery Bill Calculator");
        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel priceLabel = new JLabel("Price per Item:");
        priceLabel.setBounds(50, 30, 150, 20);
        JTextField priceField = new JTextField();
        priceField.setBounds(180, 30, 150, 20);
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 70, 150, 20);
        JTextField quantityField = new JTextField();
        quantityField.setBounds(180, 70, 150, 20);

        JLabel discountLabel = new JLabel("Discount (%):");
        discountLabel.setBounds(50, 110, 150, 20);
        JTextField discountField = new JTextField();
        discountField.setBounds(180,110,150,20);
        JButton calculateButton=new JButton("Calculate Total");
        calculateButton.setBounds(100,150,180,30);
        JLabel resultLable=new JLabel("Total: inr 0.00");
        resultLable.setBounds(140,200,200,20);
        JLabel FeedbackLabel = new JLabel("Feedback:");
        FeedbackLabel.setBounds(50, 110, 150, 100);
        JTextField FeedbackField = new JTextField();
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(discountLabel);
        frame.add(discountField);
        frame.add(calculateButton);
        frame.add(resultLable);
        frame.add(FeedbackLabel);
        frame.add(FeedbackField);
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    double discount = Double.parseDouble(discountField.getText());
                    double total = price* quantity;
                    double discountAmount = total * discount/100;
                    double finalAmount = total - discountAmount;
                    resultLable.setText("Total:"+String.format("%.2f",finalAmount));
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Please Enter Valid Numbers!");
                }
            }
        });
        frame.setVisible(true);
    }
}