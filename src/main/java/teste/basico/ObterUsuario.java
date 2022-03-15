package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // Respons�vel por criar o EntityManager
		EntityManager em = emf.createEntityManager(); // Encapsular as conex�es
		
		Usuario usuario = em.find(Usuario.class, 1L);
		
		System.out.println("\n"+ usuario.getId() +" - "+ usuario.getNome() +" - "+usuario.getEmail());
		
		em.close();
		emf.close();

	}

}
