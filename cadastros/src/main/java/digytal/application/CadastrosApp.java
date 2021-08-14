package digytal.application;

import digytal.dao.ProfissaoDao;
import digytal.model.Profissao;

import java.util.List;

public class CadastrosApp {
    static ProfissaoDao dao = new ProfissaoDao();
    public static void main(String[] args) {
        addProfissao("INSTRUTOR");
        addProfissao("PROGRAMADOR");
        addProfissao("WEB DESIGNER");

        listProfissoes();
    }
    static void listProfissoes(){
        System.out.println("EXIBINDO AS PROFISSOES");
        List<Profissao> list = dao.findAll();
        for(Profissao p: list){
            System.out.println(p.getId() + " - " + p.getNome());
        }
    }
    static void addProfissao(String nome){

        boolean exists = dao.existsByNome(nome);

        if(!exists) {
            Profissao profissao = new Profissao();
            profissao.setNome(nome);
            dao.save(profissao);
        }
    }
}
