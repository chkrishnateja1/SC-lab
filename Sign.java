import java.security.*;
import java.util.Scanner;
public class Sign {
 public static void main(String[] args) throws Exception {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter data to sign: ");
 String data = scanner.nextLine();
 KeyPair keyPair = generateKeyPair();
 byte[] signature = signData(data, keyPair.getPrivate());
 System.out.println("Signature value: " + bytesToHex(signature));
 boolean verified = verifySignature(data, signature, keyPair.getPublic());
 System.out.println("Signature verified: " + verified);
 scanner.close();
 }
 public static KeyPair generateKeyPair() throws Exception {
 KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
 keyPairGenerator.initialize(2048);
 return keyPairGenerator.generateKeyPair();
 }
 public static byte[] signData(String data, PrivateKey privateKey) throws Exception {
 Signature signature = Signature.getInstance("SHA256withRSA");
 signature.initSign(privateKey);
 signature.update(data.getBytes());
 return signature.sign();
 }
 public static boolean verifySignature(String data, byte[] signature, PublicKey publicKey) throws 
Exception {
 Signature verifier = Signature.getInstance("SHA256withRSA");
 verifier.initVerify(publicKey);
 verifier.update(data.getBytes());
 return verifier.verify(signature);
 }
 public static String bytesToHex(byte[] bytes) {
 StringBuilder hexString = new StringBuilder();
 for (byte b : bytes) {
 String hex = Integer.toHexString(0xff & b);
 if (hex.length() == 1) {
 hexString.append('0');
 }
 hexString.append(hex);
 }
 return hexString.toString();
 }
}
