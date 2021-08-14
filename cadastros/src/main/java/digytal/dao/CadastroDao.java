package digytal.dao;

import digytal.model.Cadastro;
import digytal.model.Profissao;

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
}
