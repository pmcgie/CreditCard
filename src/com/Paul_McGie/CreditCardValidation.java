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
    private JPanel MainPanel;

    public CreditCardValidation() {
        super("Credit Card Validator");
        setContentPane(MainPanel);
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
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(CreditCardValidation.this, "Are" +
                        "you sure you want to quit?","Confirm Quit",JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private boolean isVisaCreditCardNumberValid(String ccNumber) {
        //Set starting decision to true
        boolean Decision = true;

        //Set initial position
        int cc_Pos = 1;

        //Set initial value
        int cc_val = 0;
        int Calc_Num = 0;
        int New_val = 0;

        //Place string into int array
        String Numbers [] = ccNumber.split("");
        int [] Num_List = new int[Numbers.length];

        //Run through equation and validation
        for (int x = 0; x < ccNumber.length();x++) {

            //Parse into integer
            Num_List[x] = Integer.parseInt(Numbers[x]);

            //Check position to determine calculation
            if (cc_Pos % 2 != 0) {
                Calc_Num = (Num_List[x] * 2);
            } else {
                Calc_Num = Num_List[x];
            }

            //If number * 2 is greater than 10 split number for calc and add both numbers
            if (Calc_Num >= 10) {
                //Set conditions
                String New_Num = Integer.toString(Calc_Num);
                String [] Split_Num = New_Num.split("");
                int[] Split_Nums = new int[Split_Num.length];

                for (int y = 0; y < Split_Num.length; y++) {
                    New_val = New_val + Split_Nums[y];
                    cc_val = cc_val + New_val;
                }

            } else {
                cc_val = cc_val + Calc_Num;
            }
            //Define cc position
            cc_Pos = cc_Pos+1;
        }

        //Determine Decision
        if (cc_val % 10 == 0) {
            Decision = true;
        } else {
            Decision = false;
        }

        return Decision;

    }


}
