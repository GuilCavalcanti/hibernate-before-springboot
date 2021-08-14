package digytal.model;

public enum Sexo {
	M ("MASCULINO"),
	F ("FEMININO");
	
	private String nome;
	private Sexo(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
