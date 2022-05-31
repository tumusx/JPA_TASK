package dao;

import entity.Automovel;
import entity.Marca;
import entity.Modelo;

import java.util.List;

public interface ModeloDAOImpl {
    void cadastrarModelo(Modelo modeloOBJ);
    void update(Modelo modeloOBJ);
    void deletarModelo(Integer id);
    Modelo findModelo(Integer id);
    List<Modelo> listarModelo();
}
