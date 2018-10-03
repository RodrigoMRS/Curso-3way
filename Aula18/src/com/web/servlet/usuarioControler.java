package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAO.usuarioDAO;
import com.web.Usuario.Usuario;


@WebServlet("/usuarioControler")
public class usuarioControler extends HttpServlet{
	private static final long serialVersionUID = 5339672341283037225L;
	private static final String INSERIR_OU_EDITAR = "/usuario.jsp";
	private static final String LISTAR_USUARIOS = "/listaUsuario.jsp";
	private usuarioDAO dao = new usuarioDAO();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{		
		String forward = "";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("deletar")) {
			int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
			dao.delete(codigoUsuario);
			forward = LISTAR_USUARIOS;
			request.setAttribute("usuarios", dao.listar());
		}else if(action.equalsIgnoreCase("editar")) {
			forward = INSERIR_OU_EDITAR;
			int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
			Usuario usuario = dao.consultar(codigoUsuario);
			request.setAttribute("usuario", usuario);
			
		}else if(action.equalsIgnoreCase("listarUsuarios")) {
			forward = LISTAR_USUARIOS;
			request.setAttribute("usuarios", dao.listar());
		}else {
			forward = INSERIR_OU_EDITAR;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(request.getParameter("usuarioCodigo") != "" ? Integer.parseInt(request.getParameter("usuarioCodigo")): 0);
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setMatricula(request.getParameter("matricula") != null ? Integer.parseInt(request.getParameter("matricula")): 0);
		String codigoUsuario = request.getParameter("usuarioCodigo");
		String buscarUsuarios = request.getParameter("buscarUsuario");
		
		List<Usuario> usuarios = new ArrayList<>();
		
		if((codigoUsuario == null || codigoUsuario.isEmpty()) && buscarUsuarios == null ) {
			dao.insert(usuario.getNome(), usuario.getLogin(), usuario.getMatricula());
			usuarios = dao.listar();
		}else if(buscarUsuarios != null) {
			usuarios = dao.consultarPorNome(buscarUsuarios);
			usuarios = dao.listar();
			
		}else {
			usuario.setCodigo(Integer.parseInt(codigoUsuario));
			dao.update(usuario);
			usuarios = dao.listar();
			
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LISTAR_USUARIOS);
		request.setAttribute("usuarios", usuarios);
		view.forward(request, response);
	}

}
