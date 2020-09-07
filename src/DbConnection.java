
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NCC
 */
public class DbConnection{
   public static Connection conn=null;
   public static PreparedStatement ps;
       
  public static  Connection connect(){
//     Connection conn=null;
      
//        PreparedStatement ps;
        ResultSet rs;
        try {
          Class.forName("org.sqlite.JDBC");  
            conn=DriverManager.getConnection("jdbc:sqlite:IcecreamParlour.sqlite");
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, "connection fail");
        }
        return conn;
        
  }
     public static void ddispose()
        {
       try {
            ps.close();
           conn.close();
         
       } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "connection not closed by dispose");
       }
        }
  
}
