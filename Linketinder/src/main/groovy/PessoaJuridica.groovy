import groovy.transform.ToString

@ToString
class PessoaJuridica implements Pessoa{
    private String nome, email, cep, estado, pais, descricao, senha, cnpj

    PessoaJuridica(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cnpj) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.descricao = descricao
        this.senha = senha
        this.cnpj = cnpj
    }

    PessoaJuridica() {
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    String getCep() {
        return cep
    }

    void setCep(String cep) {
        this.cep = cep
    }

    String getEstado() {
        return estado
    }

    void setEstado(String estado) {
        this.estado = estado
    }

    String getPais() {
        return pais
    }

    void setPais(String pais) {
        this.pais = pais
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getSenha() {
        return senha
    }

    void setSenha(String senha) {
        this.senha = senha
    }

    String getCnpj() {
        return cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    @Override
    String toString(){
        return nome + ", " + email + ", " + cep + ", " + estado + ", " + pais + ", " + descricao + ", " + cnpj + "; "
    }
}