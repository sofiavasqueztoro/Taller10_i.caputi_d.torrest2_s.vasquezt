import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Solicitar el mensaje de entrada
        System.out.print("Escriba el texto que desea cifrar: ");
        String mensaje = sc.nextLine();

        // Generar las llaves simétricas k1 y k2
        KeyGenerator generador = KeyGenerator.getInstance("AES");
        SecretKey k1 = generador.generateKey();
        SecretKey k2 = generador.generateKey();

        System.out.println("Mensaje de entrada en texto claro: " + mensaje);

        // Cifrar el mensaje con la llave k1
        byte[] tc1 = Simetrico.cifrar(k1, mensaje);
        System.out.print("Texto cifrado con k1: ");
        imprimir(tc1);

        // Cifrar el mensaje con la llave k2
        byte[] tc2 = Simetrico.cifrar(k2, mensaje);
        System.out.print("Texto cifrado con k2: ");
        imprimir(tc2);

        // Descifrar tc1 con la llave k1
        byte[] textoDescifrado = Simetrico.descifrar(k1, tc1);
        System.out.print("Texto descifrado con k1: ");
        imprimir(textoDescifrado);
        
        // Mostrar el texto descifrado en formato de cadena
        System.out.println("Texto descifrado con k1: " + new String(textoDescifrado));

        try {
            byte[] resultadoIncorrecto = Simetrico.descifrar(k2, tc1);
            System.out.print("Intento de descifrar tc1 con k2: ");
            imprimir(resultadoIncorrecto);
            System.out.println("Texto descifrado con k2: " + new String(resultadoIncorrecto));
        } catch (Exception e) {
            System.out.println("Error al intentar descifrar tc1 con k2: " + e.getMessage());
        }
        
    }

    // Método para imprimir el contenido de un arreglo de bytes
    public static void imprimir(byte[] arreglo) {
        for (byte b : arreglo) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
