import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Cardapio {
    private final List<ItemDoCardapio> itensDisponiveis;
    public Cardapio() {
        this.itensDisponiveis = new ArrayList<>();
        inicializarCardapio();
    }
    private void inicializarCardapio() {


        // --- HAMBÚRGUERES ---
        itensDisponiveis.add(new Hamburguer("Cheeseburger Simples", "Pão, carne e queijo.", 18.00));
        itensDisponiveis.add(new Hamburguer("X-Bacon", "Pão, carne, queijo e bacon.", 22.00));
        itensDisponiveis.add(new Hamburguer("Duplo Monstro", "Dois hambúrgueres, queijo duplo, alface e tomate.", 28.00));
        itensDisponiveis.add(new Hamburguer("Frango Grelhado", "Pão, filé de frango grelhado e salada.", 20.00));

        // --- BEBIDAS ---
        itensDisponiveis.add(new Bebida("Refrigerante", "Lata 350ml", 5.00, 350));
        itensDisponiveis.add(new Bebida("Suco Natural", "Laranja 500ml", 8.00, 500));
        itensDisponiveis.add(new Bebida("Água Mineral", "Garrafa 500ml", 3.00, 500));

        // --- COMBOS ---
        ItemDoCardapio xbacon = itensDisponiveis.get(1);
        ItemDoCardapio monstro = itensDisponiveis.get(2);
        ItemDoCardapio refri = itensDisponiveis.get(4);
        Combo comboSolteirao = new Combo("Combo solteirao(X-bacon + Refri)", Arrays.asList(xbacon, refri));
        itensDisponiveis.add(comboSolteirao);
        Combo comboMataFome  =  new Combo("Combo mata fome", Arrays.asList(monstro, refri));
        itensDisponiveis.add(comboMataFome);
    }

    public List<ItemDoCardapio> getItensDisponiveis() {
        return itensDisponiveis;
    }
    public void printarHamburgueres() {
        int i=0;
        for (ItemDoCardapio itensDisponivei : itensDisponiveis) {
            if (itensDisponivei instanceof Hamburguer) {
                i++;
                System.out.print(i+":"+ itensDisponivei.getNome());
                System.out.print(", ");
                System.out.println(itensDisponivei.getValor()+" R$");
            }
        }
    }
    public void printarBebidas() {
        int i=0;
        for (ItemDoCardapio itensDisponivei : itensDisponiveis) {
            if (itensDisponivei instanceof Bebida) {
                i++;
                System.out.print(i+":"+ itensDisponivei.getNome());
                System.out.print(", ");
                System.out.println(itensDisponivei.getValor()+" R$");
            }
        }
    }

    public void printarCombos() {
        int i=0;
        for (ItemDoCardapio itensDisponiveis : itensDisponiveis) {
            if (itensDisponiveis instanceof Combo combo) {
                i++;
                System.out.print(i+":"+ combo.getNome()+", ");
                System.out.println(combo.calcularTotal()+" R$");
            }
        }
    }
}
