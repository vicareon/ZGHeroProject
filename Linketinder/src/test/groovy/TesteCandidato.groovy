import controller.CandidatoController
import model.Candidato
import org.junit.AfterClass
import org.junit.Test

class TesteCandidato {
    @Test
    void testeInserirCandidato(){
        CandidatoController candidatoController = new CandidatoController()
        Candidato candidato = new Candidato("nome", "email", "cep", "estado", "pais", "descricao", "senha", "cpf", "formacaoAcademica", 99)
        candidatoController.inserirCandidato(candidato)
        println("\nTeste de adição de candidato realizado!\n")
    }

    @Test
    void testeDeletarCandidato(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.deletarCandidato("cpf")
        println("\nTeste de exclusão de candidato realizado!\n")
    }

    @Test
    void testeListarCandidatos(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.listarCandidatos()
        println("\nTeste de listagem de candidatos realizado!\n")
    }

    @Test
    void testeAtualizarNome(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarNome("nome atualizado", "cpf")
        println("\nTeste de atualização de nome de candidato realizado!\n")
    }

    @Test
    void testeAtualizarEmail(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarEmail("email atualizado", "cpf")
        println("\nTeste de atualização de email de candidato realizado!\n")
    }

    @Test
    void testeAtualizarCep(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarCep("cep atualizado", "cpf")
        println("\nTeste de atualização de CEP de candidato realizado!\n")
    }

    @Test
    void testeAtualizarEstado(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarEstado("estado atualizado", "cpf")
        println("\nTeste de atualização de estado de candidato realizado!\n")
    }

    @Test
    void testeAtualizarPais(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarPais("país atualizado", "cpf")
        println("\nTeste de atualização de país de candidato realizado!\n")
    }

    @Test
    void testeAtualizarDescricao(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarDescricao("descrição atualizada", "cpf")
        println("\nTeste de atualização de descrição de candidato realizado!\n")
    }

    @Test
    void testeAtualizarFormacaoAcademica(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarFormacaoAcademica("formação acadêmica atualizada", "cpf")
        println("\nTeste de atualização de formação acadêmica de candidato realizado!\n")
    }

    @Test
    void testeAtualizarIdade(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarIdade(77, "cpf")
        println("\nTeste de atualização de idade de candidato realizado!\n")
    }

    @Test
    void testeAtualizarSenha(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.atualizarSenha("novasenha", "cpf")
        println("\nTeste de atualização de senha de candidato realizado!\n")
    }

    @AfterClass
    static void excluirCandidatoTesteDepoisTodosOsTestes(){
        CandidatoController candidatoController = new CandidatoController()
        candidatoController.deletarCandidato("cpf")
        println("\nLimpeza de candidato teste concluída!\n")
    }
}