package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import dao.PessoaDao;
import entidade.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaController implements Serializable{

	private static final long serialVersionUID = 1971638693799680582L;
	
	private Pessoa pessoa;
	private PessoaDao pessoaDao;
	
	@PostConstruct
	public void init(){
		if(pessoa == null){
			pessoa = new Pessoa();
		}
		if(pessoaDao == null){
			pessoaDao = new PessoaDao();
			
		}
	}
	
	public String logar(){
		try{
			if(pessoaDao.buscarPorLoginESenha(this.pessoa.getLogin(), this.pessoa.getSenha())!= null){
				return "principal.xhtml?faces-redirect=true";
			}
		}catch(Exception ex){
			exibirMessagem("Login ou senha inválidos!", null);
		}
		return null;
	}
	
	public boolean salvar(){
		if(pessoaDao.salvar(this.pessoa)){
			return true;
		}  
		return false;
	}
	
	public void exibirMessagem(String header, String mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, header, mensagem);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
	
}
