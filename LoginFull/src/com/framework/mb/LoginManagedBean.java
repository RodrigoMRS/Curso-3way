package com.framework.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String enviar() {
             
            usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
            FacesContext context = FacesContext.getCurrentInstance();
            if (usuario == null) {
                  usuario = new Usuario();
                  context.addMessage( null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
                  context.validationFailed();
                  return null;
            } else {
            	context.getExternalContext().getSessionMap().put("logado", true);
                  return "/restrito/listaUsuarios.xhtml?faces-redirect=true";
            }
             
             
      }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(com.framework.model.Usuario usuario) {
		this.usuario = usuario;
	}
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("logado");
		return "/login/login.xhtml?faces-redirect=true";
	}
}