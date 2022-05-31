package dao;
import entity.Modelo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ModeloDAO implements ModeloDAOImpl {
    EntityManager entityManager;

    public ModeloDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void cadastrarModelo(Modelo modeloOBJ) {
        entityManager.getTransaction().begin();
        entityManager.persist(modeloOBJ);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Modelo modeloOBJ) {
        entityManager.getTransaction().begin();
        entityManager.merge(modeloOBJ);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletarModelo(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findModelo(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Modelo findModelo(Integer id) {
        return entityManager.find(Modelo.class, id);
    }

    @Override
    public List<Modelo> listarModelo() {
        Query query = entityManager.createQuery("SELECT modelo FROM Modelo modelo");
        return query.getResultList();
    }

}

