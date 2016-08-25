package entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = -8966800143067980717L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", length=45, nullable=false)
	private String nome;
	
	@Column(name="data_nasc", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="cpf", length=15, nullable=false)
	private String cpf;
	
	@Column(name="login", length=45, nullable=false)
	private String login;
	
	@Column(name="senha", length=45, nullable=false)
	private String senha;
	
	public Pessoa(){}

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

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascimentoFormatada() {
		return new DateTime(getDataNascimento()).toString("dd/MM/yyyy");
	}
	
	public int getDiaAniversario() {
		return new DateTime(getDataNascimento()).getDayOfMonth();
	}
	
	public String getMesAniversario() {
		return new DateTime(getDataNascimento()).toString("MMMMMMMMM");
	}
	
	public String getDataAniversario(){
		return getDiaAniversario() + " de " + getMesAniversario();
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
