import java.util.ArrayList;
import java.util.List;

public class Message {
    private static List<Message> messageCache = new ArrayList<>();
    private static int count = 0;
    private String msg;

    public Message(String txt) {
        count++;
        this.msg = String.format("Msg (#%d) %s",count,txt);
    }

    public void putInCache() {
        messageCache.add(this);
    }

    public void writeMessage() {
        System.out.println(this.msg);
    }

    public static Message getMessage(int index) throws Exception {
        if (index < 0 || index >= messageCache.size()) {
            throw new Exception("Message is not in cache any more. Please load it from disk!");
        }

        return messageCache.get(index);
    }

    public static void main(String... args) {
        for (int i = 0; i < 10_000_000; i++){
            // message received here
            Message msg = new Message("test");
            msg.putInCache();
        }

        try {
            Message.getMessage(42).writeMessage();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}