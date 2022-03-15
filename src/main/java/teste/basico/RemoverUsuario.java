package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {
	
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa"); //Responsável por criar o EntityManager
		EntityManager em = emf.createEntityManager(); //Encapsular as conexões
		
		Usuario usuario = em.find(Usuario.class, 8L);
		
		if(usuario != null) {
			System.out.println("O usuário: "+ usuario.getNome() +" - Cód: "+usuario.getId() +". Será removido da base!");
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
}
