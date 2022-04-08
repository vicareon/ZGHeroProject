package acelerazg

import groovy.transform.ToString

import java.lang.reflect.Array

@ToString
class PessoaFisica extends Pessoa{
    public String cpf, formacaoAcademica
    public int idade
    public ArrayList competencias

    PessoaFisica(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cpf, String formacaoAcademica, int idade) {
        super(nome, email, cep, estado, pais, descricao, senha)
        this.cpf = cpf
        this.formacaoAcademica = formacaoAcademica
        this.idade = idade
    }

    PessoaFisica() {
    }

    void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    void setIdade(int idade) {
        this.idade = idade
    }

    void setCompetencias(ArrayList competencias){
        this.competencias = competencias
    }

    String getCpf() {
        return cpf
    }

    String getFormacaoAcademica() {
        return formacaoAcademica
    }

    int getIdade() {
        return idade
    }

    ArrayList getCompetencias() {
        return competencias
    }

    @Override
    String toString(){
        return nome + ", " + email + ", " + cep + ", " + estado + ", " + pais + ", " + descricao + ", " + cpf + ", " + idade + ", " + formacaoAcademica + ", " + competencias.toString() + "; "
    }

    void cadastroPessoaFisica(){
        Scanner leitor = new Scanner(System.in)

        println("Digite o nome do participante:")
        this.setNome(leitor.nextLine())
        println("Digite o email do participante:")
        this.setEmail(leitor.nextLine())
        println("Digite o CEP do participante:")
        this.setCep(leitor.nextLine())
        println("Digite o estado do participante:")
        this.setEstado(leitor.nextLine())
        println("Digite o país do participante:")
        this.setPais(leitor.nextLine())
        println("Digite a descrição do participante:")
        this.setDescricao(leitor.nextLine())
        println("Digite o CPF do participante:")
        this.setCpf(leitor.nextLine())
        println("Digite a idade do participante:")
        this.setIdade(leitor.nextInt())
        println("Digite a formação acadêmica:")
        this.setFormacaoAcademica(leitor.nextLine())
        println("Digite o número de competências que deseja adicionar:")

        def competencias = []
        int quantidadeCompetencias = leitor.nextInt()
        for(int i = 0; i == quantidadeCompetencias; i++){
            println("Digite a competência:")
            competencias << leitor.nextLine()
        }
        this.setCompetencias(competencias)
        println("Digite a senha com no máximo 10 caracteres:")
        this.setSenha(leitor.nextLine())
        println("Cadastro realizado com sucesso!")
        leitor.close()
    }
}