import java.io.*;
import javax.crypto.SecretKey;

public class Main4 {

    public static void main(String[] args) throws Exception {
        // 1. Recuperar la llave desde el archivo "llaveAES.key"
        FileInputStream archivoLlave = new FileInputStream("llaveAES.key");
        ObjectInputStream oisLlave = new ObjectInputStream(archivoLlave);
        SecretKey llave = (SecretKey) oisLlave.readObject();
        oisLlave.close();

        // 2. Recuperar el texto cifrado desde el archivo "textoCifrado.dat"
        FileInputStream archivoTexto = new FileInputStream("textoCifrado.dat");
        ObjectInputStream oisTexto = new ObjectInputStream(archivoTexto);
        byte[] textoCifrado = (byte[]) oisTexto.readObject();
        oisTexto.close();

        // 3. Descifrar el texto usando la clase Simetrico
        byte[] textoClaro = Simetrico.descifrar(llave, textoCifrado);

        // 4. Mostrar el resultado descifrado
        if (textoClaro != null) {
            System.out.println("Texto descifrado: " + new String(textoClaro));
        } else {
            System.out.println("No se pudo descifrar el texto.");
        }
    }
}
