package digytal.application;

import digytal.dao.ProfissaoDao;
import digytal.model.Profissao;

public class CadastrosApp {
    public static void main(String[] args) {
        addProfissao();
    }
    static void addProfissao(){
        ProfissaoDao dao = new ProfissaoDao();

        String nome = "INSTRUTOR";
        boolean exists = dao.existsByNome(nome);

        if(!exists) {
            Profissao profissao = new Profissao();
            profissao.setNome(nome);
            dao.save(profissao);
        }
    }
}
