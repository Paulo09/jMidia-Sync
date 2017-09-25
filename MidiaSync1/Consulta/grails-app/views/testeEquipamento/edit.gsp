

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title><b>>> EDITAR DADOS DO EQUIPAMENTO</b></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Menu Principal</a></span>
            <span class="menuButton"><g:link class="list" action="list">Lista de Equipamentos</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">Novo Equipamento</g:link></span>
        </div>
        <div class="body">
            <h1><b>>> EDITAR DADOS DO EQUIPAMENTO</b></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${testeEquipamento}">
            <div class="errors">
                <g:renderErrors bean="${testeEquipamento}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${testeEquipamento?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nomecliente"><b>Nome Equipamento:</b></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:testeEquipamento,field:'nomecliente','errors')}">
                                    <input type="text" id="nomecliente" name="nomecliente" value="${fieldValue(bean:testeEquipamento,field:'nomecliente')}"/>
                                </td>
                            </tr> 
							
							<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="nomecliente"><b>Id Equipamento:</b></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:testeEquipamento,field:'id','errors')}">
                                    <input type="text" id="id" name="id" value="${fieldValue(bean:testeEquipamento,field:'id')}"/>
                                </td>
                            </tr> 
							<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cadastro_data"><b>Data do Cadastro:</b></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:testeEquipamento,field:'cadastro_data','errors')}">
                                    <g:datePicker name="cadastro_data" value="${testeEquipamento?.cadastro_data}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Salvar" action="Update"/></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Deseja Deletar os Dados?');" value="Deletar" action="Delete"/></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
