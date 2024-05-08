public class Retweet extends Tweet {
    private Tweet originalTweet;

    public Retweet(String message, UserAccount sender, Tweet originalTweet) {
        super(message, sender);
        if (originalTweet == null) {
            throw new IllegalArgumentException("El tweet original no puede ser nulo.");
        }
        this.originalTweet = originalTweet;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    @Override
    public String toString() {
        return "Retweet de [" + originalTweet.toString() + "] | " + super.toString();
    }
}
