package pgp.buttons;

import java.sql.Timestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintClickHistoryPGPButton extends PGPButton {
    private final List<String> clickHistory;
    private final Date date;
    public PrintClickHistoryPGPButton(String label) {
        super(label);
        this.clickHistory = new ArrayList<>();
        this.date = new Date();
    }

    @Override
    public void click() {
        clickHistory.add(new Timestamp(System.currentTimeMillis()).toString());
        System.out.println(this.getText() + " was clicked. History is:");
        for(String s : clickHistory){
            System.out.println("\t" + s);
        }

    }
}