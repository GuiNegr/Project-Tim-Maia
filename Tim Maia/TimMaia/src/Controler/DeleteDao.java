package Controler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
    public void delete(String id){
        String sql = "DELETE FROM PRODUTOS WHERE ID_PRODUTO = ?";

        try{
            Connection connection = new ConexaoDAO().conectaBd();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.execute();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro no delete: "+e.getMessage());

        }
    }
}
