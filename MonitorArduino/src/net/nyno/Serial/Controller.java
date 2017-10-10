/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nyno.Serial;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Classe para controlar a comunicação com a porta serial
 *
 * @author Andeson
 */
public class Controller {

    private OutputStream outputStream;
    private InputStream inputStream;
    private int taxa;
    private String porta;
    private CommPortIdentifier com;
    private SerialPort port;

    /**
     * Construtor passado somente a porta e mantendo a taxa padrão de 9600
     *
     * @param porta porta de comunicação exemplo: COM1, COM2, COM3 e etc...
     */
    public void Open(String porta) throws Exception {
        this.taxa = 9600;
        this.porta = porta;
        Start();
    }

    /**
     * Método privado de inicialização com o dispositivo na porta informada.
     */
    private void Start() throws Exception {
        //para identificar que porta estaremos usando.

        try {
            //busca a porta serial  
            this.com = CommPortIdentifier.getPortIdentifier(this.porta);
        } catch (NoSuchPortException e) {
            //devolve a mensagem para ser tratada na classe que a chamou.
            new Exception(e.getMessage());
        }

        if (!com.isCurrentlyOwned()) {
            //Abrindo a porta para comunicação
            port = (SerialPort) com.open(this.porta, this.taxa);
        }

        this.outputStream = port.getOutputStream();
        this.inputStream = port.getInputStream();
        port.setSerialPortParams(this.taxa,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

    }

    /**
     * Método para fechar a porta de Comunicação Serial
     *
     * @throws IOException
     */
    public void ClosePorta() throws IOException {
        outputStream.close();
    }
    
    /**
     * Ler dados da serial 
     */
    public void LerSerial(JTextArea monitor){
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = this.inputStream.read(buffer)) > -1) {
                String r = new String(buffer, 0, len);
                monitor.append(r);
                //System.out.print( r );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Enviando dados para a serial
     *
     * @param s pacote de dados que deseja enviar
     * @throws IOException
     */
    public void SendData(String s) throws IOException {
        outputStream.write(s.getBytes());
    }

    /**
     * Retorna a lista de porta encontrada.
     *
     * @return
     */
    public List<String> ListaPortas() {
        List<String> retorno = new ArrayList();
        Enumeration<CommPortIdentifier> portas = CommPortIdentifier.getPortIdentifiers();
        while (portas.hasMoreElements()) {
            CommPortIdentifier com = portas.nextElement();
            retorno.add(com.getName());
        }
        return retorno;
    }

    private String getPortTypeName(int portType) {
        switch (portType) {
            case CommPortIdentifier.PORT_I2C:
                return "I2C";
            case CommPortIdentifier.PORT_PARALLEL:
                return "Parallel";
            case CommPortIdentifier.PORT_RAW:
                return "Raw";
            case CommPortIdentifier.PORT_RS485:
                return "RS485";
            case CommPortIdentifier.PORT_SERIAL:
                return "Serial";
            default:
                return "unknown type";
        }
    }

}
