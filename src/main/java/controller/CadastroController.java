package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import dao.PessoaDao;
import entidade.Pessoa;
import helper.FacesHelper;
import helper.MessageHelper;
import helper.SessionHelper;

@ManagedBean
@ViewScoped
public class CadastroController implements Serializable{

	private static final long serialVersionUID = 1971638693799680582L;
	
	private Pessoa usuarioLogado;
	private Pessoa pessoa;
	private PessoaDao pessoaDao;
	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;
	
	@PostConstruct
	public void init(){
		iniciarObjetos();
		obterUsuarioLogado();
		popularListaPessoas();
	}

	private void popularListaPessoas() {
		try {
			pessoas = pessoaDao.buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void obterUsuarioLogado() {
		try {
			usuarioLogado = SessionHelper.obterUsuarioLogado();
			if(usuarioLogado == null){
				FacesHelper.redirecionarPagina("acessoNegado.xhtml");
			}else{
				usuarioLogado = pessoaDao.buscarPorId(usuarioLogado.getId());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void iniciarObjetos() {
		if(pessoa == null){
			pessoa = new Pessoa();
		}
		if(pessoaDao == null){
			pessoaDao = new PessoaDao();
		}
	}
	
	public void salvar(){
		if(pessoaDao.salvar(this.pessoa)){
			MessageHelper.exibirMessagem("Cadastrado com sucesso!", null);
			this.pessoa = new Pessoa();
			fecharModal();
			return;
		}
		MessageHelper.exibirMessagem("Erro ao cadastrar!", null);
	}
	
	public void logout(){
		SessionHelper.logout();
		FacesHelper.redirecionarPagina("index.xhtml");
	}
	
	public void exibirDetalhes(Pessoa pessoa){
		this.pessoaSelecionada = pessoa;
	}
	
	public void fecharModal(){
		RequestContext.getCurrentInstance().execute("PF('modalCadastro').hide();");
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

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public Pessoa getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
