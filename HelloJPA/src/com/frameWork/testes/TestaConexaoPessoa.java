package com.frameWork.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.frameWork.dao.PessoaDao;
import com.frameword.model.Pessoa;

public class TestaConexaoPessoa {
	static PessoaDao pessoaDao = PessoaDao.getInstance();
	
	public static void main(String[] args) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HelloJPA");
//		EntityManager entityManager = factory.createEntityManager();
//		
//		Pessoa pessoa = new Pessoa();
//		pessoa.setCpf("12345678901");
//		pessoa.setNome("Rodrigo");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(pessoa);
//		entityManager.getTransaction().commit();
//		
//		List<Pessoa> pessoas = entityManager.createQuery("from " + Pessoa.class.getName()).getResultList();
		
		IncluirPessoa();

	}
	
	private static void IncluirPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("10432654482");
		pessoa.setNome("Adlla");
		pessoaDao.persist(pessoa);
	}
}
