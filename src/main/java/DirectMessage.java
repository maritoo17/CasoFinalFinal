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
        return "DirectMessage{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", sender=" + sender.getAlias() +
                ", receiver=" + receiver.getAlias() +
                '}';
    }
}
