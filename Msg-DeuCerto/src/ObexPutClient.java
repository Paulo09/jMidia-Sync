import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
import javax.obex.Operation;
import javax.obex.ResponseCodes;
import java.io.File;
import java.io.FileInputStream;

public class ObexPutClient 
{

    public static void main(String[] args) throws IOException, InterruptedException 
    {

        String serverURL = null; // = "btgoep://0019639C4007:6"
        
        if ((args != null) && (args.length > 0)) 
        {
            serverURL = args[0];
        }
        
        if (serverURL == null) 
        {
            String[] searchArgs = null;
            // Connect to OBEXPutServer from examples
            // searchArgs = new String[] { "11111111111111111111111111111123" };
           
            ServicesSearch.main(searchArgs);
            if (ServicesSearch.serviceFound.size() == 0) 
            {
                System.out.println("OBEX service not found");
                return;
            }
            // Select the first service found
            serverURL = (String)ServicesSearch.serviceFound.elementAt(0);
        }

        System.out.println("Connecting to " + serverURL);

        ClientSession clientSession = (ClientSession) Connector.open(serverURL);
        HeaderSet hsConnectReply = clientSession.connect(null);
        if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) 
        {
            System.out.println("Failed to connect");
            return;
        }


        File f = new File("c:\\Apetite.jpg" );
        
        HeaderSet hsOperation = clientSession.createHeaderSet();
        hsOperation.setHeader(HeaderSet.NAME, f.getName());
        hsOperation.setHeader(HeaderSet.TYPE,"image/jpg");
        hsOperation.setHeader(HeaderSet.LENGTH, new Long(f.length()));

                
        //Create PUT Operation
        Operation putOperation = clientSession.put(hsOperation);

                  
        //***************************************************************
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
