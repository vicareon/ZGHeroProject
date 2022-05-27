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
            empresa.setEmail(requisicao.getParameter("_email"))
            empresa.setCep(requisicao.getParameter("_cep"))
            empresa.setEstado(requisicao.getParameter("_estado"))
            empresa.setPais(requisicao.getParameter("_pais"))
            empresa.setDescricao(requisicao.getParameter("_descricao"))
            empresa.setCnpj(requisicao.getParameter("_cnpj"))
            empresa.setSenha(requisicao.getParameter("_senha"))

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

            e.printStackTrace()
        }
    }
}