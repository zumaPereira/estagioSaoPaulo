
import java.util.Scanner;
public class Exercicio2 {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int numero = scanner.nextInt();
        scanner.close();

        int num1 = 0;
        int num2 = 1;
        boolean pertence = false;

        
        if (numero == num1 || numero == num2) {
            pertence = true;
        } else {
            int proximoNumero = num1 + num2;
            while (proximoNumero <= numero) {
                if (proximoNumero == numero) {
                    pertence = true;
                    break;
                }
                num1 = num2;
                num2 = proximoNumero;
                proximoNumero = num1 + num2;
            }
        }

       
        if (pertence) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }
}
