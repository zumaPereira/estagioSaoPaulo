
import java.util.Scanner;
public class Exercicio5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite uma palavra para ser invertida:");
        String input = scanner.nextLine();


        scanner.close();


        String stringInvertida = inverterString(input);

        System.out.println("Palavra invertida: " + stringInvertida);
    }

    public static String inverterString(String str) {

        char[] caracteres = str.toCharArray();


        int inicio = 0;
        int fim = caracteres.length - 1;


        while (inicio < fim) {

            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;


            inicio++;
            fim--;
        }


        return new String(caracteres);
    }
}
