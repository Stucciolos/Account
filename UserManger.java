import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDataManager {
    private static final Map<String, String> userData = new HashMap<>();
    private static final String USER_DATA_FILE_PATH = "user_data_backup.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        createData(scanner);
        readData();
        updateData(scanner);
        deleteData();

        scanner.close();
    }

    public static void createData(Scanner scanner) {
        System.out.println("Parte 3: CRUD di Dati Utente - Create");
        if (isLoggedIn()) {
            System.out.print("Inserisci nuove informazioni: ");
            String newData = scanner.nextLine();

            if (validateData(newData)) {
                userData.put(AccountManager.getLoggedInUser(), newData);
                System.out.println("Informazioni aggiunte con successo.");
                backupData();
            } else {
                System.out.println("Errore: Le informazioni non sono valide.");
            }
        } else {
            System.out.println("Devi effettuare l'accesso per aggiungere informazioni.");
        }
    }

    public static void readData() {
        System.out.println("Parte 3: CRUD di Dati Utente - Read");
        if (isLoggedIn()) {
            String data = userData.get(AccountManager.getLoggedInUser());
            if (data != null) {
                System.out.println("Le tue informazioni: " + data);
            } else {
                System.out.println("Nessuna informazione disponibile.");
            }
        } else {
            System.out.println("Devi effettuare l'accesso per visualizzare le informazioni.");
        }
    }

    public static void updateData(Scanner scanner) {
        System.out.println("Parte 3: CRUD di Dati Utente - Update");
        if (isLoggedIn()) {
            System.out.print("Inserisci nuove informazioni: ");
            String newData = scanner.nextLine();

            if (validateData(newData)) {
                userData.put(AccountManager.getLoggedInUser(), newData);
                System.out.println("Informazioni aggiornate con successo.");
                backupData();
            } else {
                System.out.println("Errore: Le informazioni non sono valide.");
            }
        } else {
            System.out.println("Devi effettuare l'accesso per aggiornare le informazioni.");
        }
    }

    public static void deleteData() {
        System.out.println("Parte 3: CRUD di Dati Utente - Delete");
        if (isLoggedIn()) {
            userData.remove(AccountManager.getLoggedInUser());
            System.out.println("Informazioni eliminate con successo.");
            backupData();
        } else {
            System.out.println("Devi effettuare l'accesso per eliminare le informazioni.");
        }
    }

    private static boolean validateData(String data) {
        return data.length() >= 5;
    }

    private static void backupData() {
        try (FileWriter writer = new FileWriter(USER_DATA_FILE_PATH)) {
            for (Map.Entry<String, String> entry : userData.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            System.out.println("Backup dei dati completato con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante il backup dei dati: " + e.getMessage());
        }
    }

    private static boolean isLoggedIn() {
        return AccountManager.isLoggedIn();
    }
}
