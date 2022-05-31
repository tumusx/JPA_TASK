package dao;

import entity.Automovel;

import java.util.List;

public interface AutomovelDAOImpl {
    void cadastrarAutomovel(Automovel automovelOBJ);
    void update(Automovel automovelOBJ);
    void deletarAutomovel(Integer id);
    Automovel findAutomovel(Integer id);
    List<Automovel> listarAutomovel();


}
