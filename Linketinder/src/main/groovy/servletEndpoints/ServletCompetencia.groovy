package servletEndpoints

import controller.CompetenciaController
import model.Competencia

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/cadastroCompetencia")
class ServletCompetencia extends HttpServlet{
    CompetenciaController competenciaController = new CompetenciaController()

    void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        Competencia competencia = new Competencia()
        this.competenciaController.inserirCompetencia(competencia)
    }
}