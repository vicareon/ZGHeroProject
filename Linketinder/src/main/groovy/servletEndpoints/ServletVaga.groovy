package servletEndpoints

import controller.VagaController
import model.Vaga

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/cadastroVaga")
class ServletVaga extends HttpServlet{
    VagaController vagaController = new VagaController()

    void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        Vaga vaga = new Vaga()
        this.vagaController.inserirVaga(vaga)
    }
}