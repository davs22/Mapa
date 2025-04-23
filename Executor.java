import Class.Capital;
import Class.Caminho;
import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
     
    Grafo grafo = new Grafo();

    grafo.adicionarAresta(Capital.BRASILIA, Capital.SAO_PAULO, 1017);
    grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.RIO_DE_JANEIRO, 434);
    grafo.adicionarAresta(Capital.BRASILIA, Capital.BELO_HORIZONTE, 733);
    grafo.adicionarAresta(Capital.SAO_PAULO, Capital.RIO_DE_JANEIRO, 416);
    grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.SALVADOR, 1618);
    grafo.adicionarAresta(Capital.MACEIO, Capital.ARACAJU, 270);
    grafo.adicionarAresta(Capital.ARACAJU, Capital.SALVADOR, 323);
    grafo.adicionarAresta(Capital.NATAL, Capital.RIO_DE_JANEIRO, 2487);
    grafo.adicionarAresta(Capital.RIO_BRANCO, Capital.BELO_HORIZONTE, 3485);
    grafo.adicionarAresta(Capital.GOIANIA, Capital.SAO_PAULO, 909);
    grafo.adicionarAresta(Capital.BELEM, Capital.RIO_BRANCO, 4060);
    grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.FORTALEZA, 2567);
    grafo.adicionarAresta(Capital.NATAL, Capital.FORTALEZA, 512);
    
    Scanner scanner = new Scanner(System.in);

    System.out.print("Origem: ");
    Capital origem = Capital.fromNome(scanner.nextLine());

    System.out.print("Destino: ");
    Capital destino = Capital.fromNome(scanner.nextLine());

    if (origem == null || destino == null) {
        System.out.println("Capital inválida!");
        return;
    }

    Caminho caminho = grafo.menorCaminho(origem, destino);

    System.out.print("Menor caminho: ");
    for (Capital capital : caminho.getRota()) {
        System.out.print(capital.getNome());
        if (!capital.equals(destino)) System.out.print(" -> ");
    }
    System.out.println("\nDistância total: " + caminho.getDistanciaTotal() + " km");
}
  }