package dao;

import entity.Automovel;
import entity.Marca;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MarcaDAO implements MarcaDAOImpl{
    EntityManager entityManager;

    public MarcaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void cadastrarMarca(Marca marcaOBJ) {
        entityManager.getTransaction().begin();
        entityManager.persist(marcaOBJ);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Marca marcaOBJ) {
        entityManager.getTransaction().begin();
        entityManager.merge(marcaOBJ);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletarMarca(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(this.findMarca(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Marca findMarca(Integer id) {
        return entityManager.find(Marca.class, id);
    }

    @Override
    public List<Marca> listarMarca() {
        Query query = entityManager.createQuery("SELECT marca FROM Marca marca");
        return query.getResultList();
    }
}
