import java.io.IOException;


public class Principal  
{

	
	public static void main(String[] args) 
	{
		
		ObexPutClient sp =new ObexPutClient();
		
		try {
			ObexPutClient.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
