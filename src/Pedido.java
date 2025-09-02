import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemDoCardapio> itensDoPedido;
    private static int contadorDePedidos = 0;
    private final int id;
    Status status;
    Cliente cliente;
    private double precoTotal;

    public Pedido(Cliente cliente) {
        this.itensDoPedido = new ArrayList<>();
        this.cliente = cliente;
        contadorDePedidos++;
        this.id = contadorDePedidos;
    }

    private double calcularPrecoTotal() {
        for (ItemDoCardapio itemDoCardapio : itensDoPedido) {
            precoTotal += itemDoCardapio.calcularTotal();
        }
        return precoTotal;
    }

    public void pedidoPronto() {
        System.out.println("-------------------------");
        System.out.println("Pedido nº" + this.id + "pronto");
        System.out.println("-------------------------");
    }

    public void adicionarItem(ItemDoCardapio item) {
        this.itensDoPedido.add(item);
    }

    public void removerItem(ItemDoCardapio item) {
        this.itensDoPedido.remove(item);
    }

    public void printarPedido() {
        for (ItemDoCardapio item : itensDoPedido) {
            System.out.println(item);
        }
        System.out.println();
    }

    public void informacoesPedido() {
        System.out.println("------------------------");
        System.out.println(cliente);
        for (ItemDoCardapio item : itensDoPedido) {
            System.out.println(item);
        }
        precoTotal = calcularPrecoTotal();
        System.out.println("Preco Total: " + precoTotal);
    }
}