package TurismoAngola;
import java.util.List;
import java.util.*;

class Grafo {
    private Map<String, List<String>> adjacencias;

    public Grafo() {
        adjacencias = new HashMap<>();
    }

    public void adicionarAresta(String origem, String destino) {
        adjacencias.computeIfAbsent(origem, k -> new ArrayList<>()).add(destino);
        adjacencias.computeIfAbsent(destino, k -> new ArrayList<>()).add(origem);
    }

    public List<String> obterRotas(String origem, String destino) {
        if (!adjacencias.containsKey(origem) || !adjacencias.containsKey(destino))
            return Collections.emptyList();

        Queue<String> fila = new LinkedList<>();
        Map<String, String> pais = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();
            if (atual.equals(destino)) {
                return construirCaminho(pais, destino);
            }

            for (String vizinho : adjacencias.getOrDefault(atual, Collections.emptyList())) {
                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                    pais.put(vizinho, atual);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<String> construirCaminho(Map<String, String> pais, String destino) {
        List<String> caminho = new ArrayList<>();
        caminho.add(destino);

        String atual = destino;
        while (pais.containsKey(atual)) {
            atual = pais.get(atual);
            caminho.add(0, atual);
        }

        return caminho;
    }
}
