package controller

import dao.VagaDAO
import model.Vaga

import java.sql.Array
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class VagaController implements VagaDAO{
    VagaController() {
    }

    @Override
    void listarVagas() {
        String BUSCAR_TODAS_VAGAS = "SELECT * FROM vagas"

        try{
            PreparedStatement listarVagas = ConexaoFactory.conectar().prepareStatement(
                    BUSCAR_TODAS_VAGAS,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resultado = listarVagas.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado > 0){
                println("Listando vagas. . .")
                println("-------------------------------")
                while(resultado.next()){
                    println("ID: " + resultado.getInt('Id_Vgs'))
                    println("Nome: " + resultado.getString('Nome_Vgs'))
                    println("Estado: " + resultado.getString('Estado_Vgs'))
                    println("Empresa: " + resultado.getString('Empresa_Vgs'))
                    println("Descrição: " + resultado.getString('Descricao_Vgs'))
                    println("Competências exigidas: " + resultado.getArray('Competencias_Vgs'))
                    println("-------------------------------")
                }
            }
            else{
                println("Não tem vagas cadastradas.")
            }
        } catch(Exception e){
            e.printStackTrace()
            println("Erro buscando todas as vagas!")
            System.exit(-42)
        }
    }

    @Override
    void inserirVaga(Vaga vaga) {
        String INSERIR_VAGA = "INSERT INTO vagas (nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (?, ?, ?, ?, ?)"

        try{
            PreparedStatement inserirVaga = ConexaoFactory.conectar().prepareStatement(INSERIR_VAGA)
            inserirVaga.setString(1, vaga.getNome())
            inserirVaga.setString(2, vaga.getEstado())
            inserirVaga.setString(3, vaga.getDescricao())
            inserirVaga.setString(4, vaga.getCnpjEmpresa())
            inserirVaga.setArray(5, vaga.getListaCompetencias() as Array)
            inserirVaga.executeUpdate()
            inserirVaga.close()
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando vaga.")
            System.exit(-42)
        }
    }

    @Override
    void deletarVaga(String buscaCnpj) {
        String DELETAR_POR_CNPJ = "DELETE FROM vagas WHERE empresa_vgs = ?"
        String BUSCAR_POR_CNPJ = "SELECT * FROM vagas WHERE empresa_vgs = ?"

        try{
            PreparedStatement deletarVaga = ConexaoFactory.conectar().prepareStatement(BUSCAR_POR_CNPJ,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            deletarVaga.setString(1, buscaCnpj)
            ResultSet resultado = deletarVaga.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                deletarVaga = ConexaoFactory.conectar().prepareStatement(DELETAR_POR_CNPJ)
                deletarVaga.setString(1, buscaCnpj)
                deletarVaga.executeUpdate()
                deletarVaga.close()
                println("Vaga deletada com sucesso.")
            }
            else{
                println("Não existe vaga com o CNPJ informado.")
            }
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro ao deletar vaga.")
            System.exit(-42)
        }
    }

    //@Override
    void atualizarVaga(String cnpj) {
        println("Informe o CNPJ da empresa: ")
        String buscaCnpj = LEITOR.nextLine()

        String BUSCAR_POR_CNPJ = "SELECT * FROM vagas WHERE empresa_vgs = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement atualizaVaga = conexao.prepareStatement(BUSCAR_POR_CNPJ,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            atualizaVaga.setString(1, buscaCnpj)
            ResultSet resultado = atualizaVaga.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                println("Escolha o campo que deseja atualizar: " +
                        "\n1. Nome" +
                        "\n2. Estado" +
                        "\n3. Descrição")
                int escolhaAtualizaVaga = LEITOR.nextInt()
                LEITOR.nextLine()
                switch(escolhaAtualizaVaga){
                    case 1:
                        //atualiza nome
                        println("Digite o nome atualizado: ")
                        String nomeVgsAtualizado = LEITOR.nextLine()
                        String ATUALIZA_NOME_VAGA = "UPDATE vagas SET nome_vgs=? WHERE empresa_vgs=?"
                        PreparedStatement updateNomeVaga = conexao.prepareStatement(ATUALIZA_NOME_VAGA)
                        updateNomeVaga.setString(1, nomeVgsAtualizado)
                        updateNomeVaga.setString(2, buscaCnpj)
                        updateNomeVaga.executeUpdate()
                        updateNomeVaga.close()
                        break
                    case 2:
                        //atualiza estado
                        println("Digite o estado atualizado: ")
                        String estadoVgsAtualizado = LEITOR.nextLine()
                        String ATUALIZA_ESTADO_VAGA = "UPDATE vagas SET estado_vgs=? WHERE empresa_vgs=?"
                        PreparedStatement updateEstadoVaga = conexao.prepareStatement(ATUALIZA_ESTADO_VAGA)
                        updateEstadoVaga.setString(1, estadoVgsAtualizado)
                        updateEstadoVaga.setString(2, buscaCnpj)
                        updateEstadoVaga.executeUpdate()
                        updateEstadoVaga.close()
                        break
                    case 3:
                        //atualiza descrição
                        println("Digite a descrição atualizada: ")
                        String descricaoVgsAtualizada = LEITOR.nextLine()
                        String ATUALIZA_DESCRICAO_VAGA = "UPDATE vagas SET descricao_vgs=? WHERE empresa_vgs=?"
                        PreparedStatement updateDescricaoVaga = conexao.prepareStatement(ATUALIZA_DESCRICAO_VAGA)
                        updateDescricaoVaga.setString(1, descricaoVgsAtualizada)
                        updateDescricaoVaga.setString(2, buscaCnpj)
                        updateDescricaoVaga.executeUpdate()
                        updateDescricaoVaga.close()
                        break
                }
            }else{
                println("Vaga não encontrada!")
            }
        }catch(Exception e){
            e.printStackTrace()
            println("Não foi possível atualizar a vaga.")
            System.exit(-42)
        }
    }

    @Override
    void atualizarNome(String nomeAtualizado, String buscaCnpj) {
        String ATUALIZA_NOME_VAGA = "UPDATE vagas SET nome_vgs=? WHERE empresa_vgs=?"
        PreparedStatement atualizarNome = ConexaoFactory.conectar().prepareStatement(ATUALIZA_NOME_VAGA)
        atualizarNome.setString(1, nomeAtualizado)
        atualizarNome.setString(2, buscaCnpj)
        atualizarNome.executeUpdate()
        atualizarNome.close()
    }

    @Override
    void atualizarEstado(String estadoAtualizado, String buscaCnpj) {
        String ATUALIZA_ESTADO_VAGA = "UPDATE vagas SET estado_vgs=? WHERE empresa_vgs=?"
        PreparedStatement atualizarEstado = ConexaoFactory.conectar().prepareStatement(ATUALIZA_ESTADO_VAGA)
        atualizarEstado.setString(1, estadoAtualizado)
        atualizarEstado.setString(2, buscaCnpj)
        atualizarEstado.executeUpdate()
        atualizarEstado.close()
    }

    @Override
    void atualizarDescricao(String descricaoAtualizada, String buscaCnpj) {
        String ATUALIZA_DESCRICAO_VAGA = "UPDATE vagas SET descricao_vgs=? WHERE empresa_vgs=?"
        PreparedStatement atualizarDescricao = ConexaoFactory.conectar().prepareStatement(ATUALIZA_DESCRICAO_VAGA)
        atualizarDescricao.setString(1, descricaoAtualizada)
        atualizarDescricao.setString(2, buscaCnpj)
        atualizarDescricao.executeUpdate()
        atualizarDescricao.close()
    }
}