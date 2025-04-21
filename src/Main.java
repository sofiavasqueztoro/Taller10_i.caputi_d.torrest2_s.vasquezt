import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Escriba el texto que desea cifrar: ");
        String mensaje = sc.nextLine();
    
        System.out.println(mensaje);
        System.out.println("Mensaje de entrada en texto claro: " + mensaje);
    
        byte[] textoClaro = mensaje.getBytes();
    
        System.out.print("Texto claro: ");
        imprimir(textoClaro);
    
        KeyGenerator generador = KeyGenerator.getInstance("AES");
        SecretKey llave = generador.generateKey();
    
        // Medir el tiempo de cifrado
        long tiempoInicial = System.nanoTime(); 
        byte[] textoCifrado = Simetrico.cifrar(llave, mensaje);
        long tiempoFinal = System.nanoTime();
        long tiempoCifrado = tiempoFinal - tiempoInicial;
        System.out.println("Tiempo de cifrado (en nanosegundos): " + tiempoCifrado);
    
        System.out.print("Texto cifrado: ");
        imprimir(textoCifrado);
    
        // Medir el tiempo de descifrado
        tiempoInicial = System.nanoTime();
        byte[] textoDescifrado = Simetrico.descifrar(llave, textoCifrado);
        tiempoFinal = System.nanoTime();
        long tiempoDescifrado = tiempoFinal - tiempoInicial;
        System.out.println("Tiempo de descifrado (en nanosegundos): " + tiempoDescifrado);
    
        System.out.print("Texto descifrado: ");
        imprimir(textoDescifrado);
    
        System.out.println("Texto descifrado: " + new String(textoDescifrado));
    }
    

    public static void imprimir(byte[] arreglo) {
        for (byte b : arreglo) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}
