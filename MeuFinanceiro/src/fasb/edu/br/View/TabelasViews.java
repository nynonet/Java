/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.View;

import fasb.edu.br.Model.TypeGrid;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andesonjesusdemenezes
 */
public class TabelasViews<T> extends AbstractTableModel{
    
    private List<T> myList;
    private String[] columnDisplay;
    private String[] columnName;
    
    public void setDados(List<T> list, String[] colDisplay, String[] colName){
        this.myList = list;
        this.columnDisplay = colDisplay;
        this.columnName = colName;
    }

    @Override
    public int getRowCount() {
        return myList.size();
    }

    @Override
    public int getColumnCount() {
        return columnDisplay.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnDisplay[ column ];
    }
    
    public T getObjeto( int row ){
        return myList.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String value = "";
        for (int i=0; i<=columnIndex; i++){
            if (i == columnIndex){
                value = ((TypeGrid) myList.get( rowIndex) ).getValueCol( columnName[i].toLowerCase() );
            }
        }
        return value;
    }
    
}
