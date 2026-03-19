public class ProdutoUnitario extends Produto {
    private double preco;

    public ProdutoUnitario(int id, String nome, double preco) {
        super(id, nome);
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}