package msg.resources.gui;

import java.awt.*;
import javax.swing.*;
import msg.i;

public class guiWindow {

    private static void createWindow () {

        //Create and set up the window.
        JFrame frame = new JFrame("Simple GUI");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));

        frame.getContentPane().add(textLabel, BorderLayout.CENTER);

        //Display the window

        frame.setLocationRelativeTo(null);

        frame.pack();

        frame.setVisible(true);


    }

    public static void fire () {
        createWindow();
    }

}
