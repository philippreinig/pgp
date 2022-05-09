package pgp.buttons;

import java.awt.*;
import java.util.Random;

public class RecolorPGPButton extends PGPButton {
    private static final Random rand = new Random();
    public RecolorPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        System.out.println(this.getText() + " was clicked");
        int r = RecolorPGPButton.rand.nextInt(256);
        int g = RecolorPGPButton.rand.nextInt(256);
        int b = RecolorPGPButton.rand.nextInt(256);

        this.setBackground(new Color(r,g,b));
    }
}