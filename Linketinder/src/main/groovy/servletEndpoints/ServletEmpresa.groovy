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
        Empresa empresa = new Empresa()
        this.empresaController.inserirEmpresa(empresa)
    }
}