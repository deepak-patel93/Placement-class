package GUIProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CartGUI extends JFrame {

    private Cart cart;
    private DefaultListModel<Product> productListModel;
    private DefaultListModel<Product> cartListModel;
    private JList<Product> productList;
    private JList<Product> cartList;
    private JLabel totalLabel;

    public CartGUI() {
        setTitle("Amazon Cart Simulation");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        cart = new Cart();

        productListModel = new DefaultListModel<>();
        cartListModel = new DefaultListModel<>();

        productListModel.addElement(new Product("Laptop", 59999.99));
        productListModel.addElement(new Product("Phone", 19999.49));
        productListModel.addElement(new Product("Book", 499.00));
        productListModel.addElement(new Product("Headphones", 1499.99));

        productList = new JList<>(productListModel); 
        cartList = new JList<>(cartListModel);

        totalLabel = new JLabel("Total: 0.00");

        JButton addButton = new JButton("Add to Cart");
        JButton removeButton = new JButton("Remove from Cart");
        JButton clearButton = new JButton("Clear Cart");

        
        addButton.addActionListener(e -> {
            Product selected = productList.getSelectedValue();
            if (selected != null) {
                cart.addProduct(selected);
                cartListModel.addElement(selected);
                updateTotal();
            }
        });

       
        removeButton.addActionListener(e -> {
            Product selected = cartList.getSelectedValue();
            if (selected != null) {
                cart.removeProduct(selected);
                cartListModel.removeElement(selected);
                updateTotal();
            }
        });

        
        clearButton.addActionListener(e -> {
            cart.clearCart();
            cartListModel.clear();
            updateTotal();
        });

     
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Available Products"), BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(productList), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Your Cart"), BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(); 
        controlPanel.add(addButton);
        controlPanel.add(removeButton);
        controlPanel.add(clearButton);
        controlPanel.add(totalLabel);

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void updateTotal() {
        totalLabel.setText("Total: ₹" + String.format("%.2f", cart.getTotal()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CartGUI().setVisible(true));
    }
}

