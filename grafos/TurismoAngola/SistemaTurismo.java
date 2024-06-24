package TurismoAngola;

import java.util.List;
import java.util.Scanner;

public class SistemaTurismo {
  
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.adicionarAresta("Luanda", "Benguela");
        grafo.adicionarAresta("Luanda", "Huambo");
        grafo.adicionarAresta("Benguela", "Lobito");
        grafo.adicionarAresta("Benguela", "Namibe");
        grafo.adicionarAresta("Huambo", "Bie");
        grafo.adicionarAresta("Huambo", "Kuito");

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Sistema de Turismo em Angola ===\n");

        while (true) {
            System.out.print("\nDigite a cidade de origem (ou 'sair' para encerrar o programa): ");
            String origem = scanner.nextLine();

            if (origem.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("\nDigite a cidade de destino: ");
            String destino = scanner.nextLine();

            List<String> rota = grafo.obterRotas(origem, destino);

            if (!rota.isEmpty()) {
                System.out.println("\nRota encontrada:");
                for (String cidade : rota) {
                    System.out.println(cidade);
                }
            } else {
                System.out.println("\nNão foi possível encontrar uma rota entre " + origem + " e " + destino + ".");
            }
        }

        System.out.println("\nPrograma encerrado.");
        scanner.close();
    }
}

