package acelerazg

import groovy.transform.ToString

@ToString
class PessoaJuridica extends Pessoa{
    public String cnpj

    PessoaJuridica(String nome, String email, String cep, String estado, String pais, String descricao, String senha, String cnpj) {
        super(nome, email, cep, estado, pais, descricao, senha)
        this.cnpj = cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }

    String getCnpj() {
        return cnpj
    }

    @Override
    String toString(){
        return nome + ", " + email + ", " + cep + ", " + estado + ", " + pais + ", " + descricao + ", " + cnpj + "; "
    }

    void cadastroPessoaJuridica(){
        Scanner leitor = new Scanner(System.in)
        println("Digite o nome da empresa:")
        this.setNome(leitor.nextLine())
        println("Digite o email da empresa:")
        this.setEmail(leitor.nextLine())
        println("Digite o CEP da empresa:")
        this.setCep(leitor.nextLine())
        println("Digite o estado da empresa:")
        this.setEstado(leitor.nextLine())
        println("Digite o país da empresa:")
        this.setPais(leitor.nextLine())
        println("Digite a descrição da empresa:")
        this.setDescricao(leitor.nextLine())
        println("Digite o CNPJ da empresa:")
        this.setCnpj(leitor.nextLine())
        println("Digite a senha com no máximo 10 caracteres:")
        this.setSenha(leitor.nextLine())
        println("Cadastro realizado com sucesso!")
        leitor.close()
    }
}