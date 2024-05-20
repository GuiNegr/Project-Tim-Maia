package Controler;

import Model.Produto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {
    public void update(Produto produto,String id){
        String sql = "UPDATE PRODUTOS SET NOME_PRODUTO = ?, TIPO_PRODUTO = ?, VALIDAE_PRODUTO = ?, QUANTIDADE_PRODUTO = ? WHERE ID_PRODUTO = ?";
        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome_produto());
            preparedStatement.setString(2, produto.getTipo_produto());
            preparedStatement.setDate(3,produto.getValidade_produto());
            preparedStatement.setString(4, produto.getQtd_produto());
            preparedStatement.setString(5,id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"PRODUTO ATUALIZADO COM SUCESSO");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UDPATE: "+e.getMessage());
        }
    }

    public void updateNome(String nome,String id){
        String sql = "UPDATE PRODUTOS SET NOME_PRODUTO = ? WHERE ID_PRODUTO = ?";
        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nome);
            preparedStatement.setString(2,id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"PRODUTO ATUALIZADO COM SUCESSO");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UDPATE: "+e.getMessage());
        }
    }

    public void updateTipo(String tipo,String id){
        String sql = "UPDATE PRODUTOS SET TIPO_PRODUTO = ? WHERE ID_PRODUTO = ?";
        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tipo);
            preparedStatement.setString(2,id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"PRODUTO ATUALIZADO COM SUCESSO");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UDPATE: "+e.getMessage());
        }
    }

    public void updateValidade(Date validade, String id){
        String sql = "UPDATE PRODUTOS SET VALIDAE_PRODUTO = ? WHERE ID_PRODUTO = ?";
        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1,validade);
            preparedStatement.setString(2,id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"PRODUTO ATUALIZADO COM SUCESSO");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UDPATE: "+e.getMessage());
        }
    }

    public void updateQtd(String quantidade, String id){
        String sql = "UPDATE PRODUTOS SET quantidade_produto = ? WHERE ID_PRODUTO = ?";
        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,quantidade);
            preparedStatement.setString(2,id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null,"PRODUTO ATUALIZADO COM SUCESSO");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR UDPATE: "+e.getMessage());
        }
    }

}
