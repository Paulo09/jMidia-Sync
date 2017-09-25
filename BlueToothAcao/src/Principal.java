import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.bind.ParseConversionEvent;

import sun.io.Converters;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;


public class Principal extends BlueToothLocaliza {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		//int opc=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a Opção:"));
		//if(opc==1)
		//{
		 //BlueToothLocaliza sp=new BlueToothLocaliza();
		 //sp.BlueToothScanner();
		//}
		//else
		//{
			//JOptionPane.showMessageDialog(null,"Opção Não Válida!");
		//}
		BlueToothLocaliza sp1=new BlueToothLocaliza();
		sp1.BlueToothScanner();
			
				
			
	}

}
