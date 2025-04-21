import java.io.*;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main3 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        KeyGenerator generador = KeyGenerator.getInstance("AES");
        SecretKey llave = generador.generateKey();

        FileOutputStream archivo = new FileOutputStream("llaveAES.key");
        ObjectOutputStream oos = new ObjectOutputStream(archivo);
        oos.writeObject(llave);
        oos.close();

        System.out.print("Escriba el texto que desea cifrar: ");
        String mensaje = sc.nextLine();

        byte[] textoCifrado = Simetrico.cifrar(llave, mensaje);

        archivo = new FileOutputStream("textoCifrado.dat");
        oos = new ObjectOutputStream(archivo);
        oos.writeObject(textoCifrado);
        oos.close();

        System.out.println("Llave generada y texto cifrado guardados correctamente.");
    }
}
