package dao;

import entity.Automovel;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AutomovelDAO implements AutomovelDAOImpl{
    EntityManager entityManager;


    public AutomovelDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public void cadastrarAutomovel(Automovel automovelOBJ) {
        entityManager.getTransaction().begin();
        entityManager.persist(automovelOBJ);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Automovel automovelOBJ) {
        entityManager.getTransaction().begin();
        entityManager.merge(automovelOBJ);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletarAutomovel(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findAutomovel(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Automovel findAutomovel(Integer id) {
        return entityManager.find(Automovel.class, id);
    }

    @Override
    public List<Automovel> listarAutomovel() {
        Query query = entityManager.createQuery("SELECT automovel FROM Automovel automovel");
        return query.getResultList();
    }
}
