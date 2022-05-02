import groovy.transform.ToString

@ToString
class PessoaJuridica extends Pessoa{
    private String cnpj

    PessoaJuridica(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cnpj) {
        super(nome, email, cep, estado, pais, descricao, senha)
        this.cnpj = cnpj
    }

    PessoaJuridica() {

    }

    String getCnpj() {
        return cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }
}