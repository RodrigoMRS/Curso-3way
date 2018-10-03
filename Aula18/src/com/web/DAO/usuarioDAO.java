package com.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.Usuario.Usuario;
import com.web.Util.Conexao;

public class usuarioDAO {
	// Cria a consulta do SQL
	private static final String OBTER_POR_ID_SQL = "select cod, nome, login, matricula from usuario where cod= ?";
	private static final String OBTER_POR_TITULO_SQL = "select autor,titulo,cod_livro,imagem,preco,descricao from livro where titulo ilike ?";
	private static final String LISTAR = "select * from usuario";
	private static final String OBTER_POR_NOME_SQL = "select * from usuario where nome ilike'?'";
	private static final String UPDATE = "UPDATE usuario SET nome=?,login=?,matricula=? where cod= ?";
	private static final String INSERT_SQL = "INSERT INTO usuario (nome,login,matricula)values(?,?,?)";
	private static final String DELETE_SQL = "delete from usuario where cod=?";

	public static void insert(String nome,  String login, int matricula) {
		// Cria uma conexão com o banco
		// Cria um PreparedStatment, classe usada para executa a query
		try (Connection conexao = Conexao.getConexao(); PreparedStatement ps = conexao.prepareStatement(INSERT_SQL);) {

			// Adiciona o valor do primeiro parâmetro da sql

			ps.setString(1, nome);

			// Adiciona o valor do primeiro parâmetro da sql

			ps.setString(2, login);

			// Adiciona o valor do primeiro parâmetro da sql

			ps.setDouble(3, matricula);

			// executa a query sem retonar nada
			ps.execute();
			System.out.println("Informação inserida no banco Corretamente!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Usuario usuario) {
		// Cria uma conexão com o banco
		// Cria um PreparedStatment, classe usada para executa a query
		try (Connection conexao = Conexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(UPDATE);) {

			// Adiciona o valor do primeiro parâmetro da sql

			consulta.setString(1, usuario.getNome());

			// Adiciona o valor do primeiro parâmetro da sql

			consulta.setString(2, usuario.getLogin());
			consulta.setInt(3, usuario.getMatricula());

			// Adiciona o valor do primeiro parâmetro da sql

			consulta.setInt(4, usuario.getCodigo());

			// executa a query sem retonar nada
			consulta.execute();

			System.out.println("Informação Alterada no banco Corretamente!");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Usuario> listar() {
		// cria o Array de livros
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection conexao = Conexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(LISTAR);) {
			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				// Cria um novo cliente para consultar

				Usuario usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("cod"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setMatricula(resultado.getInt("matricula"));
				

				// insere o objeto livro no array
				usuarios.add(usuario);
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// retornando o array de livros
		return usuarios;

	}

	public Usuario consultar(int codigo) {
		Usuario usuario = null;
		try (Connection conexao = Conexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(OBTER_POR_ID_SQL);) {
			consulta.setInt(1, codigo);
			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				// Cria um novo cliente para consultar
				usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("cod"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setMatricula(resultado.getInt("matricula"));
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;

	}

	public static void delete(int codigo) {
		// Cria uma conexão com o banco
		// Cria um PreparedStatment, classe usada para executa a query
		try (Connection conexao = Conexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(DELETE_SQL);) {

			consulta.setInt(1, codigo);
			consulta.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Usuario> consultarPorNome(String nome) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try (Connection conexao = Conexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(OBTER_POR_NOME_SQL);) {
			consulta.setString(1, "%" + nome.toUpperCase() + "%");
			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				// Cria um novo cliente para consultar
				Usuario usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("cod"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setMatricula(resultado.getInt("matricula"));
				usuarios.add(usuario);
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;

	}
	

}
