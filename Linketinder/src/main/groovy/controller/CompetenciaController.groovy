package controller

import dao.CompetenciaDAO
import model.Competencia

import java.sql.PreparedStatement
import java.sql.ResultSet

class CompetenciaController implements CompetenciaDAO{
    @Override
    void listarCompetencias() {
        String BUSCAR_TODAS_COMPETENCIAS = "SELECT * FROM competencias"
        try{
            PreparedStatement listarCompetencias = ConexaoFactory.conectar().prepareStatement(
                    BUSCAR_TODAS_COMPETENCIAS,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resultado = listarCompetencias.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado > 0){
                println("Listando competências. . .")
                println("-------------------------------")
                while(resultado.next()){
                    println("ID: " + resultado.getInt('Id_Cmp'))
                    println("Nome: " + resultado.getString('Nome_Cmp'))
                    println("-------------------------------")
                }
            }
            else{
                println("Não tem competências cadastradas.")
            }
        } catch(Exception e){
            e.printStackTrace()
            println("Erro buscando todas as competências!")
            System.exit(-42)
        }
    }

    @Override
    void inserirCompetencia(Competencia competencia) {
        String INSERIR_COMPETENCIAS = "INSERT INTO competencias (nome_cmp) VALUES (?)"

        try{
            PreparedStatement inserirCompetencia = ConexaoFactory.conectar().prepareStatement(INSERIR_COMPETENCIAS)
            inserirCompetencia.setString(1, competencia.getNome())
            inserirCompetencia.executeUpdate()
            inserirCompetencia.close()
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando competência.")
            System.exit(-42)
        }
    }

    @Override
    void deletarCompetencia(String buscaNomeCompetencia) {
        String DELETAR_POR_NOME_COMPETENCIA = "DELETE FROM competencias WHERE nome_cmp = ?"
        String BUSCAR_POR_NOME_COMPETENCIA = "SELECT * FROM competencias WHERE nome_cmp = ?"

        try{
            PreparedStatement deletarCompetencia = ConexaoFactory.conectar().prepareStatement(BUSCAR_POR_NOME_COMPETENCIA,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            deletarCompetencia.setString(1, buscaNomeCompetencia)
            ResultSet resultado = deletarCompetencia.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                deletarCompetencia = ConexaoFactory.conectar().prepareStatement(DELETAR_POR_NOME_COMPETENCIA)
                deletarCompetencia.setString(1, buscaNomeCompetencia)
                deletarCompetencia.executeUpdate()
                deletarCompetencia.close()
                println("Competência deletada com sucesso.")
            }
            else{
                println("Não existe competência com o nome informado.")
            }
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro ao deletar competência.")
            System.exit(-42)
        }
    }

    @Override
    void atualizarCompetencia(String buscaNomeCompetencia, String nomeCompetenciaAtualizado) {
        String BUSCAR_POR_NOME_COMPETENCIA = "SELECT * FROM competencias WHERE nome_cmp = ?"
        String ATUALIZAR_NOME_COMPETENCIA = "UPDATE competencias SET nome_cmp = ? WHERE nome_cmp = ?"

        try{
            PreparedStatement atualizarCompetencia = ConexaoFactory.conectar().prepareStatement(BUSCAR_POR_NOME_COMPETENCIA,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            atualizarCompetencia.setString(1, buscaNomeCompetencia)
            ResultSet resultado = atualizarCompetencia.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                atualizarCompetencia = ConexaoFactory.conectar().prepareStatement(ATUALIZAR_NOME_COMPETENCIA)
                atualizarCompetencia.setString(1, nomeCompetenciaAtualizado)
                atualizarCompetencia.setString(2, buscaNomeCompetencia)
                atualizarCompetencia.executeUpdate()
                atualizarCompetencia.close()
                println("Competência atualizada com sucesso.")
            }
            else{
                println("Não existe competência com o nome informado.")
            }
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro ao deletar competência.")
            System.exit(-42)
        }
    }
}