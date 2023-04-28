package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class display extends JFrame implements ActionListener {
    JFrame d;
    JTextField amountField;
    JButton exchangeButton;
    JComboBox<String> toCurrencyList;
    JLabel resultLabel;

    public display() {
        d = new JFrame();
        d.setVisible(true);
        d.setBounds(0, 0, 800, 600);
        
        // Create a new text field for entering the amount of money
        amountField = new JTextField(10);
        
        // Create a new button for initiating the exchange
        exchangeButton = new JButton("Exchange");
        exchangeButton.addActionListener(this);
        
        // Create a new select list of currencies for "to" options
        String[] currencies = {"USD", "EUR", "MXN"};
        toCurrencyList = new JComboBox<String>(currencies);
        
        // Create a new label for displaying the result of the exchange
        resultLabel = new JLabel("Result: ");
        
        // Create a new panel and add the components to it
        JPanel panel = new JPanel();
        panel.add(new JLabel("Amount (in Quetzals): "));
        panel.add(amountField);
        panel.add(new JLabel("To: "));
        panel.add(toCurrencyList);
        panel.add(exchangeButton);
        panel.add(resultLabel);
        
        // Add the panel to the frame
        d.add(panel);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Define the exchange rates for each currency
        double usdRate = 0.129;
        double eurRate = 0.108;
        double mxnRate = 2.6;

        // Get the amount entered by the user as a double
        double amount = Double.parseDouble(amountField.getText());

        // Get the selected currency from the select list
        String toCurrency = (String) toCurrencyList.getSelectedItem();

        // Convert the amount from Quetzals to the selected currency
        double result;
        if (toCurrency.equals("USD")) {
            result = amount * usdRate;
        } else if (toCurrency.equals("EUR")) {
            result = amount * eurRate;
        } else {
            result = amount * mxnRate;
        }

        // Display the result in the label
        resultLabel.setText("Result: " + result + " " + toCurrency);
    }
}
