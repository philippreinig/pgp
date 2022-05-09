package pgp.buttons;

import javax.swing.*;
import java.awt.*;

public class PGPButton extends JButton {
    /* static constants to define width and height of buttons */
    private final static int BUTTON_WIDTH = 200;
    private final static int BUTTON_HEIGHT = 25;

    /* several constructors */

    public PGPButton(String label) {
        this(label, null);
    }

    public PGPButton(Icon icon) {
        this(null, icon);
    }

    public PGPButton(String label, Icon icon) {
        super(label, icon);

        // set button size
        this.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

        // add action listener which calls the click method if button is clicked
        this.addActionListener(actionListener -> this.click());
        this.setVisible(true);
    }

    public void click() {
        System.out.println(this.getText() + " was clicked!");
    }
}