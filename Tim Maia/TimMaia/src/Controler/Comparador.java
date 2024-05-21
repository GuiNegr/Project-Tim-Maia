package Controler;
import Model.Produto;

import java.util.Comparator;
public class Comparador {

    public static Comparator<Produto> byVal(){
        return new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return o1.getValidade_produto().compareTo(o2.getValidade_produto());
            }
        };
    }

    public static Comparator<Produto> byTipo(){
        return new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                return o1.getTipo_produto().compareTo(o2.getTipo_produto());
            }
        };
    }

    public static Comparator<Produto> byQtd(){
        return new Comparator<Produto>() {
            @Override
            public int compare(Produto o1, Produto o2) {
                int o1int = Integer.parseInt(o1.getQtd_produto());
                int o2int = Integer.parseInt(o2.getQtd_produto());
                return Integer.compare(o1int, o2int);
            }
        };
    }
}
