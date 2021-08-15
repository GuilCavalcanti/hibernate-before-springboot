package digytal.model.dto;

public class CadastroProfissao {
    private String cpfCnpj;
    private String nome;
    private String profissao;

    public CadastroProfissao(String cpfCnpj, String nome, String profissao) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.profissao = profissao;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    @Override
    public String toString() {
        return "CadastroProfissao{" +
                "cpfCnpj='" + cpfCnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                '}';
    }
}
