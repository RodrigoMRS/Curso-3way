package com.framework.teste;

import com.framework.dao.ProdutoDAO;
import com.framework.model.Produto;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProdutoDAO prodDao = new ProdutoDAO();
		Produto prod = new Produto();
		prod.setDescricao("Castanha do Par�");
		prod.setFornecedor("Adriano Par�");
		prod.setValor(25.0);
		prodDao.inserirProduto(prod);
	}

}
