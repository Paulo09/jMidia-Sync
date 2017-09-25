import java.beans.Statement; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import javax.bluetooth.DeviceClass;
import javax.bluetooth.RemoteDevice;
import javax.swing.JOptionPane;

public class PostgresConexao extends BlueToothLocaliza
{ 
 	

public void Exite(String sql, String id,String nome)
	{
    Connection conn = null;
    String sql_insert = null;
  try
  { 
    Class.forName("org.postgresql.Driver"); 
    conn = DriverManager.getConnection("jdbc:postgresql:BLUETOOTH", "postgres","123456"); 
    
    //System.out.println("Sucesso na conexão!"); 
    java.sql.Statement stm = conn.createStatement(); 
    ResultSet rs = ((java.sql.Statement) stm).executeQuery(sql);
  
    if (rs.next()) 
    {
    	String linha1  = rs.getString("NomeCliente");
 	    String linha2  = rs.getString("ID");
        String linha3  = rs.getString("Equipamento");

        System.out.println("----------------------");
        System.out.println("Nome Cliente:" + linha1);
        System.out.println("IdEquipamento:"+ linha2);
        System.out.println("Equipamento:"  + linha3);
        System.out.println("----------------------");
        
    }
    else if (id != null)
    {
    	 sql_insert = "INSERT INTO equipamento (id, nomecliente) VALUES('"+id+"', '"+nome+"')";
    	 stm.execute(sql_insert);
    	    	
    }
    
  }
 
  catch (ClassNotFoundException e) 
  { 
   System.out.println("excessao ClassNotFound..."); 
   e.printStackTrace(); 
  }
  catch (SQLException e) 
   { 
    System.out.println("Erro da Porra!"); 
    e.printStackTrace(); 
   }
  finally 
  { 
try
  { 
   conn.close(); 
  }
 catch (SQLException onConClose) 
    { 
     System.out.println("error on closing"); 
     onConClose.printStackTrace(); 
    } 
    }

  }

	
 } 
