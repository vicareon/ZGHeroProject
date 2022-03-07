package testesUnitarios

import acelerazg.PessoaFisica
import org.junit.Test


class TestePessoaFisica {
    //given
    def listaCandidatos = []
    def competencias = []

    //when
    @Test
    public void testePessoaFisica(){
        PessoaFisica pessoaFisicaTeste = new PessoaFisica("Teste de Nome", "emailteste@acelerazg.com", "80808-888", "Goiás", "Brasil", "Descrição de Teste", "080.808.080-80", 33)

        competencias << "Competência 1"
        competencias << "Competência 2"
        competencias << "Competência 3"

        pessoaFisicaTeste.setCompetencias(competencias as ArrayList)

        //then
        println(pessoaFisicaTeste.toString())
    }

    @Test
    void testeCadastroPessoaFisica(){
        PessoaFisica pessoaFisicaTeste = new PessoaFisica("Teste de Nome", "emailteste@acelerazg.com", "80808-888", "Goiás", "Brasil", "Descrição de Teste", "080.808.080-80", 33)

        competencias << "Competência 1"
        competencias << "Competência 2"
        competencias << "Competência 3"

        pessoaFisicaTeste.setCompetencias(competencias as ArrayList)

        //then
        listaCandidatos << pessoaFisicaTeste
    }
}
