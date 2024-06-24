import java.util.Scanner;

public class SistemaArquivos {
    private static class Arquivo {
        String nome;
        Arquivo esquerda;
        Arquivo direita;

        public Arquivo(String nome) {
            this.nome = nome;
            esquerda = null;
            direita = null;
        }
    }

    private static Arquivo raiz;

    // Adicionar arquivo à árvore
    private static void adicionarArquivo(String nome) {
        Arquivo novoArquivo = new Arquivo(nome);
        if (raiz == null) {
            raiz = novoArquivo;
        } else {
            adicionarArquivoRecursivo(raiz, novoArquivo);
        }
        System.out.println("Arquivo \"" + nome + "\" adicionado com sucesso.");
    }

    // Função auxiliar recursiva para adicionar arquivo à árvore
    private static void adicionarArquivoRecursivo(Arquivo atual, Arquivo novoArquivo) {
        if (novoArquivo.nome.compareTo(atual.nome) < 0) {
            if (atual.esquerda == null) {
                atual.esquerda = novoArquivo;
            } else {
                adicionarArquivoRecursivo(atual.esquerda, novoArquivo);
            }
        } else if (novoArquivo.nome.compareTo(atual.nome) > 0) {
            if (atual.direita == null) {
                atual.direita = novoArquivo;
            } else {
                adicionarArquivoRecursivo(atual.direita, novoArquivo);
            }
        } else {
            System.out.println("O arquivo \"" + novoArquivo.nome + "\" já existe.");
        }
    }

    // Buscar arquivo na árvore
    private static boolean buscarArquivo(String nome) {
        return buscarArquivoRecursivo(raiz, nome);
    }

    // Função auxiliar recursiva para buscar arquivo na árvore
    private static boolean buscarArquivoRecursivo(Arquivo atual, String nome) {
        if (atual == null) {
            return false;
        }

        if (nome.compareTo(atual.nome) < 0) {
            return buscarArquivoRecursivo(atual.esquerda, nome);
        } else if (nome.compareTo(atual.nome) > 0) {
            return buscarArquivoRecursivo(atual.direita, nome);
        } else {
            return true;
        }
    }

    // Remover arquivo da árvore
    private static void removerArquivo(String nome) {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
        } else if (buscarArquivo(nome)) {
            raiz = removerArquivoRecursivo(raiz, nome);
            System.out.println("Arquivo \"" + nome + "\"removido com sucesso.");
        } else {
            System.out.println("O arquivo \"" + nome + "\" não existe.");
        }
    }

    // Função auxiliar recursiva para remover arquivo da árvore
    private static Arquivo removerArquivoRecursivo(Arquivo atual, String nome) {
        if (atual == null) {
            return null;
        }

        if (nome.compareTo(atual.nome) < 0) {
            atual.esquerda = removerArquivoRecursivo(atual.esquerda, nome);
            return atual;
        } else if (nome.compareTo(atual.nome) > 0) {
            atual.direita = removerArquivoRecursivo(atual.direita, nome);
            return atual;
        } else {
            // Caso 1: O arquivo não tem filhos
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }
            // Caso 2: O arquivo tem apenas um filho
            else if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }
            // Caso 3: O arquivo tem dois filhos
            else {
                Arquivo sucessor = encontrarSucessor(atual.direita);
                atual.nome = sucessor.nome;
                atual.direita = removerArquivoRecursivo(atual.direita, sucessor.nome);
                return atual;
            }
        }
    }

    // Encontrar o sucessor de um arquivo
    private static Arquivo encontrarSucessor(Arquivo atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    // Exibir os arquivos presentes na árvore (ordem alfabética)
    private static void exibirArquivos() {
        if (raiz == null) {
            System.out.println("\nA árvore está vazia.");
        } else {
            System.out.println("\nArquivos presentes na árvore:");
            exibirArquivosRecursivo(raiz);
        }
    }

    // Função auxiliar recursiva para exibir os arquivos presentes na árvore
private static void exibirArquivosRecursivo(Arquivo atual) {
    if (atual != null) {
        exibirArquivosRecursivo(atual.esquerda);
        System.out.println(atual.nome);
        exibirArquivosRecursivo(atual.direita);
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcao = 0;

    while (opcao != 5) {
        System.out.println("\nSistema de Arquivos - Opções:\n");
        System.out.println("    1. Adicionar arquivo");
        System.out.println("    2. Buscar arquivo");
        System.out.println("    3. Remover arquivo");
        System.out.println("    4. Exibir arquivos");
        System.out.println("    5. Sair");
        System.out.print("   Digite a opção desejada: ");
        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("\nDigite o nome do arquivo: ");
                scanner.nextLine(); // Limpar o buffer
                String nomeArquivo = scanner.nextLine();
                adicionarArquivo(nomeArquivo);
                break;
            case 2:
                System.out.print("\nDigite o nome do arquivo a ser buscado: ");
                scanner.nextLine(); // Limpar o buffer
                String arquivoBuscado = scanner.nextLine();
                if (buscarArquivo(arquivoBuscado)) {
                    System.out.println("\nO arquivo \"" + arquivoBuscado + "\" existe na árvore.");
                } else {
                    System.out.println("\nO arquivo \"" + arquivoBuscado + "\" não existe na árvore.");
                }
                break;
            case 3:
                System.out.print("\nDigite o nome do arquivo a ser removido: ");
                scanner.nextLine(); // Limpar o buffer
                String arquivoRemovido = scanner.nextLine();
                removerArquivo(arquivoRemovido);
                break;
            case 4:
                exibirArquivos();
                break;
            case 5:
                System.out.println("\nEncerrando o programa.");
                break;
            default:
                System.out.println("\nOpção inválida. Digite um número de 1 a 5.");
                break;
            }
         }
            scanner.close();
    }
}