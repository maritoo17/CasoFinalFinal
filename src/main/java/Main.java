import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static UserAccount currentUser;
    private static Map<String, UserAccount> allUsers = new HashMap<>();

    public static void main(String[] args) {
        currentUser = new UserAccount("Rubén", "Rubén@example.com");
        allUsers.put(currentUser.getAlias(), currentUser);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nBienvenido Rubén, que deseas hacer:\n1. Escribir un tweet\n2. Ver el timeline de tweets:\n3. Seguir a un usuario:\nEscribe 'exit' para salir.");
            System.out.print("Elige una opción: ");
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
                    System.out.println("Opcion inválida. Por favor, elige una opción válida.");
                    break;
            }
        }
        scanner.close();
    }

    private static void writeTweet(Scanner scanner) {
        System.out.print("Escribe tu tweet: ");
        String tweetText = scanner.nextLine();
        try {
            Tweet newTweet = new Tweet(tweetText, currentUser);
            currentUser.tweet(newTweet);
            System.out.println("Tweet subido sin problemas.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showTimeline() {
        List<Tweet> userTweets = currentUser.getTweets();
        if (userTweets.isEmpty()) {
            System.out.println("Tu timeline está vacío.");
        } else {
            System.out.println("Tu timeline:");
            userTweets.forEach(tweet -> System.out.println(tweet.toString()));
        }
    }

    private static void followUser(Scanner scanner) {
        System.out.print("Mete el alias del usuario que quieras meter: ");
        String alias = scanner.nextLine().trim();

        if (alias.equals(currentUser.getAlias())) {
            System.out.println("No te puedes seguir a ti mismo.");
            return;
        }

        if (currentUser.getFollowing().stream().anyMatch(user -> user.getAlias().equals(alias))) {
            System.out.println("Ya estás siguiendo a " + alias);
            return;
        }

        if (!allUsers.containsKey(alias)) {
            UserAccount newUser = new UserAccount(alias, alias + "@example.com");
            allUsers.put(alias, newUser);
        }

        UserAccount userToFollow = allUsers.get(alias);
        currentUser.follow(userToFollow);
        System.out.println("Ahora siguiendo a" + alias);
    }

}
