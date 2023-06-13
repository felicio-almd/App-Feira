/*Codigo com tentativa de mudança para funcionar os valores de cada produto vendido, não da resultado esperado quando o código é executado */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ValoresNaFeira {
    public static void main(String[] args) {
        List<String> listaFeira = new ArrayList<>();
        listaFeira.add("laranja");
        listaFeira.add("banana");
        listaFeira.add("morango");
        listaFeira.add("uva");
        listaFeira.add("mamão");
        listaFeira.add("abacate");

        Map<String, Double> precosFrutas = new HashMap<>();
        precosFrutas.put("laranja", 2.50);
        precosFrutas.put("banana", 1.00);
        precosFrutas.put("morango", 3.00);
        precosFrutas.put("uva", 4.50);
        precosFrutas.put("mamão", 2.00);
        precosFrutas.put("abacate", 5.00);

        List<String> listaDesejada = solicitarListaDesejada(listaFeira);

        double correspondencia = calcularCorrespondencia(listaDesejada, precosFrutas);
        double gorjeta = calcularGorjeta(correspondencia);

        double valorTotal = correspondencia * calcularValorTotal(listaDesejada, precosFrutas);

        System.out.println("Total de " + correspondencia + "% de frutas compradas, gorjeta de R$ " + gorjeta);
        System.out.println("Valor total a ser pago: R$ " + valorTotal);
    }

    public static List<String> solicitarListaDesejada(List<String> listaFeira) {
        Scanner scanner = new Scanner(System.in);
        List<String> listaDesejada = new ArrayList<>();

        System.out.println("Bem-vindo à feira de frutas! Por favor, digite as frutas desejadas (digite 'fim' para encerrar):");

        String fruta;
        do {
            fruta = scanner.nextLine().toLowerCase();
            if (fruta.equals("fim")) {
                break;
            }
            if (listaFeira.contains(fruta)) {
                listaDesejada.add(fruta);
            } else {
                System.out.println("Fruta inválida. Digite novamente:");
            }
        } while (true);

        return listaDesejada;
    }

    public static double calcularCorrespondencia(List<String> listaDesejada, Map<String, Double> precosFrutas) {
        int quantidadeDesejada = listaDesejada.size();
        int quantidadeComprada = 0;

        for (String fruta : listaDesejada) {
            if (precosFrutas.containsKey(fruta)) {
                quantidadeComprada++;
            }
        }

        double correspondencia = (double) quantidadeComprada / quantidadeDesejada * 100;
        return correspondencia;
    }

    public static double calcularGorjeta(double correspondencia) {
        if (correspondencia >= 90) {
            return 10.00;
        } else if (correspondencia >= 75) {
            return 5.00;
        } else if (correspondencia >= 50) {
            return 3.00;
        } else {
            return 0.00;
        }
    }
    
    

    public static double calcularValorTotal(List<String> listaDesejada, Map<String, Double> precosFrutas) {
        double valorTotal = 0.0;
        return calcularValorTotal(listaDesejada, precosFrutas);
    }
}

       
