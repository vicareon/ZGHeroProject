import controller.CandidatoController
import controller.EmpresaController
import model.Candidato
import model.Empresa
import org.junit.AfterClass
import org.junit.Test

class TesteEmpresa {
    @Test
    void testeInserirEmpresa(){
        EmpresaController empresaController = new EmpresaController()
        Empresa empresa = new Empresa("nome", "email", "cep", "estado", "pais", "descricao", "senha", "cnpj")
        empresaController.inserirEmpresa(empresa)
        println("\nTeste de adição de empresa realizado!\n")
    }

    @Test
    void testeDeletarEmpresa(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.deletarEmpresa("cnpj")
        println("\nTeste de exclusão de empresa realizado!\n")
    }

    @Test
    void testeListarEmpresas(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.listarEmpresas()
        println("\nTeste de listagem de empresa realizado!\n")
    }

    @Test
    void testeAtualizarNome(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarNome("nome atualizado", "cnpj")
        println("\nTeste de atualização de nome de empresa realizado!\n")
    }

    @Test
    void testeAtualizarEmail(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarEmail("email atualizado", "cnpj")
        println("\nTeste de atualização de email de empresa realizado!\n")
    }

    @Test
    void testeAtualizarCep(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarCep("cep atualizado", "cnpj")
        println("\nTeste de atualização de CEP de empresa realizado!\n")
    }

    @Test
    void testeAtualizarEstado(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarEstado("estado atualizado", "cnpj")
        println("\nTeste de atualização de estado de empresa realizado!\n")
    }

    @Test
    void testeAtualizarPais(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarPais("país atualizado", "cnpj")
        println("\nTeste de atualização de país de empresa realizado!\n")
    }

    @Test
    void testeAtualizarDescricao(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarDescricao("descrição atualizada", "cnpj")
        println("\nTeste de atualização de descrição de empresa realizado!\n")
    }

    @Test
    void testeAtualizarSenha(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.atualizarSenha("novasenha", "cnpj")
        println("\nTeste de atualização de senha de empresa realizado!\n")
    }

    @AfterClass
    static void excluirCandidatoTesteDepoisTodosOsTestes(){
        EmpresaController empresaController = new EmpresaController()
        empresaController.deletarEmpresa("cnpj")
        println("\nLimpeza de candidato teste concluída!\n")
    }
}