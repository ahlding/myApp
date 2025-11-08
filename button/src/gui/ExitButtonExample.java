package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonExample {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Exit Button Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a JButton
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 80, 100, 30);

        // Add ActionListener to the button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });

        // Add the button to the frame
        frame.add(exitButton);

        // Make the frame visible
        frame.setVisible(true);
    }
}
