package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
	
	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Camara Secreta", 9.8);
		Filme filmeB = new Filme("O Teste", 8.8);
		
		Ator atorA = new Ator("Harry");
		Ator atorB = new Ator("Rony");
		
		filmeA.adicionar(atorA);
		filmeA.adicionar(atorB);
		
		filmeB.adicionar(atorA);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(filmeA);
	}

}
