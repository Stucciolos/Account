import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountManager {
    private static final Map<String, String> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createAccount(scanner);

        scanner.close();
    }

    public static void createAccount(Scanner scanner) {
        System.out.println("Parte 1: Creazione Account");
        String username = requestUniqueUsername(scanner);
        String password = requestPassword(scanner);

        if (validatePassword(password)) {
            String encryptedPassword = encryptPassword(password);
            accounts.put(username, encryptedPassword);
            System.out.println("Account creato con successo.");
            backupData();
        } else {
            System.out.println("Errore: La password non è valida. Deve avere almeno 8 caratteri.");
        }
    }

    private static String requestUniqueUsername(Scanner scanner) {
        String username;
        do {
            System.out.print("Inserisci un username unico: ");
            username = scanner.nextLine();
        } while (!validateUsername(username));
        return username;
    }

    private static boolean validateUsername(String username) {
        if (accounts.containsKey(username)) {
            System.out.println("L'username esiste già. Scegli un altro username.");
            return false;
        }
        return true;
    }

    private static String requestPassword(Scanner scanner) {
        System.out.print("Inserisci la password: ");
        return scanner.nextLine();
    }

    private static boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    private static String encryptPassword(String password) {
        String encryptedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
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
}