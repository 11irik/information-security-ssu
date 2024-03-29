package com.kirill.informationsecurity.gui.text;

import com.kirill.informationsecurity.algorithms.crypto.Crypto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CryptoGUI extends JFrame {
    private JButton encodeButton;
    private JPanel rootPanel;
    private JTextField textEncodeInput;
    private JTextField textEncodeOutput;
    private JTextField textEncodeKey;
    private JTabbedPane tabbedPaneEncode;
    private JPanel encodePane;
    private JPanel tabbedPaneDecode;
    private JTextField textDecodeInput;
    private JTextField textDecodeKey;
    private JTextField textDecodeOutput;
    private JButton buttonDecode;

    public CryptoGUI() {
        setSize(400, 200);
        setContentPane(rootPanel);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String enc = Crypto.encrypt(textEncodeInput.getText(), textEncodeKey.getText());
                    textEncodeOutput.setText(enc);
                } catch (Exception ignored) {
                }
            }
        });

        buttonDecode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String decode = Crypto.decrypt(textDecodeInput.getText(), textDecodeKey.getText());
                    textDecodeOutput.setText(decode);
                } catch (Exception ignored) {
                }
            }
        });
    }

    public static void main(String[] args) {
        new CryptoGUI();
    }

}
