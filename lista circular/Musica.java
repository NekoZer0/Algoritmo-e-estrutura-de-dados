
import java.util.Scanner;

// Classe que representa uma música
class Musica {
    private String nome;

    public Musica(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// Classe que representa um nó na lista circular
class No {
    private Musica musica;
    private No proximo;

    public No(Musica musica) {
        this.musica = musica;
        this.proximo = null;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }
}

// Classe que representa a lista circular de músicas
class Playlist {
    private No primeiro;
    private No ultimo;

    public Playlist() {
        primeiro = null;
        ultimo = null;
    }

    // Verifica se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Insere uma música no final da lista
    public void inserirNoFinal(Musica musica) {
        No novoNo = new No(musica);
        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
            novoNo.setProximo(primeiro);
        } else {
            novoNo.setProximo(primeiro);
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
    }

    // Insere uma música no início da lista
    public void inserirNoInicio(Musica musica) {
        No novoNo = new No(musica);
        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
            novoNo.setProximo(primeiro);
        } else {
            novoNo.setProximo(primeiro);
            primeiro = novoNo;
            ultimo.setProximo(primeiro);
        }
    }

    // Remove a primeira ocorrência de uma música no início da lista
    public void removerNoInicio() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            primeiro = primeiro.getProximo();
            ultimo.setProximo(primeiro);
        }
        System.out.println("A primeira música foi removida da lista.");
    }

    // Remove a primeira ocorrência de uma música no final da lista
    public void removerNoFinal() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            No atual = primeiro;
            while (atual.getProximo() != ultimo) {
                atual = atual.getProximo();
            }
            atual.setProximo(primeiro);
            ultimo = atual;
        }
        System.out.println("A última música foi removida da lista.");
    }

        // Remove todas as ocorrências de uma música na lista
        public void remover(Musica musica) {
            if (estaVazia()) {
                System.out.println("A lista está vazia.");
                return;
            }
    
            No atual = primeiro;
            No anterior = ultimo;
            boolean encontrou = false;
    
            do {
                if (atual.getMusica().getNome().equals(musica.getNome())) {
                    if (atual == primeiro) {
                        primeiro = primeiro.getProximo();
                        ultimo.setProximo(primeiro);
                    } else if (atual == ultimo) {
                        ultimo = anterior;
                        ultimo.setProximo(primeiro);
                    } else {
                        anterior.setProximo(atual.getProximo());
                    }
                    encontrou = true;
                }
    
                anterior = atual;
                atual = atual.getProximo();
    
            } while (atual != primeiro);
    
            if (encontrou) {
                System.out.println("A música '" + musica.getNome() + "' foi removida da lista.");
            } else {
                System.out.println("A música '" + musica.getNome() + "' não foi encontrada na lista.");
            }
        }
    
        // Busca uma música específica na lista
        public boolean buscar(Musica musica) {
            if (estaVazia()) {
                System.out.println("A lista está vazia.");
                return false;
            }
    
            No atual = primeiro;
    
            do {
                if (atual.getMusica().getNome().equals(musica.getNome())) {
                    System.out.println("A música '" + musica.getNome() + "' foi encontrada na lista.");
                    return true;
                }
    
                atual = atual.getProximo();
    
            } while (atual != primeiro);
    
            System.out.println("A música '" + musica.getNome() + "' não foi encontrada na lista.");
            return false;
        }
    
        // Exibe todas as músicas da lista
        public void exibirLista() {
            if (estaVazia()) {
                System.out.println("A lista está vazia.");
                return;
            }
    
            No atual = primeiro;
    
            System.out.println("Playlist:");
    
            do {
                System.out.println("- " + atual.getMusica().getNome());
                atual = atual.getProximo();
    
            } while (atual != primeiro);
        }
    
        // Método principal para interação com o usuário
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Playlist playlist = new Playlist();
    
            System.out.println("Bem-vindo(a) à sua playlist!");
    
            int opcao;
            do {
                System.out.println(" =========REPRODUÇÃO DE MÚSICA==========");
                System.out.println("\nMenu:");
                System.out.println("    1. Inserir música no início da lista");
                System.out.println("    2. Inserir música no final da lista");
                System.out.println("    3. Remover música no início da lista");
                System.out.println("    4. Remover música no final da lista");
                System.out.println("    5. Remover música da lista");
                System.out.println("    6. Buscar música na lista");
                System.out.println("    7. Exibir todas as músicas da lista");
                System.out.println("    0. Encerrar programa");
                System.out.print("      Escolha uma opção: ");
    
                opcao = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome da música: ");
                        String nomeMusicaInicio = scanner.nextLine();
                        playlist.inserirNoInicio(new Musica(nomeMusicaInicio));
                        System.out.println("A música '" + nomeMusicaInicio + "' foi inserida no início da lista.");
                        break;
                    case 2:
                        System.out.print("Digite o nome da música: ");
                        String nomeMusicaFinal = scanner.nextLine();
                        playlist.inserirNoFinal(new Musica(nomeMusicaFinal));
                        System.out.println("A música '" + nomeMusicaFinal + "' foi inserida no final da lista.");
                        break;
                    case 3:
                        playlist.removerNoInicio();
                        break;
                    case 4:
                        playlist.removerNoFinal();
                        break;
                    case 5:
                        System.out.print("Digite o nome da música: ");
                        String nomeMusicaRemover = scanner.nextLine();
                        playlist.remover(new Musica(nomeMusicaRemover));
                        break;
                    case 6:
                        System.out.print("Digite o nome da música: ");
                        String nomeMusicaBuscar = scanner.nextLine();
                        playlist.buscar(new Musica(nomeMusicaBuscar));
                        break;
                    case 7:
                        playlist.exibirLista();
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
    
            } while (opcao != 0);
    
            scanner.close();
        }
    }
