/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrol;

import Model.Tabela;
import dao.Conexao;
import dao.TabelaDao;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.table.TableModel;

/**
 *
 * @author Andeson
 */
public class TabelaCtrl {

    private TabelaDao tabelaDao;
    private Conexao con;

    public TabelaCtrl(Conexao conexao) {
        tabelaDao = new TabelaDao(conexao.getCon());
        con = conexao;
    }
    
    public TableModel getRegistros() {
        //por não ter nenhum filtro não houve nenhum tratamento
        TabelaTab model = new TabelaTab(tabelaDao.getRegistro());        
        return model;        
    }

    public Tabela getRegistro(int id) {
        
        if (id <= 0) {
           JOptionPane.showMessageDialog(null, "Informe a quantidade válida!");
           return null;
        }
        
        return tabelaDao.getRegistro(id);    
    }
    
    public String getResumo(TipoResumo resumo ){
        String corpo;
        switch (resumo) {
            case VL_MAX : corpo = "max(valor) as maxx"; break;
            case VL_MIN : corpo = "min(valor) as minn"; break;
            case VL_AVG : corpo = "avg(valor) as avgg"; break;
            case DT_MAX : corpo = "to_char( max(data), 'dd/mm/yyyy hh:mm:ss') as maxx";  break;
            case DT_MIN : corpo = "to_char( min(data), 'dd/mm/yyyy hh:mm:ss') as minn";  break;
            default : corpo = "";
        }
       
        if (corpo.length()==0) {
            JOptionPane.showMessageDialog(null, "Resumo não informado!");
            return "";
        }
        
        Object r = tabelaDao.getValor(corpo);
        
        if (resumo.gettipo() == 1) {
            return  String.format("%.2f", (BigDecimal) r );
        } else {
            return (String) r;
        }
        
    }

    public void gerarRegistros(JSpinner sequencia, JProgressBar progresso, JButton btnClick) {
        
        int qtd_vezes = (int) sequencia.getValue();

        if (qtd_vezes <= 0) {
            JOptionPane.showMessageDialog(sequencia.getParent(), "Informe a quantidade válida!");
            return;
        }
        
        if ( ! con.isConectado()) {
            JOptionPane.showMessageDialog(sequencia.getParent(), "Sem conexão com o banco de dados!");
            return;
        }
        

        progresso.setMaximum(qtd_vezes);

        new Thread() {
            @Override
            public void run() {
                try {
                    sequencia.setEnabled(false);
                    btnClick.setEnabled(false);
                    
                    Random valor = new Random();
                    

                    for (int i = 1; i <= qtd_vezes; i++) {
                        progresso.setValue( i );
                        
                        Tabela obj = new Tabela();
                        obj.setData( Calendar.getInstance() );
                        obj.setValor(valor.nextDouble()*i);
                        obj.setNome( Nome() );
                        obj.setAtivo(valor.nextBoolean());
                        
                        tabelaDao.Inserir(obj);
                    }

                } finally {
                    sequencia.setEnabled(true);
                    btnClick.setEnabled(true);
                }
            }
        }.start();
    }
    
    public String Nome(){
        String lista[] = {"ANDESON", "JESUS", "MENEZES", "SILVA", "CARNEIRO", 
            "RIOS", "MACHADO", "GOMES", "DAIANE", "DÉBORA", "DAVI", "DANIEL",
        "ANTONIO", "ANA", "FRANCISO", "JOSÉ", "OLIVEIRA", "CASTRO", "TIMBRE",
        "LUA", "SOL", "MENDES", "TIAGO", "VICTOR", "VITOR", "JANUARIO", "RAY",
        "BARRACUDA"};        
        Random r = new Random();
        
        return lista[r.nextInt(lista.length)]+ " "+
                lista[r.nextInt(lista.length-2)]+ " de "+
                lista[r.nextInt(lista.length-5)];
        
    }

}
