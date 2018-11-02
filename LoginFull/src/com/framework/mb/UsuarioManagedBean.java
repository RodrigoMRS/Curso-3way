package com.framework.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean
public class UsuarioManagedBean {
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String idUsuario = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
		if(idUsuario != null) {
			this.usuario = usuarioDao.getUsuario(Integer.parseInt(idUsuario));
		}
	}
	
	private List<Usuario> usuarioListDb = new ArrayList<>();
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarioListDb() {
		return usuarioDao.listarTodos();
	}
	public void setUsuarioListDb(List<Usuario> usuarioListDb) {
		this.usuarioListDb = usuarioListDb;
	}
	public void excluirUsuarioDb(Usuario usuario) {
		usuarioDao.deletarUsuario(usuario);
	}
	public String incluirUsuarioDb(Usuario usuario) {
		if(!usuarioDao.inserirUsuario(usuario)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro: Usuário já Cadastrado!", ""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "/restrito/novoUsuario.xhtml?faces-redirect=true";
		}
		return "/restrito/main.xhtml?faces-redirect=true";
		
	}
	public String paginaEditar(Usuario usuario) {
		return "/restrito/editarUsuario.xhtml?faces-redirect=true&id="+ usuario.getId();
	}
	public String editarUsuarioDb(Usuario usuario) {
		usuarioDao.editarUsuario(usuario);
		return "Usuário Alterado com Sucesso";
	}

}
