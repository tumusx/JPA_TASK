package dao;

import entity.Automovel;
import entity.Marca;

import java.util.List;

public interface MarcaDAOImpl {
    void cadastrarMarca(Marca marcaOBJ);
    void update(Marca marcaOBJ);
    void deletarMarca(Integer id);
    Marca findMarca(Integer id);
    List<Marca> listarMarca();

}
