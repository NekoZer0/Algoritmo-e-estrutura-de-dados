
// Classe que representa um contato com nome, telefone e email
class Contato {
    String nome;
    String telefone;
    String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}

// Classe que representa um nó da lista encadeada
class No {
    Contato contato;
    No proximo;

    public No(Contato contato) {
        this.contato = contato;
        this.proximo = null;
    }
}

// Classe que implementa a lista encadeada e seus métodos
class ListaEncadeada {
    No primeiro;
    int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    // Retorna o tamanho da lista
    public int getTamanho() {
        return tamanho;
    }

    // Insere um contato no início da lista
    public void inserirInicio(Contato contato) {
        No novoNo = new No(contato);
        novoNo.proximo = primeiro;
        primeiro = novoNo;
        tamanho++;
    }

    // Insere um contato no final da lista
    public void inserirFinal(Contato contato) {
        No novoNo = new No(contato);
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            No atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    // Insere um contato em uma posição específica da lista
    public void inserirPosicao(Contato contato, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Posição inválida!");
            return;
        }
        if (posicao == 0) {
            inserirInicio(contato);
        } else if (posicao == tamanho) {
            inserirFinal(contato);
        } else {
            No novoNo = new No(contato);
            No atual = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
            tamanho++;
        }
    }

    // Remove o contato do início da lista
    public void removerInicio() {
        if (primeiro == null) {
            System.out.println("A lista está vazia!");
            return;
        }
        primeiro = primeiro.proximo;
        tamanho--;
    }

    // Remove o contato do final da lista
    public void removerFinal() {
        if (primeiro == null) {
            System.out.println("A lista está vazia!");
            return;
        }
        if (tamanho == 1) {
            primeiro = null;
        } else {
            No atual = primeiro;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = null;
        }
        tamanho--;
    }

    // Remove o contato de uma posição específica da lista
    public void removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida!");
            return;
        }
        if (posicao == 0) {
            removerInicio();
        } else if (posicao == tamanho - 1) {
            removerFinal();
        } else {
            No atual = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
            tamanho--;
        }
    }

    // Percorre a lista e exibe os contatos
    public void percorrerLista() {
        No atual = primeiro;
        while (atual != null) {
            System.out.println("Nome: " + atual.contato.nome);
            System.out.println("Telefone: " + atual.contato.telefone);
            System.out.println("Email: " + atual.contato.email);
            System.out.println("-------------------------");
            atual = atual.proximo;
        }
    }

    // Pesquisa e retorna o contato de uma posição específica da lista
    public Contato pesquisarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida!");
            return null;
        }
        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.contato;
    }

    // Limpa a lista, removendo todos os contatos
    public void limparLista() {
        primeiro = null;
        tamanho = 0;
    }
}

