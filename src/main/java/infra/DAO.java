package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// Logar
		}
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public DAO() {
		this(null);
	}

	// Abrir Transação
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}

	// Fechar Transação
	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	// Incluir Entidade
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	// Incluir Atômico/Completo (Inclusão com transação - Abertura e Fechamento)
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}

	// Obter por ID
	public E obterPorId(Object id) {
		return em.find(classe, id);
	}

	// Obter todos sempre limitado a 10
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}

	// Obter todos (Consulta com limit e deslocamento)
	public List<E> obterTodos(int qtde, int deslocamente) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula!!");
		}

		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);

		query.setMaxResults(qtde);
		query.setFirstResult(deslocamente);
		return query.getResultList();
	}

	// Fechar conexão
	public void fechar() {
		em.close();
	}

	public List<E> consultar(String nomeConsulta, Object... params) {
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
}
