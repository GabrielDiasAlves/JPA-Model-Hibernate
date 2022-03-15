package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); //Responsável por criar o EntityManager
		EntityManager em = emf.createEntityManager();  //Encapsular as conexões
		
		Usuario novoUsuario = new Usuario("Guilherme", "guilherme@gmail.com");
		
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println("\nO ID gerado foi: "+ novoUsuario.getId());
		
		em.close();
		emf.close();
	}

}
