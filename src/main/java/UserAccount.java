import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    String alias;
    private String email;
    private List<Tweet> tweets = new ArrayList<>();
    private List<Tweet> timeline = new ArrayList<>();
    private List<UserAccount> following = new ArrayList<>();
    private List<UserAccount> followers = new ArrayList<>();


    public String getAlias() {
        return alias;
    }

    public UserAccount(String alias, String email) {
        if (!Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("Invalid alias. Alias must contain only letters and numbers.");
        }
        this.alias = alias;
        this.email = email;
    }

    public void follow(UserAccount user) {
        if (user != null && !following.contains(user)) {
            following.add(user);
            user.followers.add(this);
        }
    }

    public void tweet(Tweet tweet) {
        tweets.add(tweet);
        for (UserAccount follower : followers) {
            follower.timeline.add(tweet);
        }
    }

    @Override
    public String toString() {
        return "User: " + alias + ", Email: " + email;
    }
}

class Utils {
    public static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public static boolean isValidAlias(String alias) {
        return alias.matches("[a-zA-Z0-9]+");
    }
}
