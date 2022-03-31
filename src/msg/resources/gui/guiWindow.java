package msg.resources.gui;

import msg.Main;
import msg.i;

import javax.swing.*;
import java.awt.*;

/** MessageEngine GUI <p></p>
 * @author gemsvidø
 * @since 0.2.3 */
public class guiWindow {

    protected JLabel textLabel;

    protected JTextField textField;

    protected Boolean built;

    protected JFrame frame;

    /** (Private) Create and display a MessageEngine GUI window <p></p>
     * @author gemsvidø
     * @since 0.2.3 */
    private void createWindow () {




        //Create and set up the window.
        frame = new JFrame("MessageEngine");


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


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

                    if (!textField.getText().equals("")) {

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


        // Ready the window for Display

        frame.setLocationRelativeTo(null);
        frame.pack();



    }


    /** Push content to a MessageEngine GUI window <p></p>
     * @author gemsvidø
     * @since 0.2.3 */
    public void push (String content) {

        if (!content.equals("")) {

            textLabel.setText("<html>" +
                    content.replace("<html>", "").replace("</html>", "") +
                    "<p>[" + Main.loggedin.getRank() + "] " + Main.loggedin.getUsername() + ": " + textField.getText() + "</p>" +
                    "</html>");

        }

    }

    /** Display this MessageEngine GUI window <p></p>
     * @author gemsvidø
     * @since 0.2.3 */
    public void show () {
        frame.setVisible(true);
    }


    /** Stop displaying this MessageEngine GUI window <p></p>
     * @author gemsvidø
     * @since 0.2.3 */
    public void hide () {
        frame.setVisible(false);
    }


    /** Create and display a MessageEngine GUI window <p></p>
     * @author gemsvidø
     * @since 0.2.3 */
    public guiWindow () {
        createWindow();
    }

}
