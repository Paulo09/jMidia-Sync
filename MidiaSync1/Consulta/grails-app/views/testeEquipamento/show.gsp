

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>DADOS DO CADASTRO</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Menu Principal</a></span>
            <span class="menuButton"><g:link class="list" action="list">Lista de Equipamentos</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Novo Equipamento</g:link></span>
        </div>
        <div class="body">
            <h1><b>>> DADOS DO CADASTRO</b></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                        <tr class="prop">
                            <td valign="top" class="name"><b>Nome Equipamento:</b></td>
                            
                            <td valign="top" class="value">${fieldValue(bean:testeEquipamento, field:'nomecliente')}</td>
                            
                        </tr>                       
                        <tr class="even">
				        <td colspan="4" nowrap="nowrap">
				        <hr />
				        </td>
				        </tr>						
                        <tr class="prop">
                            <td valign="top" class="name"><b>Id Equipamento:</b></td>
                            
                            <td valign="top" class="value">${fieldValue(bean:testeEquipamento, field:'id')}</td>
                            
                        </tr>
						<tr class="even">
				        <td colspan="4" nowrap="nowrap">
				        <hr />
				        </td>
				        </tr> 
                        <tr class="prop">
                            <td valign="top" class="name"><b>Data do Cadastro:</b></td>
                            
                            <td valign="top" class="value">${fieldValue(bean:testeEquipamento, field:'cadastro_data')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${testeEquipamento?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Editar" action="Edit"/></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Deseja Deletar os Dados?');" value="Deletar" action="Delete"/></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
