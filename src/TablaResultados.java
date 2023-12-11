package visorconsultas.vista;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import visorconsultas.modelo.ModeloTabla;
import javax.swing.table.TableModel;
public class TablaResultados extends JScrollPane {
    public ModeloTabla modelo;//Crea una instancia del modelo
    public JTable tabla;
    public TablaResultados() {
        modelo=new ModeloTabla();
        tabla=new JTable(modelo);//Se asigna el modelo a la tabla al momento de construirla
//Las columnas se autoajustan
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        setViewportView(tabla); //La tabla se verá dentro del panel de barras de desplazamiento
    }
}
