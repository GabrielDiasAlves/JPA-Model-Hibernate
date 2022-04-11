package teste.consulta;

import java.util.List;
import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class ObterFilmes {
	
	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.5);
		
		System.out.println("Quantidade de filmes: "+filmes.size());
		
		for(Filme filme: filmes) {
			System.out.print("\n>  Filme: ");
			System.out.println(filme.getNome() +" | Nota: "+filme.getNota());
			
			for(Ator ator: filme.getAtores()) {
				System.out.println(" - "+ator.getNome());
			}
		}
	}

}
