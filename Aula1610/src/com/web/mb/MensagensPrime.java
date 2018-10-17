package com.web.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name="mensagens")
public class MensagensPrime {

		public void info() {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"info","Mensagem Informando algo!" ));
			
		}
		public void erro() {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro","Ocorrreu um erro!" ));
			
		}
		public void aviso() {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Isso é um aviso!" ));
			
		}
		public void fatal() {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Fatal","Parou de Funcionar" ));
			
		}
	
}
