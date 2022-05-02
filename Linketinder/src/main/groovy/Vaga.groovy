class Vaga {
    private String nome, estado, descricao, nomeEmpresa
    private ArrayList<Competencia> listaCompetencias

    Vaga(String nome, String estado, String descricao, String nomeEmpresa, ArrayList<Competencia> listaCompetencias) {
        this.nome = nome
        this.estado = estado
        this.descricao = descricao
        this.nomeEmpresa = nomeEmpresa
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

    String getNomeEmpresa() {
        return nomeEmpresa
    }

    void setNomeEmpresa(PessoaJuridica empresa) {
        this.nomeEmpresa = empresa.getNome()
    }

    ArrayList<Competencia> getListaCompetencias() {
        return listaCompetencias
    }

    void setListaCompetencias(ArrayList<Competencia> listaCompetencias) {
        this.listaCompetencias = listaCompetencias
    }
}