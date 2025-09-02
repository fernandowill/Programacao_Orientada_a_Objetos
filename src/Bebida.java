public class Bebida extends ItemDoCardapio{
    private final int ml;
    private double precototal;
    public Bebida(String nome, String descricao, double valor,int ml) {
        super(nome,descricao,valor);
        this.ml = ml;
        precototal = calcularTotal();
    }

    @Override
    public double calcularTotal() {
        return ml * 0.8;
    }

    public int getMl() {
        return ml;
    }

    public double getPrecototal() {
        return precototal;
    }

    public void setPrecototal(double precototal) {
        this.precototal = precototal;
    }
}
