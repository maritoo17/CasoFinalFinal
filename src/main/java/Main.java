import java.util.Scanner;

public class Main {
    private static UserAccount currentUser;

    public static void main(String[] args) {
        currentUser = new UserAccount("user123", "user123@example.com");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Write your tweet (or type 'exit' to quit):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }

            try {
                Tweet newTweet = new Tweet(input, currentUser);
                currentUser.tweet(newTweet);
                System.out.println("Tweet successfully posted!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
