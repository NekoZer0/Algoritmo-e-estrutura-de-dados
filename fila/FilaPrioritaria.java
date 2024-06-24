import java.util.Scanner;

class FilaPrioritaria {
    private static final int PESSOA_NORMAL = 0;
    private static final int PESSOA_PRIORITARIA = 1;

    private int contadorSenha;
    private int contadorPessoaNormal;
    private int contadorPessoaPrioritaria;

    public FilaPrioritaria() {
        contadorSenha = 1;
        contadorPessoaNormal = 0;
        contadorPessoaPrioritaria = 0;
    }

    public void adicionarPessoa(int tipoPessoa) {
        if (tipoPessoa == PESSOA_NORMAL) {
            contadorPessoaNormal++;
        } else if (tipoPessoa == PESSOA_PRIORITARIA) {
            contadorPessoaPrioritaria++;
        }

        System.out.println("Senha adicionada: " + contadorSenha);
        contadorSenha++;
    }

    public void removerPessoa() {
        if (contadorPessoaPrioritaria > 0) {
            System.out.println("Atendendo a pessoa prioritária. Senha: " + contadorSenha);
            contadorPessoaPrioritaria--;
        } else if (contadorPessoaNormal > 0) {
            System.out.println("Atendendo a pessoa normal. Senha: " + contadorSenha);
            contadorPessoaNormal--;
        } else {
            System.out.println("Não há pessoas na fila.");
        }

        contadorSenha++;
    }

    public void removerPessoaPrioritaria() {
        if (contadorPessoaPrioritaria > 0) {
            System.out.println("Atendendo a pessoa prioritária. Senha: " + contadorSenha);
            contadorPessoaPrioritaria--;
            contadorSenha++;
        } else {
            System.out.println("Não há pessoas prioritárias na fila.");
        }
    }

    public void verificarSenha() {
        System.out.println("Próxima senha: " + contadorSenha);
    }

    public static void main(String[] args) {
        FilaPrioritaria fila = new FilaPrioritaria();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\nSelecione uma opção:\n");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Remover pessoa (normal)");
            System.out.println("3. Remover pessoa (prioritária)");
            System.out.println("4. Verificar próxima senha");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o tipo de pessoa (0 - normal, 1 - prioritária):");
                    int tipoPessoa = scanner.nextInt();
                    fila.adicionarPessoa(tipoPessoa);
                    break;
                case 2:
                    fila.removerPessoa();
                    break;
                case 3:
                    fila.removerPessoaPrioritaria();
                    break;
                case 4:
                    fila.verificarSenha();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}

