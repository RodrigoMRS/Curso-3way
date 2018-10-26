package com.framework.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;

@ManagedBean
public class UsuarioManagedBean {
	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private Usuario usuario = new Usuario();
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
		usuarioDao.inserirUsuario(usuario);
		return "/main";
	}
	
	

}
