package visorconsultas.vista;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class AreaConsulta extends JScrollPane{

    public JTextArea textArea;
    public AreaConsulta(){
        textArea = new JTextArea(4,30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setViewportView(textArea);
    }
}
