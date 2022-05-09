package pgp.buttons;

public class PrintPositionPGPButton extends PGPButton {
    public PrintPositionPGPButton(String label) {
        super(label);
    }

    @Override
    public void click() {
        System.out.println(this.getText() + " was clicked: " + this.getX() + ", " + this.getY());

    }
}
