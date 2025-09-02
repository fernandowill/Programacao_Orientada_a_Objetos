import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Combo extends ItemDoCardapio {
    private final List<ItemDoCardapio> itensCombo;

    public Combo(String nome, List<ItemDoCardapio> itensCombo) {
        super(nome, "Combinações", 0.0);
        this.itensCombo = itensCombo;
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (ItemDoCardapio item : itensCombo) {
            total += item.getValor();
        }
        total = total * 0.9;
        return total;
    }

    public List<ItemDoCardapio> getItensDoCombo() {
        // Retorna uma lista não modificável para proteger a lista interna do combo.
        return Collections.unmodifiableList(this.itensCombo);
    }

    public List<ItemDoCardapio> getItensCombo() {
        return itensCombo;
    }

    public String getNome() {
        return nome;
    }

}
