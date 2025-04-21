import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Simetrico {

    private static final String PADDING = "AES/ECB/PKCS5Padding";

    public static byte[] cifrar(SecretKey llave, String texto) {
        byte[] textoCifrado;
    
        try {
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] textoClaro = texto.getBytes();
            cifrador.init(Cipher.ENCRYPT_MODE, llave);
            textoCifrado = cifrador.doFinal(textoClaro);
            return textoCifrado;
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
    }
    
    public static byte[] descifrar(SecretKey llave, byte[] texto) {
        byte[] textoClaro;
    
        try {
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cifrador.init(Cipher.DECRYPT_MODE, llave);
            textoClaro = cifrador.doFinal(texto);
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
    
        return textoClaro;
    }
    
}
