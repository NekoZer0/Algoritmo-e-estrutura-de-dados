import java.util.Scanner;

// Classe que representa um vídeo
class Video {
    private String nome;

    public Video(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// Classe que representa um nó da lista duplamente ligada
class No {
    private Video video;
    private No proximo;
    private No anterior;

    public No(Video video) {
        this.video = video;
        this.proximo = null;
        this.anterior = null;
    }

    public Video getVideo() {
        return video;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}

// Classe que representa a lista duplamente ligada (playlist)
class Playlist {
    private No primeiro;
    private No ultimo;
    private No atual;

    public Playlist() {
        this.primeiro = null;
        this.ultimo = null;
        this.atual = null;
    }

    // Método para adicionar um vídeo à playlist    
    public void adicionarVideo(Video video) {
        No novoNo = new No(video);

        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
            atual = novoNo;
        } else {
            novoNo.setAnterior(ultimo);
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
    }

    // Método para avançar para o próximo vídeo
    public void avancar() {
        if (atual != null && atual.getProximo() != null) {
            atual = atual.getProximo();
        } else {
            System.out.println("Não há próximo vídeo.");
        }
    }

    // Método para retroceder para o vídeo anterior
    public void retroceder() {
        if (atual != null && atual.getAnterior() != null) {
            atual = atual.getAnterior();
        } else {
            System.out.println("Não há vídeo anterior.");
        }
    }

    // Método para pular para um vídeo específico
    public void pularPara(int indice) {
        No no = primeiro;
        int i = 0;
        while (no != null && i < indice) {
            no = no.getProximo();
            i++;
        }
        if (no != null) {
            atual = no;
        } else {
            System.out.println("Vídeo não encontrado.");
        }
    }

    // Método para reproduzir o vídeo atual
    public void reproduzir() {
        if (atual != null) {
            System.out.println("Reproduzindo vídeo: " + atual.getVideo().getNome());
        } else {
            System.out.println("Não há vídeo para reproduzir.");
        }
    }
        public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);

        // Exemplo de adição de vídeos à playlist
        playlist.adicionarVideo(new Video("Video 1"));
        playlist.adicionarVideo(new Video("Video 2"));
        playlist.adicionarVideo(new Video("Video 3"));

        // Menu de interação com o usuário
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n*********** REPRODUTOR DE VIDEO **************\n");
            System.out.println("    Selecione uma opção:\n");
            System.out.println("    1. Avançar para o próximo vídeo");
            System.out.println("    2. Retroceder para o vídeo anterior");
            System.out.println("    3. Pular para um vídeo específico");
            System.out.println("    4. Reproduzir vídeo atual");
            System.out.println("    5. Adicionar vídeo à playlist");
            System.out.println("    6. Sair\n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    playlist.avancar();
                    break;
                case 2:
                    playlist.retroceder();
                    break;
                case 3:
                    System.out.println("Digite o índice do vídeo:");
                    int indice = scanner.nextInt();
                    playlist.pularPara(indice);
                    break;
                case 4:
                    playlist.reproduzir();
                    break;
                case 5:
                    System.out.println("Digite o nome do vídeo:");
                    String nomeVideo = scanner.next();
                    Video novoVideo = new Video(nomeVideo);
                    playlist.adicionarVideo(novoVideo);
                    break;
                case 6:
                    System.out.println("Encerrando o reprodutor de vídeo.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                }
            }

        scanner.close();
    }
}
   


