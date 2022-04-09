package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import persistencia.PessoaDAO;

//Indicar que a classe é uma entidade
@Entity
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1;
	
	//identifica a FK da entidade
	@Id
	//Ordena o banco de dados a gerar o id automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
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

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
	
	//Persistencia
	public void gravarDados() {
		new PessoaDAO().createTable(this);
	}
	
	public void recuperarDados() {
		System.out.println(new PessoaDAO().selectPessoa(this));
	}
	
	public void excluirPessoa() {
		new PessoaDAO().deletePessoa(this);
	}
}
