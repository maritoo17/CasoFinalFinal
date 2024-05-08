import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private static Scanner scanner = new Scanner(System.in);

    public static String leerCadena() {
        return scanner.nextLine();
    }

    public static int leerEntero() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Por favor, introduce un número entero.");
        }
        return scanner.nextInt();
    }

    public static float leerFloat() {
        while (!scanner.hasNextFloat()) {
            scanner.next();
            System.out.println("Por favor, introduce un número flotante.");
        }
        return scanner.nextFloat();
    }

    public static double leerDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Por favor, introduce un número doble.");
        }
        return scanner.nextDouble();
    }
}

