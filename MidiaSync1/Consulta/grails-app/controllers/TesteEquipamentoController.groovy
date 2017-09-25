class TesteEquipamentoController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ testeEquipamentoList: TesteEquipamento.list( params ) ]
    }

    def show = {
        def testeEquipamento = TesteEquipamento.get( params.id )

        if(!testeEquipamento) {
            flash.message = "TesteEquipamento not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ testeEquipamento : testeEquipamento ] }
    }

    def delete = {
        def testeEquipamento = TesteEquipamento.get( params.id )
        if(testeEquipamento) {
            testeEquipamento.delete()
            flash.message = "TesteEquipamento ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "TesteEquipamento not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def testeEquipamento = TesteEquipamento.get( params.id )

        if(!testeEquipamento) {
            flash.message = "TesteEquipamento not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ testeEquipamento : testeEquipamento ]
        }
    }

    def update = {
        def testeEquipamento = TesteEquipamento.get( params.id )
        if(testeEquipamento) {
            testeEquipamento.properties = params
            if(!testeEquipamento.hasErrors() && testeEquipamento.save()) {
                flash.message = "TesteEquipamento ${params.id} updated"
                redirect(action:show,id:testeEquipamento.id)
            }
            else {
                render(view:'edit',model:[testeEquipamento:testeEquipamento])
            }
        }
        else {
            flash.message = "TesteEquipamento not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def testeEquipamento = new TesteEquipamento()
        testeEquipamento.properties = params
        return ['testeEquipamento':testeEquipamento]
    }

    def save = {
        def testeEquipamento = new TesteEquipamento(params)
        if(!testeEquipamento.hasErrors() && testeEquipamento.save()) {
            flash.message = "TesteEquipamento ${testeEquipamento.id} created"
            redirect(action:show,id:testeEquipamento.id)
        }
        else {
            render(view:'create',model:[testeEquipamento:testeEquipamento])
        }
    }
}
