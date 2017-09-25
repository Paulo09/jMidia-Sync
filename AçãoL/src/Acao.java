/*
 * Projeto:   			BlueSync
 * 
 * Descri��o: 			Controle e envio de propogandas para dispositivos bluetooth
 * 			  			Envio de midias. Imagens / Audio / Video
 * 
 * Responsaveis:		Paulo Sergio
 * 						Leandro Neves
 * 
 * Ultima Altera��o:	21/04/2008
 * 				   :    Intera��o com banco de dados, cadastrando o dispositivo 
 * 						quando encontrado pela primeira vez e no historico nas
 * 						identifica��es posteriores;
 * 						Altera��o nome das da classe ObexPutClient para Propaganda
 * 						Cria��o da classe Acao.
 */

import java.io.IOException;

public class Acao {

 public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException
 	{
	 
	 int i=0;
	 
	 while (i < 10){
		 Propaganda propaganda = new Propaganda();
		 propaganda.Enviar(null);
	      
	 i++;
	 }
 	}
}
