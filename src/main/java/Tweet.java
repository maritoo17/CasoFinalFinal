import java.time.LocalDate;

public class Tweet {
    protected String message;
    protected LocalDate time;
    protected UserAccount sender;

    public Tweet(String message, UserAccount sender) {
        if (message == null || message.length() > 140) {
            throw new IllegalArgumentException("Message must not exceed 140 characters and cannot be null.");
        }
        this.message = message;
        this.time = LocalDate.now();
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getTime() {
        return time;
    }

    public UserAccount getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Tweet from " + sender.getAlias() +
                " at " + time +
                ": \"" + message + "\"";
    }
}
