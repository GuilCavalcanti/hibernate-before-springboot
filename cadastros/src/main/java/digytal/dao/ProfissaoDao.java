package digytal.dao;

import digytal.model.Profissao;

import javax.persistence.*;
import java.util.List;

public class ProfissaoDao {
    private EntityManager em;
    public ProfissaoDao(){
        em = Persistence.createEntityManagerFactory("CADASTROS_PU").createEntityManager();
    }
    public void save(Profissao entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    public boolean existsByNome(String nome){
        Query query = em.createQuery("SELECT p FROM Profissao p WHERE p.nome= :nome");
        query.setParameter("nome",nome);
        try{
            query.getSingleResult();
            return true;
        }catch (NoResultException | NonUniqueResultException ex) {
            return false;
        }
    }
    public List<Profissao> findAll(){
        Query query = em.createQuery("SELECT p FROM Profissao p");
        return query.getResultList();
    }
}
