import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static UserAccount currentUser;
    private static Map<String, UserAccount> allUsers = new HashMap<>();

    public static void main(String[] args) {
        currentUser = new UserAccount("user123", "user123@example.com");
        allUsers.put(currentUser.getAlias(), currentUser);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nOptions:\n1. Write a tweet\n2. Show timeline\n3. Follow a user\nType 'exit' to quit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    writeTweet(scanner);
                    break;
                case "2":
                    showTimeline();
                    break;
                case "3":
                    followUser(scanner);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid number.");
                    break;
            }
        }
        scanner.close();
    }

    private static void writeTweet(Scanner scanner) {
        System.out.print("Write your tweet: ");
        String tweetText = scanner.nextLine();
        try {
            Tweet newTweet = new Tweet(tweetText, currentUser);
            currentUser.tweet(newTweet);
            System.out.println("Tweet successfully posted!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showTimeline() {
        List<Tweet> userTweets = currentUser.getTweets();
        if (userTweets.isEmpty()) {
            System.out.println("Your timeline is empty.");
        } else {
            System.out.println("Your timeline:");
            userTweets.forEach(tweet -> System.out.println(tweet.toString()));
        }
    }

    private static void followUser(Scanner scanner) {
        System.out.print("Enter the alias of the user you want to follow: ");
        String alias = scanner.nextLine();
        if (!allUsers.containsKey(alias)) {
            UserAccount newUser = new UserAccount(alias, alias + "@example.com");
            allUsers.put(alias, newUser);
        }
        UserAccount userToFollow = allUsers.get(alias);
        currentUser.follow(userToFollow);
        System.out.println("Now following " + alias);
    }
}
