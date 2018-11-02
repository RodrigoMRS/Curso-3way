package com.framework.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.framework.model.Produto;

public class ProdutoDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("produto");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public List<Produto> listarProdutos() {
		Query queryobj = em.createQuery("SELECT u FROM Produto u");
		List produtosList = queryobj.getResultList();
		if (produtosList != null && produtosList.size() > 0) {
			return produtosList;
		} else {
			return null;
		}
	}

	public Produto getproduto(int cod) {
		try {
			return em.find(Produto.class, cod);
		} catch (Exception e) {
			return null;
		}
	}

	public Boolean editar(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		try {
			em.merge(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean inserirProduto(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		try {
			em.persist(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean deletarProduto(Produto produto) {
		try {
			em.remove(produto);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
