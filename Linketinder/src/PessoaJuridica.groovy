import groovy.transform.ToString

@ToString
class PessoaJuridica extends Pessoa{
    public String cnpj

    PessoaJuridica(String nome, String email, String cep, String estado, String pais, String descricao, String cnpj) {
        super(nome, email, cep, estado, pais, descricao)
        this.cnpj = cnpj
    }

    @Override
    String toString(){
        return nome + ", " + email + ", " + cep + ", " + estado + ", " + pais + ", " + descricao + ", " + cnpj + "; "
    }
}
