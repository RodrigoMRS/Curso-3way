package com.web.mb;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "faces")
public class PessoaMB {

	private String nomeCompleto ;
	private int idade ;
	private String sexo ;
	
	
	
	@PostConstruct
	public void init() {
		setNomeCompleto("Rodrigo Marques");
		setIdade(28);
		setSexo("Masculino");
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	} 

}
