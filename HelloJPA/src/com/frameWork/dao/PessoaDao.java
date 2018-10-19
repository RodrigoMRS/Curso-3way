package com.frameWork.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.frameword.model.Pessoa;

public class PessoaDao {
	
	private EntityManager entityMananger;
	
	/* Nossa classe PessoaDao segue o padra~do de projeto Singleton
	que garante que apenas uma inst�ncia dessa
	classe ser� criada durante toda a aplica��o */
	
	private static PessoaDao instance;
	
	public static PessoaDao getInstance() {
		if(instance == null) {
			instance = new PessoaDao();
		}
		return instance;
	}
	private PessoaDao() {
		entityMananger = getEntityMananger();
	}
	public EntityManager getEntityMananger() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("HelloJPA");
		if(entityMananger == null) {
			entityMananger = factory.createEntityManager();
		}
		return entityMananger;
	}
	public void setEntityMananger(EntityManager entityMananger) {
		this.entityMananger = entityMananger;
	}
	public void persist(Pessoa Pessoa) {
		try {
			entityMananger.getTransaction().begin();
			entityMananger.persist(Pessoa);
			entityMananger.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityMananger.getTransaction().rollback();
		}
	}
}
