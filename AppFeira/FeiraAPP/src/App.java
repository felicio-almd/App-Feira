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

        double correspondencia = calcularCorrespondencia(listaDesejada, listaFeira);
        double gorjeta = calcularGorjeta(correspondencia);

        System.out.println("Total de " + correspondencia + "% de frutas compradas, gorjeta de R$ " + gorjeta);
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

    public static double calcularCorrespondencia(List<String> listaDesejada, List<String> listaFeira) {
        int quantidadeDesejada = listaDesejada.size();
        int quantidadeComprada = 0;

        for (String fruta : listaDesejada) {
            if (listaFeira.contains(fruta)) {
                quantidadeComprada++;
            }
        }

        double correspondencia = (double) quantidadeComprada / quantidadeDesejada * 100;
        return correspondencia;
    }


    // Por enquanto a gorjeta não muda de 100, mas o calculo vai ser consertado
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
}


// Além de calcular o valor da gorjeta, defina uma lista de preços para as frutas disponíveis no
// menu, e faça com que o seu programa calcule o valor total que você deve pagar (incluindo a
// gorjeta do comprador).