package digytal.dao;

import digytal.model.Cadastro;
import digytal.model.Profissao;
import digytal.model.dto.CadastroEmail;
import digytal.model.dto.CadastroProfissao;

import javax.persistence.*;
import java.util.List;

public class CadastroDao {
    private EntityManager em;
    public CadastroDao(){
        em = Persistence.createEntityManagerFactory("CADASTROS_PU").createEntityManager();
    }
    public void save(Cadastro entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    public void update(Cadastro entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
    public boolean existsByCpfCnpj(String cpfCnpj){
        Query query = em.createQuery("SELECT c FROM Cadastro c WHERE c.cpfCnpj= :cpfCnpj");
        query.setParameter("cpfCnpj",cpfCnpj);
        try{
            query.getSingleResult();
            return true;
        }catch (NoResultException | NonUniqueResultException ex) {
            return false;
        }
    }
    public List<Cadastro> findAll(){
        Query query = em.createQuery("SELECT c FROM Cadastro c");
        return query.getResultList();
    }
    public Cadastro findById(Integer id){
        return em.find(Cadastro.class, id);
    }
    //Query Constructor
    public List<CadastroProfissao> listCadastroProfissao(){
        String sql = " SELECT NEW digytal.model.dto.CadastroProfissao(c.cpfCnpj, c.nome, c.profissao.nome) FROM Cadastro c ";
        Query query = em.createQuery(sql);
        List<CadastroProfissao> lista = query.getResultList();
        return lista;
    }
    public List<CadastroEmail> listCatalogoEmail(){
        String sql = " SELECT c.cpfCnpj, c.nome, e" +
                     " FROM Cadastro c join c.emails e ";
        Query query = em.createQuery(sql);
        List l = query.getResultList();
        System.out.println(l);
        return null;
    }
}
