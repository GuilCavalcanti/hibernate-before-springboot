package digytal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cadastro_telefone")
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, length = 2)
	private Integer ddd;
	
	@Column(nullable = false, length = 10)
	private Long numero;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private TelefoneTipo tipo;
	
	public Telefone(TelefoneTipo tipo, Integer ddd, Long numero) {
		super();
		this.tipo = tipo;
		this.ddd = ddd;
		this.numero = numero;
	}
	public Telefone(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public TelefoneTipo getTipo() {
		return tipo;
	}
	public void setTipo(TelefoneTipo tipo) {
		this.tipo = tipo;
	}
	
}
