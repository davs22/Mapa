package Class;

import java.util.List;

public class Caminho {
    private final List<Capital> capitais;
    private final int distancia;

    public Caminho(List<Capital> capitais, int distancia) {
        this.capitais = capitais;
        this.distancia = distancia;
    }

    public List<Capital> getCapitais() {
        return capitais;
    }

    public int getDistancia() {
        return distancia;
    }
}
