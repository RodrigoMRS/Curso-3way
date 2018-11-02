package com.framework.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.framework.dao.ProdutoDAO;
import com.framework.model.Produto;


@ManagedBean
@ViewScoped
public class ProdutoManagedBean {
	ProdutoDAO prodDao = new ProdutoDAO();
	Produto produto = new Produto();
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String codProduto = (String) facesContext.getExternalContext().getRequestParameterMap().get("cod");
		if(codProduto != null) {
			this.produto = prodDao.getproduto(Integer.parseInt(codProduto));
		}
	}
	 
	public List<Produto> listarTodosProdutos() {
		return  prodDao.listarProdutos();
	}
	
	public String editar(Produto produto) {
		prodDao.editar(produto);
		return "Produto Alterado com Sucesso!";
		
	}
	public Produto getProduto() {
		return produto;
	}
	public Produto setProduto() {
		return produto;
	}
	
	public void excluirProdutoDb(Produto produto) {
		prodDao.deletarProduto(produto);
	}
	public String incluirProdutoDb(Produto produto) {
		if(!prodDao.inserirProduto(produto)) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro: Usuário já Cadastrado!", ""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "/restrito/novoUsuario.xhtml?faces-redirect=true";
		}
		return "/restrito/main.xhtml?faces-redirect=true";
		
	}
	public String paginaEditar(Produto produto) {
		return "/editarProduto.xhtml?faces-redirect=true&cod="+ produto.getCod();
	}
	public String editarprodutoDb(Produto produto) {
		prodDao.editar(produto);
		return "Usuário Alterado com Sucesso";
	}

}
