public class DirectMessage extends Tweet {
    private UserAccount receiver;

    public DirectMessage(String message, UserAccount sender, UserAccount receiver) {
        super(message, sender);
        if (receiver == null) {
            throw new IllegalArgumentException("El recibidor no puede ser nulo.");
        }
        this.receiver = receiver;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "DirectMessage a " + receiver.getAlias() + " | " + super.toString();
    }
}
