
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterApp extends JFrame {
    private JLabel lblAmount;
    private JTextField txtAmount;
    private JLabel lblFromCurrency;
    private JComboBox<String> cmbFromCurrency;
    private JLabel lblToCurrency;
    private JComboBox<String> cmbToCurrency;
    private JButton btnConvert;
    private JLabel lblResult;

    // Currency conversion rates
    private static final double USD_TO_INR = 81.9;
    private static final double USD_TO_GBP = 0.78;
    private static final double KWD_TO_INR = 266.5;

    public CurrencyConverterApp() {
        setTitle("Currency Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        lblAmount = new JLabel("Amount:");
        txtAmount = new JTextField(10);
        lblFromCurrency = new JLabel("From:");
        cmbFromCurrency = new JComboBox<>(new String[]{"USD", "KWD"});
        lblToCurrency = new JLabel("To:");
        cmbToCurrency = new JComboBox<>(new String[]{"INR", "GBP", "JPY"});
        btnConvert = new JButton("Convert");
        lblResult = new JLabel("Result:");

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(lblAmount);
        add(txtAmount);
        add(lblFromCurrency);
        add(cmbFromCurrency);
        add(lblToCurrency);
        add(cmbToCurrency);
        add(btnConvert);
        add(lblResult);

        // Register action listener for the Convert button
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        // Get the amount from the text field
        double amount = Double.parseDouble(txtAmount.getText());

        // Get the selected currencies
        String fromCurrency = (String) cmbFromCurrency.getSelectedItem();
        String toCurrency = (String) cmbToCurrency.getSelectedItem();

        // Perform the currency conversion
        double result = 0.0;
        if (fromCurrency.equals("USD")) {
            if (toCurrency.equals("IND")) {
                result = amount * USD_TO_IND;
            } else if (toCurrency.equals("GBP")) {
                result = amount * USD_TO_GBP;
            } else if (toCurrency.equals("JPY")) {
                result = amount * USD_TO_JPY;
            }
        }

        // Display the result
        lblResult.setText("Result: " + result + " " + toCurrency);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverterApp().setVisible(true);
            }
        });
    }
}
