import Controler.ConexaoDAO;
import VIEW.GUI;

public class Main {
    public static void main(String[] args) {
        new GUI();
        new ConexaoDAO().conectaBd();
    }
}