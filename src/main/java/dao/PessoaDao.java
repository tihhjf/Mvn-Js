package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Pessoa;
import helper.JPAHelper;

public class PessoaDao extends GenericDao<Pessoa, Long>{

	public PessoaDao(){
		super(Pessoa.class);
	}

	public Pessoa buscarPorLoginESenha(String login, String senha) throws Exception {
		Pessoa pessoa = null;
		String query = "SELECT p FROM Pessoa p WHERE p.login = :login and p.senha = :senha";
		EntityManager manager = JPAHelper.getEntityManager();
		Query q = manager.createQuery(query);
		q.setParameter("login", login);
		q.setParameter("senha", senha);

		manager.getTransaction().begin();
		pessoa = (Pessoa) q.getSingleResult();
		manager.close();
		return pessoa;
	}
}
