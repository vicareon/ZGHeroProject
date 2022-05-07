package controller

import dao.CandidatoDAO
import model.Candidato

import java.sql.PreparedStatement
import java.sql.ResultSet

class CandidatoController implements CandidatoDAO{
    CandidatoController() {
    }

    @Override
    void listarCandidatos() {
        String BUSCAR_TODOS_CANDIDATOS = "SELECT * FROM candidatos"
        try{
            PreparedStatement candidatos = ConexaoFactory.conectar().prepareStatement(
                    BUSCAR_TODOS_CANDIDATOS,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resultado = candidatos.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado > 0){
                println("Listando candidatos. . .")
                println("-------------------------------")
                while(resultado.next()){
                    println("ID: " + resultado.getInt('Id_Cnd'))
                    println("Nome: " + resultado.getString('Nome_Cnd'))
                    println("Email: " + resultado.getString('Email_Cnd'))
                    println("CEP: " + resultado.getString('Cep_Cnd'))
                    println("Estado: " + resultado.getString('Estado_Cnd'))
                    println("País: " + resultado.getString('Pais_Cnd'))
                    println("Formação Acadêmica: " + resultado.getString('Formacao_Cnd'))
                    println("Descrição pessoal: " + resultado.getString('Descricao_Cnd'))
                    println("-------------------------------")
                }
            }
            else{
                println("Não tem candidatos cadastrados.")
            }
        } catch(Exception e){
            e.printStackTrace()
            println("Erro buscando todos os candidatos!")
            System.exit(-42)
        }
    }

    @Override
    void inserirCandidato(Candidato candidato) {
        String INSERIR_CANDIDATO = "INSERT INTO candidatos (nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, idade_cnd, senha_cnd, formacao_cnd) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try{
            PreparedStatement salvaCandidato = ConexaoFactory.conectar().prepareStatement(INSERIR_CANDIDATO)
            salvaCandidato.setString(1, candidato.getNome())
            salvaCandidato.setString(2, candidato.getEmail())
            salvaCandidato.setString(3, candidato.getCep())
            salvaCandidato.setString(4, candidato.getEstado())
            salvaCandidato.setString(5, candidato.getPais())
            salvaCandidato.setString(6, candidato.getDescricao())
            salvaCandidato.setString(7, candidato.getCpf())
            salvaCandidato.setInt(8, candidato.getIdade())
            salvaCandidato.setString(9, candidato.getSenha())
            salvaCandidato.setString(10, candidato.getFormacaoAcademica())
            salvaCandidato.executeUpdate()
            salvaCandidato.close()
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando candidato.")
            System.exit(-42)
        }
    }

    @Override
    void deletarCandidato(String buscaCpf) {
        String DELETAR_POR_CPF = "DELETE FROM candidatos WHERE cpf_cnd = ?"
        String BUSCAR_POR_CPF = "SELECT * FROM candidatos WHERE cpf_cnd = ?"

        try{
            PreparedStatement buscaDeletaCandidato = ConexaoFactory.conectar().prepareStatement(BUSCAR_POR_CPF,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscaDeletaCandidato.setString(1, buscaCpf)
            ResultSet resultado = buscaDeletaCandidato.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                PreparedStatement deletaCandidato = ConexaoFactory.conexao.prepareStatement(DELETAR_POR_CPF)
                deletaCandidato.setString(1, buscaCpf)
                deletaCandidato.executeUpdate()
                deletaCandidato.close()
                ConexaoFactory.conectar().close()
                println("Candidato deletado com sucesso.")
            }
            else{
                println("Não existe candidato com o CPF informado.")
            }
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro ao deletar candidato.")
            System.exit(-42)
        }
    }

    @Override
    static int buscarCpf(String buscaCpf) {
        String BUSCAR_POR_CPF = "SELECT * FROM candidatos WHERE cpf_cnd = ?"
        try{
            PreparedStatement buscarCandidato = ConexaoFactory.conectar().prepareStatement(BUSCAR_POR_CPF,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscarCandidato.setString(1, buscaCpf)
            ResultSet resultado = buscarCandidato.executeQuery()
            resultado.last()
            return resultado.getRow()
        } catch(Exception e){
            e.printStackTrace()
            println("Candidato não encontrado.")
            return 0
        }
    }
//@Override
    void atualizarCandidato(String cpf) {

    }

    //@Override
    void menuAtualizacaoCandidato(String buscaCpf, int escolhaAtualizaCandidato) {
        String BUSCAR_POR_CPF = "SELECT * FROM candidatos WHERE cpf_cnd = ?"

        try{
            PreparedStatement atualizaCandidato = ConexaoFactory.conectar().prepareStatement(BUSCAR_POR_CPF,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            atualizaCandidato.setString(1, buscaCpf)
            ResultSet resultado = atualizaCandidato.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(resultado.getRow() == 1){
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

                switch(escolhaAtualizaCandidato){
                    case 1:
                        atualizarNome(nome, buscaCpf)
                        break
                    case 2:
                        atualizarEmail(email)
                        break
                    case 3:
                        atualizarCep(cep)
                        break
                    case 4:
                        atualizarEstado(estado)
                        break
                    case 5:
                        atualizarPais(pais)
                        break
                    case 6:
                        atualizarDescricao(descricao)
                        break
                    case 7:
                        atualizarFormacaoAcademica(formacaoAcademica)
                        break
                    case 8:
                        atualizarIdade(idade)
                        break
                    case 9:
                        atualizarSenha(senha)
                }
            }
            else{
                println("Candidato não encontrado!")
            }
        }catch(Exception e){
            e.printStackTrace()
            println("Não foi possível atualizar o candidato.")
            System.exit(-42)
        }
    }

    @Override
    void atualizarNome(String nomeAtualizado, String buscaCpf) {
        if(buscarCpf(buscaCpf) == 1){
            String ATUALIZA_NOME_CANDIDATO = "UPDATE candidatos SET nome_cnd=? WHERE cpf_cnd=?"
            PreparedStatement atualizarNome = ConexaoFactory.conectar().prepareStatement(ATUALIZA_NOME_CANDIDATO)
            atualizarNome.setString(1, nomeAtualizado)
            atualizarNome.setString(2, buscaCpf)
            atualizarNome.executeUpdate()
            atualizarNome.close()
        }
        else{
            println("Não foi possível atualizar o candidato.")
        }
    }

    @Override
    void atualizarEmail(String emailAtualizado, String buscaCpf) {
        String ATUALIZA_EMAIL_CANDIDATO = "UPDATE candidatos SET email_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarEmail = ConexaoFactory.conectar().prepareStatement(ATUALIZA_EMAIL_CANDIDATO)
        atualizarEmail.setString(1, emailAtualizado)
        atualizarEmail.setString(2, buscaCpf)
        atualizarEmail.executeUpdate()
        atualizarEmail.close()
    }

    @Override
    void atualizarCep(String cepAtualizado, String buscaCpf) {
        String ATUALIZA_CEP_CANDIDATO = "UPDATE candidatos SET cep_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarCep = ConexaoFactory.conectar().prepareStatement(ATUALIZA_CEP_CANDIDATO)
        atualizarCep.setString(1, cepAtualizado)
        atualizarCep.setString(2, buscaCpf)
        atualizarCep.executeUpdate()
        atualizarCep.close()
    }

    @Override
    void atualizarEstado(String estadoAtualizado, String buscaCpf) {
        String ATUALIZA_ESTADO_CANDIDATO = "UPDATE candidatos SET estado_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarEstado = ConexaoFactory.conectar().prepareStatement(ATUALIZA_ESTADO_CANDIDATO)
        atualizarEstado.setString(1, estadoAtualizado)
        atualizarEstado.setString(2, buscaCpf)
        atualizarEstado.executeUpdate()
        atualizarEstado.close()
    }

    @Override
    void atualizarPais(String paisAtualizado, String buscaCpf) {
        String ATUALIZA_PAIS_CANDIDATO = "UPDATE candidatos SET pais_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarPais = ConexaoFactory.conectar().prepareStatement(ATUALIZA_PAIS_CANDIDATO)
        atualizarPais.setString(1, paisAtualizado)
        atualizarPais.setString(2, buscaCpf)
        atualizarPais.executeUpdate()
        atualizarPais.close()
    }

    @Override
    void atualizarDescricao(String descricaoAtualizada, String buscaCpf) {
        String ATUALIZA_DESCRICAO_CANDIDATO = "UPDATE candidatos SET descricao_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarDescricao = ConexaoFactory.conectar().prepareStatement(ATUALIZA_DESCRICAO_CANDIDATO)
        atualizarDescricao.setString(1, descricaoAtualizada)
        atualizarDescricao.setString(2, buscaCpf)
        atualizarDescricao.executeUpdate()
        atualizarDescricao.close()
    }

    @Override
    void atualizarFormacaoAcademica(String formacaoAtualizada, String buscaCpf) {
        String ATUALIZA_FORMACAO_CANDIDATO = "UPDATE candidatos SET formacao_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarFormacaoAcademica = ConexaoFactory.conectar().prepareStatement(ATUALIZA_FORMACAO_CANDIDATO)
        atualizarFormacaoAcademica.setString(1, formacaoAtualizada)
        atualizarFormacaoAcademica.setString(2, buscaCpf)
        atualizarFormacaoAcademica.executeUpdate()
        atualizarFormacaoAcademica.close()
    }

    @Override
    void atualizarIdade(int idadeAtualizada, String buscaCpf) {
        String ATUALIZA_IDADE_CANDIDATO = "UPDATE candidatos SET idade_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarIdade = ConexaoFactory.conectar().prepareStatement(ATUALIZA_IDADE_CANDIDATO)
        atualizarIdade.setString(1, idadeAtualizada as String)
        atualizarIdade.setString(2, buscaCpf)
        atualizarIdade.executeUpdate()
        atualizarIdade.close()
    }

    @Override
    void atualizarSenha(String senhaAtualizada, String buscaCpf) {
        String ATUALIZA_SENHA_CANDIDATO = "UPDATE candidatos SET senha_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarSenha = ConexaoFactory.conectar().prepareStatement(ATUALIZA_SENHA_CANDIDATO)
        atualizarSenha.setString(1, senhaAtualizada)
        atualizarSenha.setString(2, buscaCpf)
        atualizarSenha.executeUpdate()
        atualizarSenha.close()
    }
}