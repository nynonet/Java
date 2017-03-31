/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasb;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andeson
 */
public class ModeloTabela extends AbstractTableModel{
    String colunas[] = new String[] {"Tempo", "Prestaçao", 
                      "Juros", "Amortização", "Saldo Devedor"}; 
    
    List<Tabela> registros;

    public ModeloTabela(List<Tabela> registros) {
        this.registros = registros;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[ column ];
    }
    
    public Tabela getRegistro( int selecionado ) {
        return registros.get( selecionado );
    }
    
    @Override
    public int getRowCount() {
        return registros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 : 
            if ( (rowIndex>0) && (registros.get(rowIndex).getTempo()==0) ){
                return "Totais: ";
            } else {
                return registros.get(rowIndex).getTempo();
            }
            case 1 : return registros.get(rowIndex).getPrestacao();
            case 2 : return registros.get(rowIndex).getJuros();
            case 3 : return registros.get(rowIndex).getAmortizacao();
            case 4 : return registros.get(rowIndex).getSaldoDevedor();
            default : return "";                
        }
    }
    
}
