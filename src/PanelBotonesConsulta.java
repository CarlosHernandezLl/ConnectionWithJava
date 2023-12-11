package visorconsultas.vista;
import javax.swing.JPanel;
import javax.swing.JButton;
public class PanelBotonesConsulta extends JPanel{
    public JButton consultar, salir;
    public PanelBotonesConsulta() {
        iniciaComponentes();
        agregaComponentes();
    }
    private void iniciaComponentes(){
        consultar =new JButton("Consultar");
        consultar.setMnemonic('c');
        salir =new JButton("Salir");
        salir.setMnemonic('s');
    }
    private void agregaComponentes(){
        add(consultar);
        add(salir);
    }
}
