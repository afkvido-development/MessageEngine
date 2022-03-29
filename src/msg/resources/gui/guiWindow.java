package msg.resources.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import msg.Main;
import msg.i;

public class guiWindow {

    protected static JLabel textLabel;

    protected static JTextField textField;

    private static void createWindow () {

        //Create and set up the window.
        JFrame frame = new JFrame("MessageEngine");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Text Label
        textLabel = new JLabel("<html>Messages will display here.<p/><html/>", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);


        // Text Box
        textField = new JTextField("Input message", SwingConstants.CENTER);
        textField.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textField, BorderLayout.SOUTH);

        textField.addActionListener(
                ae -> {

                    if (textField.getText().equals("")) {

                    } else {
                        i.ProcessInput(textField.getText());
                        textLabel.setText("<html>" +
                                textLabel.getText().replace("<html>", "").replace("</html>", "") +
                                "<p>[" + Main.loggedin.getRank() + "] " + Main.loggedin.getUsername() + ": " + textField.getText() + "</p>" +
                                "</html>");
                        textField.setText("");
                    }
                }
        );


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
