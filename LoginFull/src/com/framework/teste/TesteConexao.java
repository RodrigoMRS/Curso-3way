package com.framework.teste;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario user = new Usuario();
		user.setNomeUsuario("admin");
		user.setSenha("9090");
		user.setMatricula("20204433");
		usuarioDao.inserirUsuarioCard(user);
	}

}
