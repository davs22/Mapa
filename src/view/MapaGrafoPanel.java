package view;

import Class.Capital;
import Class.Grafo;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class MapaGrafoPanel extends JPanel {
    private Image imagemFundo;
    private final Grafo grafo;

    private List<Capital> caminhoCompleto;
    private final List<Capital> caminhoAnimado = new ArrayList<>();

    private ActionListener fimAnimacaoListener; 

    public MapaGrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        
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

        g2.setColor(Color.GREEN);
        for (int i = 0; i < caminhoAnimado.size() - 1; i++) {
            Capital c1 = caminhoAnimado.get(i);
            Capital c2 = caminhoAnimado.get(i + 1);
            g2.drawLine(
                escalarX(c1.getX(), width), escalarY(c1.getY(), height),
                escalarX(c2.getX(), width), escalarY(c2.getY(), height)
            );
        }

        for (Capital capital : Capital.values()) {
            int x = escalarX(capital.getX(), width);
            int y = escalarY(capital.getY(), height);

            int circleSize = 12; 
            int offset = circleSize / 2;

            if (caminhoAnimado.contains(capital)) {
                g.setColor(Color.GREEN); 
            } else {
                g.setColor(Color.BLUE); 
            }

            g.fillOval(x - offset, y - offset, circleSize, circleSize);
            g.setColor(Color.BLACK);
            
        }
    }

    private int escalarX(int original, int largura) {
        return (int) (original / 1000.0 * largura);
    }

    private int escalarY(int original, int altura) {
        return (int) (original / 1000.0 * altura);
    }

    public void setFimAnimacaoListener(ActionListener listener) {
        this.fimAnimacaoListener = listener;
    }

    public void animarCaminho(List<Capital> caminho) {
        this.caminhoCompleto = caminho;
        this.caminhoAnimado.clear();
        repaint(); 

        if (caminhoCompleto == null || caminhoCompleto.isEmpty()) {
            if (fimAnimacaoListener != null) {
                fimAnimacaoListener.actionPerformed(null);
            }
            return;
        }

        Timer timer = new Timer(500, null); 
        final int[] index = {0};

        timer.addActionListener(e -> {
            if (index[0] < caminhoCompleto.size()) {
                caminhoAnimado.add(caminhoCompleto.get(index[0]));
                index[0]++;
                repaint(); 
            } else {
               
                ((Timer) e.getSource()).stop();
                
                repaint(); 
                if (fimAnimacaoListener != null) {
                    fimAnimacaoListener.actionPerformed(null); 
                }
            }
        });

        timer.start();
    }

    public List<Capital> getCaminhoAnimado() {
        return caminhoAnimado;
    }
}