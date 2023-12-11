//Vamos a realizar la conexion a la base de datos
package visorconsultas.controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conector;
    String error;

    public Conexion(String host, String user, String password, String base){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conector=DriverManager.getConnection("jdbc:mysql://"+host+"/"+base,user,password);

        }catch (ClassNotFoundException e){
            error=e.getMessage();
        }
        catch (SQLException e){
            error=e.getMessage();
        }
    }

    public Connection getConector() {
        return conector;
    }

    public void closeConector(){
        try {
            conector.close();
        }catch (Exception e){}
    }

    public String getMessageError(){
        return error;
    }
}
