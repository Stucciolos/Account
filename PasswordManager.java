import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordManager {
    private static final Map<String, String> passwordData = new HashMap<>();
    private static final String PASSWORD_DATA_FILE_PATH = "password_data_backup.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        changePassword(scanner);

        scanner.close();
    }

    public static void changePassword(Scanner scanner) {
        System.out.println("Parte 4: Funzione Aggiuntiva - Cambio Password");
        if (isLoggedIn()) {
            System.out.print("Inserisci la vecchia password: ");
            String oldPassword = scanner.nextLine();

            if (verifyOldPassword(oldPassword)) {
                String newPassword = requestNewPassword(scanner);

                updatePassword(newPassword);

                System.out.println("Password cambiata con successo.");
                backupData();
            } else {
                System.out.println("Errore: Vecchia password non corretta.");
            }
        } else {
            System.out.println("Devi effettuare l'accesso per cambiare la password.");
        }
    }

    private static boolean verifyOldPassword(String oldPassword) {
        return passwordData.containsKey(AccountManager.getLoggedInUser()) &&
                passwordData.get(AccountManager.getLoggedInUser()).equals(AccountManager.encryptPassword(oldPassword));
    }

    private static String requestNewPassword(Scanner scanner) {
        System.out.print("Inserisci la nuova password: ");
        return scanner.nextLine();
    }

    private static void updatePassword(String newPassword) {
        passwordData.put(AccountManager.getLoggedInUser(), AccountManager.encryptPassword(newPassword));
    }

    private static void backupData() {
        try (FileWriter writer = new FileWriter(PASSWORD_DATA_FILE_PATH)) {
            for (Map.Entry<String, String> entry : passwordData.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            System.out.println("Backup dei dati delle password completato con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante il backup dei dati delle password: " + e.getMessage());
        }
    }

    private static boolean isLoggedIn() {
        return AccountManager.isLoggedIn();
    }
}
