
class Livro {
    private String nome;
    private String isbn;
    private String autor;
    private int anoLancamento;

    public Livro(String nome, String isbn, String autor, int anoLancamento) {
        this.nome = nome;
        this.isbn = isbn;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}

class PilhaLivros {
    private static final int CAPACIDADE_MAXIMA = 30;
    private Livro[] livros;
    private int topo;

    public PilhaLivros() {
        livros = new Livro[CAPACIDADE_MAXIMA];
        topo = -1;
    }

    public void empilharLivro(Livro livro) {
        if (topo < CAPACIDADE_MAXIMA - 1) {
            topo++;
            livros[topo] = livro;
            System.out.println("Livro empilhado: " + livro.getNome());
        } else {
            System.out.println("A pilha de livros está cheia. Não é possível empilhar mais livros.");
        }
    }

    public Livro desempilharLivro() {
        if (topo >= 0) {
            Livro livroDesempilhado = livros[topo];
            topo--;
            System.out.println("Livro desempilhado: " + livroDesempilhado.getNome());
            return livroDesempilhado;
        } else {
            System.out.println("A pilha de livros está vazia. Não é possível desempilhar livros.");
            return null;
        }
    }

    public void verificarLivroTopo() {
        if (topo >= 0) {
            Livro livroTopo = livros[topo];
            System.out.println("Livro no topo da pilha: " + livroTopo.getNome());
        } else {
            System.out.println("A pilha de livros está vazia.");
        }
    }

    public void imprimirPilha() {
        if (topo >= 0) {
            System.out.println("Livros na pilha:");
            for (int i = topo; i >= 0; i--) {
                Livro livro = livros[i];
                System.out.println("Nome: " + livro.getNome());
                System.out.println("ISBN: " + livro.getIsbn());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano de Lançamento: " + livro.getAnoLancamento());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("A pilha de livros está vazia.");
        }
    }

    public boolean pilhaVazia() {
        return topo == -1;
    }

    public boolean pilhaCheia() {
        return topo == CAPACIDADE_MAXIMA - 1;
    }

    public int tamanhoPilha() {
        return topo + 1;
    }
}