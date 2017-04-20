/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Andeson
 */
public interface Dao<T> {
    
    public void Inserir(T obj);
    public void Atualizar(T obj);
    public void Deletar(T obj);
    
    public List<T> getRegistro();
    public T getRegistro(int Id);
    
}
