package com.example.loginauthapi.model;

import java.util.List;

import jakarta.persistence.FetchType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_funcionario;
	private String nome;
	@Column(unique = true)
	private String rg;
	private Double salario;
	private LocalDate data_adm;
	private LocalDate data_egresso;
	private String nome_fantasia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	@OneToMany(mappedBy = "cozinheiro")
	private List<Receitas> receitas;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "livro_id")
	private Livros livros;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "meta_id")
	private Meta metas;

	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getData_adm() {
		return data_adm;
	}

	public void setData_adm(LocalDate data_adm) {
		this.data_adm = data_adm;
	}

	public LocalDate getData_egresso() {
		return data_egresso;
	}

	public void setData_egresso(LocalDate data_egresso) {
		this.data_egresso = data_egresso;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Receitas> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receitas> receitas) {
		this.receitas = receitas;
	}

	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

	public Meta getMetas() {
		return metas;
	}

	public void setMetas(Meta metas) {
		this.metas = metas;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	
	
	
	
}
