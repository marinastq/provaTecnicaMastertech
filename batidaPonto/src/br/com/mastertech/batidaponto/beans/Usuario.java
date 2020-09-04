package br.com.mastertech.batidaponto.beans;

import java.util.Date;

public class Usuario {
	
	//id, nome completo, cpf, email e data de cadastro
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private Date dataCadastro;
	
	public Usuario(int id) {
		super();
		this.id = id;
	}
	
	public Usuario(int id, String nome, String cpf, String email, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
}
