package digytal.application;

import digytal.dao.CadastroDao;
import digytal.dao.ProfissaoDao;
import digytal.model.*;
import digytal.model.dto.CadastroProfissao;

import java.util.Arrays;
import java.util.List;

public class CadastrosApp {
    static ProfissaoDao profissaoDao = new ProfissaoDao();
    static CadastroDao cadastroDao = new CadastroDao();

    public static void main(String[] args) {
        //addProfissao("INSTRUTOR");
        //addProfissao("PROGRAMADOR");
        //addProfissao("WEB DESIGNER");
        //listProfissoes();

        //addCadastro1();
        //addCadastro2();
        //updateCadastro();
        //listCadastros();
        //listCatalogoEmails();
        listCadastrosProfissao();
    }
    static void listCatalogoEmails(){
        cadastroDao.listCatalogoEmail();
    }
    static void listCadastrosProfissao(){
        System.out.println("EXIBINDO OS CPF, NOME, PROFISSAO DE CADASTRO");
        List<CadastroProfissao> list = cadastroDao.listCadastroProfissao();
        for(CadastroProfissao c: list){
            System.out.println(c.toString());
        }
    }
    static void listCadastros(){
        System.out.println("EXIBINDO OS CADASTROS");
        List<Cadastro> list = cadastroDao.findAll();
        for(Cadastro c: list){
            System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getProfissao().getNome());
        }
    }
    static void updateCadastro(){
        Cadastro cadastro = cadastroDao.findById(8);
        if(cadastro!=null){
            cadastro.setNome("GLEYSON SAMPAIO DE OLIVEIRA");
            cadastroDao.update(cadastro);
        }
    }
    static void addCadastro1(){
        Cadastro cadastro = new Cadastro();
        cadastro.setCpfCnpj("769877");
        cadastro.setNome("GLEYSON SAMPAIO");
        cadastro.setSexo(Sexo.M);

        Endereco endereco = new Endereco();
        endereco.setCidade("TERESINA - PI");
        endereco.setLogradouro("RUA DAS FLORES");
        endereco.setNumero("12");
        //embedded
        cadastro.setEndereco(endereco);

        //element collections
        cadastro.setEmails(Arrays.asList(new String[]{"gleyson@digytal.com.br","glysns@hotmail.com"}));

        //one to many
        cadastro.setTelefones(Arrays.asList(new Telefone[]{new Telefone(TelefoneTipo.W,11,958940362L)}));

        //many to one
        Profissao profissao = profissaoDao.findByNome("INSTRUTOR");
        cadastro.setProfissao(profissao);

        cadastroDao.save(cadastro);
    }
    static void addCadastro2(){
        Cadastro cadastro = new Cadastro();
        cadastro.setCpfCnpj("786776");
        cadastro.setNome("FRANK MARLON");
        cadastro.setSexo(Sexo.M);

        Endereco endereco = new Endereco();
        endereco.setCidade("SAO LUIS - MA");
        endereco.setLogradouro("AVENIDA MARANHÃO");
        endereco.setNumero("345");
        //embedded
        cadastro.setEndereco(endereco);

        //element collections
        cadastro.setEmails(Arrays.asList(new String[]{"frank@digytal.com.br","fmms@hotmail.com"}));

        //one to many
        cadastro.setTelefones(Arrays.asList(new Telefone[]{new Telefone(TelefoneTipo.W,98,976540987L)}));

        //many to one
        Profissao profissao = profissaoDao.findByNome("PROGRAMADOR");
        cadastro.setProfissao(profissao);

        cadastroDao.save(cadastro);
    }
    static void listProfissoes(){
        System.out.println("EXIBINDO AS PROFISSOES");
        List<Profissao> list = profissaoDao.findAll();
        for(Profissao p: list){
            System.out.println(p.getId() + " - " + p.getNome());
        }
    }
    static void addProfissao(String nome){

        boolean exists = profissaoDao.existsByNome(nome);

        if(!exists) {
            Profissao profissao = new Profissao();
            profissao.setNome(nome);
            profissaoDao.save(profissao);
        }
    }
}
