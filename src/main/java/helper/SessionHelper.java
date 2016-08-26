package helper;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entidade.Pessoa;

public class SessionHelper {
	
	public static void login(Pessoa pessoa){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.setAttribute("usuario", pessoa);
	}
	
	public static Pessoa obterUsuarioLogado(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		return (Pessoa) session.getAttribute("usuario");
	}
	
	public static void logout(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
	}

}
