package testesUnitarios

import acelerazg.PessoaJuridica
import org.junit.Test

class TestePessoaJuridica {
    //given
    def listaEmpresas = []
    def competencias = []

    //when
    @Test
    public void testePessoaJuridica(){
        PessoaJuridica pessoaJuridicaTeste = new PessoaJuridica("Teste de Nome", "emailteste@acelerazg.com", "80808-888", "Goiás", "Brasil", "Descrição de Teste", "080.808.080-80")

        //then
        println(pessoaJuridicaTeste.toString())
    }

    @Test
    void testeCadastroPessoaJuridica(){
        PessoaJuridica pessoaFisicaTeste = new PessoaJuridica("Teste de Nome", "emailteste@acelerazg.com", "80808-888", "Goiás", "Brasil", "Descrição de Teste", "080.808.080-80")

        //then
        listaEmpresas << pessoaFisicaTeste
    }
}
