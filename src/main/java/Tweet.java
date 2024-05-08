import java.time.LocalDate;

public class Tweet {
    private String message;
    private LocalDate time;
    private UserAccount sender;

    public Tweet(String message, UserAccount sender) {
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
