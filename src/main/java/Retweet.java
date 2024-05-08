public class Retweet extends Tweet {
    private Tweet originalTweet;

    public Retweet(String message, UserAccount sender, Tweet originalTweet) {
        super(message, sender);
        this.originalTweet = originalTweet;
    }
}