package com.brunocandido.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.brunocandido.cursomc.enuns.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable {


	private static final long serialVersionUID = 1L;
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private String email;
	private String cpfCgc;
	private Integer tipoCliente;
    
	
	//@JsonManagedReference
	@OneToMany(mappedBy="cliente") //"cliente" equivale a classe Enderecos declaracao private Cliente cliente; 
	private List<Enderecos> enderecos = new ArrayList<>();
	
	@ElementCollection //Cria uma tabela no caso vinculada ao ID cliente já que faz parte da tabela cliente
	@CollectionTable(name="TELEFONE")
	private Set<String> telefone = new HashSet<>(); // Set salva uma lista não podendo repetir, ou seja nao poderei
													// repetir o telefone
	 @JsonIgnore
	//@JsonBackReference //Dentro da Classe Cliente é feito @JsonBackReference ,@JsonManagedReference dentro do Pedido
    //Esta anotação serve para que o serviço não dê um loop infinito
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();


	public Cliente() {

	}

	public Cliente(Integer id, String nome, String email, String cpfCgc, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCgc = cpfCgc;
		this.tipoCliente = tipoCliente.getCod();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCgc() {
		return cpfCgc;
	}

	public void setCpfCgc(String cpfCgc) {
		this.cpfCgc = cpfCgc;
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(this.tipoCliente); // Busca dentro da Classe Tipo de Cliente o Enum do tipo Statico
														// que nao precisa dar o new
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
