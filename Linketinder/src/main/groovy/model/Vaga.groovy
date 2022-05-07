package model

class Vaga {
    private String nome, estado, descricao, cnpjEmpresa
    private ArrayList<Competencia> listaCompetencias

    Vaga(String nome, String estado, String descricao, String cnpjEmpresa, ArrayList<Competencia> listaCompetencias) {
        this.nome = nome
        this.estado = estado
        this.descricao = descricao
        this.cnpjEmpresa = cnpjEmpresa
        this.listaCompetencias = listaCompetencias
    }

    Vaga(){

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

    String getCnpjEmpresa() {
        return cnpjEmpresa
    }

    void setCnpjEmpresa(Empresa empresa) {
        this.cnpjEmpresa = empresa.getCnpj()
    }

    ArrayList<Competencia> getListaCompetencias() {
        return listaCompetencias
    }

    void setListaCompetencias(ArrayList<Competencia> listaCompetencias) {
        this.listaCompetencias = listaCompetencias
    }
}