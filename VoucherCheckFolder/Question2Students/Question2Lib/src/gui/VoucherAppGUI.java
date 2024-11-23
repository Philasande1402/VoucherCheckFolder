/*
(2.3) VoucherAppGUI Class (10):
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.VoucherCheck;
import models.Voucher;

public class VoucherAppGUI extends JFrame {
    private JTextField voucherCodeField;
    private VoucherCheck voucherCheck;

    public VoucherAppGUI(VoucherCheck voucherCheck) {
       
        

        // Set up the frame
        setTitle("Voucher Management System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create and add components
        voucherCodeField = new JTextField(20);
        add(new JLabel("Enter Voucher Code:"));
        add(voucherCodeField);

        JButton checkButton = new JButton("Check Voucher");
        add(checkButton);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = voucherCodeField.getText();
                
                Voucher voucher = new Voucher(code);
                
               // VoucherCheck vc = new VoucherCheck();
                
                boolean redeemed = voucherCheck.checkVoucher(voucher);
                if(redeemed)
                {
                    JOptionPane.showMessageDialog(null, "Voucher is valid.");
                }else
                {
                    JOptionPane.showMessageDialog(null, "Voucher has been redeemed.NOT VALID");
                }
            }
        });

        JButton clearButton = new JButton("Clear");
        add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               voucherCodeField.setText("");
            }
        });

        JButton exitButton = new JButton("Exit");
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
        });
    }
}

