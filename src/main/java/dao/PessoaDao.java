package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entidade.Pessoa;

public class PessoaDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo-maven");
	EntityManager manager = emf.createEntityManager();
	
	public boolean salvar(Pessoa pessoa){
		try{
			manager.getTransaction().begin();
			manager.persist(pessoa);
			manager.close();
			return true;
		}catch(PersistenceException ex){
			manager.close();
			ex.printStackTrace();
			return false;
		}
	}
	
	public Pessoa buscarPorLoginESenha(String login, String senha) throws Exception{
		Pessoa pessoa = null;
		String query = "SELECT p FROM Pessoa p WHERE p.login = :login and p.senha = :senha";
		
        Query q = manager.createQuery(query);
        q.setParameter("login", login);
        q.setParameter("senha", senha);
	
		manager.getTransaction().begin();
		pessoa = (Pessoa) q.getSingleResult();
		manager.close();
		return pessoa;
	}
}
