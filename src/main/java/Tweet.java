import java.time.LocalDate;

public class Tweet {
    private static int nextId = 1;
    private int ID;
    private String message;
    private LocalDate time;
    private UserAccount sender;

    public Tweet(String message, UserAccount sender) {
        this.ID = nextId++;
        this.message = message;
        this.time = LocalDate.now();
        this.sender = sender;
    }

    public int getID() {
        return ID;
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
        return "Tweet de " + sender.getAlias() +
                " el día " + time +
                ": \"" + message + "\"";
    }
}
