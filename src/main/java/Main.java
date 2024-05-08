import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static UserAccount currentUser;
    private static Map<String, UserAccount> allUsers = new HashMap<>();
    private static List<Tweet> allTweets = new ArrayList<>();

    public static void main(String[] args) {
        currentUser = new UserAccount("Rubén", "Rubén@example.com");
        allUsers.put(currentUser.getAlias(), currentUser);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nBienvenido Rubén, ¿qué deseas hacer?:\n" +
                    "1. Escribir un tweet\n" +
                    "2. Ver el timeline de tweets\n" +
                    "3. Seguir a un usuario\n" +
                    "4. Ver timeline de seguimientos\n" +
                    "5. Enviar un mensaje directo\n" +
                    "6. Retweetear un tweet\n" +
                    "Escribe 'exit' para salir.");
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
                case "4":
                    showFollowTimeline();
                    break;
                case "5":
                    sendDirectMessage(scanner);
                    break;
                case "6":
                    retweet(scanner);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
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
            allTweets.add(newTweet);
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

    private static void showFollowTimeline() {
        List<String> followActivities = currentUser.getFollowActivities();
        if (followActivities.isEmpty()) {
            System.out.println("No hay actividades de seguimiento.");
        } else {
            System.out.println("Actividades de seguimiento:");
            followActivities.forEach(System.out::println);
        }
    }

    private static void followUser(Scanner scanner) {
        System.out.print("Mete el alias del usuario que quieras seguir: ");
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
        System.out.println("Ahora siguiendo a " + alias);
    }

    private static void sendDirectMessage(Scanner scanner) {
        System.out.print("Ingrese el alias del destinatario: ");
        String alias = scanner.nextLine();
        UserAccount receiver = allUsers.get(alias);
        if (receiver == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.print("Escribe tu mensaje: ");
        String message = scanner.nextLine();
        DirectMessage dm = new DirectMessage(message, currentUser, receiver);
        System.out.println("Mensaje enviado a " + receiver.getAlias() + ".");
    }

    private static void retweet(Scanner scanner) {
        System.out.println("Lista de Tweets disponibles para retweetear:");
        allTweets.forEach(tweet -> System.out.println(tweet.getID() + ": " + tweet));
        System.out.print("Ingrese el ID del tweet a retweetear: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        Tweet originalTweet = allTweets.stream().filter(t -> t.getID() == id).findFirst().orElse(null);
        if (originalTweet == null) {
            System.out.println("Tweet no encontrado.");
            return;
        }
        Retweet retweet = new Retweet("Retweeted", currentUser, originalTweet);
        currentUser.tweet(retweet);
        System.out.println("Retweet realizado con éxito.");
    }

    private static void preloadTweets() {
        allTweets.add(new Tweet("¡Hola, mundo!", currentUser));
        allTweets.add(new Tweet("Explorando Java y sus posibilidades.", currentUser));
        allTweets.add(new Tweet("¿Alguien para intercambiar ideas sobre programación?", currentUser));
        allTweets.add(new Tweet("Este es un tweet más en tu feed.", currentUser));
        allTweets.add(new Tweet("Último tweet del día, ¡buenas noches!", currentUser));
    }
}
