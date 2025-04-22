import Class.Aresta;
import Class.Capital;
import Class.Caminho;

import java.util.*;

public class Grafo {
    private final Map<Capital, List<Aresta>> adjacencias = new HashMap<>();

    public void adicionarAresta(Capital origem, Capital destino, int distancia) {
        adjacencias.computeIfAbsent(origem, k -> new ArrayList<>()).add(new Aresta(destino, distancia));
        adjacencias.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Aresta(origem, distancia));
    }

    public Caminho menorCaminho(Capital origem, Capital destino) {
        Map<Capital, Integer> distancias = new HashMap<>();
        Map<Capital, Capital> anteriores = new HashMap<>();
        PriorityQueue<Capital> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Capital capital : Capital.values()) {
            distancias.put(capital, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Capital atual = fila.poll();

            for (Aresta aresta : adjacencias.getOrDefault(atual, new ArrayList<>())) {
                int novaDistancia = distancias.get(atual) + aresta.getDistancia();
                if (novaDistancia < distancias.get(aresta.getDestino())) {
                    distancias.put(aresta.getDestino(), novaDistancia);
                    anteriores.put(aresta.getDestino(), atual);
                    fila.add(aresta.getDestino());
                }
            }
        }

        List<Capital> caminho = new ArrayList<>();
        for (Capital at = destino; at != null; at = anteriores.get(at)) {
            caminho.add(at);
        }
        Collections.reverse(caminho);

        return new Caminho(caminho, distancias.get(destino));
    }
}
