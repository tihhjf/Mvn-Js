package helper;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class FacesHelper {
	
	private static final String ID = "id";
	
	private static Long converterParaLong(String id){
		return id!=null?Long.parseLong(id):0;
	}
	
	public static Long getIdUrl(){
		return converterParaLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(ID));
	}
	
	public static void redirecionarPagina(String pagina){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
