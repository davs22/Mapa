package view;

import Class.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Executor {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Região Sudeste
        grafo.adicionarAresta(Capital.SAO_PAULO, Capital.RIO_DE_JANEIRO, 430);
        grafo.adicionarAresta(Capital.SAO_PAULO, Capital.CURITIBA, 410);
        grafo.adicionarAresta(Capital.SAO_PAULO, Capital.BELO_HORIZONTE, 586);
        grafo.adicionarAresta(Capital.SAO_PAULO, Capital.BRASILIA, 1015);
        grafo.adicionarAresta(Capital.SAO_PAULO, Capital.CAMPO_GRANDE, 990); // SP-CG

        grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.VITORIA, 520); // Ajustado de 513
        grafo.adicionarAresta(Capital.RIO_DE_JANEIRO, Capital.BELO_HORIZONTE, 440);

        grafo.adicionarAresta(Capital.VITORIA, Capital.SALVADOR, 1200);
        grafo.adicionarAresta(Capital.VITORIA, Capital.BELO_HORIZONTE, 520); // Ajustado de 515

        // Região Sul
        grafo.adicionarAresta(Capital.CURITIBA, Capital.PORTO_ALEGRE, 720); // Ajustado de 710
        grafo.adicionarAresta(Capital.CURITIBA, Capital.CAMPO_GRANDE, 990); // Curitiba-CG
        grafo.adicionarAresta(Capital.CURITIBA, Capital.FLORIANOPOLIS, 300);

        grafo.adicionarAresta(Capital.PORTO_ALEGRE, Capital.CUIABA, 1900); // POA-Cuiabá
        grafo.adicionarAresta(Capital.PORTO_ALEGRE, Capital.CAMPO_GRANDE, 1350); // Ajustado de 1400
        grafo.adicionarAresta(Capital.PORTO_ALEGRE, Capital.FLORIANOPOLIS, 470);

        // Região Nordeste (principal foco da correção)
        grafo.adicionarAresta(Capital.SALVADOR, Capital.ARACAJU, 330);
        grafo.adicionarAresta(Capital.ARACAJU, Capital.MACEIO, 280);
        grafo.adicionarAresta(Capital.MACEIO, Capital.RECIFE, 260);
        grafo.adicionarAresta(Capital.RECIFE, Capital.JOAO_PESSOA, 120);
        grafo.adicionarAresta(Capital.JOAO_PESSOA, Capital.NATAL, 180);
        grafo.adicionarAresta(Capital.NATAL, Capital.FORTALEZA, 520);
        grafo.adicionarAresta(Capital.FORTALEZA, Capital.TERESINA, 630);
        grafo.adicionarAresta(Capital.TERESINA, Capital.SAO_LUIS, 450);
        grafo.adicionarAresta(Capital.SAO_LUIS, Capital.BELEM, 793);

        // ATENÇÃO: Esta é a aresta que foi ajustada para forçar o caminho via SE e AL
        grafo.adicionarAresta(Capital.SALVADOR, Capital.RECIFE, 950); // Aumentado de 840 para forçar rota costeira (870km)

        grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.SALVADOR, 1370);
        grafo.adicionarAresta(Capital.BELO_HORIZONTE, Capital.MACEIO, 2100); // penaliza o caminho direto
        grafo.adicionarAresta(Capital.TERESINA, Capital.SALVADOR, 1000); // Teresina-Salvador

        // Região Centro-Oeste
        grafo.adicionarAresta(Capital.BRASILIA, Capital.GOIANIA, 210);
        grafo.adicionarAresta(Capital.BRASILIA, Capital.CUIABA, 1050); // Ajustado de 1066
        grafo.adicionarAresta(Capital.BRASILIA, Capital.PALMAS, 970);
        grafo.adicionarAresta(Capital.BRASILIA, Capital.SALVADOR, 1450);
        grafo.adicionarAresta(Capital.BRASILIA, Capital.BELO_HORIZONTE, 740); // Ajustado de 735

        grafo.adicionarAresta(Capital.GOIANIA, Capital.CAMPO_GRANDE, 890); // Ajustado de 900
        grafo.adicionarAresta(Capital.GOIANIA, Capital.CUIABA, 900);

        grafo.adicionarAresta(Capital.CAMPO_GRANDE, Capital.CUIABA, 700);

        // Região Norte
        grafo.adicionarAresta(Capital.PALMAS, Capital.BELEM, 1030);
        grafo.adicionarAresta(Capital.PALMAS, Capital.TERESINA, 970);
        grafo.adicionarAresta(Capital.PALMAS, Capital.BELO_HORIZONTE, 1530);
        grafo.adicionarAresta(Capital.PALMAS, Capital.CUIABA, 950);
        grafo.adicionarAresta(Capital.PALMAS, Capital.SAO_LUIS, 1100);
        grafo.adicionarAresta(Capital.PALMAS, Capital.SALVADOR, 1110);

        grafo.adicionarAresta(Capital.BELEM, Capital.MACAPA, 530);
        grafo.adicionarAresta(Capital.BELEM, Capital.MANAUS, 1600); // Rota longa, mas plausível para grafo

        grafo.adicionarAresta(Capital.MANAUS, Capital.BOA_VISTA, 750);
        grafo.adicionarAresta(Capital.MANAUS, Capital.PORTO_VELHO, 900);
        grafo.adicionarAresta(Capital.PORTO_VELHO, Capital.RIO_BRANCO, 510);
        grafo.adicionarAresta(Capital.PORTO_VELHO, Capital.CUIABA, 1450);

        grafo.adicionarAresta(Capital.RIO_BRANCO, Capital.MANAUS, 1400); // Via PVH seria 900+510=1410. Mantido 1400 para "direto"


        // Inicialização da interface gráfica
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mapa Interativo - Capitais do Brasil");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 900);
            frame.setLayout(new BorderLayout());

            // Painel do mapa
            MapaGrafoPanel mapaPanel = new MapaGrafoPanel(grafo);
            frame.add(mapaPanel, BorderLayout.CENTER);

            // Painel inferior com lista e total
            JPanel infoPanel = new JPanel(new BorderLayout());
            frame.add(infoPanel, BorderLayout.SOUTH);

            DefaultListModel<String> listaModelo = new DefaultListModel<>();
            JList<String> listaCapitais = new JList<>(listaModelo);
            JScrollPane scrollLista = new JScrollPane(listaCapitais);
            scrollLista.setPreferredSize(new Dimension(0, 100));
            infoPanel.add(scrollLista, BorderLayout.CENTER);

            JLabel labelDistancia = new JLabel("Distância total: ");
            labelDistancia.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            infoPanel.add(labelDistancia, BorderLayout.SOUTH);

            // Painel de controle (origem, destino, botão)
            JPanel controlePanel = new JPanel(new FlowLayout());

            JComboBox<Capital> origemBox = new JComboBox<>(Capital.values());
            JComboBox<Capital> destinoBox = new JComboBox<>(Capital.values());
            JButton calcularBtn = new JButton("Calcular Caminho");

            controlePanel.add(new JLabel("Origem:"));
            controlePanel.add(origemBox);
            controlePanel.add(new JLabel("Destino:"));
            controlePanel.add(destinoBox);
            controlePanel.add(calcularBtn);

            frame.add(controlePanel, BorderLayout.NORTH);

            // Ação do botão calcular com animação e lista atualizada
            calcularBtn.addActionListener((ActionEvent e) -> {
                Capital origem = (Capital) origemBox.getSelectedItem();
                Capital destino = (Capital) destinoBox.getSelectedItem();

                if (origem == destino) {
                    JOptionPane.showMessageDialog(frame, "Origem e destino não podem ser iguais!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Caminho caminho = grafo.menorCaminho(origem, destino);
                List<Capital> rota = caminho.getCapitais();

                // Bloco de depuração para ver a rota no console
                System.out.println("\n--- Cálculo de Caminho ---");
                System.out.println("Origem: " + origem.getNome() + ", Destino: " + destino.getNome());
                System.out.print("Rota calculada: ");
                if (rota.isEmpty()) {
                    System.out.println("Nenhum caminho encontrado.");
                } else {
                    for (Capital cap : rota) {
                        System.out.print(cap.getSigla() + " -> ");
                    }
                    System.out.println("FIM");
                    System.out.println("Distância Total: " + caminho.getDistancia() + " km");
                }
                System.out.println("--------------------------\n");
                // Fim do bloco de depuração

                if (rota.isEmpty() || caminho.getDistancia() == Integer.MAX_VALUE) { // Adicionado verificação de distância Max_Value
                    JOptionPane.showMessageDialog(frame, "Não existe caminho entre essas capitais.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                calcularBtn.setEnabled(false);
                listaModelo.clear(); // Limpa a lista antes de preencher
                labelDistancia.setText("Distância total: " + caminho.getDistancia() + " km");

                // Configura listener para habilitar botão no fim da animação
                mapaPanel.setFimAnimacaoListener(ae -> calcularBtn.setEnabled(true));

                // Começa animação no painel
                mapaPanel.animarCaminho(rota);

                // Timer que atualiza a lista conforme animação avança
                new Timer(100, ev -> {
                    listaModelo.clear();
                    for (Capital cap : mapaPanel.getCaminhoAnimado()) {
                        listaModelo.addElement(cap.name() + " (" + cap.getSigla() + ")");
                    }
                    if (mapaPanel.getCaminhoAnimado().size() >= rota.size()) {
                        ((Timer) ev.getSource()).stop();
                    }
                }).start();
            });

            frame.setVisible(true);
        });
    }
}