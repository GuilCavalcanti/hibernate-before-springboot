package digytal.model.dto;

public class CadastroEmail {
    private String cpfCnpj;
    private String nome;
    private String email;

    public CadastroEmail(String cpfCnpj, String nome, String email) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
