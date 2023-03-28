package com.epicode.model;

public class user {

	private Long id;
	private String nome, cognome, email;
	private Integer anni;

	public user(String nome, String cognome, Integer anni, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		this.email = email;
	}

	public user(Long id, String nome, String cognome, Integer anni, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.anni = anni;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAnni() {
		return anni;
	}

	public void setAnni(Integer anni) {
		this.anni = anni;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", anni=" + anni
				+ "]";
	}

}
