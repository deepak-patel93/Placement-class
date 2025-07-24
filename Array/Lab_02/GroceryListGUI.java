import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }
    public double getTotalPrice() { return product.getPrice() * quantity; }
}

public class GroceryListGUI extends JFrame {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<CartItem> cart = new ArrayList<>();
    private JTextArea cartArea;
    private JLabel totalLabel;

    public GroceryListGUI() {
        setTitle("Grocery List with Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

 
        products.add(new Product("Apples", 200));
        products.add(new Product("Bananas", 70));
        products.add(new Product("Milk", 60));
        products.add(new Product("Bread", 40));
        products.add(new Product("Eggs", 15));
        // products.add(new Product(name:"parotha",price:15));

        JPanel productPanel = new JPanel(new GridLayout(products.size(), 1));
        for (Product p : products) {
            productPanel.add(createProductPanel(p));
        }

        cartArea = new JTextArea(10, 20);
        cartArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartArea);

        totalLabel = new JLabel("Total: 0.00");

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Thank you! Please visit again..."));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(scrollPane, BorderLayout.CENTER);
        rightPanel.add(totalLabel, BorderLayout.SOUTH);
        rightPanel.add(checkoutBtn, BorderLayout.NORTH);

        setLayout(new BorderLayout());
        add(productPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private JPanel createProductPanel(Product product) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel(product.getName() + " (RS. " + product.getPrice() + ")");
        JTextField qtyField = new JTextField("1", 3);
        JButton addBtn = new JButton("Add to Cart");

        addBtn.addActionListener(e -> {
            try {
                int quantity = Integer.parseInt(qtyField.getText());
                if (quantity <= 0) return;
                boolean found = false;
                for (CartItem item : cart) {
                    if (item.getProduct().getName().equals(product.getName())) {
                        item.setQuantity(item.getQuantity() + quantity);
                        found = true;
                        break;
                    }
                }
                if (!found) cart.add(new CartItem(product, quantity));
                updateCartDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity!");
            }
        });

        panel.add(nameLabel);
        panel.add(new JLabel("Qty:"));
        panel.add(qtyField);
        panel.add(addBtn);
        return panel;
    }

    private void updateCartDisplay() {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        for (CartItem item : cart) {
            sb.append(item.getProduct().getName())
              .append(" x ").append(item.getQuantity())
              .append(" = RS.").append(String.format("%.2f", item.getTotalPrice())).append("\n");
            total += item.getTotalPrice();
        }
        cartArea.setText(sb.toString());
        totalLabel.setText("Total: RS" + String.format("%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GroceryListGUI::new);
    }
}