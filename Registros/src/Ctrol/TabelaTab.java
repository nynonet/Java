/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrol;

import Model.Tabela;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andeson
 */
public class TabelaTab extends AbstractTableModel {

    private String colunas[] = {"ID", "NOME", "VALOR", "DATA", "ATIVO?"};
    private List<Tabela> lista;

    public TabelaTab(List<Tabela> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getId();
            case 1:
                return lista.get(rowIndex).getNome();          
            case 2:
                return lista.get(rowIndex).getValor();
            case 3:
                return (Date) lista.get(rowIndex).getData().getTime();
            case 4:
                return lista.get(rowIndex).isAtivo();
            default:
                return "";
        }
    }

    public Tabela getRegistro(int index) {
        return lista.get(index);
    }

}
