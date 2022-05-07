package controller

import dao.EmpresaDAO
import model.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class EmpresaController implements EmpresaDAO{
    @Override
    void listarEmpresas() {
        String BUSCAR_TODAS_EMPRESAS = "SELECT * FROM empresas"
        try{
            Connection conexao = conectar()
            PreparedStatement empresas = conexao.prepareStatement(
                    BUSCAR_TODAS_EMPRESAS,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resultado = empresas.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado > 0){
                println("Listando empresas. . .")
                println("-------------------------------")
                while(resultado.next()){
                    println("ID: " + resultado.getInt('Id_Emp'))
                    println("Nome: " + resultado.getString('Nome_Emp'))
                    println("Email: " + resultado.getString('Email_Emp'))
                    println("Estado: " + resultado.getString('Estado_Emp'))
                    println("CEP: " + resultado.getString('Cep_Emp'))
                    println("País: " + resultado.getString('Pais_Emp'))
                    println("Descrição pessoal: " + resultado.getString('Descricao_Emp'))
                    println("-------------------------------")
                }
            }
            else{
                println("Não tem empresas cadastradas.")
            }
        } catch(Exception e){
            e.printStackTrace()
            println("Erro buscando todas as empresas!")
            System.exit(-42)
        }
    }

    @Override
    void inserirEmpresa(Empresa empresa) {
        String INSERIR_EMPRESA = "INSERT INTO empresas (Nome_Emp, Email_Emp, Estado_Emp, Pais_Emp, Descricao_Emp, Cnpj_Emp, Senha_Emp, Cep_Emp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"

        try{
            Connection conexao = conectar()
            PreparedStatement salvaEmpresa = conexao.prepareStatement(INSERIR_EMPRESA)

            salvaEmpresa.setString(1, empresa.getNome())
            salvaEmpresa.setString(2, empresa.getEmail())
            salvaEmpresa.setString(3, empresa.getEstado())
            salvaEmpresa.setString(4, empresa.getPais())
            salvaEmpresa.setString(5, empresa.getDescricao())
            salvaEmpresa.setString(6, empresa.getCnpj())
            salvaEmpresa.setString(7, empresa.getSenha())
            salvaEmpresa.setString(8, empresa.getCep())

            salvaEmpresa.executeUpdate()
            salvaEmpresa.close()
            desconectar(conexao)
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando empresa.")
            System.exit(-42)
        }
    }

    @Override
    void deletarEmpresa(String cnpj) {
        println("Informe o CNPJ da empresa: ")
        String buscaCnpj = LEITOR.nextLine()

        String DELETAR_POR_CNPJ = "DELETE FROM empresas WHERE cnpj_emp = ?"
        String BUSCAR_POR_CNPJ = "SELECT * FROM empresas WHERE cnpj_emp = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement buscaDeletaEmpresa = conexao.prepareStatement(BUSCAR_POR_CNPJ,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscaDeletaEmpresa.setString(1, buscaCnpj)
            ResultSet resultado = buscaDeletaEmpresa.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                PreparedStatement deletaEmpresa = conexao.prepareStatement(DELETAR_POR_CNPJ)
                deletaEmpresa.setString(1, buscaCnpj)
                deletaEmpresa.executeUpdate()
                deletaEmpresa.close()
                desconectar(conexao)
                println("Empresa deletada com sucesso.")
            }
            else{
                println("Não existe empresa com o CNPJ informado.")
            }
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro ao deletar empresa.")
            System.exit(-42)
        }
    }

    void menuAtualizacaoEmpresa(String cnpj) {
        println("Informe o CNPJ da empresa: ")
        String buscaCnpj = LEITOR.nextLine()

        String BUSCAR_POR_CNPJ = "SELECT * FROM empresas WHERE cnpj_emp = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement atualizaEmpresa = conexao.prepareStatement(BUSCAR_POR_CNPJ,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            atualizaEmpresa.setString(1, buscaCnpj)
            ResultSet resultado = atualizaEmpresa.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                println("Escolha o campo que deseja atualizar: " +
                        "\n1. Nome" +
                        "\n2. Email" +
                        "\n3. CEP" +
                        "\n4. Estado" +
                        "\n5. País" +
                        "\n6. Descrição" +
                        "\n7. Senha")
                int escolhaAtualizaEmpresa = LEITOR.nextInt()
                LEITOR.nextLine()
                switch(escolhaAtualizaEmpresa){
                    case 1:
                        //atualiza nome
                        println("Digite o nome atualizado: ")
                        String nomeEmpAtualizado = LEITOR.nextLine()
                        String ATUALIZA_NOME_EMPRESA = "UPDATE empresas SET nome_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updateNomeEmpresa = conexao.prepareStatement(ATUALIZA_NOME_EMPRESA)
                        updateNomeEmpresa.setString(1, nomeEmpAtualizado)
                        updateNomeEmpresa.setString(2, buscaCnpj)
                        updateNomeEmpresa.executeUpdate()
                        updateNomeEmpresa.close()
                        break
                    case 2:
                        //atualiza email
                        println("Digite o email atualizado: ")
                        String emailEmpAtualizado = LEITOR.nextLine()
                        String ATUALIZA_EMAIL_EMPRESA = "UPDATE empresas SET email_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updateEmailEmpresa = conexao.prepareStatement(ATUALIZA_EMAIL_EMPRESA)
                        updateEmailEmpresa.setString(1, emailEmpAtualizado)
                        updateEmailEmpresa.setString(2, buscaCnpj)
                        updateEmailEmpresa.executeUpdate()
                        updateEmailEmpresa.close()
                        break
                    case 3:
                        //atualiza cep
                        println("Digite o CEP atualizado: ")
                        String cepEmpAtualizado = LEITOR.nextLine()
                        String ATUALIZA_CEP_EMPRESA = "UPDATE empresas SET cep_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updateCepEmpresa = conexao.prepareStatement(ATUALIZA_CEP_EMPRESA)
                        updateCepEmpresa.setString(1, cepEmpAtualizado)
                        updateCepEmpresa.setString(2, buscaCnpj)
                        updateCepEmpresa.executeUpdate()
                        updateCepEmpresa.close()
                        break
                    case 4:
                        //atualiza estado
                        println("Digite o estado atualizado: ")
                        String estadoEmpAtualizado = LEITOR.nextLine()
                        String ATUALIZA_ESTADO_EMPRESA = "UPDATE empresas SET estado_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updateEstadoEmpresa = conexao.prepareStatement(ATUALIZA_ESTADO_EMPRESA)
                        updateEstadoEmpresa.setString(1, estadoEmpAtualizado)
                        updateEstadoEmpresa.setString(2, buscaCnpj)
                        updateEstadoEmpresa.executeUpdate()
                        updateEstadoEmpresa.close()
                        break
                    case 5:
                        //atualiza pais
                        println("Digite o país atualizado: ")
                        String paisEmpAtualizado = LEITOR.nextLine()
                        String ATUALIZA_PAIS_EMPRESA = "UPDATE empresas SET pais_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updatePaisEmpresa = conexao.prepareStatement(ATUALIZA_PAIS_EMPRESA)
                        updatePaisEmpresa.setString(1, paisEmpAtualizado)
                        updatePaisEmpresa.setString(2, buscaCnpj)
                        updatePaisEmpresa.executeUpdate()
                        updatePaisEmpresa.close()
                        break
                    case 6:
                        //atualiza descricao
                        println("Digite a descrição atualizada: ")
                        String descricaoEmpAtualizada = LEITOR.nextLine()
                        String ATUALIZA_DESCRICAO_EMPRESA = "UPDATE empresas SET descricao_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updateDescricaoEmpresa = conexao.prepareStatement(ATUALIZA_DESCRICAO_EMPRESA)
                        updateDescricaoEmpresa.setString(1, descricaoEmpAtualizada)
                        updateDescricaoEmpresa.setString(2, buscaCnpj)
                        updateDescricaoEmpresa.executeUpdate()
                        updateDescricaoEmpresa.close()
                        break
                    case 7:
                        //atualiza senha
                        println("Digite a senha atualizada: ")
                        String senhaEmpAtualizada = LEITOR.nextLine()
                        String ATUALIZA_SENHA_EMPRESA = "UPDATE empresas SET senha_emp=? WHERE cnpj_emp=?"
                        PreparedStatement updateSenhaEmpresa = conexao.prepareStatement(ATUALIZA_SENHA_EMPRESA)
                        updateSenhaEmpresa.setString(1, senhaEmpAtualizada)
                        updateSenhaEmpresa.setString(2, buscaCnpj)
                        updateSenhaEmpresa.executeUpdate()
                        updateSenhaEmpresa.close()
                        break
                }
            }else{
                println("Empresa não encontrada!")
            }
        }catch(Exception e){
            e.printStackTrace()
            println("Não foi possível atualizar a empresa.")
            System.exit(-42)
        }
    }

    @Override
    void atualizarNome(String nomeAtualizado, String buscaCnpj) {
        String ATUALIZA_NOME_EMPRESA = "UPDATE empresas SET nome_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarNome = ConexaoFactory.conectar().prepareStatement(ATUALIZA_NOME_EMPRESA)
        atualizarNome.setString(1, nomeAtualizado)
        atualizarNome.setString(2, buscaCnpj)
        atualizarNome.executeUpdate()
        atualizarNome.close()
    }

    @Override
    void atualizarEmail(String emailAtualizado, String buscaCnpj) {
        String ATUALIZA_EMAIL_EMPRESA = "UPDATE empresas SET email_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarEmail = ConexaoFactory.conectar().prepareStatement(ATUALIZA_EMAIL_EMPRESA)
        atualizarEmail.setString(1, emailAtualizado)
        atualizarEmail.setString(2, buscaCnpj)
        atualizarEmail.executeUpdate()
        atualizarEmail.close()
    }

    @Override
    void atualizarCep(String cepAtualizado, String buscaCnpj) {
        String ATUALIZA_CEP_EMPRESA = "UPDATE empresas SET cep_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarCep = ConexaoFactory.conectar().prepareStatement(ATUALIZA_CEP_EMPRESA)
        atualizarCep.setString(1, cepAtualizado)
        atualizarCep.setString(2, buscaCnpj)
        atualizarCep.executeUpdate()
        atualizarCep.close()
    }

    @Override
    void atualizarEstado(String estadoAtualizado, String buscaCnpj) {
        String ATUALIZA_ESTADO_EMPRESA = "UPDATE empresas SET estado_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarEstado = ConexaoFactory.conectar().prepareStatement(ATUALIZA_ESTADO_EMPRESA)
        atualizarEstado.setString(1, estadoAtualizado)
        atualizarEstado.setString(2, buscaCnpj)
        atualizarEstado.executeUpdate()
        atualizarEstado.close()
    }

    @Override
    void atualizarPais(String paisAtualizado, String buscaCnpj) {
        String ATUALIZA_PAIS_EMPRESA = "UPDATE empresas SET pais_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarPais = ConexaoFactory.conectar().prepareStatement(ATUALIZA_PAIS_EMPRESA)
        atualizarPais.setString(1, paisAtualizado)
        atualizarPais.setString(2, buscaCnpj)
        atualizarPais.executeUpdate()
        atualizarPais.close()
    }

    @Override
    void atualizarDescricao(String descricaoAtualizada, String buscaCnpj) {
        String ATUALIZA_DESCRICAO_EMPRESA = "UPDATE empresas SET descricao_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarDescricao = ConexaoFactory.conectar().prepareStatement(ATUALIZA_DESCRICAO_EMPRESA)
        atualizarDescricao.setString(1, descricaoAtualizada)
        atualizarDescricao.setString(2, buscaCnpj)
        atualizarDescricao.executeUpdate()
        atualizarDescricao.close()
    }

    @Override
    void atualizarSenha(String senhaAtualizada, String buscaCnpj) {
        String ATUALIZA_SENHA_EMPRESA = "UPDATE empresas SET senha_emp=? WHERE cnpj_emp=?"
        PreparedStatement atualizarSenha = ConexaoFactory.conectar().prepareStatement(ATUALIZA_SENHA_EMPRESA)
        atualizarSenha.setString(1, senhaAtualizada)
        atualizarSenha.setString(2, buscaCnpj)
        atualizarSenha.executeUpdate()
        atualizarSenha.close()
    }
}
