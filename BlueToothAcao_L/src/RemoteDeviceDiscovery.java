import java.io.IOException;
import java.util.Vector;
import javax.bluetooth.*;

/**
 * Minimal Device Discovery example.
 */

public class RemoteDeviceDiscovery {

    public static final Vector/*<RemoteDevice>*/ devicesDiscovered = new Vector();

    public static void main(String[] args) throws IOException, InterruptedException {

        final Object inquiryCompletedEvent = new Object();
        
        devicesDiscovered.clear();

        DiscoveryListener listener = new DiscoveryListener() {

        	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
        		
        		devicesDiscovered.addElement(btDevice);
            	try {
            		
                System.out.println("Equipamento Encontrado: " + btDevice.getBluetoothAddress() +" - " +btDevice.getFriendlyName(false));
            		
            	Propaganda dados = new Propaganda();
            	dados.Exite(btDevice.getBluetoothAddress(),btDevice.getFriendlyName(false));
            	}
            	catch (IOException cantGetDeviceName) {
            	}
            }

            public void inquiryCompleted(int discType) {
                synchronized(inquiryCompletedEvent){
                    inquiryCompletedEvent.notifyAll();
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
        };

        synchronized(inquiryCompletedEvent) {
        	
        	
        	boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            
            
            if (started) {
                System.out.println("Localizando equipamentos...");
                inquiryCompletedEvent.wait();
            }
        }
    }

}