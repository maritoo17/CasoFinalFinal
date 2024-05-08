import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<UserAccount> followers;
    private List<UserAccount> following;
    private List<Tweet> timeline;

    public UserAccount(String alias, String email) {
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.timeline = new ArrayList<>();
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public void follow(UserAccount otherUser) {
        if (!following.contains(otherUser)) {
            following.add(otherUser);
            otherUser.followers.add(this);
        }
    }

    public List<UserAccount> getFollowing() {
        return following;
    }

    public void updateTimeline() {
        timeline.clear();
        for (UserAccount user : following) {
            timeline.addAll(user.getTweets());
        }
        timeline.sort((t1, t2) -> t2.getTime().compareTo(t1.getTime()));
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void tweet(Tweet tweet) throws IllegalArgumentException {
        if (tweet.getMessage().length() > 140) {
            throw new IllegalArgumentException("Tweet cannot exceed 140 characters.");
        }
        tweets.add(tweet);
    }

}

