import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.Enumeration;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import javax.bluetooth.RemoteDevice;
import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
import javax.obex.Operation;
import javax.obex.ResponseCodes;
import java.io.File;
import java.io.FileInputStream;

public class Propaganda
{ 
 	public final String classDriver  = "org.postgresql.Driver"; 
 	public final String driver 	 	 = "jdbc:postgresql:BLUETOOTH";  
 	public final String usuario 	 = "postgres";
 	public final String senha 		 = "123456";
	
	public void Exite(String id, String nome)
	{
      Connection conn = null;
      String sql_select = "SELECT id, nomecliente FROM equipamento WHERE id = '" + id + "'";
      String sql_insert = null;
      
	  try
	  { 
	    Class.forName(classDriver); 
	    conn = DriverManager.getConnection(driver, usuario, senha); 
	    
	    java.sql.Statement stm = conn.createStatement(); 
	    ResultSet rs = ((java.sql.Statement) stm).executeQuery(sql_select);
	  
	    if (rs.next()) 
	    {
	    	 sql_insert = "INSERT INTO equipamentomovimento (id, movimento_data, movimento_time) VALUES('"+id+"', now(), now())";
	    	 stm.execute(sql_insert);
	    }
	    else
	    {
	    	 sql_insert = "INSERT INTO equipamento (id, nomecliente, cadastro_data, cadastro_time) VALUES('"+id+"', '"+nome+"', now(), now())";
	    	 stm.execute(sql_insert);
	    }
	    
	  }
	 
	  catch (ClassNotFoundException e) 
	  { 
	   System.out.println("Erro: " + e.getMessage()); 
	   e.printStackTrace(); 
	  }
	  
	  catch (SQLException e) 
	   { 
	    System.out.println("Erro: " + e.getMessage()); 
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
			System.out.println("Erro ao fechar conexão"); 
			onConClose.printStackTrace(); 
	      } 
	  }
	
	}

	public void Enviar(String[] args) throws IOException, InterruptedException, ClassNotFoundException 
	    {
			  String serverURL 		= null; // = "btgoep://0019639C4007:6"
	    	  String url_arquivo	= null;
	    	  String tipo_arquivo	= null;
	    	  
	          if ((args != null) && (args.length > 0)) 
	          {
	              serverURL = args[0];
	          }
	          
	          if (serverURL == null) 
	          {
	              String[] searchArgs = null;
	              
	              ServicesSearch.main(searchArgs);
	              if (ServicesSearch.serviceFound.size() == 0) 
	              {
	                  System.out.println("OBEX service not found");
	            	  //System.out.println("Equipamento sem surporte para envio de arquivos!");
	            	  return;
	              }
	              
	              serverURL = (String)ServicesSearch.serviceFound.elementAt(1);
	          }

	          System.out.println(serverURL);
	          //***********************************************************************
	          //Recupera arquivo a ser enviado
	          
	          String dispositivo = serverURL ;
	          
	          Connection conn = null;
	    	  String sql_select = "SELECT promocao.promocao, promocao.descricao, promocaoitens.promocaoitens, promocaoitens.url, promocaoitens.tipo" +
	    		"			 FROM promocao" +
	    		"			 INNER JOIN promocaoitens ON (promocao.promocao = promocaoitens.promocao)" +
	    		"			 WHERE promocao.aberto	= 'A' " +
	    		"			 AND   promocao.promocao not in (SELECT promocao " +
	    		"											FROM equipamentopromocaolojista" +
	    		"											WHERE id = '" +	dispositivo.substring(9, 21) + "' " +
	    		"											AND   equipamentopromocaolojista.promocao = promocao.promocao " +
	    		"											AND   equipamentopromocaolojista.promocaoitens = promocaoitens.promocaoitens)";
	    	  
	          try
	    	  { 
	    	    Class.forName(classDriver); 
	    	    conn = DriverManager.getConnection(driver, usuario, senha); 
	    	    
	    	    
	    	    java.sql.Statement stm = conn.createStatement(); 
	    	    ResultSet rs = ((java.sql.Statement) stm).executeQuery(sql_select);
	    	  
	    	    if (rs.next()) 
	    	    {
	    	    	url_arquivo  	= "c:\\" + rs.getString("url");
		            tipo_arquivo 	= rs.getString("tipo");
		            String promocao = rs.getString("promocao");
		            String itens = rs.getString("promocaoitens");
		            
		            String sql_insert = "INSERT INTO equipamentopromocaolojista (promocao, promocaoitens, id, envio_time, envio_data) " +
		            		"			 VALUES (" + promocao + ", " + itens +", '" + dispositivo.substring(9, 21) + "', now(), now())";
		            
		            stm.execute(sql_insert);
		            
	    	    }
	    	    
	    	  }
	    	  catch (SQLException e) 
		   	   { 
		   	    System.out.println("Erro: " + e.getMessage()); 
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
		   			System.out.println("Erro ao fechar conexão"); 
		   			onConClose.printStackTrace(); 
		   	      } 
		   	  }	    	
	          //***********************************************************************

			  
			  //**************************************************************
			  //Caso exista propaganda a ser enviada.
			  if (url_arquivo != null) {
		          
	        	  ClientSession clientSession = (ClientSession) Connector.open(serverURL);
		          HeaderSet hsConnectReply = clientSession.connect(null);
		          if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) 
		          {
		              System.out.println("Falha na conexão!");
		              return;
		          }

		          
	        	  
		          File f = new File(url_arquivo);
		          
		          HeaderSet hsOperation = clientSession.createHeaderSet();
		          hsOperation.setHeader(HeaderSet.NAME, f.getName());
		          hsOperation.setHeader(HeaderSet.TYPE, tipo_arquivo);
		          hsOperation.setHeader(HeaderSet.LENGTH, new Long(f.length()));
		                  
		          //Create PUT Operation
		          Operation putOperation = clientSession.put(hsOperation);
	
		          //***********************************************************************
		          //Ler arquivo de forma binaria.
		          long length = f.length();
		          byte[] data = new byte[(int)length];
		          InputStream is = new FileInputStream(f);
	
		          // Read in the bytes
		          int offset = 0;
		          int numRead = 0;
		          while (offset < data.length
		                 && (numRead=is.read(data, offset, data.length-offset)) >= 0) {
		              offset += numRead;
		          }
		          //**************************************************************
		          
		          OutputStream os = putOperation.openOutputStream();
		          os.write(data);
		          os.close();
	
		          putOperation.close();
	
		          clientSession.disconnect(null);
	
		          clientSession.close();
	          }
	    }

} 
