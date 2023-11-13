import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Crud{
    private static Map<String, String> userAccounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayUserInfo("username1");
        updateUserInfo("username1");
        displayUserInfo("username1");
        deleteUserAccount("username1");
    }


    private static void displayUserInfo(String username) {
        if (userAccounts.containsKey(username)) {
            System.out.println("Informazioni dell'utente:");
            System.out.println("Username: " + username);
            System.out.println("Password: " + userAccounts.get(username));
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    private static void updateUserInfo(String username) {
        if (userAccounts.containsKey(username)) {
            System.out.println("Aggiornamento delle informazioni dell'utente.");
            System.out.print("Nuova password: ");
            String newPassword = scanner.nextLine();
            userAccounts.put(username, newPassword);
            System.out.println("Informazioni aggiornate con successo.");
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    private static void deleteUserAccount(String username) {
        if (userAccounts.containsKey(username)) {
            userAccounts.remove(username);
            System.out.println("Account eliminato con successo.");
        } else {
            System.out.println("Utente non trovato.");
        }
    }
}
