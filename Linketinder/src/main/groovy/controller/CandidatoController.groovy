package controller

import dao.CandidatoDAO
import model.Candidato

import javax.servlet.annotation.WebServlet
import java.sql.PreparedStatement
import java.sql.ResultSet
import javax.servlet.http.HttpServlet

class CandidatoController extends HttpServlet implements CandidatoDAO{
    CandidatoController() {
    }

    //post, get, etc


    @Override
    void listarCandidatos() {
        String BUSCAR_TODOS_CANDIDATOS = "SELECT * FROM candidatos"
        try{
            PreparedStatement candidatos = Conexao.conectar().prepareStatement(
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
            PreparedStatement salvaCandidato = Conexao.conectar().prepareStatement(INSERIR_CANDIDATO)
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
            PreparedStatement buscaDeletaCandidato = Conexao.conectar().prepareStatement(BUSCAR_POR_CPF,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscaDeletaCandidato.setString(1, buscaCpf)
            ResultSet resultado = buscaDeletaCandidato.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                PreparedStatement deletaCandidato = Conexao.conexao.prepareStatement(DELETAR_POR_CPF)
                deletaCandidato.setString(1, buscaCpf)
                deletaCandidato.executeUpdate()
                deletaCandidato.close()
                Conexao.conectar().close()
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
    void atualizarCandidato(String buscaCpf, int escolhaAtualizaCandidato, String dadoAtualizado) {
        String BUSCAR_POR_CPF = "SELECT * FROM candidatos WHERE cpf_cnd = ?"

        try{
            PreparedStatement atualizaCandidato = Conexao.conectar().prepareStatement(BUSCAR_POR_CPF,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            atualizaCandidato.setString(1, buscaCpf)
            ResultSet resultado = atualizaCandidato.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                switch(escolhaAtualizaCandidato){
                    case 1:
                        atualizarNome(dadoAtualizado, buscaCpf)
                        break
                    case 2:
                        atualizarEmail(dadoAtualizado, buscaCpf)
                        break
                    case 3:
                        atualizarCep(dadoAtualizado, buscaCpf)
                        break
                    case 4:
                        atualizarEstado(dadoAtualizado, buscaCpf)
                        break
                    case 5:
                        atualizarPais(dadoAtualizado, buscaCpf)
                        break
                    case 6:
                        atualizarDescricao(dadoAtualizado, buscaCpf)
                        break
                    case 7:
                        atualizarFormacaoAcademica(dadoAtualizado, buscaCpf)
                        break
                    case 8:
                        atualizarIdade(dadoAtualizado as int, buscaCpf)
                        break
                    case 9:
                        atualizarSenha(dadoAtualizado, buscaCpf)
                        break
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
        String ATUALIZA_NOME_CANDIDATO = "UPDATE candidatos SET nome_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarNome = Conexao.conectar().prepareStatement(ATUALIZA_NOME_CANDIDATO)
        atualizarNome.setString(1, nomeAtualizado)
        atualizarNome.setString(2, buscaCpf)
        atualizarNome.executeUpdate()
        atualizarNome.close()
    }

    @Override
    void atualizarEmail(String emailAtualizado, String buscaCpf) {
        String ATUALIZA_EMAIL_CANDIDATO = "UPDATE candidatos SET email_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarEmail = Conexao.conectar().prepareStatement(ATUALIZA_EMAIL_CANDIDATO)
        atualizarEmail.setString(1, emailAtualizado)
        atualizarEmail.setString(2, buscaCpf)
        atualizarEmail.executeUpdate()
        atualizarEmail.close()
    }

    @Override
    void atualizarCep(String cepAtualizado, String buscaCpf) {
        String ATUALIZA_CEP_CANDIDATO = "UPDATE candidatos SET cep_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarCep = Conexao.conectar().prepareStatement(ATUALIZA_CEP_CANDIDATO)
        atualizarCep.setString(1, cepAtualizado)
        atualizarCep.setString(2, buscaCpf)
        atualizarCep.executeUpdate()
        atualizarCep.close()
    }

    @Override
    void atualizarEstado(String estadoAtualizado, String buscaCpf) {
        String ATUALIZA_ESTADO_CANDIDATO = "UPDATE candidatos SET estado_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarEstado = Conexao.conectar().prepareStatement(ATUALIZA_ESTADO_CANDIDATO)
        atualizarEstado.setString(1, estadoAtualizado)
        atualizarEstado.setString(2, buscaCpf)
        atualizarEstado.executeUpdate()
        atualizarEstado.close()
    }

    @Override
    void atualizarPais(String paisAtualizado, String buscaCpf) {
        String ATUALIZA_PAIS_CANDIDATO = "UPDATE candidatos SET pais_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarPais = Conexao.conectar().prepareStatement(ATUALIZA_PAIS_CANDIDATO)
        atualizarPais.setString(1, paisAtualizado)
        atualizarPais.setString(2, buscaCpf)
        atualizarPais.executeUpdate()
        atualizarPais.close()
    }

    @Override
    void atualizarDescricao(String descricaoAtualizada, String buscaCpf) {
        String ATUALIZA_DESCRICAO_CANDIDATO = "UPDATE candidatos SET descricao_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarDescricao = Conexao.conectar().prepareStatement(ATUALIZA_DESCRICAO_CANDIDATO)
        atualizarDescricao.setString(1, descricaoAtualizada)
        atualizarDescricao.setString(2, buscaCpf)
        atualizarDescricao.executeUpdate()
        atualizarDescricao.close()
    }

    @Override
    void atualizarFormacaoAcademica(String formacaoAtualizada, String buscaCpf) {
        String ATUALIZA_FORMACAO_CANDIDATO = "UPDATE candidatos SET formacao_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarFormacaoAcademica = Conexao.conectar().prepareStatement(ATUALIZA_FORMACAO_CANDIDATO)
        atualizarFormacaoAcademica.setString(1, formacaoAtualizada)
        atualizarFormacaoAcademica.setString(2, buscaCpf)
        atualizarFormacaoAcademica.executeUpdate()
        atualizarFormacaoAcademica.close()
    }

    @Override
    void atualizarIdade(int idadeAtualizada, String buscaCpf) {
        String ATUALIZA_IDADE_CANDIDATO = "UPDATE candidatos SET idade_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarIdade = Conexao.conectar().prepareStatement(ATUALIZA_IDADE_CANDIDATO)
        atualizarIdade.setString(1, idadeAtualizada as String)
        atualizarIdade.setString(2, buscaCpf)
        atualizarIdade.executeUpdate()
        atualizarIdade.close()
    }

    @Override
    void atualizarSenha(String senhaAtualizada, String buscaCpf) {
        String ATUALIZA_SENHA_CANDIDATO = "UPDATE candidatos SET senha_cnd=? WHERE cpf_cnd=?"
        PreparedStatement atualizarSenha = Conexao.conectar().prepareStatement(ATUALIZA_SENHA_CANDIDATO)
        atualizarSenha.setString(1, senhaAtualizada)
        atualizarSenha.setString(2, buscaCpf)
        atualizarSenha.executeUpdate()
        atualizarSenha.close()
    }
}