import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
public class DESExample {
 public static void main(String[] args) throws Exception {
 String plaintext = "Hello, DES!";
 String secretKey = "SecretKey"; // Your secret key
 
 byte[] encrypted = encrypt(plaintext, secretKey);
 System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
 
 String decrypted = decrypt(encrypted, secretKey);
 System.out.println("Decrypted: " + decrypted);
 }
 public static byte[] encrypt(String plaintext, String secretKey) throws Exception {
 DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
 SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
 SecretKey key = keyFactory.generateSecret(keySpec);
 Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
 cipher.init(Cipher.ENCRYPT_MODE, key);
 return cipher.doFinal(plaintext.getBytes());
 }
 public static String decrypt(byte[] ciphertext, String secretKey) throws Exception {
 DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
 SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
 SecretKey key = keyFactory.generateSecret(keySpec);
 Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
 cipher.init(Cipher.DECRYPT_MODE, key);
 byte[] decryptedBytes = cipher.doFinal(ciphertext);
 return new String(decryptedBytes);
 }
}

