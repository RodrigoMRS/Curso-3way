package com.web.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.DAO.usuarioDAO;



public class TestaConexao {
	
	usuarioDAO usuarioBd = new usuarioDAO();
	

	public static void main(String[] args) {
		Connection con;
		try {
			con = Conexao.getConexao();
			if(con!= null) {
				// Instanciando o Classe da Conexão com o Banco
//				LivroDAO livro = new LivroDAO();
				//Imprimindo o resultado da consulta
//				System.out.println(livro.consultar(1).getAutor());
				
				//updateBD("Valor titulo alterado","Valor Alterado",1);
				
				//insertBD("Como Fazer inimizados no Curso", "Rodrigo Marques", 150.99, "C:\\desktop", "Ese é um livro que irá mostrar como não avaliar curso!");
				TestaConexao.insertBD("Rodrigo Marques", "digao.rmrsilva", 16);
				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
//	public void updateBD(Livro livro) {
//		
//		Connection con;
//		try {
//			con = Conexao.getConexao();
//			if(con!= null) {
////				testarConsulta(1);
//				livroBd.update(livro);
//				
//				con.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
public void consultaTitulo(String nome) {
		
		Connection con;
		try {
			con = Conexao.getConexao();
			if(con!= null) {
//				testarConsulta(1);
				usuarioBd.consultarPorNome(nome);
				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertBD(String nome, String login, int matricula) {
		Connection con;
		try {
			con = Conexao.getConexao();
			if(con!= null) {
//				testarConsulta(1);
				usuarioDAO.insert(nome, login, matricula);
				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteBD(int codigo) {
		Connection con;
		try {
			con = Conexao.getConexao();
			if(con!= null) {
//				testarConsulta(1);
				usuarioDAO.delete( codigo);
				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
