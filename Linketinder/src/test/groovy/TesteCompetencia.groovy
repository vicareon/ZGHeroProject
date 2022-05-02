import org.junit.Test
import static org.junit.Assert.*

class TesteCompetencia {
    Pessoa candidato = new PessoaFisica()
    Competencia competencia = new Competencia("Competência Teste")
    ArrayList<Competencia> listaCompetencias = new ArrayList<Competencia>()

    @Test
    void testeAdicionarCompetencia(){
        candidato.setListaCompetencias(listaCompetencias)
        candidato.getListaCompetencias() << competencia

        assertTrue(candidato.getListaCompetencias().contains(competencia))
    }

    @Test
    void testeRemoverCompetencia(){
        candidato.setListaCompetencias(listaCompetencias)
        candidato.getListaCompetencias() << competencia
        candidato.getListaCompetencias().remove(competencia)

        assertFalse(candidato.getListaCompetencias().contains(competencia))
    }
}