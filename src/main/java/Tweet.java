import java.time.LocalDate;

public class Tweet {
    protected String message;
    protected LocalDate time;
    protected UserAccount sender;

    public Tweet(String message, UserAccount sender) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message cannot exceed 140 characters.");
        }
        this.message = message;
        this.time = LocalDate.now();
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Time: " + time + ", Sender: " + sender.alias + ", Message: " + message;
    }
}