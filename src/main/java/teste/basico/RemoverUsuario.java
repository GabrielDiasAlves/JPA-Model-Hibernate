package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {
	
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); //Respons�vel por criar o EntityManager
		EntityManager em = emf.createEntityManager(); //Encapsular as conex�es
		
		Usuario usuario = em.find(Usuario.class, 8L);
		
		if(usuario != null) {
			System.out.println("O usu�rio: "+ usuario.getNome() +" - C�d: "+usuario.getId() +". Ser� removido da base!");
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
}
