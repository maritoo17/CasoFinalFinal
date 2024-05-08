import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<UserAccount> userAccounts = new ArrayList<>();

    public static void main(String[] args) {
        loadUsersFromFile();
        Scanner scanner = new Scanner(System.in);
        UserAccount currentUser = findUser(scanner);
        if (currentUser != null) {
            try {
                String message = readMessage(scanner);
                currentUser.tweet(new Tweet(message, currentUser));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static UserAccount findUser(Scanner scanner) {
        System.out.println("Enter user alias:");
        String alias = scanner.nextLine();
        for (UserAccount user : userAccounts) {
            if (user.getAlias().equals(alias)) {
                return user;
            }
        }
        return null;
    }

    private static String readMessage(Scanner scanner) {
        System.out.println("Enter your tweet message (up to 140 characters):");
        String message = scanner.nextLine();
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message cannot exceed 140 characters.");
        }
        return message;
    }

    private static void loadUsersFromFile() {
    }
}
