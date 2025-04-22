package Class;

public class Aresta {
    public final Capital destino;
    public final int distancia;

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
