package view;

import Class.Capital;
import Class.Grafo;
import Class.Aresta;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class MapaGrafoPanel extends JPanel {
    private Image imagemFundo;
    private final Grafo grafo;
    private final List<Capital> caminho;

    public MapaGrafoPanel(Grafo grafo, List<Capital> caminho) {
        this.grafo = grafo;
        this.caminho = caminho;
        imagemFundo = new ImageIcon("resources/mapa.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        int width = getWidth();
        int height = getHeight();

        g.setColor(Color.GRAY);
        for (Map.Entry<Capital, List<Aresta>> entry : grafo.getAdjacencias().entrySet()) {
            int x1 = escalarX(entry.getKey().getX(), width);
            int y1 = escalarY(entry.getKey().getY(), height);
            for (Aresta aresta : entry.getValue()) {
                Capital destino = aresta.getDestino();
                if (entry.getKey().ordinal() < destino.ordinal()) {
                    int x2 = escalarX(destino.getX(), width);
                    int y2 = escalarY(destino.getY(), height);
                    g.drawLine(x1, y1, x2, y2);
                }
            }
        }

        g.setColor(Color.RED);
        for (int i = 0; i < caminho.size() - 1; i++) {
            Capital c1 = caminho.get(i);
            Capital c2 = caminho.get(i + 1);
            g.drawLine(
                escalarX(c1.getX(), width), escalarY(c1.getY(), height),
                escalarX(c2.getX(), width), escalarY(c2.getY(), height)
            );
        }

        for (Capital capital : Capital.values()) {
            int x = escalarX(capital.getX(), width);
            int y = escalarY(capital.getY(), height);
            g.setColor(Color.BLUE);
            g.fillOval(x - 5, y - 5, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString(capital.getSigla(), x + 5, y - 5);
        }
    }

    private int escalarX(int original, int largura) {
        return (int) (original / 1000.0 * largura);
    }

    private int escalarY(int original, int altura) {
        return (int) (original / 1000.0 * altura);
    }
}
