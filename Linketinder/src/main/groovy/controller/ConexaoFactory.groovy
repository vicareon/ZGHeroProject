package controller

import java.sql.Connection
import java.sql.DriverManager

class ConexaoFactory {
    public static Connection conexao

    static Connection conectar(){
        Properties props = new Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password", " ")
        props.setProperty("ssl", "false")
        String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"
        try{
            conexao = DriverManager.getConnection(URL_SERVIDOR, props)
            return conexao
        }catch(Exception e){
            e.printStackTrace()
            if(e instanceof ClassNotFoundException){
                println("Verifique driver de conexão")
            } else{
                println("Verifique se o servidor está ativo")
            }
            System.exit(-42)
            return null
        }
    }
}