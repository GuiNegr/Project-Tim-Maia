package Controler;

import Model.Produto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class ReadDAO {
    public ArrayList<Produto> padrao(){
        String SQL = "SELECT * FROM PRODUTOS";
        try {
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Produto> produtos = new ArrayList<>();
            while (resultSet.next()){
                String id = resultSet.getString("ID_PRODUTO");
                String nome = resultSet.getString("NOME_PRODUTO");
                String tipo = resultSet.getString("TIPO_PRODUTO");
                Date validade = resultSet.getDate("VALIDAE_PRODUTO");
                String qtd = resultSet.getString("QUANTIDADE_PRODUTO");
                Produto produto = new Produto(id,nome,validade,tipo,qtd);
                produtos.add(produto);
            }
            Collections.sort(produtos);
            return produtos;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO NO READ PADRAO: "+e.getMessage());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Produto>byQtd(){
        ArrayList<Produto> produtos = padrao();
        if(produtos != null){
            Collections.sort(produtos, Comparador.byQtd());
        }
        return produtos;
    }

    public ArrayList<Produto>byVal(){
        ArrayList<Produto> produtos = padrao();
        if(produtos != null){
            Collections.sort(produtos, Comparador.byVal());
        }
        return produtos;
    }

    public ArrayList<Produto>byTipo(){
        ArrayList<Produto> produtos = padrao();
        if(produtos != null){
            Collections.sort(produtos, Comparador.byTipo());
        }
        return produtos;
    }
}
