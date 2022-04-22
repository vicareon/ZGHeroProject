package acelerazg

import java.sql.Array
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class Database {
    public static final Scanner LEITOR = new Scanner(System.in)

    static Connection conectar(){
        Properties props = new Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password", " ")
        props.setProperty("ssl", "false")
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"
        println("Conectando...")

        try{
            return DriverManager.getConnection(URL_SERVIDOR, props)
        }catch(Exception e){
            e.printStackTrace()
            if(e instanceof ClassNotFoundException){
                println("Verifique driver de conexao")
            } else{
                println("Verifique se o servidor esta ativo")
            }
            System.exit(-42)
            return null
        }
    }

    static void desconectar(Connection conexao){
        if(conexao != null){
            try{
                conexao.close()
            } catch(SQLException e){
                e.printStackTrace()
            }
        }
    }

    static void listarTodosCandidatos(){
        String BUSCAR_TODOS_CANDIDATOS = "SELECT * FROM candidatos"
        try{
            Connection conexao = conectar()
            PreparedStatement candidatos = conexao.prepareStatement(
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

    static void listarTodasEmpresas(){
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

    static void listarTodasVagas(){
        String BUSCAR_TODAS_VAGAS = "SELECT * FROM vagas"
        try{
            Connection conexao = conectar()
            PreparedStatement vagas = conexao.prepareStatement(
                    BUSCAR_TODAS_VAGAS,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resultado = vagas.executeQuery()
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

    static void listarTodasCompetencias(){
        String BUSCAR_TODAS_COMPETENCIAS = "SELECT * FROM competencias"
        try{
            Connection conexao = conectar()
            PreparedStatement competencias = conexao.prepareStatement(
                    BUSCAR_TODAS_COMPETENCIAS,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            )
            ResultSet resultado = competencias.executeQuery()
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

    static void inserirDadosCandidato(PessoaFisica candidato){
        String INSERIR_CANDIDATO = "INSERT INTO candidatos (nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, idade_cnd, senha_cnd, formacao_cnd) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try{
            Connection conexao = conectar()
            PreparedStatement salvaCandidato = conexao.prepareStatement(INSERIR_CANDIDATO)
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
            desconectar(conexao)
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando candidato.")
            System.exit(-42)
        }
    }

    static void inserirDadosEmpresa(PessoaJuridica empresa){
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

    static void inserirDadosVaga(Vaga vaga){
        String INSERIR_VAGA = "INSERT INTO vagas (nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (?, ?, ?, ?, ?)"

        try{
            Connection conexao = conectar()
            PreparedStatement salvaVaga = conexao.prepareStatement(INSERIR_VAGA)

            salvaVaga.setString(1, vaga.getNome())
            salvaVaga.setString(2, vaga.getEstado())
            salvaVaga.setString(3, vaga.getDescricao())
            salvaVaga.setString(4, vaga.getNomeEmpresa())
            salvaVaga.setArray(5, vaga.getCompetencias() as Array)

            salvaVaga.executeUpdate()
            salvaVaga.close()
            desconectar(conexao)
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando vaga.")
            System.exit(-42)
        }
    }

    static void inserirDadosCompetencias(){
        String INSERIR_COMPETENCIAS = "INSERT INTO competencias (nome_cmp) VALUES (?)"

        try{
            Connection conexao = conectar()
            PreparedStatement salvaCompetencia = conexao.prepareStatement(INSERIR_COMPETENCIAS)

            println("Digite o número de competências que deseja inserir: ")
            int quantidadeCompetencias = LEITOR.nextInt()
            LEITOR.nextLine()

            for(int i = 0; i > quantidadeCompetencias; i++){
                println("Digite o nome da competência" + (i + 1) + ": ")
                String competencia = LEITOR.nextLine()
                salvaCompetencia.setString(2, competencia)
            }

            salvaCompetencia.executeUpdate()
            salvaCompetencia.close()
            desconectar(conexao)
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando competências.")
            System.exit(-42)
        }
    }

    static void atualizarDadosCandidato(){
        println("Informe o CPF do candidato: ")
        String buscaCpf = LEITOR.nextLine()

        String BUSCAR_POR_CPF = "SELECT * FROM candidatos WHERE cpf_cnd = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement atualizaCandidato = conexao.prepareStatement(BUSCAR_POR_CPF,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)
            atualizaCandidato.setString(1, buscaCpf)
            ResultSet resultado = atualizaCandidato.executeQuery()
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
                        "\n7. Formação Acadêmica" +
                        "\n8. Idade" +
                        "\n9. Senha")
                int escolhaAtualizaCandidato = LEITOR.nextInt()
                LEITOR.nextLine()
                switch(escolhaAtualizaCandidato){
                    case 1:
                        //atualiza nome
                        println("Digite o nome atualizado: ")
                        String nomeCndAtualizado = LEITOR.nextLine()
                        String ATUALIZA_NOME_CANDIDATO = "UPDATE candidatos SET nome_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateNomeCandidato = conexao.prepareStatement(ATUALIZA_NOME_CANDIDATO)
                        updateNomeCandidato.setString(1, nomeCndAtualizado)
                        updateNomeCandidato.setString(2, buscaCpf)
                        updateNomeCandidato.executeUpdate()
                        updateNomeCandidato.close()
                        break
                    case 2:
                        //atualiza email
                        println("Digite o email atualizado: ")
                        String emailCndAtualizado = LEITOR.nextLine()
                        String ATUALIZA_EMAIL_CANDIDATO = "UPDATE candidatos SET email_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateEmailCandidato = conexao.prepareStatement(ATUALIZA_EMAIL_CANDIDATO)
                        updateEmailCandidato.setString(1, emailCndAtualizado)
                        updateEmailCandidato.setString(2, buscaCpf)
                        updateEmailCandidato.executeUpdate()
                        updateEmailCandidato.close()
                        break
                    case 3:
                        //atualiza cep
                        println("Digite o CEP atualizado: ")
                        String cepCndAtualizado = LEITOR.nextLine()
                        String ATUALIZA_CEP_CANDIDATO = "UPDATE candidatos SET cep_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateCepCandidato = conexao.prepareStatement(ATUALIZA_CEP_CANDIDATO)
                        updateCepCandidato.setString(1, cepCndAtualizado)
                        updateCepCandidato.setString(2, buscaCpf)
                        updateCepCandidato.executeUpdate()
                        updateCepCandidato.close()
                        break
                    case 4:
                        //atualiza estado
                        println("Digite o estado atualizado: ")
                        String estadoCndAtualizado = LEITOR.nextLine()
                        String ATUALIZA_ESTADO_CANDIDATO = "UPDATE candidatos SET estado_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateEstadoCandidato = conexao.prepareStatement(ATUALIZA_ESTADO_CANDIDATO)
                        updateEstadoCandidato.setString(1, estadoCndAtualizado)
                        updateEstadoCandidato.setString(2, buscaCpf)
                        updateEstadoCandidato.executeUpdate()
                        updateEstadoCandidato.close()
                        break
                    case 5:
                        //atualiza pais
                        println("Digite o país atualizado: ")
                        String paisCndAtualizado = LEITOR.nextLine()
                        String ATUALIZA_PAIS_CANDIDATO = "UPDATE candidatos SET pais_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updatePaisCandidato = conexao.prepareStatement(ATUALIZA_PAIS_CANDIDATO)
                        updatePaisCandidato.setString(1, paisCndAtualizado)
                        updatePaisCandidato.setString(2, buscaCpf)
                        updatePaisCandidato.executeUpdate()
                        updatePaisCandidato.close()
                        break
                    case 6:
                        //atualiza descricao
                        println("Digite a descrição atualizada: ")
                        String descricaoCndAtualizada = LEITOR.nextLine()
                        String ATUALIZA_DESCRICAO_CANDIDATO = "UPDATE candidatos SET descricao_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateNomeCandidato = conexao.prepareStatement(ATUALIZA_DESCRICAO_CANDIDATO)
                        updateNomeCandidato.setString(1, descricaoCndAtualizada)
                        updateNomeCandidato.setString(2, buscaCpf)
                        updateNomeCandidato.executeUpdate()
                        updateNomeCandidato.close()
                        break
                    case 7:
                        //atualiza formacao
                        println("Digite a formação atualizada: ")
                        String formacaoCndAtualizada = LEITOR.nextLine()
                        String ATUALIZA_FORMACAO_CANDIDATO = "UPDATE candidatos SET formacao_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateNomeCandidato = conexao.prepareStatement(ATUALIZA_FORMACAO_CANDIDATO)
                        updateNomeCandidato.setString(1, formacaoCndAtualizada)
                        updateNomeCandidato.setString(2, buscaCpf)
                        updateNomeCandidato.executeUpdate()
                        updateNomeCandidato.close()
                        break
                    case 8:
                        //atualiza idade
                        println("Digite a idade atualizada: ")
                        int idadeCndAtualizada = LEITOR.nextInt()
                        LEITOR.nextLine()
                        String ATUALIZA_IDADE_CANDIDATO = "UPDATE candidatos SET idade_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateNomeCandidato = conexao.prepareStatement(ATUALIZA_IDADE_CANDIDATO)
                        updateNomeCandidato.setString(1, idadeCndAtualizada)
                        updateNomeCandidato.setString(2, buscaCpf)
                        updateNomeCandidato.executeUpdate()
                        updateNomeCandidato.close()
                        break
                    case 9:
                        //atualiza senha
                        String senhaCndAtualizada = LEITOR.nextLine()
                        String ATUALIZA_SENHA_CANDIDATO = "UPDATE candidatos SET senha_cnd=? WHERE cpf_cnd=?"
                        PreparedStatement updateNomeCandidato = conexao.prepareStatement(ATUALIZA_SENHA_CANDIDATO)
                        updateNomeCandidato.setString(1, senhaCndAtualizada)
                        updateNomeCandidato.setString(2, buscaCpf)
                        updateNomeCandidato.executeUpdate()
                        updateNomeCandidato.close()
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

    static void atualizarDadosEmpresa(){
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

    static void atualizarDadosVaga(){
        println("Informe o CNPJ da empresa: ")
        String buscaCnpj = LEITOR.nextLine()

        String BUSCAR_POR_CNPJ = "SELECT * FROM vagas WHERE cnpj_emp = ?"

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
                        String ATUALIZA_NOME_VAGA = "UPDATE vagas SET nome_vgs=? WHERE cnpj_emp=?"
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
                        String ATUALIZA_ESTADO_VAGA = "UPDATE empresas SET estado_vgs=? WHERE cnpj_emp=?"
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
                        String ATUALIZA_DESCRICAO_VAGA = "UPDATE vagas SET descricao_vgs=? WHERE cnpj_emp=?"
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

    /*observação importante:
    escolhi não implementar a atualização de competências pois é o campo nome_competencias que serve de PK e FK.
    não sei se esta prática é a melhor, ou a mais correta, porém é a decisão que cheguei no momento que escrevi este código e pode mudar mais pra frente.
    08-04-22
     */
    
    static void excluirDadosCandidato(){
        println("Informe o CPF do candidato: ")
        String buscaCpf = LEITOR.nextLine()

        String DELETAR_POR_CPF = "DELETE FROM candidatos WHERE cpf_cnd = ?"
        String BUSCAR_POR_CPF = "SELECT * FROM candidatos WHERE cpf_cnd = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement buscaDeletaCandidato = conexao.prepareStatement(BUSCAR_POR_CPF,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscaDeletaCandidato.setString(1, buscaCpf)
            ResultSet resultado = buscaDeletaCandidato.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                PreparedStatement deletaCandidato = conexao.prepareStatement(DELETAR_POR_CPF)
                deletaCandidato.setString(1, buscaCpf)
                deletaCandidato.executeUpdate()
                deletaCandidato.close()
                desconectar(conexao)
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

    static void excluirDadosEmpresa(){
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

    static void excluirDadosVaga(){
        println("Informe o CNPJ da empresa: ")
        String buscaCnpj = LEITOR.nextLine()

        String DELETAR_POR_CNPJ = "DELETE FROM vagas WHERE cnpj_emp = ?"
        String BUSCAR_POR_CNPJ = "SELECT * FROM vagas WHERE cnpj_emp = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement buscaDeletaVaga = conexao.prepareStatement(BUSCAR_POR_CNPJ,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscaDeletaVaga.setString(1, buscaCnpj)
            ResultSet resultado = buscaDeletaVaga.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                PreparedStatement deletaVaga = conexao.prepareStatement(DELETAR_POR_CNPJ)
                deletaVaga.setString(1, buscaCnpj)
                deletaVaga.executeUpdate()
                deletaVaga.close()
                desconectar(conexao)
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

    static void excluirDadosCompetencia(){
        println("Informe o nome da competência: ")
        String buscaNomeCompetencia = LEITOR.nextLine()

        String DELETAR_POR_NOME_COMPETENCIA = "DELETE FROM competencias WHERE nome_cmp = ?"
        String BUSCAR_POR_NOME_COMPETENCIA = "SELECT * FROM competencias WHERE nome_cmp = ?"

        try{
            Connection conexao = conectar()
            PreparedStatement buscaDeletaCompetencia = conexao.prepareStatement(BUSCAR_POR_NOME_COMPETENCIA,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY)
            buscaDeletaCompetencia.setString(1, buscaNomeCompetencia)
            ResultSet resultado = buscaDeletaCompetencia.executeQuery()
            resultado.last()
            int quantidadeResultado = resultado.getRow()
            resultado.beforeFirst()

            if(quantidadeResultado = 1){
                PreparedStatement deletaCompetencia = conexao.prepareStatement(DELETAR_POR_NOME_COMPETENCIA)
                deletaCompetencia.setString(1, buscaNomeCompetencia)
                deletaCompetencia.executeUpdate()
                deletaCompetencia.close()
                desconectar(conexao)
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
}