import java.time.LocalDate;

public class Tweet {
    private String message;
    private LocalDate time;
    private UserAccount sender;
    private int ID;

    public Tweet(String message, UserAccount sender) {
        this.message = message;
        this.time = LocalDate.now();
        this.sender = sender;
        this.ID = 0;
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

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Tweet de " + sender.getAlias() +
                " el día " + time +
                ": \"" + message + "\"";
    }
}
