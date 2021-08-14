package digytal.model;

public enum TelefoneTipo {
	F ("FIXO"),
	C ("CELULAR"),
	W ("WHATSAPP")
	;
	private String nome;
	private TelefoneTipo(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
