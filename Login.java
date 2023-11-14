import java.util.Scanner;

public class Login {
    public String username;
    public String password;
    
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void effettuaLogin(String usernameSalvato, String passwordSalvata) {
        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci l'email: ");
        String usernameInput = input.nextLine();

        System.out.println("Inserisci la password: ");
        String passwordInput = input.nextLine();
        
        boolean accessoConsentito = verificaCredenziali(usernameInput, passwordInput, usernameSalvato, passwordSalvata);

        if (accessoConsentito) {
            System.out.println("Accesso consentito. Benvenuto!");
        } else {
            System.out.println("Credenziali errate. Accesso negato.");
        }
    }

    public static boolean verificaCredenziali(String username, String password, String usernameSalvato, String passwordSalvata) {
        return username.equals(usernameSalvato) && password.equals(passwordSalvata);
    }
}