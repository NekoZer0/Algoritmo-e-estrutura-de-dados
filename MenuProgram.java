
import java.util.Scanner;

public class MenuProgram {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
        int opcao = 0;

            while (opcao != 8) {
                exibirMenu();
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer de entrada

                switch (opcao) {
                    case 1:
                        MenuProgram.PilhaLivro();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 2:
                        MenuProgram.FilaDocumentos();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 3:
                        MenuProgram.FilaPrioritaria();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 4:
                        MenuProgram.AgendaContatos();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 5:
                        MenuProgram.Video();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 6:
                        MenuProgram.Musica();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 7:
                        MenuProgram.SistemaArquivos();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 8:
                        MenuProgram.SistemaTurismo();
                        scanner.nextLine(); // Limpar o buffer
                        break;
                    case 9:
                        MenuProgram.sairDoPrograma();
                        scanner.nextLine(); // Limpar o buffer
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        } // Scanner será fechado automaticamente aqui, mesmo em caso de exceção
    }

        

    private static void exibirMenu() {
        System.out.println("\n===== MENU =====\n");
        System.out.println("1. Estrutura Pilha");
        System.out.println("2. Estrutura Fila");
        System.out.println("3. Fila prioritaria");
        System.out.println("4. Lista Ligada");
        System.out.println("5. Duplamente Ligada");
        System.out.println("6. Lista Circular");
        System.out.println("7. Arvore Binaria");
        System.out.println("8. Estrutura de Grafos");
        System.out.println("9. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void sairDoPrograma() {
        System.out.println("Saindo do programa...");
    }

    private static void PilhaLivro(){
        System.out.println("Executando Subprograma 1"); 
        // Lógica do subprograma 1  
    }

    private static void FilaDocumentos() {
        System.out.println("Executando Subprograma 2");
        // Lógica do subprograma 2
    }

    private static void FilaPrioritaria() {
        System.out.println("Executando Subprograma 3");
        // Lógica do subprograma 3
    }

    private static void AgendaContatos() {
        System.out.println("Executando Subprograma 4");
        // Lógica do subprograma 4
    }

    private static void Video() {
        System.out.println("Executando Subprograma 5");
        // Lógica do subprograma 5
    }

    private static void Musica() {
        System.out.println("Executando Subprograma 6");
        // Lógica do subprograma 6
    }

    private static void SistemaArquivos() {
        System.out.println("Executando Subprograma 7");
        // Lógica do subprograma 7
    }

    private static void SistemaTurismo() {
        System.out.println("Executando Subprograma 8");
        // Lógica do subprograma 8
    }
}
    