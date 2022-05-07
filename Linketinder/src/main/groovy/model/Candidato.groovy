package model

class Candidato{
    private String nome, email, cep, estado, pais, descricao, senha, cpf, formacaoAcademica
    private int idade

    Candidato(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cpf, String formacaoAcademica, int idade) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.pais = pais
        this.descricao = descricao
        this.senha = senha
        this.cpf = cpf
        this.formacaoAcademica = formacaoAcademica
        this.idade = idade
    }

    Candidato() {

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

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getFormacaoAcademica() {
        return formacaoAcademica
    }

    void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica
    }

    int getIdade() {
        return idade
    }

    void setIdade(int idade) {
        this.idade = idade
    }
}