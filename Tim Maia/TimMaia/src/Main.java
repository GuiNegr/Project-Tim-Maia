import Controler.ConexaoDAO;
import Controler.ReadDAO;
import VIEW.GUI;

public class Main {
    public static void main(String[] args) {
        new GUI();
        new ReadDAO().padrao();
        new ConexaoDAO().conectaBd();
    }
}