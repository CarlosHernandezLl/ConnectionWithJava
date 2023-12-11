package visorconsultas.vista;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visorconsultas.controlador.Controlador;
public class VentanaConsultas extends JFrame implements ActionListener {
    public visorconsultas.vista.DialogoAutenticador autenticador;
    public visorconsultas.vista.TablaResultados resultados;
    public visorconsultas.vista.AreaConsulta area;
    public visorconsultas.vista.PanelBotonesConsulta botones;
    public visorconsultas.controlador.Controlador controlDe;
    public VentanaConsultas() {
        iniciaComponentes();
        agregaComponentes();
        agregaListeners();
        inicio();
    }
    private void iniciaComponentes(){
        autenticador=new visorconsultas.vista.DialogoAutenticador();
        resultados=new visorconsultas.vista.TablaResultados();
        area=new visorconsultas.vista.AreaConsulta();
        botones=new visorconsultas.vista.PanelBotonesConsulta();
    }
    private void agregaComponentes(){
        add(resultados,"South");
        add(area,"West");
        add(botones,"East");
        pack();
        setLocation(100,100);
    }
    private void agregaListeners(){
        this.autenticador.panelAutenticador.aceptar.addActionListener(this);
        this.autenticador.panelAutenticador.cancelar.addActionListener(this);
        botones.consultar.addActionListener(this);
        botones.salir.addActionListener(this);
    }
    public void inicio(){
        controlDe=new visorconsultas.controlador.Controlador();
        setVisible(true);
        autenticador.setLocationRelativeTo(this);
        autenticador.setModal(true);
        autenticador.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt){
        controlDe.acciones(this,evt);
    }
}