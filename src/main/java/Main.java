import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<UserAccount> userAccounts = new ArrayList<>();

    public static void main(String[] args) {
        loadUsersFromFile("users.txt");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Load User by Alias");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = Utils.leerEntero();

            switch (option) {
                case 1:
                    System.out.print("Enter user alias to load: ");
                    String alias = Utils.leerCadena();
                    UserAccount user = findUserByAlias(alias);
                    if (user != null) {
                        System.out.println("Loaded User: " + user);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        scanner.close();
    }

    private static void loadUsersFromFile(String fileName) {
        userAccounts.add(new UserAccount("user1", "user1@example.com"));
        userAccounts.add(new UserAccount("user2", "user2@example.com"));
        userAccounts.add(new UserAccount("user3", "user3@example.com"));
    }

    private static UserAccount findUserByAlias(String alias) {
        for (UserAccount user : userAccounts) {
            if (user.getAlias().equals(alias)) {
                return user;
            }
        }
        return null;
    }
}
