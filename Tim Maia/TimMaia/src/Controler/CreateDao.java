package Controler;

import Model.Produto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDao {
    public void create(Produto produto){
        String sql = "insert into produtos (NOME_PRODUTO,TIPO_PRODUTO,VALIDAE_PRODUTO,QUANTIDADE_PRODUTO) values (?,?,?,?)";

        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome_produto());
            preparedStatement.setString(2, produto.getTipo_produto());
            preparedStatement.setDate(3,produto.getValidade_produto());
            preparedStatement.setString(4, produto.getQtd_produto());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"Produto deleteado com sucesso");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro na criação"+e.getMessage());
        }
    }
}
