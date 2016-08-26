package helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageHelper {
	
	public static void exibirMessagem(String header, String mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, header, mensagem);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
