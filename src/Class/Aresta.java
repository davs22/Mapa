package Class;

public class Aresta {
    private final Capital destino;
    private final int distancia;

    public Aresta(Capital destino, int distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Capital getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
}
