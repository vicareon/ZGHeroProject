package servletEndpoints

import controller.CandidatoController
import model.Candidato

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/cadastroCandidato")
class ServletCandidato extends HttpServlet{
    CandidatoController candidatoController = new CandidatoController()

    void doPost(HttpServletRequest requisicao, HttpServletResponse resposta){
        Candidato candidato = new Candidato()

        candidato.setNome(requisicao.getParameter("nome"))
        candidato.setEmail(requisicao.getParameter("email"))
        candidato.setEstado(requisicao.getParameter("estado"))
        candidato.setPais(requisicao.getParameter("pais"))
        candidato.setDescricao(requisicao.getParameter("descricao"))
        candidato.setCpf(requisicao.getParameter("cpf"))
        candidato.setFormacaoAcademica(requisicao.getParameter("formacaoAcademica"))
        candidato.setIdade(requisicao.getParameter("idade") as int)
        candidato.setSenha(requisicao.getParameter("senha"))

        this.candidatoController.inserirCandidato(candidato)

        resposta.setStatus(HttpServletResponse.SC_CREATED)
    }
}