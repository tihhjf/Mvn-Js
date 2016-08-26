package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.PessoaDao;
import entidade.Pessoa;
import helper.MessageHelper;
import helper.SessionHelper;

@ManagedBean
@ViewScoped
public class LoginController implements Serializable{

	private static final String ID = "id";
	private static final long serialVersionUID = -6983839857205389929L;
	private Pessoa pessoa;
	private PessoaDao pessoaDao;

	@PostConstruct
	public void init(){
		iniciarObjetos();
	}

	private void iniciarObjetos() {
		if(pessoa == null){
			pessoa = new Pessoa();
		}
		if(pessoaDao == null){
			pessoaDao = new PessoaDao();
		}
	}
	
	public String logar(){
		try{
			Pessoa pessoaLogin = pessoaDao.buscarPorLoginESenha(this.pessoa.getLogin(), this.pessoa.getSenha());
			if(pessoaLogin != null){
				SessionHelper.login(pessoaLogin);
				return "principal.xhtml?%s=%d&faces-redirect=true";
			}
		}catch(Exception ex){
			MessageHelper.exibirMessagem("Login ou senha inválidos!", null);
		}
		return null;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public static String getId() {
		return ID;
	}
	
}
