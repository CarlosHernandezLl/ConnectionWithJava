package visorconsultas.vista;
import javax.swing.JDialog;
public class DialogoAutenticador extends JDialog {
    public visorconsultas.vista.PanelAutenticador panelAutenticador;

    public DialogoAutenticador(){
        panelAutenticador=new visorconsultas.vista.PanelAutenticador();
        add(panelAutenticador);
        setSize(330,150);
    }


}
