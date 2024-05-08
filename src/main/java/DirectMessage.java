public class DirectMessage extends Tweet {
    private UserAccount receiver;

    public DirectMessage(String message, UserAccount sender, UserAccount receiver) {
        super(message, sender);
        if (receiver == null) {
            throw new IllegalArgumentException("Receiver cannot be null.");
        }
        this.receiver = receiver;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "DirectMessage to " + receiver.getAlias() + " | " + super.toString();
    }
}
