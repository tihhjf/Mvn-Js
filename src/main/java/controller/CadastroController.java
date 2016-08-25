package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.PessoaDao;
import entidade.Pessoa;

@ManagedBean
@ViewScoped
public class CadastroController implements Serializable{

	private static final long serialVersionUID = 1971638693799680582L;
	
	private Pessoa pessoa;
	private PessoaDao pessoaDao;
	private List<Pessoa> pessoas;
	
	@PostConstruct
	public void init(){
		if(pessoa == null){
			pessoa = new Pessoa();
		}
		if(pessoaDao == null){
			pessoaDao = new PessoaDao();
		}
		try {
			pessoas = pessoaDao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		if(pessoaDao.salvar(this.pessoa)){
			exibirMessagem("Cadastrado com sucesso!", null);
			this.pessoa = new Pessoa();
			fecharModal();
			return;
		}
		exibirMessagem("Erro ao cadastrar!", null);
	}
	
	public void fecharModal(){
		RequestContext.getCurrentInstance().execute("PF('dlg2').hide();");
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

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
