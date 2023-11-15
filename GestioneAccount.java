import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestioneAccount{
    private Map<String,String> accountCliente;

    public GestioneAccount(){
        this.accountCliente=new HashMap<>();
    } 
 
    public void registraAccount(){
        Scanner mioc=new Scanner(System.in);

        String username;
        String password;

        username = richiediUsernameUnico(mioc);

        System.out.print("Inserisci la password: ");
        password = mioc.nextLine();

        String passwordC=criptaPassword(password);

        accountCliente.put(username, passwordC);

        System.out.println("Account registrato con successo!");
    }

    private String richiediUsernameUnico(Scanner mioc) {
        String username;
        do {
            System.out.print("Inserisci un username unico: ");
            username = mioc.nextLine();
        } while (!validaUsername(username));
        return username;
    }

    private boolean validaUsername(String username) {
        if (accountCliente.containsKey(username)) {
            System.out.println("L'username esiste già. Scegli un altro username.");
            return false;
        }
        return true;
    }

    private String criptaPassword(String password) {
        String encryptedpassword = null;  
        try   
        {  
            MessageDigest m = MessageDigest.getInstance("MD5");  
            m.update(password.getBytes());    
            byte[] bytes = m.digest();  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            } 
            encryptedpassword = s.toString();  
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  
        return encryptedpassword;
    }
}