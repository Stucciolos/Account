import java.util.Scanner;

public class LoginManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        login(scanner);

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.println("Parte 2: Login");
        String usernameInput = requestUsername(scanner);
        String passwordInput = requestPassword(scanner);

        if (verifyCredentials(usernameInput, passwordInput)) {
            AccountManager.setLoggedInUser(usernameInput);
            System.out.println("Accesso effettuato con successo.");
        } else {
            System.out.println("Errore: Credenziali non valide. Accesso negato.");
        }
    }

    private static String requestUsername(Scanner scanner) {
        System.out.print("Inserisci username: ");
        return scanner.nextLine();
    }

    private static String requestPassword(Scanner scanner) {
        System.out.print("Inserisci la password: ");
        return scanner.nextLine();
    }

    private static boolean verifyCredentials(String username, String password) {
        return AccountManager.getAccounts().containsKey(username) &&
                AccountManager.getAccounts().get(username).equals(AccountManager.encryptPassword(password));
    }
}
