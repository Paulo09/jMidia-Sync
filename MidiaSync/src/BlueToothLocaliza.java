import java.io.IOException;   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;   
import javax.bluetooth.*;   
import javax.swing.JOptionPane;
  
public class BlueToothLocaliza 
{ 
    
	public static final Vector/*<RemoteDevice>*/ devicesDiscovered = new Vector();
	
    public String GetID() 
    {   
        //System.out.println("Dispositivo " + btDevice.getBluetoothAddress() + " encontrado");   
        
    	  {
    	
        try 
        {  
        	RemoteDevice btDevice = null;
		    System.out.println("Nome " + btDevice.getFriendlyName(false));
            System.out.println("ID:"+btDevice.getBluetoothAddress());
            devicesDiscovered.addElement(btDevice);  
        } 
        catch (IOException cantGetDeviceName) 
        {   
        }   
    }
		return GetID();
		
    }
  ///----------------------------------------------------------
    
    public void BlueToothScanner()
    {   
           	
    	final Object inquiryCompletedEvent = new Object();   
  
        devicesDiscovered.clear();   
  
        DiscoveryListener listener = new DiscoveryListener() {   
  
         public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) 
            {    
                //System.out.println("Dispositivo " + btDevice.getBluetoothAddress() + " encontrado");   
                
            	  {
            	
                try 
                {   System.out.println("Nome" + btDevice.getFriendlyName(false));
                    System.out.println("ID:"+btDevice.getBluetoothAddress());
                    
                         
                    if (btDevice.getBluetoothAddress() != null)
                    {
                    	
                    	String ID 	= btDevice.getBluetoothAddress();
                    	String Nome = btDevice.getFriendlyName(false);
                    	
                    	PostgresConexao   con = new PostgresConexao();
                		
                		               	    	
                		String sql="SELECT * FROM Equipamento  WHERE  ID = '";
                		sql = sql+ID+"'";
                		con.Exite(sql,ID,Nome);
                		
                    }
                    devicesDiscovered.addElement(btDevice);  
                } 
                catch (IOException cantGetDeviceName) 
                {   
                }   
            }   
            }
           
            
           public void inquiryCompleted(int discType) 
            {   
                System.out.println("Terminada Busca de Aparelho!");   
                synchronized(inquiryCompletedEvent)
                {   
                    inquiryCompletedEvent.notifyAll();   
                }   
            }   
  
            public void serviceSearchCompleted(int transID, int respCode) 
            {   
            }   
  
            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) 
            {   
            }   
        };   
  
        synchronized(inquiryCompletedEvent) 
        {   
            boolean started = false;
			try 
			{
				started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
			} 
			catch (BluetoothStateException e) 
			{
			  e.printStackTrace();
			}   
            if (started)
            {   
                System.out.println("Espere Completar a Busca por Dispositivos...");   
                try {
					inquiryCompletedEvent.wait();
				} catch (InterruptedException e) 
				{
					
					e.printStackTrace();
				}   
                System.out.println(devicesDiscovered.size() +  "Aparelho Encontrado!");   
            }   
        }
		 
    }   
  
}  