import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendasEmMemoria implements VendasFachada{
	private List<Produto> produtos;
	
	public VendasEmMemoria() {
		produtos = new ArrayList<>();

		Produto p1 = new ProdutoUnitario(1, "Caneta", 1.50);
        Produto p2 = new ProdutoUnitario(2, "Caderno", 20.00);

		KitProduto kitEscolar = new KitProduto(3, "Kit Volta às Aulas", 0.15); // 15% desc.
		
		kitEscolar.adicionar(p1);
        kitEscolar.adicionar(p2);
		produtos.add(kitEscolar);


		produtos.add(new ProdutoUnitario(1, "Caneta", 1.55));
		produtos.add(new ProdutoUnitario(2, "Borracha", 1.15));
		produtos.add(new ProdutoUnitario(3, "Caderno", 32.99));
		produtos.add(p1);
        produtos.add(p2);
        
	}
	
	@Override
	public Venda iniciarVenda() {
		return new Venda(LocalDateTime.now());
	}

	@Override
	public void registrarVenda(Venda umaVenda, int codigoProduto, int quantidade) {
		Produto prod = produtos.stream().filter(p -> p.getId() == codigoProduto).findFirst().get();
		umaVenda.registrarVenda(prod, quantidade);
	}

	@Override
	public String emitirComprovante(Venda umaVenda) {
		return umaVenda.emitirComprovante();
	}

	@Override
	public List<Produto> buscarProdutos() {
		return Collections.unmodifiableList(produtos);
	}

}
