import java.util.*;
import Class.Capital;
import Class.Aresta;
import Class.Caminho;

public class Dijkstra {
    public static Caminho calcularMenorCaminho(Map<Capital, List<Aresta>> adjacencias, Capital origem, Capital destino) {
        Map<Capital, Integer> distancias = new HashMap<>();
        Map<Capital, Capital> anteriores = new HashMap<>();
        PriorityQueue<Capital> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Capital c : Capital.values()) {
            distancias.put(c, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Capital atual = fila.poll();

            for (Aresta aresta : adjacencias.getOrDefault(atual, new ArrayList<>())) {
                int novaDist = distancias.get(atual) + aresta.distancia;
                if (novaDist < distancias.get(aresta.destino)) {
                    distancias.put(aresta.destino, novaDist);
                    anteriores.put(aresta.destino, atual);
                    fila.add(aresta.destino);
                }
            }
        }

        List<Capital> caminho = new ArrayList<>();
        Capital atual = destino;
        while (atual != null) {
            caminho.add(atual);
            atual = anteriores.get(atual);
        }
        Collections.reverse(caminho);

        return new Caminho(caminho, distancias.get(destino));
    }
}
