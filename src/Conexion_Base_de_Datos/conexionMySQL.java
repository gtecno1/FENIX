/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion_Base_de_Datos;
import java.sql.*;
import javax.swing.JOptionPane;
public class conexionMySQL {
    
   public String db = "cnae";
   public String url = "jdbc:mysql://localhost/"+db;
   public String user = "root";
   public String pass = "";
   public Statement comando=null;
   
   public conexionMySQL()
   {
     
   }

   
   public Connection Conectar()
   {
       Connection link = null;
       try
       {
          //Cargamos el Driver MySQL
           Class.forName ("org.gjt.mm.mysql.Driver");
            // Creamos un enlace hacia la base de datos
           link = DriverManager.getConnection(this.url, this.user, this.pass);
       }
       catch (Exception e)
       {
        JOptionPane.showMessageDialog (null, e);
       } 
       return link;
   }
}