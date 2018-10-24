package com.framework.teste;

import com.framework.dao.UsuarioDAO;
import com.framework.model.Usuario;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario user = new Usuario();
		user.setNomeUsuario("Rodrigo");
		user.setSenha("1608");
		usuarioDao.inserirUsuario(user);
	}

}
