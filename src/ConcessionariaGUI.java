import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConcessionariaGUI {

    private JPanel cards;
    private CardLayout cardLayout;
    private DefaultTableModel carroTableModel;
    private DefaultTableModel motoTableModel;

    private JTable carroTable;
    private JTable motoTable;

    private List<Carro> carros;
    private List<Moto> motos;
    private int proximoId = 1;

    // Declara os campos numPortasField e cilindradaField fora do método criarFormulario
    private JTextField numPortasField;
    private JTextField cilindradaField;

    public ConcessionariaGUI() {
        JFrame frame = new JFrame("Concessionária de Veículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        frame.add(cards);

        JButton carroButton = new JButton("Carro");
        JButton motoButton = new JButton("Moto");

        carroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "CARRO");
            }
        });

        motoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "MOTO");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(carroButton);
        buttonPanel.add(motoButton);

        JPanel carroPanel = criarFormulario("CARRO");
        JPanel motoPanel = criarFormulario("MOTO");

        cards.add(carroPanel, "CARRO");
        cards.add(motoPanel, "MOTO");

        carroTableModel = new DefaultTableModel(new Object[]{"ID", "Marca", "Modelo", "Ano", "Preço", "Cor", "Quantidade", "Número de Portas"}, 0);
        carroTable = new JTable(carroTableModel);
        JScrollPane carroTableScrollPane = new JScrollPane(carroTable);

        motoTableModel = new DefaultTableModel(new Object[]{"ID", "Marca", "Modelo", "Ano", "Preço", "Cor", "Quantidade", "Cilindrada"}, 0);
        motoTable = new JTable(motoTableModel);
        JScrollPane motoTableScrollPane = new JScrollPane(motoTable);

        frame.add(carroTableScrollPane, BorderLayout.SOUTH);
        frame.add(motoTableScrollPane, BorderLayout.SOUTH);

        carros = new ArrayList<>();
        motos = new ArrayList<>();

        frame.setVisible(true);
    }

    private JPanel criarFormulario(String veiculo) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Cadastro de " + veiculo));

        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaField = new JTextField(20);
        JLabel modeloLabel = new JLabel("Modelo:");
        JTextField modeloField = new JTextField(20);
        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField(10);
        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField(10);
        JLabel corLabel = new JLabel("Cor:");
        JTextField corField = new JTextField(20);
        JLabel qtdeLabel = new JLabel("Quantidade:");
        JTextField qtdeField = new JTextField(10);

        if (veiculo.equals("CARRO")) {
            JLabel numPortasLabel = new JLabel("Número de Portas:");
            numPortasField = new JTextField(10);
            panel.add(numPortasLabel);
            panel.add(numPortasField);
        } else if (veiculo.equals("MOTO")) {
            JLabel cilindradaLabel = new JLabel("Cilindrada:");
            cilindradaField = new JTextField(10);
            panel.add(cilindradaLabel);
            panel.add(cilindradaField);
        }

        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                int ano = Integer.parseInt(anoField.getText());
                double preco = Double.parseDouble(precoField.getText());
                String cor = corField.getText();
                int qtde = Integer.parseInt(qtdeField.getText());

                if (veiculo.equals("CARRO")) {
                    int numeroPortas = Integer.parseInt(numPortasField.getText());
                    Carro novoCarro = new Carro(proximoId, marca, modelo, ano, preco, numeroPortas, cor, qtde);
                    carros.add(novoCarro);
                    carroTableModel.addRow(new Object[]{proximoId, marca, modelo, ano, preco, cor, qtde, numeroPortas});
                } else if (veiculo.equals("MOTO")) {
                    int cilindrada = Integer.parseInt(cilindradaField.getText());
                    Moto novaMoto = new Moto(proximoId, marca, modelo, ano, preco, cilindrada, cor, qtde);
                    motos.add(novaMoto);
                    motoTableModel.addRow(new Object[]{proximoId, marca, modelo, ano, preco, cor, qtde, cilindrada});
                }

                marcaField.setText("");
                modeloField.setText("");
                anoField.setText("");
                precoField.setText("");
                corField.setText("");
                qtdeField.setText("");

                proximoId++;
            }
        });

        panel.add(marcaLabel);
        panel.add(marcaField);
        panel.add(modeloLabel);
        panel.add(modeloField);
        panel.add(anoLabel);
        panel.add(anoField);
        panel.add(precoLabel);
        panel.add(precoField);
        panel.add(corLabel);
        panel.add(corField);
        panel.add(qtdeLabel);
        panel.add(qtdeField);
        panel.add(adicionarButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConcessionariaGUI();
            }
        });
    }
}
