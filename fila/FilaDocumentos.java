import java.util.Scanner;

public class FilaDocumentos {
    private static class NoDocumento {
        String documento;
        NoDocumento proximo;

        public NoDocumento(String documento) {
            this.documento = documento;
            this.proximo = null;
        }
    }

    private static class Fila {
        private NoDocumento inicio;
        private NoDocumento fim;

        public Fila() {
            this.inicio = null;
            this.fim = null;
        }

        public void adicionarDocumento(String documento) {
            NoDocumento novoDocumento = new NoDocumento(documento);

            if (inicio == null) {
                inicio = novoDocumento;
                fim = novoDocumento;
            } else {
                fim.proximo = novoDocumento;
                fim = novoDocumento;
            }

            System.out.println("Documento \"" + documento + "\" adicionado à fila.");
        }

        public void removerDocumento() {
            if (inicio == null) {
                System.out.println("A fila de documentos está vazia.");
                return;
            }

            String documentoRemovido = inicio.documento;
            inicio = inicio.proximo;

            if (inicio == null) {
                fim = null;
            }

            System.out.println("Documento \"" + documentoRemovido + "\" removido da fila.");
        }

        public void verificarDocumentos() {
            if (inicio == null) {
                System.out.println("A fila de documentos está vazia.");
                return;
            }

            System.out.println("Documentos na fila:");

            NoDocumento atual = inicio;
            while (atual != null) {
                System.out.println(atual.documento);
                atual = atual.proximo;
            }
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:\n");
            System.out.println("1 - Adicionar documento");
            System.out.println("2 - Remover documento");
            System.out.println("3 - Verificar documentos");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do documento:");
                    String documento = scanner.nextLine();
                    fila.adicionarDocumento(documento);
                    break;
                case 2:
                    fila.removerDocumento();
                    break;
                case 3:
                    fila.verificarDocumentos();
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println(); // Nova linha para separar as iterações
        }
    }
}