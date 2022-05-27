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
        try{
            Candidato candidato = new Candidato()

            candidato.setNome(requisicao.getParameter("_nome"))
            candidato.setEmail(requisicao.getParameter("_email"))
            candidato.setEstado(requisicao.getParameter("_estado"))
            candidato.setPais(requisicao.getParameter("_pais"))
            candidato.setDescricao(requisicao.getParameter("_descricao"))
            candidato.setCpf(requisicao.getParameter("_cpf"))
            candidato.setFormacaoAcademica(requisicao.getParameter("_formacaoAcademica"))
            candidato.setIdade(requisicao.getParameter("_idade") as int)
            candidato.setSenha(requisicao.getParameter("_senha"))

            this.candidatoController.inserirCandidato(candidato)

            resposta.setContentType("text/html")
            PrintWriter out = new PrintWriter()
            resposta.setStatus(HttpServletResponse.SC_CREATED)
            out.println("Criado com sucesso!")
        } catch(Exception e){
            resposta.setContentType("text/html")
            PrintWriter out = new PrintWriter()
            resposta.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED)
            out.println("Erro na criação de candidato.")
        }
    }
}