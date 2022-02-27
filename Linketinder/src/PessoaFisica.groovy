import groovy.transform.ToString

import java.lang.reflect.Array

@ToString
class PessoaFisica extends Pessoa{
    public String cpf
    public int idade
    public Array competencias

    PessoaFisica(String nome, String email, String cep, String estado, String pais, String descricao, String cpf, int idade) {
        super(nome, email, cep, estado, pais, descricao)
        this.cpf = cpf
        this.idade = idade
    }

    void setCompetencias(Array competencias){
        this.competencias = competencias
    }

    @Override
    String toString(){
        return nome + ", " + email + ", " + cep + ", " + estado + ", " + pais + ", " + descricao + ", " + cpf + ", " + idade + "; "
    }
}
