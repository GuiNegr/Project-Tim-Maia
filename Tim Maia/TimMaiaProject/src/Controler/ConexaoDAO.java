package Controler;
import Model.Produto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    public Connection conectaBd(){
        Connection conexao = null;

        try{
            String url = "jdbc:mysql://localhost:3306/tim_maia?user=root&password=root";
            conexao = DriverManager.getConnection(url);
            System.out.println("conexao bem sucedida");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"erro na ConexaoDao: "+e.getMessage());
        }
    return conexao;
    }
}
