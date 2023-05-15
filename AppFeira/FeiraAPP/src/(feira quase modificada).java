import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<String> listaFeira = new ArrayList<>();
        listaFeira.add("laranja");
        listaFeira.add("banana");
        listaFeira.add("morango");
        listaFeira.add("uva");
        listaFeira.add("mamão");
        listaFeira.add("abacate");

        List<String> listaDesejada = solicitarListaDesejada(listaFeira);
        List<String> indisponivel = new ArrayList<>();
        
        double correspondencia = calcularCorrespondencia(listaDesejada, listaFeira, indisponivel);
        double gorjeta = calcularGorjeta(correspondencia);

        System.out.println("Correspondência de " + correspondencia + "%, gorjeta de R$ " + gorjeta);
    }

    public static List<String> solicitarListaDesejada(List<String> listaFeira) {
        Scanner scanner = new Scanner(System.in);
        List<String> listaDesejada = new ArrayList<>();
        List<String> indisponivel = new ArrayList<>();

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
                indisponivel.add(fruta);
            }
        } while (true);

        return listaDesejada;
    }

    public static double calcularCorrespondencia(List<String> listaDesejada, List<String> listaFeira, List<String> indisponivel) {
        int quantidadeDesejada = listaDesejada.size() + indisponivel.size();
        int quantidadeComprada = 0;

        for (String fruta : listaDesejada) {
            if (listaFeira.contains(fruta)) {
                quantidadeComprada++;
            }
        }

        double correspondencia = (double) quantidadeComprada / quantidadeDesejada * 100;
        return correspondencia;
    }

    public static double calcularGorjeta(double correspondencia) {
        if (correspondencia >= 90) {
            return 10.0;
        } else if (correspondencia >= 75) {
            return 5.0;
        } else if (correspondencia >= 50) {
            return 3.0;
        } else {
            return 0.0;
        }
    }
}
