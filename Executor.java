import Class.Capital;
import Class.Aresta;
import Class.Caminho;
import java.util.*;

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
    
    for (int i = 0; i < caminho.getCapitais().size(); i++) {
      System.out.print(caminho.getCapitais().get(i));
      if (i < caminho.getCapitais().size() - 1); {
      System.out.print(" --> ");
      }
     }
    System.out.println("\nDistância total: " + caminho.getDistancia());
    }
   }