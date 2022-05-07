import controller.CandidatoController
import controller.CompetenciaController
import model.Competencia
import model.Candidato
import org.junit.AfterClass
import org.junit.Test
import static org.junit.Assert.*

class TesteCompetencia {
    @Test
    void testeInserirCompetencia(){
        CompetenciaController competenciaController = new CompetenciaController()
        Competencia competencia = new Competencia("Competência Teste")
        competenciaController.inserirCompetencia(competencia)
        println("\nTeste de adição de competência realizado!\n")
    }

    @Test
    void testeDeletarCompetencia(){
        CompetenciaController competenciaController = new CompetenciaController()
        competenciaController.deletarCompetencia("Competência Teste")
        println("\nTeste de remoção de competência realizado!\n")
    }

    @Test
    void testeListarCompetencias(){
        CompetenciaController competenciaController = new CompetenciaController()
        competenciaController.listarCompetencias()
        println("\nTeste de listagem de competências realizado!\n")
    }

    @Test
    void testeAtualizarCompetencia(){
        CompetenciaController competenciaController = new CompetenciaController()
        competenciaController.atualizarCompetencia("Competência Teste", "Nome Atualizado")
        println("\nTeste de atualização de competência realizado!\n")
    }

    @AfterClass
    static void excluirCompetenciaTesteDepoisTodosOsTestes(){
        CompetenciaController competenciaController = new CompetenciaController()
        competenciaController.deletarCompetencia("Competência Teste")
        println("\nLimpeza de candidato teste concluída!\n")
    }
}