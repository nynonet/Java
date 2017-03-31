/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaandroid.DAO;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andeson
 */
public class GridPadrao<T> extends AbstractTableModel{
    
    List<T> Registros;
    String Colunas[];

    public GridPadrao( List<T> dados, String colunas[] ) {
        Registros = dados;
        Colunas = colunas;
    }   
    
    @Override
    public int getRowCount() {
       return Registros.size();
    }
    
    @Override
    public int getColumnCount() {
        return Colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getValueAt(rowIndex, columnIndex);
    }
    
    public T getRegistro(int rowIndex){
        return Registros.get(rowIndex) ;
    }
    

    
    
}
