/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 * Inferface que implementa todos os métodos padrão
 * para as classes DAO. "Modelo de métodos p/o banco de dados"
 * No nosso exemplo a letra <U> representa uma classe generia do Java
 * que será substituida por uma classe a definir no momento de sua 
 * utilização. 
 * @author Andeson
 */
public interface ModeloDAO<U> {
     
    /**
     * Deverá as classes implementar cada método 
     * @param objeto receber um objeto da classe a ser utulizada
     * @throws Exception devolve para quem o chama a responsabilidade
     * de realizar o tratamento de ERRO/Exceção. 
     */
    public void Inserir(U objeto) throws Exception;
    public void Atualizar(U objeto) throws Exception;
    public void Excluir(U objeto) throws Exception;
    /**
     * Implementa o método que retorna uma lista de objetos
     * @param filtro condição WHERE a ser aplicada na consulta SQL
     * @return retorno da lista 
     * @throws Exception Exception devolve para quem o chama a responsabilidade
     * de realizar o tratamento de ERRO/Exceção. 
     */
    public List<U> getRegistros(String filtro) throws Exception;
    public U getRegistro(int id) throws Exception; 
   
}
