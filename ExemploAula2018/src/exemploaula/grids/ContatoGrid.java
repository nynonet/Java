/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula.grids;

import exemploaula.model.Contato;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andeson de Jesus
 */
public class ContatoGrid extends AbstractTableModel {
    
    List<Contato> lista; //lista de contatos que será passada. 
    
    String[] colunas = {"Código", "Nome"}; //Colunas da tabela  
    
    /**
     * Método construtor 
     * @param lista passando a lista que será apresentada.
     */
    public ContatoGrid(List<Contato> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        //qual a quantidade de registros? 
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        //quantas coluna terá? 
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        //Quan o nome da coluna?
        return colunas[ column ];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //verifica qual a coluna está sendo lida
        switch ( columnIndex ){
            case 0 :  //caso sejá a coluna ID retorna o mesmo
               return lista.get(rowIndex).getId();
            case 1 :  //caso sejá a coluna Nome retorna o mesmo
                return lista.get(rowIndex).getNome();                
            default: return ""; //retorna vazio caso seja algo não definido
        }
    }
   
    /**
     * Devolve o objeto do tipo Contato da Tabela ou Grid
     * @param index  deve-se informar o item selecionado
     * @return contato
     */    
    public Contato getItem( int index ) {
        return lista.get( index );
    }
    
}
