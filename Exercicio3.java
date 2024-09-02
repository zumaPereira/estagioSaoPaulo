import java.util.ArrayList;
import java.util.List;

public class Exercicio3 {

    static class Faturamento {
        int dia;
        double valor;

        Faturamento(int dia, double valor) {
            this.dia = dia;
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        // Dados JSON com valores inventados para um mês cheio
        String json = "["
            + "{\"dia\": 1, \"valor\": 1200.0},"
            + "{\"dia\": 2, \"valor\": 1500.0},"
            + "{\"dia\": 3, \"valor\": 1300.0},"
            + "{\"dia\": 4, \"valor\": 0.0},"
            + "{\"dia\": 5, \"valor\": 1800.0},"
            + "{\"dia\": 6, \"valor\": 2200.0},"
            + "{\"dia\": 7, \"valor\": 1400.0},"
            + "{\"dia\": 8, \"valor\": 1600.0},"
            + "{\"dia\": 9, \"valor\": 0.0},"
            + "{\"dia\": 10, \"valor\": 1700.0},"
            + "{\"dia\": 11, \"valor\": 2000.0},"
            + "{\"dia\": 12, \"valor\": 0.0},"
            + "{\"dia\": 13, \"valor\": 1900.0},"
            + "{\"dia\": 14, \"valor\": 0.0},"
            + "{\"dia\": 15, \"valor\": 2100.0},"
            + "{\"dia\": 16, \"valor\": 1500.0},"
            + "{\"dia\": 17, \"valor\": 2200.0},"
            + "{\"dia\": 18, \"valor\": 0.0},"
            + "{\"dia\": 19, \"valor\": 2300.0},"
            + "{\"dia\": 20, \"valor\": 2400.0},"
            + "{\"dia\": 21, \"valor\": 1500.0},"
            + "{\"dia\": 22, \"valor\": 1600.0},"
            + "{\"dia\": 23, \"valor\": 0.0},"
            + "{\"dia\": 24, \"valor\": 1700.0},"
            + "{\"dia\": 25, \"valor\": 0.0},"
            + "{\"dia\": 26, \"valor\": 1800.0},"
            + "{\"dia\": 27, \"valor\": 1900.0},"
            + "{\"dia\": 28, \"valor\": 2000.0},"
            + "{\"dia\": 29, \"valor\": 2100.0},"
            + "{\"dia\": 30, \"valor\": 0.0},"
            + "{\"dia\": 31, \"valor\": 2200.0}"
            + "]";

        // Exibe o JSON
        System.out.println("JSON de faturamento:");
        System.out.println(json);

        // Processa o JSON manualmente
        List<Faturamento> faturamentos = processaJSON(json);

        // Calcula menor valor, maior valor e soma dos valores de faturamento
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0.0;
        int diasComFaturamento = 0;

        for (Faturamento faturamento : faturamentos) {
            double valor = faturamento.valor;
            if (valor > 0.0) { // Ignora dias sem faturamento
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                soma += valor;
                diasComFaturamento++;
            }
        }

      
        if (diasComFaturamento == 0) {
            System.out.println("Nenhum dia com faturamento encontrado.");
            return;
        }

        double mediaMensal = soma / diasComFaturamento;
        int diasAcimaDaMedia = 0;

        
        for (Faturamento faturamento : faturamentos) {
            double valor = faturamento.valor;
            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        
        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }

    private static List<Faturamento> processaJSON(String json) {
        List<Faturamento> faturamentos = new ArrayList<>();
        
        json = json.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\{", "").replaceAll("\\}", "");
       
        String[] entries = json.split(",");
        for (String entry : entries) {
            String[] keyValue = entry.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");
                if (key.equals("dia")) {
                    int dia = Integer.parseInt(value);
                    double valor = Double.parseDouble(value);
                    faturamentos.add(new Faturamento(dia, valor));
                }
            }
        }
        return faturamentos;
    }
}

