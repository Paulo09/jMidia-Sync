<html>
  <head>
	  <title>TELA DE ERRO: FAVOR ENTRAR EM CONTATO COM PAULO CASTRO FONE: 870187279 ou paullocasttro@gmail.com</title>
	  <style type="text/css">
	  		.message {
	  			border: 1px solid black;
	  			padding: 5px;
	  			background-color:#E9E9E9;
	  		}
	  		.stack {
	  			border: 1px solid black;
	  			padding: 5px;	  		
	  			overflow:auto;
	  			height: 300px;
	  		}
	  		.snippet {
	  			padding: 5px;
	  			background-color:white;
	  			border:1px solid black;
	  			margin:3px;
	  			font-family:courier;
	  		}
	  </style>
  </head>
  
  <body>
    <h1><b>TELA DE ERRO: FAVOR ENTRAR EM CONTATO COM PAULO CASTRO FONE: 870187279 ou paullocasttro@gmail.com</b></h1>
    <h2><b>DETALHES DO ERRO</b></h2>
  	<div class="message">
  		<strong>Mensagem:</strong> ${exception.message?.encodeAsHTML()} <br />
  		<strong>Causa do Erro:</strong> ${exception.cause?.message?.encodeAsHTML()} <br />
  		<strong>Classe de Erro:</strong> ${exception.className} <br />  		  		
  		<strong>linha Afetada:</strong> [${exception.lineNumber}] <br />  		
  		<strong>Código:</strong><br />   		
  		<div class="snippet">
  			<g:each var="cs" in="${exception.codeSnippet}"> 
  				${cs?.encodeAsHTML()}<br />  			
  			</g:each>  	
  		</div>	  		
  	</div>
    <h2>Stack Trace</h2>
    <div class="stack">
      <pre><g:each in="${exception.stackTraceLines}">${it.encodeAsHTML()}<br/></g:each></pre>
    </div>
  </body>
</html>