import java.util.ArrayList;
import java.util.List;

public class UserAccount {
    public String alias;
    private String email;
    private List<Tweet> tweets;
    private List<Tweet> timeline;
    private List<UserAccount> following;
    private List<UserAccount> followers;

    public UserAccount(String alias, String email) {
        if (!Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("Invalid alias. Alias must contain only letters and numbers.");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.timeline = new ArrayList<>();
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public String getAlias() {
        return alias;
    }

    public void follow(UserAccount user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot follow null user.");
        }
        if (user == this) {
            throw new IllegalArgumentException("Cannot follow oneself.");
        }
        if (!following.contains(user)) {
            following.add(user);
            user.followers.add(this);
        } else {
            System.out.println("Already following " + user.alias);
        }
    }

    public void tweet(Tweet tweet) {
        if (tweet == null) {
            throw new IllegalArgumentException("Cannot tweet a null object.");
        }
        tweets.add(tweet);
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

class Utils {
    public static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public static boolean isValidAlias(String alias) {
        return alias.matches("[a-zA-Z0-9]+");
    }
}
