public class DirectMessage extends Tweet {
    private UserAccount receiver;

    public DirectMessage(String message, UserAccount sender, UserAccount receiver) {
        super(message, sender);
        this.receiver = receiver;
    }
}
