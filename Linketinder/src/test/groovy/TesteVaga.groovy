import controller.EmpresaController
import controller.VagaController
import model.Competencia
import model.Empresa
import model.Vaga
import org.junit.AfterClass
import org.junit.Test
import static org.junit.Assert.*

class TesteVaga {
    @Test
    void testeListarVagas(){
        VagaController vagaController = new VagaController()
        vagaController.listarVagas()
        println("\nTeste de listagem de vagas realizado!\n")
    }

    @Test
    void testeAdicionarVaga(){
        VagaController vagaController = new VagaController()
        ArrayList<Competencia> listaCompetencias = new ArrayList<Competencia>()
        Vaga vaga = new Vaga("nome", "estado", "descricao", "nome empresa", listaCompetencias)
        vagaController.inserirVaga(vaga)
        println("\nTeste de inserção de competência realizado!\n")
    }

    @Test
    void testeRemoverVaga(){
        VagaController vagaController = new VagaController()
        vagaController.deletarVaga("cnpj empresa")
        println("\nTeste de remoção de vaga realizado!\n")
    }

    @Test
    void testeAtualizarNome(){
        VagaController vagaController = new VagaController()
        vagaController.atualizarNome("nome atualizado", "cnpj")
        println("\nTeste de atualização de nome de empresa realizado!\n")
    }

    @Test
    void testeAtualizarEstado(){
        VagaController vagaController = new VagaController()
        vagaController.atualizarEstado("estado atualizado", "cnpj")
        println("\nTeste de atualização de estado de empresa realizado!\n")
    }

    @Test
    void testeAtualizarDescricao(){
        VagaController vagaController = new VagaController()
        vagaController.atualizarDescricao("descrição atualizada", "cnpj")
        println("\nTeste de atualização de descrição de empresa realizado!\n")
    }

    @AfterClass
    static void excluirVagaTesteDepoisTodosOsTestes(){
        VagaController vagaController = new VagaController()
        vagaController.deletarVaga("cnpj empresa")
        println("\nLimpeza de vaga teste concluída!\n")
    }
}
