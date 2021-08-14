package digytal.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tab_cadastro")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String cpfCnpj;

    @Column(length = 50, nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "tab_cadastro_email", joinColumns = @JoinColumn(name = "cd_cadastro"))
    @Column(name = "email", length = 80)
    private List<String> emails = new ArrayList<String>();

    private LocalDate aniversario;

    @Embedded
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "cd_cadastro")
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Sexo sexo;

    @Embedded
    private Log log;

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
    public List<String> getEmails() {
        return emails;
    }
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
    public LocalDate getAniversario() {
        return aniversario;
    }
    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public List<Telefone> getTelefones() {
        return telefones;
    }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public Log getLog() {
        return log;
    }
    public void setLog(Log log) {
        this.log = log;
    }
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @PrePersist
    private void prePersist() {
        log = new Log();
        log.setDataHoraInclusao(new Date());
    }
    @PreUpdate
    private void preUpdate() {
        log.setDataHoraAlteracao(new Date());
    }
}
