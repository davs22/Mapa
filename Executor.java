import Class.Capital;
import Class.Caminho;
import java.util.List;

public class Executor {
    public static void main(String[] args) {
     
    Grafo grafo = new Grafo();

    grafo.adicionarAresta(Capital.BRASILIA, Capital.SAO_PAULO,10);
    grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.RIO_DE_JANEIRO,7);
    grafo.adicionarAresta(Capital.BRASILIA, Capital.BELO_HORIZONTE,8);
    grafo.adicionarAresta(Capital.SAO_PAULO, Capital.RIO_DE_JANEIRO,5);
    grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.SALVADOR,20);

    Capital origem = Capital.BRASILIA;
    Capital destino = Capital.SALVADOR;

    Caminho caminho = grafo.menorCaminho(origem, destino);
    
    System.out.println("Menor caminho de " + origem + " até " + destino + ":");
    
    List<Capital> listaCapitais = caminho.getCapitais();
    int distanciatotal = caminho.getDistancia();

    for (int i = 0; i < listaCapitais.size(); i++) {
      System.out.print(listaCapitais.get(i));
      if (i < listaCapitais.size() - 1) {
      System.out.print(" --> ");
      }
     }
    System.out.println("\nDistância total: " + distanciatotal);
    }
  }