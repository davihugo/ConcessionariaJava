import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConcessionariaGUI extends JFrame {
    private List<Veiculo> veiculos;
    private DefaultTableModel modeloTabelaCarros;
    private DefaultTableModel modeloTabelaMotos;
    private JTable tabelaCarros;
    private JTable tabelaMotos;

    public ConcessionariaGUI() {
        veiculos = new ArrayList<>();
        
        setTitle("Sistema de Concessionária");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Carros", criarPainelCarros());
        abas.addTab("Motos", criarPainelMotos());

        add(abas);
    }

    private JPanel criarPainelCarros() {
        JPanel painel = new JPanel(new BorderLayout());
        

        JPanel painelEntrada = new JPanel(new GridLayout(6, 2, 5, 5));
        
        JTextField campoMarca = new JTextField();
        JTextField campoModelo = new JTextField();
        JTextField campoAno = new JTextField();
        JTextField campoPreco = new JTextField();
        JTextField campoPortas = new JTextField();
        
        painelEntrada.add(new JLabel("Marca:"));
        painelEntrada.add(campoMarca);
        painelEntrada.add(new JLabel("Modelo:"));
        painelEntrada.add(campoModelo);
        painelEntrada.add(new JLabel("Ano:"));
        painelEntrada.add(campoAno);
        painelEntrada.add(new JLabel("Preço:"));
        painelEntrada.add(campoPreco);
        painelEntrada.add(new JLabel("Número de Portas:"));
        painelEntrada.add(campoPortas);

        String[] colunas = {"Marca", "Modelo", "Ano", "Preço", "Portas"};
        modeloTabelaCarros = new DefaultTableModel(colunas, 0);
        tabelaCarros = new JTable(modeloTabelaCarros);
        JScrollPane scrollPane = new JScrollPane(tabelaCarros);

        JPanel painelBotoes = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnLimpar = new JButton("Limpar Campos");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        btnAdicionar.addActionListener(e -> {
            try {
                Carro carro = new Carro(
                    campoMarca.getText(),
                    campoModelo.getText(),
                    Integer.parseInt(campoAno.getText()),
                    Double.parseDouble(campoPreco.getText()),
                    Integer.parseInt(campoPortas.getText())
                );
                veiculos.add(carro);
                atualizarTabelaCarros();
                limparCampos(campoMarca, campoModelo, campoAno, campoPreco, campoPortas);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
            }
        });

        btnEditar.addActionListener(e -> {
            int linha = tabelaCarros.getSelectedRow();
            if (linha >= 0) {
                try {
                    Carro carro = new Carro(
                        campoMarca.getText(),
                        campoModelo.getText(),
                        Integer.parseInt(campoAno.getText()),
                        Double.parseDouble(campoPreco.getText()),
                        Integer.parseInt(campoPortas.getText())
                    );
                    veiculos.set(linha, carro);
                    atualizarTabelaCarros();
                    limparCampos(campoMarca, campoModelo, campoAno, campoPreco, campoPortas);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
                }
            }
        });

        btnExcluir.addActionListener(e -> {
            int linha = tabelaCarros.getSelectedRow();
            if (linha >= 0) {
                veiculos.remove(linha);
                atualizarTabelaCarros();
            }
        });

        btnLimpar.addActionListener(e -> {
            limparCampos(campoMarca, campoModelo, campoAno, campoPreco, campoPortas);
        });

        painel.add(painelEntrada, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarPainelMotos() {
        JPanel painel = new JPanel(new BorderLayout());
        
        JPanel painelEntrada = new JPanel(new GridLayout(6, 2, 5, 5));
        
        JTextField campoMarca = new JTextField();
        JTextField campoModelo = new JTextField();
        JTextField campoAno = new JTextField();
        JTextField campoPreco = new JTextField();
        JTextField campoCilindradas = new JTextField();
        
        painelEntrada.add(new JLabel("Marca:"));
        painelEntrada.add(campoMarca);
        painelEntrada.add(new JLabel("Modelo:"));
        painelEntrada.add(campoModelo);
        painelEntrada.add(new JLabel("Ano:"));
        painelEntrada.add(campoAno);
        painelEntrada.add(new JLabel("Preço:"));
        painelEntrada.add(campoPreco);
        painelEntrada.add(new JLabel("Cilindradas:"));
        painelEntrada.add(campoCilindradas);

        String[] colunas = {"Marca", "Modelo", "Ano", "Preço", "Cilindradas"};
        modeloTabelaMotos = new DefaultTableModel(colunas, 0);
        tabelaMotos = new JTable(modeloTabelaMotos);
        JScrollPane scrollPane = new JScrollPane(tabelaMotos);

        JPanel painelBotoes = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnLimpar = new JButton("Limpar Campos");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        btnAdicionar.addActionListener(e -> {
            try {
                Moto moto = new Moto(
                    campoMarca.getText(),
                    campoModelo.getText(),
                    Integer.parseInt(campoAno.getText()),
                    Double.parseDouble(campoPreco.getText()),
                    Integer.parseInt(campoCilindradas.getText())
                );
                veiculos.add(moto);
                atualizarTabelaMotos();
                limparCampos(campoMarca, campoModelo, campoAno, campoPreco, campoCilindradas);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
            }
        });

        btnEditar.addActionListener(e -> {
            int linha = tabelaMotos.getSelectedRow();
            if (linha >= 0) {
                try {
                    Moto moto = new Moto(
                        campoMarca.getText(),
                        campoModelo.getText(),
                        Integer.parseInt(campoAno.getText()),
                        Double.parseDouble(campoPreco.getText()),
                        Integer.parseInt(campoCilindradas.getText())
                    );
                    veiculos.set(linha, moto);
                    atualizarTabelaMotos();
                    limparCampos(campoMarca, campoModelo, campoAno, campoPreco, campoCilindradas);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
                }
            }
        });

        btnExcluir.addActionListener(e -> {
            int linha = tabelaMotos.getSelectedRow();
            if (linha >= 0) {
                veiculos.remove(linha);
                atualizarTabelaMotos();
            }
        });

        btnLimpar.addActionListener(e -> {
            limparCampos(campoMarca, campoModelo, campoAno, campoPreco, campoCilindradas);
        });

        painel.add(painelEntrada, BorderLayout.NORTH);
        painel.add(scrollPane, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        return painel;
    }

    private void atualizarTabelaCarros() {
        modeloTabelaCarros.setRowCount(0);
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro) {
                Carro carro = (Carro) veiculo;
                modeloTabelaCarros.addRow(new Object[]{
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getAno(),
                    carro.getPreco(),
                    carro.getNumPortas()
                });
            }
        }
    }

    private void atualizarTabelaMotos() {
        modeloTabelaMotos.setRowCount(0);
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Moto) {
                Moto moto = (Moto) veiculo;
                modeloTabelaMotos.addRow(new Object[]{
                    moto.getMarca(),
                    moto.getModelo(),
                    moto.getAno(),
                    moto.getPreco(),
                    moto.getCilindradas()
                });
            }
        }
    }

    private void limparCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConcessionariaGUI().setVisible(true);
        });
    }
}
