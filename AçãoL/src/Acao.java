/*
 * Projeto:   			BlueSync
 * 
 * Descrição: 			Controle e envio de propogandas para dispositivos bluetooth
 * 			  			Envio de midias. Imagens / Audio / Video
 * 
 * Responsaveis:		Paulo Sergio
 * 						Leandro Neves
 * 
 * Ultima Alteração:	21/04/2008
 * 				   :    Interação com banco de dados, cadastrando o dispositivo 
 * 						quando encontrado pela primeira vez e no historico nas
 * 						identificações posteriores;
 * 						Alteração nome das da classe ObexPutClient para Propaganda
 * 						Criação da classe Acao.
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
