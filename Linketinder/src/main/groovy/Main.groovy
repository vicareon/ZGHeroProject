import controller.CandidatoController
import controller.CompetenciaController
import controller.EmpresaController
import controller.VagaController
import model.Candidato
import model.Competencia
import model.Empresa

class Main {
    static void main(String[] args){
        inicializar()
    }

    static void inicializar(){
        CandidatoController candidatoController = new CandidatoController()
        CompetenciaController competenciaController = new CompetenciaController()
        EmpresaController empresaController = new EmpresaController()
        VagaController vagaController = new VagaController()
        Scanner leitor = new Scanner(System.in)

        menuInicial(leitor, candidatoController, competenciaController, empresaController, vagaController)
    }

    static void menuInicial(Scanner leitor, CandidatoController candidatoController, CompetenciaController competenciaController, EmpresaController empresaController, VagaController vagaController){
        println("*** LINKETINDER ***")
        println("1. Listar todos os candidatos" +
                "\n2. Cadastro de candidato" +
                "\n3. Atualizar candidato" +
                "\n4. Excluir candidato" +
                "\n" +
                "\n5. Listar todas as empresas" +
                "\n6. Cadastro de empresa" +
                "\n7. Atualizar empresa" +
                "\n8. Excluir empresa" +
                "\n" +
                "\n9. Listar todas as vagas" +
                "\n10. Cadastro de vaga" +
                "\n11. Atualizar vaga" +
                "\n12. Excluir vaga" +
                "\n" +
                "\n13. Listar todas as competencias" +
                "\n14. Cadastro de competencia" +
                "\n15. Atualizar competencia" +
                "\n16. Excluir competencia" +
                "\nEscolha: ")
        int escolha = leitor.nextInt()
        leitor.nextLine()

        switch (escolha){
            case 1:
                candidatoController.listarCandidatos()
                break

            case 2:
                Candidato candidato = new Candidato()
                menuCadastroCandidato(candidato, leitor, candidatoController)
                break

            case 3:
                String cpf = buscaCpf(leitor)
                menuAtualizarCandidato(leitor, candidatoController, cpf)
                break

            case 4:
                String cpf = buscaCpf(leitor)
                candidatoController.deletarCandidato(cpf)
                break

            case 5:
                empresaController.listarEmpresas()
                break

            case 6:
                Empresa empresa = new Empresa()
                menuCadastroEmpresa(empresa, leitor, empresaController)
                break

            case 7:
                String cnpj = buscaCnpj(leitor)
                menuAtualizarEmpresa(leitor, empresaController, cnpj)
                break

            case 8:
                break

            case 9:
                vagaController.listarVagas()
                break

            case 10:
                break

            case 11:
                String cnpj = buscaCnpj(leitor)
                menuAtualizarVaga(leitor, vagaController, cnpj)
                break

            case 12:
                String cnpj = buscaCnpj(leitor)
                vagaController.deletarVaga(cnpj)
                break

            case 13:
                competenciaController.listarCompetencias()
                break

            case 14:
                println("Digite o número de competências que deseja inserir: ")
                int quantidadeCompetencias = leitor.nextInt()
                leitor.nextLine()
                for(int i = 0; i > quantidadeCompetencias; i++){
                    println("Digite o nome da competência" + (i + 1) + ": ")
                    String nomeCompetencia = leitor.nextLine()
                    Competencia competencia = new Competencia(nomeCompetencia)
                    competenciaController.inserirCompetencia(competencia)
                }
                break

            case 15:
                println("Informe o nome da competência: ")
                String buscaNomeCompetencia = leitor.nextLine()
                println("Informe o nome atualizado da competência: ")
                String nomeCompetenciaAtualizado = leitor.nextLine()
                competenciaController.atualizarCompetencia(buscaNomeCompetencia, nomeCompetenciaAtualizado)
                break

            case 16:
                println("Informe o nome da competência: ")
                String buscaNomeCompetencia = leitor.nextLine()
                competenciaController.deletarCompetencia(buscaNomeCompetencia)
                break
        }
    }

    static void menuCadastroCandidato(Candidato candidato, Scanner leitor, CandidatoController candidatoController){
        println("Digite o nome do participante:")
        candidato.setNome(leitor.nextLine())
        println("Digite o email do participante:")
        candidato.setEmail(leitor.nextLine())
        println("Digite o CEP do participante:")
        candidato.setCep(leitor.nextLine())
        println("Digite o estado do participante:")
        candidato.setEstado(leitor.nextLine())
        println("Digite o país do participante:")
        candidato.setPais(leitor.nextLine())
        println("Digite a descrição do participante:")
        candidato.setDescricao(leitor.nextLine())
        println("Digite o CPF do participante:")
        candidato.setCpf(leitor.nextLine())
        println("Digite a idade do participante:")
        candidato.setIdade(leitor.nextInt())
        println("Digite a senha com no máximo 10 caracteres:")
        candidato.setSenha(leitor.nextLine())
        println("Cadastro realizado com sucesso!")

        candidatoController.inserirCandidato(candidato)
    }

    static void menuCadastroEmpresa(Empresa empresa, Scanner leitor, EmpresaController empresaController){
        println("Digite o nome da empresa:")
        empresa.setNome(leitor.nextLine())
        println("Digite o email da empresa:")
        empresa.setEmail(leitor.nextLine())
        println("Digite o CEP da empresa:")
        empresa.setCep(leitor.nextLine())
        println("Digite o estado da empresa:")
        empresa.setEstado(leitor.nextLine())
        println("Digite o país da empresa:")
        empresa.setPais(leitor.nextLine())
        println("Digite a descrição da empresa:")
        empresa.setDescricao(leitor.nextLine())
        println("Digite o CNPJ da empresa:")
        empresa.setCnpj(leitor.nextLine())
        println("Digite a senha com no máximo 10 caracteres:")
        empresa.setSenha(leitor.nextLine())
        println("Cadastro realizado com sucesso!")

        empresaController.inserirEmpresa(empresa)
    }

    static void menuCadastroVaga(){

    }

    static void menuAtualizarCandidato(Scanner leitor, CandidatoController candidatoController, String cpf){
        println("Escolha o campo que deseja atualizar: " +
                "\n1. Nome" +
                "\n2. Email" +
                "\n3. CEP" +
                "\n4. Estado" +
                "\n5. País" +
                "\n6. Descrição" +
                "\n7. Formação Acadêmica" +
                "\n8. Idade" +
                "\n9. Senha")
        int escolha = leitor.nextInt()
        leitor.nextLine()

        switch(escolha){
            case 1:
                println("Digite o nome atualizado: ")
                String nomeAtualizado = leitor.nextLine()
                candidatoController.atualizarNome(nomeAtualizado, cpf)
                break
            case 2:
                println("Digite o email atualizado: ")
                String emailAtualizado = leitor.nextLine()
                candidatoController.atualizarEmail(emailAtualizado, cpf)
                break
            case 3:
                println("Digite o CEP atualizado: ")
                String cepAtualizado = leitor.nextLine()
                candidatoController.atualizarCep(cepAtualizado, cpf)
                break
            case 4:
                println("Digite o estado atualizado: ")
                String estadoAtualizado = leitor.nextLine()
                candidatoController.atualizarEstado(estadoAtualizado, cpf)
                break
            case 5:
                println("Digite o país atualizado: ")
                String paisAtualizado = leitor.nextLine()
                candidatoController.atualizarPais(paisAtualizado, cpf)
                break
            case 6:
                println("Digite a descrição atualizada: ")
                String descricaoAtualizada = leitor.nextLine()
                candidatoController.atualizarDescricao(descricaoAtualizada, cpf)
                break
            case 7:
                println("Digite a formação acadêmica atualizada: ")
                String formacaoAtualizado = leitor.nextLine()
                candidatoController.atualizarFormacaoAcademica(formacaoAtualizado, cpf)
                break
            case 8:
                println("Digite a idade atualizada: ")
                int idadeAtualizada = leitor.nextInt()
                leitor.nextLine()
                candidatoController.atualizarIdade(idadeAtualizada, cpf)
                break
            case 9:
                println("Digite a senha atualizada: ")
                String senhaAtualizada = leitor.nextLine()
                candidatoController.atualizarSenha(senhaAtualizada, cpf)
                break
        }
    }

    static void menuAtualizarEmpresa(Scanner leitor, EmpresaController empresaController, String cnpj){
        println("Escolha o campo que deseja atualizar: " +
                "\n1. Nome" +
                "\n2. Email" +
                "\n3. CEP" +
                "\n4. Estado" +
                "\n5. País" +
                "\n6. Descrição" +
                "\n7. Senha")
        int escolha = leitor.nextInt()
        leitor.nextLine()

        switch(escolha){
            case 1:
                println("Digite o nome atualizado: ")
                String nomeAtualizado = leitor.nextLine()
                empresaController.atualizarNome(nomeAtualizado, cnpj)
                break
            case 2:
                println("Digite o email atualizado: ")
                String emailAtualizado = leitor.nextLine()
                empresaController.atualizarEmail(emailAtualizado, cnpj)
                break
            case 3:
                println("Digite o CEP atualizado: ")
                String cepAtualizado = leitor.nextLine()
                empresaController.atualizarCep(cepAtualizado, cnpj)
                break
            case 4:
                println("Digite o estado atualizado: ")
                String estadoAtualizado = leitor.nextLine()
                empresaController.atualizarEstado(estadoAtualizado, cnpj)
                break
            case 5:
                println("Digite o país atualizado: ")
                String paisAtualizado = leitor.nextLine()
                empresaController.atualizarPais(paisAtualizado, cnpj)
                break
            case 6:
                println("Digite a descrição atualizada: ")
                String descricaoAtualizada = leitor.nextLine()
                empresaController.atualizarDescricao(descricaoAtualizada, cnpj)
                break

            case 7:
                println("Digite a senha atualizada: ")
                String senhaAtualizada = leitor.nextLine()
                empresaController.atualizarSenha(senhaAtualizada, cnpj)
                break
        }
    }

    static void menuAtualizarVaga(Scanner leitor, VagaController vagaController, String cnpj){
        println("Escolha o campo que deseja atualizar: " +
                "\n1. Nome" +
                "\n2. Estado" +
                "\n3. Descrição")
        int escolha = leitor.nextInt()
        leitor.nextLine()

        switch (escolha){
            case 1:
                println("Digite o nome atualizado: ")
                String nomeAtualizado = leitor.nextLine()
                vagaController.atualizarNome(nomeAtualizado, cnpj)
                break
            case 2:
                println("Digite o estado atualizado: ")
                String estadoAtualizado = leitor.nextLine()
                vagaController.atualizarEstado(estadoAtualizado, cnpj)
                break
            case 3:
                println("Digite a descrição atualizada: ")
                String descricaoAtualizada = leitor.nextLine()
                vagaController.atualizarDescricao(descricaoAtualizada, cnpj)
                break
        }
    }

    static String buscaCpf(Scanner leitor){
        println("Digite o CPF do candidato: ")
        String buscaCpf = leitor.nextLine()
        return buscaCpf
    }

    static String buscaCnpj(Scanner leitor){
        println("Informe o CNPJ da empresa: ")
        String buscaCnpj = leitor.nextLine()
        return buscaCnpj
    }
}