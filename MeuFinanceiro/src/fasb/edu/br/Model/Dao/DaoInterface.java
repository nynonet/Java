/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public interface DaoInterface<T> {
    
    public void insert( T t ) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
    
    public T getRow(int id) throws SQLException;
    public List<T> getRows(String wheres) throws SQLException;   
    public List<T> getFull() throws SQLException;
}
