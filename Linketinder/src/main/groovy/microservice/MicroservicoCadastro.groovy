package microservice

import com.sun.net.httpserver.HttpServer

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

class MicroservicoCadastro {
    static void main(String[] args){
        iniciarServidor()
    }

    static void iniciarServidor(){
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0)
        println("Servidor começou na porta 8080")
        servidor.createContext("/", (exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                String resposta = "oie! tá funcionando";
                exchange.sendResponseHeaders(200, resposta.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(resposta.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1)
            }
            exchange.close();
        }))

        servidor.createContext("/cadastroCandidato", (exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {
                /*Parsing do JSON enviado pelo frontend com o método de inserção do candidato*/
                //inserirCandidato()
            } else {
                exchange.sendResponseHeaders(405, -1)
            }
            exchange.close();
        }))

        servidor.createContext("/cadastroEmpresa", (exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {
                /*Parsing do JSON enviado pelo frontend com o método de inserção da empresa*/
                //inserirEmpresa()
            } else {
                exchange.sendResponseHeaders(405, -1)
            }
            exchange.close();
        }))

        servidor.setExecutor(null)
        servidor.start()
    }

    static Connection criarConexao() throws SQLException{
        String url_servidor = "jdbc:postgresql://localhost:5432/linketinder"
        String usuario = "postgres"
        String senha = " "

        Connection conexao = null

        conexao = DriverManager.getConnection(url_servidor, usuario, senha)

        return conexao
    }

    void inserirCandidato(//parâmetro de JSON) {
        String INSERIR_CANDIDATO = "INSERT INTO candidatos (nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, idade_cnd, senha_cnd, formacao_cnd) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

        try{
            PreparedStatement salvaCandidato = criarConexao().prepareStatement(INSERIR_CANDIDATO)
            salvaCandidato.setString(1, //nome)
            salvaCandidato.setString(2, //email)
            salvaCandidato.setString(3, //cep)
            salvaCandidato.setString(4, //estado)
            salvaCandidato.setString(5, //pais)
            salvaCandidato.setString(6, //descricao)
            salvaCandidato.setString(7, //cpf)
            salvaCandidato.setInt(8, //idade)
            salvaCandidato.setString(9, //senha)
            salvaCandidato.setString(10, //formacaoAcademica)
            salvaCandidato.executeUpdate()
            salvaCandidato.close()
        }
        catch(Exception e){
            e.printStackTrace()
            println("Erro salvando candidato.")
            System.exit(-42)
        }
    }

    void inserirEmpresa(//parâmetros de JSON) {
        String INSERIR_EMPRESA = "INSERT INTO empresas (Nome_Emp, Email_Emp, Estado_Emp, Pais_Emp, Descricao_Emp, Cnpj_Emp, Senha_Emp, Cep_Emp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"

        try{
            PreparedStatement salvaEmpresa = criarConexao().prepareStatement(INSERIR_EMPRESA)
            salvaEmpresa.setString(1, //nome)
            salvaEmpresa.setString(2, //email)
            salvaEmpresa.setString(3, //estado)
            salvaEmpresa.setString(4, //pais)
            salvaEmpresa.setString(5, //descricao)
            salvaEmpresa.setString(6, //cnpj)
            salvaEmpresa.setString(7, //senha)
            salvaEmpresa.setString(8, //cep)
            salvaEmpresa.executeUpdate()
            salvaEmpresa.close()
        }
    catch(Exception e){
        e.printStackTrace()
        println("Erro salvando empresa.")
        System.exit(-42)
    }
}