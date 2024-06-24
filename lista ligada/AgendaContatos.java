import java.util.Scanner;
// Classe principal que interage com o usuário e utiliza a lista encadeada
public class AgendaContatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        boolean executar = true;
        while (executar) {
            System.out.println("                                           ");
            System.out.println("------ Agenda de Contatos ------");
            System.out.println("                                           ");
            System.out.println("1. Adicionar contato no início");
            System.out.println("2. Adicionar contato no final");
            System.out.println("3. Adicionar contato em posição específica");
            System.out.println("4. Remover contato no início");
            System.out.println("5. Remover contato no final");
            System.out.println("6. Remover contato em posição específica");
            System.out.println("7. Exibir lista de contatos");
            System.out.println("8. Pesquisar contato em posição específica");
            System.out.println("9. Limpar lista de contatos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomeInicio = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefoneInicio = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String emailInicio = scanner.nextLine();
                    Contato contatoInicio = new Contato(nomeInicio, telefoneInicio, emailInicio);
                    lista.inserirInicio(contatoInicio);
                    System.out.println("Contato adicionado no início da lista.");
                    break;
                case 2:
                    System.out.print("Digite o nome: ");
                    String nomeFinal = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefoneFinal = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String emailFinal = scanner.nextLine();
                    Contato contatoFinal = new Contato(nomeFinal, telefoneFinal, emailFinal);
                    lista.inserirFinal(contatoFinal);
                    System.out.println("Contato adicionado no final da lista.");
                    break;
                case 3:
                    System.out.print("Digite o nome: ");
                    String nomePosicao = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefonePosicao = scanner.nextLine();
                    System.out.print("Digite o email: ");
                    String emailPosicao = scanner.nextLine();
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado
                    Contato contatoPosicao = new Contato(nomePosicao, telefonePosicao, emailPosicao);
                    lista.inserirPosicao(contatoPosicao, posicao);
                    System.out.println("Contato adicionado na posição " + posicao + " da lista.");
                    break;
                case 4:
                    lista.removerInicio();
                    System.out.println("Contato removido do início da lista.");
                    break;
                case 5:
                    lista.removerFinal();
                    System.out.println("Contato removido do final da lista.");
                    break;
                case 6:
                    System.out.print("Digite a posição: ");
                    int posicaoRemover = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado
                    lista.removerPosicao(posicaoRemover);
                    System.out.println("Contato removido da posição " + posicaoRemover + " da lista.");
                    break;
                case 7:
                    System.out.println("------ Lista de Contatos ------");
                    lista.percorrerLista();
                    System.out.println("--------------------------------");
                    break;
                case 8:
                    System.out.print("Digite a posição: ");
                    int posicaoPesquisa = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado
                    Contato contatoPesquisa = lista.pesquisarPosicao(posicaoPesquisa);
                    if (contatoPesquisa != null) {
                        System.out.println("Nome: " + contatoPesquisa.nome);
                        System.out.println("Telefone: " + contatoPesquisa.telefone);
                        System.out.println("Email: " + contatoPesquisa.email);
                    }
                    break;
                case 9:
                    lista.limparLista();
                    System.out.println("Lista de contatos limpa.");
                    break;
                case 0:
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Encerrando o programa...");
    }
}
