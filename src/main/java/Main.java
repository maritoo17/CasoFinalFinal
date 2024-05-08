import java.util.ArrayList;

public class Main {
    private static ArrayList<UserAccount> userAccounts = new ArrayList<>();

    public static void main(String[] args) {
        loadUsersFromFile("users.txt");
        UserAccount user = findUserByAliasWithSentinel("desiredAlias");
        if (user != null) {
            System.out.println("Usuario cargado: " + user);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void loadUsersFromFile(String fileName) {
        userAccounts.add(new UserAccount("user1", "user1@example.com"));
        userAccounts.add(new UserAccount("user2", "user2@example.com"));
        userAccounts.add(new UserAccount("user3", "user3@example.com"));
    }

    private static UserAccount findUserByAliasWithSentinel(String alias) {
        UserAccount sentinel = new UserAccount(alias, "sentinel@example.com");
        userAccounts.add(sentinel);
        int i = 0;

        while (!userAccounts.get(i).getAlias().equals(alias)) {
            i++;
        }

        userAccounts.remove(sentinel);

        if (i < userAccounts.size() && !userAccounts.get(i).getEmail().equals("sentinel@example.com")) {
            return userAccounts.get(i); // Found the user
        } else {
            return null;
        }
    }
}
