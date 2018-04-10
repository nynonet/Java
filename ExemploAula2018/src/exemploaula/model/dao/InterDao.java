/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula.model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author macbook
 */
public interface InterDao<T> {
    
    /**
     * Método obrigatório de inserção de Dados 
     * @param objT  objeto representando a classe
     * @throws SQLException Develve o erro para ser tratato
     */
    public void Inserir(T objT) throws SQLException ;
    
    /**
     * Método obrigatório de Atualização de Dados 
     * @param objT  objeto representando a classe
     * @throws SQLException Develve o erro para ser tratato
     */
    public void Gravar(T objT) throws SQLException ;
    
    /**
     * Método obrigatório de remoção de Dados 
     * @param objT  objeto representando a classe
     * @throws SQLException Devolve o erro para ser tratado
     */
    public void Deletar(T objT ) throws SQLException;
    
    /**
     * Método devolver um registro pelo seu ID
     * @param id código do registro no banco de dados
     * @return retrona um registro do objeti no banco de dados
     * @throws SQLException devolve o erro para ser tratado
     */
    public T getRegistro(int id) throws SQLException;
    
    /**
     * Método para devolver um lista de registro do banco de dados
     * @param condicao condição where a ser aplicada
     * @return retorna uma lista de registro
     * @throws SQLException Devolve o erro para ser tratado
     */
    public List<T> getRegistros(String condicao) throws SQLException;
    
}
