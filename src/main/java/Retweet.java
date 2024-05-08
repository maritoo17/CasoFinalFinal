public class Retweet extends Tweet {
    private Tweet originalTweet;

    public Retweet(String message, UserAccount sender, Tweet originalTweet) {
        super(message, sender);
        this.originalTweet = originalTweet;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    @Override
    public String toString() {
        return "Retweet{" +
                "message='" + message + '\'' +
                ", time=" + time +
                ", sender=" + sender.getAlias() +
                ", originalTweet=" + originalTweet.getMessage() +
                '}';
    }
}
