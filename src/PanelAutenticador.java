package visorconsultas.vista;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class PanelAutenticador extends JPanel {

    //Creamos los componentes necesarios
    //3 cuadros de texto
    public JTextField servidor,usuario,base;
    //1 cuadro para contraseñas
    public JPasswordField password;
    //Dos botones
    public JButton aceptar, cancelar;

    public PanelAutenticador(){

        iniciaComponentes();
        agregaComponentes();
    }

    private void iniciaComponentes(){
        servidor= new JTextField();
        usuario= new JTextField();
        password= new JPasswordField();
        base=new JTextField();
        aceptar=new JButton("Aceptar");
        aceptar.setMnemonic('a');
        cancelar=new JButton("Cancelar");
        cancelar.setMnemonic('c');

    }

    private void agregaComponentes(){
        setLayout(new GridLayout(5,2));
        add(new JLabel("Servidor",JLabel.RIGHT));
        add(servidor);
        add(new JLabel("Usuario",JLabel.RIGHT));
        add(usuario);
        add(new JLabel("Contraseña",JLabel.RIGHT));
        add(password);
        add(new JLabel("Base de Datos",JLabel.RIGHT));
        add(base);
        add(aceptar);
        add(cancelar);
    }



}
