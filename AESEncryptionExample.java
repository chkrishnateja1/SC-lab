import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class AESEncryptionExample {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 try {
 System.out.print("Enter a message to encrypt: ");
 String message = scanner.nextLine();
 System.out.print("Enter a secret key (16 bytes): ");
 String secretKey = scanner.nextLine();
 // Encrypt the message
 String encryptedMessage = encrypt(message, secretKey);
 System.out.println("Encrypted message: " + encryptedMessage);
 // Decrypt the message
 String decryptedMessage = decrypt(encryptedMessage, secretKey);
 System.out.println("Decrypted message: " + decryptedMessage);
 } catch (Exception e) {
 System.err.println("Error: " + e.getMessage());
 }
 scanner.close();
 }
 public static String encrypt(String message, String secretKey) throws Exception {
 SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
 Cipher cipher = Cipher.getInstance("AES");
 cipher.init(Cipher.ENCRYPT_MODE, keySpec);
 byte[] encryptedBytes = cipher.doFinal(message.getBytes());
 return Base64.getEncoder().encodeToString(encryptedBytes);
 }
 public static String decrypt(String encryptedMessage, String secretKey) throws Exception {
 SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
 Cipher cipher = Cipher.getInstance("AES");
 cipher.init(Cipher.DECRYPT_MODE, keySpec);
 byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
 return new String(decryptedBytes);
 }
}

