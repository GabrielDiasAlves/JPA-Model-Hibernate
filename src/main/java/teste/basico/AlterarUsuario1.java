package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); // Respons�vel por criar o EntityManager
		EntityManager em = emf.createEntityManager(); // Encapsular as conex�es
		
		em.getTransaction().begin();
		
		Usuario usu = em.find(Usuario.class, 1L);
		usu.setNome("Gabriel Dias");
		usu.setEmail("gabrielDias@gmail.com");
		
		em.merge(usu); //Respons�vel por fazer o update
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
