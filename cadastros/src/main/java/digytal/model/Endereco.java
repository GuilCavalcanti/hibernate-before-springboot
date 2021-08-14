package digytal.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column(name = "end_logra", length = 50, nullable = false)
	private String logradouro;
	
	@Column(name = "end_num", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "end_cidade", length = 100, nullable = false)
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
