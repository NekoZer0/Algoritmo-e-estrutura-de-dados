import java.util.Scanner;

public class PilhaLivro {
    public static void main(String[] args) {
        PilhaLivros pilhaLivros = new PilhaLivros();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Empilhar livro");
            System.out.println("2 - Desempilhar livro");
            System.out.println("3 - Verificar livro no topo");
            System.out.println("4 - Imprimir pilha de livros");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do livro:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    System.out.println("Digite o nome do autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ano de lançamento do livro:");
                    int anoLancamento = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Livro livro = new Livro(nome, isbn, autor, anoLancamento);
                    pilhaLivros.empilharLivro(livro);
                    break;
                case 2:
                    Livro livroDesempilhado = pilhaLivros.desempilharLivro();
                    if (livroDesempilhado != null) {
                        System.out.println("Livro desempilhado: " + livroDesempilhado.getNome());
                    }
                    break;
                case 3:
                    pilhaLivros.verificarLivroTopo();
                    break;
                case 4:
                    pilhaLivros.imprimirPilha();
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número de 1 a 5.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}