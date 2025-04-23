package Class;
import java.util.List;

public class Caminho {
    public final List<Capital> rota;
    public final int distanciaTotal;

    public Caminho(List<Capital> rota, int distanciaTotal) {
        this.rota = rota;
        this.distanciaTotal = distanciaTotal;
    }

    public List<Capital> getRota() {
        return rota;
    }

    public int getDistanciaTotal() {
        return distanciaTotal;
    }

    public List<Capital> getCapitais() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getCapitais'");
    }

    public int getDistancia() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDistancia'");
    }

    
}
