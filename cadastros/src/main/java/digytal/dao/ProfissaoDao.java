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
       return findByNome(nome)!=null;
    }
    public List<Profissao> findAll(){
        Query query = em.createQuery("SELECT p FROM Profissao p");
        return query.getResultList();
    }
    public Profissao findByNome(String nome){
        Query query = em.createQuery("SELECT p FROM Profissao p WHERE p.nome= :nome");
        query.setParameter("nome",nome);
        try{
            return (Profissao) query.getSingleResult();
        }catch (NoResultException | NonUniqueResultException ex) {
            return null;
        }
    }
    public Profissao findById(Integer id){
        return em.find(Profissao.class, id);
    }
}
