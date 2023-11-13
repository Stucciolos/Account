import java.util.Map;
import java.util.Scanner;

public class PasswordManager {
    private static final Map<String, String> accounts = new HashMap<>();

    public static void changePassword(Scanner scanner) {
        System.out.println("Parte 4: Funzione Aggiuntiva - Cambio Password");
        if (AccountManager.getLoggedInUser() == null) {
            System.out.println("Devi effettuare l'accesso per cambiare la password.");
            return;
        }

        System.out.print("Inserisci la vecchia password: ");
        String oldPassword = scanner.nextLine();

        if (!accounts.get(AccountManager.getLoggedInUser()).equals(oldPassword)) {
            System.out.println("Errore: Vecchia password non corretta.");
            return;
        }

        System.out.print("Inserisci la nuova password: ");
        String newPassword = scanner.nextLine();

        accounts.put(AccountManager.getLoggedInUser(), newPassword);

        System.out.println("Password cambiata con successo.");
    }
}
