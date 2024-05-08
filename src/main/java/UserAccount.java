import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<UserAccount> followers;
    private List<Tweet> timeline;

    public UserAccount(String alias, String email) {
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public void tweet(Tweet tweet) throws IllegalArgumentException {
        if (tweet.getMessage().length() > 140) {
            throw new IllegalArgumentException("Tweet cannot exceed 140 characters.");
        }
        tweets.add(tweet);
        timeline.add(tweet);
        for (UserAccount follower : followers) {
            follower.timeline.add(tweet);
        }
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

