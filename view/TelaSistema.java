package view;

import model.Estagiario;
import service.EstagioService;

import javax.swing.*;
import java.awt.*;


public class TelaSistema extends JFrame{

    
        private JTextField campoNome;
       
        private JButton botaoEntrada;
        private JButton botaoSaida;
        private JButton botaoTicket;
        private JButton botaoHistorico;

        private JLabel labelEntrada;
        private JLabel labelSaida;
        private JLabel labelTickets;
        private JLabel labelProdutividade;
        private JLabel labelHistorico;

        private Estagiario estagiario;

        private EstagioService service;

        private java.util.List<Estagiario> listaHistorico = new java.util.ArrayList<>();

        public TelaSistema() {


           service = new EstagioService();

           setTitle ("Sistema de Estagiários - CENTI");

           setSize(400, 300);

           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           setLocationRelativeTo(null);

           setLayout(new GridLayout(8, 1));

           setLayout(new GridLayout(10, 1, 10, 10));

            getContentPane().setBackground(
                new Color(245, 247, 250)
            );

           campoNome = new JTextField();

           Font fonteBotao = new Font(
    "Arial",
    Font.BOLD,
    14
);

        Font fonteLabel = new Font(
        "Arial",
            Font.PLAIN,
            15
        );


           botaoEntrada = new JButton("Registrar Entrada");
           botaoSaida = new JButton("Registrar Saída");
           botaoTicket = new JButton("Adicionar Ticket");
           botaoHistorico = new JButton("Verificar Histórico");

                    botaoEntrada.setBackground(
            new Color(33, 150, 243)
        );

        botaoEntrada.setForeground(Color.WHITE);

        botaoSaida.setBackground(
            new Color(244, 67, 54)
        );

        botaoSaida.setForeground(Color.WHITE);

        botaoTicket.setBackground(
            new Color(76, 175, 80)
        );

        botaoTicket.setForeground(Color.WHITE);

        botaoHistorico.setBackground(
                    new Color(244, 181, 54)
        );

        botaoHistorico.setForeground(Color.WHITE);

        botaoEntrada.setFont(fonteBotao);
        botaoSaida.setFont(fonteBotao);
        botaoTicket.setFont(fonteBotao);
        botaoHistorico.setFont(fonteBotao);

           labelEntrada = new JLabel("Entrada: ");
           labelSaida = new JLabel("Saída: ");
           labelTickets = new JLabel("Tickets: 0");
           labelProdutividade = new JLabel("Produtividade: 0%");
           labelHistorico = new JLabel("Verificar Histórico");


                JLabel labelStatus = new JLabel("Status: Trabalhando");

                labelEntrada.setFont(fonteLabel);
                labelSaida.setFont(fonteLabel);
                labelTickets.setFont(fonteLabel);
                labelHistorico.setFont(fonteLabel);

                labelProdutividade.setFont(
                    new Font("Arial", Font.BOLD, 16)
                );

                labelStatus.setFont(fonteLabel);

                labelProdutividade.setHorizontalAlignment(
                        SwingConstants.CENTER
                    );

                    labelStatus.setHorizontalAlignment(
                        SwingConstants.CENTER
                    );


           add(new JLabel("Nome do Estagiário:"));
           add(campoNome);
           add(botaoEntrada);
           add(botaoSaida);
           add(botaoTicket);
           add(botaoHistorico);
           add(labelEntrada);
           add(labelSaida);
           add(labelTickets);
           add(labelProdutividade);
           add(labelStatus);

           botaoEntrada.addActionListener(e -> registrarEntrada());
           botaoSaida.addActionListener(e -> registrarSaida());
           botaoTicket.addActionListener(e -> adicionarTicket());
           botaoHistorico.addActionListener(e -> abrirHistorico());

                    ((JPanel)getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(
                    15,
                    15,
                    15,
                    15
                )
            );
           
           setVisible(true);

                

           
        }

    private void abrirHistorico() {
        TelaRelatorio tela = new TelaRelatorio(listaHistorico);
        tela.setVisible(true);
    }


    private void registrarEntrada() {
        String nome = campoNome.getText();
        estagiario = new Estagiario(nome);
        service.registrarEntrada(estagiario);


        listaHistorico.add(estagiario);

        botaoTicket.setEnabled(true);
        labelEntrada.setText("Entrada: " + estagiario.getHorarioEntrada());
    }

    private void registrarSaida() {
        if (estagiario != null) {
            service.registrarSaida(estagiario);
            labelSaida.setText("Saída: " + estagiario.getHorarioSaida());
            botaoTicket.setEnabled(false);
        }
    }

    private void adicionarTicket() {
        if (estagiario != null) {
            service.adicionarTicket(estagiario);
            labelTickets.setText("Tickets: " + estagiario.getTickets());
            labelProdutividade.setText("Produtividade: " + String.format("%.2f", estagiario.getProdutividade()) + "%");
        }
    }
}
    
        