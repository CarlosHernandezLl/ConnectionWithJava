package visorconsultas.controlador;
import visorconsultas.vista.VentanaConsultas;

import javax.swing.*;
import java.awt.event.ActionEvent;
public class Controlador {

    visorconsultas.controlador.Conexion conMysql;

    public Controlador(){

    }

    public void acciones(VentanaConsultas visor, ActionEvent event){
        Object clicado = event.getSource();
        if (clicado ==visor.autenticador.panelAutenticador.aceptar){
            String host = visor.autenticador.panelAutenticador.servidor.getText();
            String usuario = visor.autenticador.panelAutenticador.usuario.getText();
            String pw = new String(visor.autenticador.panelAutenticador.password.getPassword());
            String base = visor.autenticador.panelAutenticador.base.getText();
            conMysql=new visorconsultas.controlador.Conexion(host,usuario,pw,base);
            if (conMysql.getConector()!=null){
                visor.autenticador.dispose();
            }
            else{
                muestraError("Error que manda Mysql es: \n"+conMysql.getMessageError());
            }
        }
        if(clicado == visor.botones.consultar){
            visorconsultas.controlador.ConsultasSQL consultasSQL =
                    new visorconsultas.controlador.ConsultasSQL(conMysql.getConector(),visor.area.textArea.getText());

            if (consultasSQL.getMessageError()==null){
                visor.resultados.modelo.setDataVector(consultasSQL.getDatosDevueltos(),
                        consultasSQL.getNombresColumnas());
            }
            else {
                muestraError("Error que manda Mysql es: \n"+conMysql.getMessageError());
            }
        }
        if(clicado==visor.autenticador.panelAutenticador.cancelar||clicado==visor.botones.salir){
            System.exit(0);
        }
    }

    private void muestraError( String e){
        javax.swing.JOptionPane.showMessageDialog(null,e);
    }

    public static void main(String[] args){
        new visorconsultas.vista.VentanaConsultas();
    }
}
