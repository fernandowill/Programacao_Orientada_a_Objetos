import javax.swing.*;

public class Hamburguer extends ItemDoCardapio{
    private final double precoPorAdicional = 1.50;
    private double precoTotal;

    public Hamburguer(String nome,String descricao, double precoBase) {
        super(nome,descricao,precoBase);
        precoTotal = calcularTotal();
    }


    @Override
    public double calcularTotal() {
        return 0;
    }


    public double getPrecoPorAdicional() {
        return precoPorAdicional;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

}
