package acelerazg

class Vaga {
    String nome, estado, descricao, nomeEmpresa
    ArrayList competencias

    Vaga(String nome, String estado, String descricao) {
        this.nome = nome
        this.estado = estado
        this.descricao = descricao
    }

    Vaga(){

    }

    ArrayList getCompetencias() {
        return competencias
    }

    void setCompetencias(ArrayList competencias) {
        this.competencias = competencias
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }

    String getEstado() {
        return estado
    }

    void setEstado(String estado) {
        this.estado = estado
    }

    String getDescricao() {
        return descricao
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getNomeEmpresa() {
        return nomeEmpresa
    }

    void setNomeEmpresa(PessoaJuridica empresa) {
        this.nomeEmpresa = empresa.getCnpj()
    }
}