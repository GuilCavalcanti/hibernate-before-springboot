package digytal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column(length = 50, nullable = false)
	private String logradouro;
	
	@Column(length = 10, nullable = false)
	private String numero;
	
	@Column(length = 100, nullable = false)
	private String cidade;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
		
}
