package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {

		Produto produto = new Produto("Caneta", 0.99);
		DAO<Produto> dao = new DAO<>(Produto.class);

		dao.abrirT().incluir(produto).fecharT().fechar();

		System.out.println("\n\nID Produto: " + produto.getId());
	}

}
