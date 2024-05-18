package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Model.Produto;

public class GUI extends JFrame implements ActionListener {

    private JTable table;
    private JPanel tablePanel;
    private JPanel btnPainel;
    private JButton create;
    private JButton delete;
    private JButton selectByVal;
    private JButton selectByType;
    private JButton selectByQtd;

    public GUI(){
        setTitle("TIM MAIA PROJECT");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        selectByQtd = botao("Select By Qtd");
        selectByType = botao("SELECT BY TYPE");
        selectByVal = botao("SELECT BY VALIDATE");
        delete = botao("delete");
        create = botao("create");

        btnPainel = painel();
        btnPainel.setLayout(new GridLayout(1,5));
        btnPainel.add(create);
        btnPainel.add(delete);
        btnPainel.add(selectByQtd);
        btnPainel.add(selectByVal);
        btnPainel.add(selectByType);

        tablePanel = painel();
        tablePanel.setLayout(new BorderLayout());
        table = tabela();
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);


        add(btnPainel,BorderLayout.SOUTH);
        setVisible(true);
    }

    public JTable tabela(){
        JTable tabela = new JTable();
        tabela.setFillsViewportHeight(true);
        add(tabela);
        return tabela;
    }

    public JButton botao(String text){
        JButton botao = new JButton();
        botao.setText(text);
        botao.addActionListener(this);
        botao.setBackground(new Color(139, 114, 236, 255));
        botao.setForeground(new Color(231, 201, 144));
        add(botao);
        return botao;
    }
    public JPanel painel(){//fornece local para alocar componentes
        JPanel painel = new JPanel();
        add(painel);
        return painel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){
            JOptionPane.showMessageDialog(null,"ESSE É O CREATE");
            String nome = JOptionPane.showInputDialog("informe o nome do produto");
            Date valdiade = obterDataValidade();
            String tipo = obterTipoProduto();
            String quantidade = JOptionPane.showInputDialog("informe a quantiade");
            Produto produto = new Produto(nome,valdiade,tipo,quantidade);
            System.out.println(produto);
        }
        if(e.getSource() == delete){
            JOptionPane.showMessageDialog(null,"ESSE É O DELETE");
        }
        if(e.getSource() == selectByQtd){
            JOptionPane.showMessageDialog(null,"ESSE É O SELECT BY QTD");
        }
        if(e.getSource() == selectByVal){
            JOptionPane.showMessageDialog(null,"ESSE É O SELECT BY VALIDATE");
        }
        if(e.getSource() == selectByType){
            JOptionPane.showMessageDialog(null,"ESSE É O SELECT BY TYPE");
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
}
