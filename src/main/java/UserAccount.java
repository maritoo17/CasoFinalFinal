import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<UserAccount> followers;
    private List<UserAccount> following;
    private List<Tweet> timeline;
    private List<String> followActivities;

    public UserAccount(String alias, String email) {
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.timeline = new ArrayList<>();
        this.followActivities = new ArrayList<>();
    }

    public void follow(UserAccount otherUser) {
        if (!following.contains(otherUser)) {
            following.add(otherUser);
            otherUser.followers.add(this);
            followActivities.add("Followed " + otherUser.getAlias() + " on " + LocalDate.now());
        }
    }

    public List<String> getFollowActivities() {
        return followActivities;
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

    public void tweet(Tweet tweet) throws IllegalArgumentException {
        if (tweet.getMessage().length() > 140) {
            throw new IllegalArgumentException("El tweet no puede superar los 140 caracteres.");
        }
        tweets.add(tweet);
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
