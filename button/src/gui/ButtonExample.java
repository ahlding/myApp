package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonExample {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("JFrame Button Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Using null layout for manual positioning

        // Create a JButton
        JButton button = new JButton("Click Me");
        button.setBounds(150, 100, 100, 40); // Set position and size (x, y, width, height)

        // Add the button to the frame
        frame.add(button);


        // Make the frame visible
        frame.setVisible(true);
    }
}
