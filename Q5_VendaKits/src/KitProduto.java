import java.util.ArrayList;
import java.util.List;

public class KitProduto extends Produto {
    private List<Produto> itensKit = new ArrayList<>();
    private double desconto;

    public KitProduto(int id, String nome, double desconto) {
        super(id, nome);
        this.desconto = desconto;
    }

    public void adicionar(Produto p) {
        itensKit.add(p);
    }

    @Override
    public double getPreco() {
        double total = 0;
        for(int i = 0; i< itensKit.size(); i ++) {
            total = total + itensKit.get(1).getPreco();
        }
        return total * (1 - desconto);
    }
}