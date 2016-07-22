package controlador;
import java.sql.*;

public class Conexion 
{     
    private static Connection conn;
        
    public static Connection CrearConexion()
    {
         //1.- Definir las credenciales de acceso a la BD
        String user = "root";
        String pas  = "root1234";
        String url  = "jdbc:mysql://localhost:3306/leica";
        //2.- Crear la conexión a la bd
        try
        {
            if(conn == null)        //Si la conexión es nula, se crea u na nueva.
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pas);
                return conn;
            }
            else                    //... sino, se devuelve la conexión existente.
                return conn;
                
        }
        catch(ClassNotFoundException c) // Excepción para forName
        {
            System.out.println("Excepción de clase: " +
                               "Clase de base de datos no enoontrada!");
            return null;
        }
        catch(SQLException e) //Excepcion para la conexión.
        {
            System.out.println("Excepción de SQL:" + e);
            return null;
        }
    }
}
