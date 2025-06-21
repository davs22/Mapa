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

    private ActionListener fimAnimacaoListener; // listener para fim da animação

    public MapaGrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        // Certifique-se de que o caminho da imagem está correto
        // Pode ser útil imprimir System.getProperty("user.dir") para verificar o diretório de execução
        imagemFundo = new ImageIcon("resources/mapa.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2)); // Linhas mais grossas para melhor visibilidade

        int width = getWidth();
        int height = getHeight();

        // Desenhar caminho animado
        // Use a cor verde para as linhas do caminho também
        g2.setColor(Color.GREEN);
        for (int i = 0; i < caminhoAnimado.size() - 1; i++) {
            Capital c1 = caminhoAnimado.get(i);
            Capital c2 = caminhoAnimado.get(i + 1);
            g2.drawLine(
                escalarX(c1.getX(), width), escalarY(c1.getY(), height),
                escalarX(c2.getX(), width), escalarY(c2.getY(), height)
            );
        }

        // Desenhar pontos das capitais
        for (Capital capital : Capital.values()) {
            int x = escalarX(capital.getX(), width);
            int y = escalarY(capital.getY(), height);

            // Aumentar o tamanho do círculo para melhor visibilidade
            int circleSize = 12; // De 10 para 12
            int offset = circleSize / 2;

            if (caminhoAnimado.contains(capital)) {
                g.setColor(Color.GREEN); // Ponto da capital no caminho
            } else {
                g.setColor(Color.BLUE); // Ponto da capital fora do caminho
            }

            g.fillOval(x - offset, y - offset, circleSize, circleSize);
            g.setColor(Color.BLACK);
            // Opcional: desenhar a sigla da capital para depuração, se quiser
            // g.drawString(capital.getSigla(), x + offset + 2, y - offset + 5);
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
        repaint(); // Limpa visualmente antes de iniciar a nova animação

        // Se o caminho for nulo ou vazio, não inicie o timer
        if (caminhoCompleto == null || caminhoCompleto.isEmpty()) {
            if (fimAnimacaoListener != null) {
                fimAnimacaoListener.actionPerformed(null);
            }
            return;
        }

        Timer timer = new Timer(500, null); // 500ms de delay por passo
        final int[] index = {0};

        timer.addActionListener(e -> {
            if (index[0] < caminhoCompleto.size()) {
                caminhoAnimado.add(caminhoCompleto.get(index[0]));
                index[0]++;
                repaint(); // Solicita redesenho a cada passo da animação
            } else {
                // A animação terminou
                ((Timer) e.getSource()).stop();
                // GARANTIA: Um repaint final para mostrar o estado completo
                repaint(); // <-- ESSA É A LINHA CRUCIAL ADICIONADA/REAFIRMADA
                if (fimAnimacaoListener != null) {
                    fimAnimacaoListener.actionPerformed(null); // avisa fim para o Executor
                }
            }
        });

        timer.start();
    }

    public List<Capital> getCaminhoAnimado() {
        return caminhoAnimado;
    }
}