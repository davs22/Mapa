package view;

import Class.*;

import javax.swing.*;
import java.util.List;

public class Executor {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

grafo.adicionarAresta(Capital.SAO_PAULO, Capital.RIO_DE_JANEIRO, 430);
grafo.adicionarAresta(Capital.SAO_PAULO, Capital.CURITIBA, 410);
grafo.adicionarAresta(Capital.SAO_PAULO, Capital.BELO_HORIZONTE, 580);
grafo.adicionarAresta(Capital.SAO_PAULO, Capital.BRASILIA, 1015);
grafo.adicionarAresta(Capital.SAO_PAULO, Capital.CAMPO_GRANDE, 990);

grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.VITORIA, 520);
grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.BELO_HORIZONTE, 440);

grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.GOIANIA, 910);
grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.SALVADOR, 1370);
grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.MACEIO, 1600);

grafo.adicionarAresta(Capital.CURITIBA, Capital.PORTO_ALEGRE, 710);
grafo.adicionarAresta(Capital.CURITIBA, Capital.CAMPO_GRANDE, 990);
grafo.adicionarAresta(Capital.CURITIBA, Capital.FLORIANOPOLIS, 300);

grafo.adicionarAresta(Capital.PORTO_ALEGRE, Capital.CUIABA, 1900);
grafo.adicionarAresta(Capital.PORTO_ALEGRE, Capital.CAMPO_GRANDE, 1400);
grafo.adicionarAresta(Capital.PORTO_ALEGRE, Capital.FLORIANOPOLIS, 470);

grafo.adicionarAresta(Capital.SALVADOR, Capital.ARACAJU, 330);
grafo.adicionarAresta(Capital.ARACAJU, Capital.MACEIO, 280);
grafo.adicionarAresta(Capital.MACEIO, Capital.RECIFE, 260);
grafo.adicionarAresta(Capital.RECIFE, Capital.JOAO_PESSOA, 120);
grafo.adicionarAresta(Capital.JOAO_PESSOA, Capital.NATAL, 180);
grafo.adicionarAresta(Capital.NATAL, Capital.FORTALEZA, 520);
grafo.adicionarAresta(Capital.FORTALEZA, Capital.TERESINA, 630);
grafo.adicionarAresta(Capital.TERESINA, Capital.SAO_LUIS, 450);
grafo.adicionarAresta(Capital.SAO_LUIS, Capital.BELEM, 800);

grafo.adicionarAresta(Capital.BRASILIA, Capital.GOIANIA, 210);
grafo.adicionarAresta(Capital.BRASILIA, Capital.CUIABA, 1130);
grafo.adicionarAresta(Capital.BRASILIA, Capital.PALMAS, 970);
grafo.adicionarAresta(Capital.BRASILIA, Capital.SALVADOR, 1450);

grafo.adicionarAresta(Capital.PALMAS, Capital.BELEM, 990);
grafo.adicionarAresta(Capital.PALMAS, Capital.TERESINA, 970);

grafo.adicionarAresta(Capital.BELEM, Capital.MACAPA, 530);
grafo.adicionarAresta(Capital.BELEM, Capital.MANAUS, 1600);

grafo.adicionarAresta(Capital.MANAUS, Capital.BOA_VISTA, 750);
grafo.adicionarAresta(Capital.MANAUS, Capital.PORTO_VELHO, 900);
grafo.adicionarAresta(Capital.PORTO_VELHO, Capital.RIO_BRANCO, 510);
grafo.adicionarAresta(Capital.PORTO_VELHO, Capital.CUIABA, 1450);

grafo.adicionarAresta(Capital.CAMPO_GRANDE, Capital.CUIABA, 700);

grafo.adicionarAresta(Capital.VITORIA, Capital.SALVADOR, 1200);

grafo.adicionarAresta(Capital.GOIANIA, Capital.CAMPO_GRANDE, 900);
grafo.adicionarAresta(Capital.GOIANIA, Capital.CUIABA, 900);
grafo.adicionarAresta(Capital.SALVADOR, Capital.RECIFE, 840);
grafo.adicionarAresta(Capital.TERESINA, Capital.SALVADOR, 1000);
grafo.adicionarAresta(Capital.SAO_LUIS, Capital.PALMAS, 1100);

        Caminho caminho = grafo.menorCaminho(Capital.BRASILIA, Capital.MACEIO);
        List<Capital> rota = caminho.getCapitais();

        JFrame frame = new JFrame("Mapa com Capitais e Rotas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.add(new MapaGrafoPanel(grafo, rota));
        frame.setVisible(true);
    }
}
