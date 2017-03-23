package com.Paul_McGie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pmcgie on 3/22/2017.
 */
public class CreditCardValidation extends JFrame {
    private JTextField cardNumberTextField;
    private JButton validateButton;
    private JButton quitButton;
    private JLabel validMessageLabel;
    private JPanel rootPanel;

    public CreditCardValidation() {
        super("Credit Card Validator");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ccNumber = cardNumberTextField.getText();

                boolean valid = isVisaCreditCardNumberValid(ccNumber);

                if (valid) {
                    validMessageLabel.setText("Credit card valid");
                } else {
                    validMessageLabel.setText("Credit card number is not valid");
                }
            }
        });
    }

    private boolean isVisaCreditCardNumberValid(String ccNumber) {

    }


}
