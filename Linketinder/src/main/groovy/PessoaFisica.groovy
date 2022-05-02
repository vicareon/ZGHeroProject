import groovy.transform.ToString

@ToString
class PessoaFisica extends Pessoa{
    private String cpf, formacaoAcademica
    private int idade
    private ArrayList<Competencia> listaCompetencias

    PessoaFisica(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cpf, String formacaoAcademica, int idade, ArrayList<Competencia> listaCompetencias) {
        super(nome, email, cep, estado, pais, descricao, senha)
        this.cpf = cpf
        this.formacaoAcademica = formacaoAcademica
        this.idade = idade
        this.listaCompetencias = listaCompetencias
    }

    PessoaFisica() {

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

    ArrayList<Competencia> getListaCompetencias() {
        return listaCompetencias
    }

    void setListaCompetencias(ArrayList<Competencia> listaCompetencias) {
        this.listaCompetencias = listaCompetencias
    }
}