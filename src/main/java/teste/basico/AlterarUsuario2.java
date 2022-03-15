package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // Responsável por criar o EntityManager
		EntityManager em = emf.createEntityManager(); // Encapsular as conexões
		
		em.getTransaction().begin();
		
		Usuario usu = em.find(Usuario.class, 1L);
		usu.setNome("Gabriel");
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
