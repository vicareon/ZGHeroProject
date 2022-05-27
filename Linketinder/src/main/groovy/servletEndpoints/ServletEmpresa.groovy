package servletEndpoints

import controller.EmpresaController
import model.Empresa

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/cadastroEmpresa")
class ServletEmpresa extends HttpServlet{
    EmpresaController empresaController = new EmpresaController()

    void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        try{
            Empresa empresa = new Empresa()
            this.empresaController.inserirEmpresa(empresa)

            empresa.setNome(requisicao.getParameter("_nome"))
            empresa.setEmail(requisicao.getParameter("_nome"))
            empresa.setCep(requisicao.getParameter("_nome"))
            empresa.setEstado(requisicao.getParameter("_nome"))
            empresa.setPais(requisicao.getParameter("_nome"))
            empresa.setDescricao(requisicao.getParameter("_nome"))
            empresa.setCnpj(requisicao.getParameter("_nome"))
            empresa.setSenha(requisicao.getParameter("_nome"))

            empresaController.inserirEmpresa(empresa)

            resposta.setContentType("text/html")
            PrintWriter out = new PrintWriter()
            resposta.setStatus(HttpServletResponse.SC_CREATED)
            out.println("Criado com sucesso!")
        } catch(Exception e){
            resposta.setContentType("text/html")
            PrintWriter out = new PrintWriter()
            resposta.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED)
            out.println("Erro na criação de empresa.")
        }
    }
}