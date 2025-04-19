package Class;
import java.util.List;

public class Caminho {
    public final List<Capital> rota;
    public final int distanciaTotal;

    public Caminho(List<Capital> rota, int distanciaTotal) {
        this.rota = rota;
        this.distanciaTotal = distanciaTotal;
    }
}
