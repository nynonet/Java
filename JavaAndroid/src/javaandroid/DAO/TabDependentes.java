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
public class TabDependentes extends AbstractTableModel {

    String coluna[] = {"Nome do Parente"};
    List<Parente> lista;

    public TabDependentes(List<Parente> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return coluna.length;
    }

    @Override
    public String getColumnName(int column) {
        return coluna[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex);
            default:
                return "";
        }
    }

    public Parente getParente(int rowIndex) {
        return lista.get(rowIndex);
    }

}
