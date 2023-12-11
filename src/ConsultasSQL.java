package visorconsultas.controlador;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
public class ConsultasSQL {

    private Connection conexion;
    private ResultSet resultadoConsulta;
    private ResultSetMetaData metaData;
    private String consulta;

    //Creamos dos arreglos
    private String[][] datosDevueltos;
    private String[] nombresColumnas;
    private String error;


    public ConsultasSQL(Connection conRecibida, String consultaRecibida){
        conexion=conRecibida;
        consulta=consultaRecibida;

        try {
            //Creamos una instancia para mandar sentencias al servidor Mysql
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //Ejecutamos la consulta y devolvemos el ResultSet
            resultadoConsulta = sentencia.executeQuery(consulta);
            //Obtiene los metadatos del ResultSet
            metaData = resultadoConsulta.getMetaData();
            error = null;
        }catch (SQLException e){
            error=e.getMessage();
        }
    }

    public String[][] getDatosDevueltos(){
        if (error==null){
            try{
                //Devuelve el numero de columnas del resulset
                int columnas=metaData.getColumnCount();
                //Lleva el cursor a la ultima fila del resulset
                resultadoConsulta.last();
                //Obtiene el numero de fila actual
                int filas= resultadoConsulta.getRow();
                //dimensionamos el arreglo DatoDevueltos con los enteros obtenidos
                datosDevueltos= new String[filas][columnas];
                //Ubica el cursor antes de la primera fila
                resultadoConsulta.beforeFirst();
                for (int i=0;i<filas;i++){
                    //Va la siguiente fila
                    resultadoConsulta.next();
                    for (int j=0;j<columnas;j++){
                        datosDevueltos[i][j]= resultadoConsulta.getString(j+1);
                        //System.out.println(datosDevueltos[i][j] + " ");
                    }
                    //System.out.println();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return datosDevueltos;
    }

    public String[] getNombresColumnas(){
        if (error==null){
            try {
                //Devuelve el numero de columnas
                int columnas=metaData.getColumnCount();
                nombresColumnas=new String[columnas];
                for (int i=0;i<columnas;i++){
                    //Obtiene el nombre de cada una de las columnas
                    nombresColumnas[i]=metaData.getColumnLabel(i+1);
                }
            }catch (SQLException ex){

            }
        }
        return nombresColumnas;
    }

    public String getMessageError(){
        return error;
    }

}
