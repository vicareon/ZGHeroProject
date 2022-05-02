import org.junit.Test
import static org.junit.Assert.*

class TesteVaga {
    Vaga vaga = new Vaga()
    Pessoa empresa = new PessoaJuridica()
    Competencia competencia = new Competencia("Competência Teste")
    ArrayList<Competencia> listaCompetencias = new ArrayList<Competencia>()

    @Test
    void testeAdicionarCompetencia(){
        vaga.setListaCompetencias(listaCompetencias)
        vaga.getListaCompetencias() << competencia

        assertTrue(vaga.getListaCompetencias().contains(competencia))
    }

    @Test
    void testeRemoverCompetencia(){
        vaga.setListaCompetencias(listaCompetencias)
        vaga.getListaCompetencias() << competencia
        vaga.getListaCompetencias().remove(competencia)

        assertFalse(vaga.getListaCompetencias().contains(competencia))
    }

    @Test
    void testeAdicionarNomeEmpresa(){
        empresa.setNome("Nome da Empresa")
        vaga.setNomeEmpresa(empresa)

        assertTrue(vaga.getNomeEmpresa() == empresa.getNome())
    }
}
