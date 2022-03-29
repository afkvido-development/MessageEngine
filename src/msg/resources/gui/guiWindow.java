package msg.resources.gui;

import java.awt.*;
import javax.swing.*;
import msg.i;

public class guiWindow {

    private static void createWindow () {

        //Create and set up the window.
        JFrame frame = new JFrame("MessageEngine");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Text Label
        JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);


        // Text Box
        JTextField textField = new JTextField("I'm a text field in the window", SwingConstants.CENTER);
        textField.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textField, BorderLayout.SOUTH);

        // Icon
        frame.setIconImage(new ImageIcon("https://raw.githubusercontent.com/afkvido/image-repository/ImageRepo/1875584.png").getImage());


        //Display the window

        frame.setLocationRelativeTo(null);

        frame.pack();

        frame.setVisible(true);


    }

    public static void fire () {
        createWindow();
    }

}
