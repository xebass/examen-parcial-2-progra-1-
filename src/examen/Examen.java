
package examen;
import conexion.CreateConnection;
import java.sql.*;

public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreateConnection cn = new CreateConnection();
        cn.getConnection();
    }
    
}
