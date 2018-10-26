package com.framework.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean(name="CardLoginMB")
public class CardLoginMB {
	private Usuario usuario = new Usuario();
	UsuarioDAO usuarioDao = new UsuarioDAO();
	private void apiReceDadosCartao() {
		String nomeUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nomeUsuario");
		String matricula = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("matricula");
		usuario.setNomeUsuario(nomeUsuario);
		usuario.setMatricula(matricula);
	}
	
	public String enviar() {
		Usuario user = new Usuario();
		apiReceDadosCartao();
		user = usuarioDao.getUsuarioCard(usuario.getNomeUsuario(), usuario.getMatricula());
		  
		if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                       null,
                       new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                   "Erro no Login!"));
            return null;
      } else {
            return "/acessoLiberado";
      }
           
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
