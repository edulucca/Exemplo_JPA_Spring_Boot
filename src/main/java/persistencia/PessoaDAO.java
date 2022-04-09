package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class PessoaDAO {
	private EntityManagerFactory emf = null;
	
	public PessoaDAO() {
		
	}
	
	private EntityManager iniciarEntity() {
		this.emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		return emf.createEntityManager();
	}
	
	public void createTable(Pessoa p) {
		EntityManager em = this.iniciarEntity();
		//Inicia transação
		em.getTransaction().begin();
		// faz a persistencia
		em.persist(p);
		//commit transação
		em.getTransaction().commit();
		//Fecha o entity
		em.close();
		
		this.emf.close();
	}
	
	public Pessoa selectPessoa(Pessoa p) {
		EntityManager em = this.iniciarEntity();
		
		p = em.find(Pessoa.class, p.getId());
		
		em.close();
		
		this.emf.close();
		
		return p;
	}
	
	public void deletePessoa(Pessoa p) {
		EntityManager em = this.iniciarEntity();
		
		Pessoa pessoa = em.find(Pessoa.class, p.getId());
		
		em.getTransaction().begin();
		
		em.remove(pessoa);
		
		em.getTransaction().commit();
		
		em.close();
		
		this.emf.close();
	}
}
