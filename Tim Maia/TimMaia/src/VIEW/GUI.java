package VIEW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Controler.CreateDao;
import Controler.DeleteDao;
import Controler.ReadDAO;
import Controler.UpdateDAO;
import Model.Produto;

public class GUI extends JFrame implements ActionListener {

    private JTable table;
    private JPanel tablePanel;
    private JPanel btnPainel;
    private JButton create;
    private JButton delete;
    private JButton selectByVal;
    private JButton selectByType;
    private JButton update;
    private JButton selectByQtd;
    private JButton defaultSelect;

    public GUI() {
        setTitle("TIM MAIA PROJECT");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        selectByQtd = botao("SLC/QUANTIDADE");
        selectByType = botao("SLC/TIPO");
        selectByVal = botao("SLC/VALIDADE");
        delete = botao("EXCLUIR");
        create = botao("ADICIONE");
        update = botao("ATUALIZAR");
        defaultSelect = botao("PADRÃO");

        btnPainel = painel();
        btnPainel.setLayout(new GridLayout(1, 6));
        btnPainel.add(create);
        btnPainel.add(delete);
        btnPainel.add(update);
        btnPainel.add(selectByQtd);
        btnPainel.add(selectByVal);
        btnPainel.add(selectByType);
        btnPainel.add(defaultSelect);

        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        table = tabela();
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);


        read();
        add(tablePanel, BorderLayout.CENTER);
        add(btnPainel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public JTable tabela() {
        String[] columnNames = {"ID", "Nome", "Tipo", "Validade", "Quantidade"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable tabela = new JTable(model);
        tabela.setFillsViewportHeight(true);
        return tabela;
    }

    public JButton botao(String text) {
        JButton botao = new JButton();
        botao.setText(text);
        botao.addActionListener(this);
        botao.setBackground(new Color(139, 114, 236, 255));
        botao.setForeground(new Color(231, 201, 144));
        botao.setFont(new Font("arial", Font.BOLD, 14));
        add(botao);
        return botao;
    }

    public JPanel painel() {
        JPanel painel = new JPanel();
        add(painel);
        return painel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            String nome = JOptionPane.showInputDialog("informe o nome do produto");
            Date valdiade = obterDataValidade();
            String tipo = obterTipoProduto();
            String quantidade = JOptionPane.showInputDialog("informe a quantiade");
            Produto produto = new Produto(nome, valdiade, tipo, quantidade);
            new CreateDao().create(produto);
            read();
        }
        if (e.getSource() == delete) {
            String id = JOptionPane.showInputDialog("POR FAVOR ME INFORME O ID DO PRODUTO DESEJADO");
            new DeleteDao().delete(id);
            read();
        }
        if (e.getSource() == selectByQtd) {
            readByqtd();
        }
        if (e.getSource() == selectByVal) {
            readByVal();
        }
        if (e.getSource() == selectByType) {
            readByTipo();
        }
        if (e.getSource() == update) {
            String id = JOptionPane.showInputDialog("Informe o id do produto cadastrado");
            escolhas(id);

        }
        if(e.getSource() == defaultSelect){
            read();
        }

    }

    private Date obterDataValidade() {
        String dataString = JOptionPane.showInputDialog("Informe a validade (dd-MM-yyyy):");
        if (dataString != null && !dataString.trim().isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try {
                java.util.Date utilDate = dateFormat.parse(dataString);
                return new Date(utilDate.getTime());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Por favor, use o formato yyyy-MM-dd.");
            }
        }
        return null;
    }

    private String obterTipoProduto() {
        String[] tipos = {"CARNE", "GRAO", "VEGETAL", "INDUSTRIAL"};
        String tipo = (String) JOptionPane.showInputDialog(
                null,
                "Informe o tipo do produto:",
                "Tipo do Produto",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
        );
        return tipo;
    }

    public int opcao() {
        String[] opções = {"Nome do produto", "tipo do produto", "validade do produto", "quantidade do produto", "todo o produto"};
        Object opcao = JOptionPane.showInputDialog(null, "ESCOLHA QUE PRODUTO ALTERAR", "CAIXA DE ESCOLHAS",
                JOptionPane.DEFAULT_OPTION, null, opções, opções[0]
        );

        if (opcao != null) {
            for (int i = 0; i < opções.length; i++) {
                if (opcao.equals(opções[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void escolhas(String id) {
        int opcoes = opcao();
        if (opcoes == 0) {
            String nome = JOptionPane.showInputDialog("informe o novo nome do produto");
            new UpdateDAO().updateNome(nome, id);
        } else if (opcoes == 1) {
            String tipo = obterTipoProduto();
            new UpdateDAO().updateTipo(tipo, id);
        } else if (opcoes == 2) {
            Date validade = obterDataValidade();
            new UpdateDAO().updateValidade(validade, id);
        } else if (opcoes == 3) {
            String qtd = JOptionPane.showInputDialog("Informe a quantidade do produto");
            new UpdateDAO().updateQtd(qtd, id);
        } else if (opcoes == 4) {
            String nome = JOptionPane.showInputDialog("informe o nome do produto");
            Date valdiade = obterDataValidade();
            String tipo = obterTipoProduto();
            String quantidade = JOptionPane.showInputDialog("informe a quantiade");
            Produto produto = new Produto(nome, valdiade, tipo, quantidade);
            new UpdateDAO().update(produto, id);
        }
        read();
    }

    private void read() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);

            ArrayList<Produto> lista = new ReadDAO().padrao();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                        lista.get(i).getId(),
                        lista.get(i).getNome_produto(),
                        lista.get(i).getTipo_produto(),
                        lista.get(i).getValidade_produto(),
                        lista.get(i).getQtd_produto()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error view listagem: " + e.getMessage());
        }


    }

    private void readByqtd() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);

            ArrayList<Produto> lista = new ReadDAO().byQtd();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                        lista.get(i).getId(),
                        lista.get(i).getNome_produto(),
                        lista.get(i).getTipo_produto(),
                        lista.get(i).getValidade_produto(),
                        lista.get(i).getQtd_produto()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error view listagem: " + e.getMessage());
        }
    }

    private void readByVal() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);

            ArrayList<Produto> lista = new ReadDAO().byVal();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                        lista.get(i).getId(),
                        lista.get(i).getNome_produto(),
                        lista.get(i).getTipo_produto(),
                        lista.get(i).getValidade_produto(),
                        lista.get(i).getQtd_produto()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error view listagem: " + e.getMessage());
        }
    }

    private void readByTipo() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setNumRows(0);

            ArrayList<Produto> lista = new ReadDAO().byTipo();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                        lista.get(i).getId(),
                        lista.get(i).getNome_produto(),
                        lista.get(i).getTipo_produto(),
                        lista.get(i).getValidade_produto(),
                        lista.get(i).getQtd_produto()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error view listagem: " + e.getMessage());
        }
    }
}

