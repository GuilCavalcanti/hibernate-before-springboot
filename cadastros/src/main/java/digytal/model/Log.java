package digytal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Log {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_inclusao")
	private Date dataHoraInclusao;
	
	@Column(name = "dh_alteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraAlteracao;
	
	public Date getDataHoraInclusao() {
		return dataHoraInclusao;
	}
	public void setDataHoraInclusao(Date dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}
	public Date getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}
	public void setDataHoraAlteracao(Date dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}
	
}
