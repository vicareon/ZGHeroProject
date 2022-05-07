package dao

import model.Candidato

interface CandidatoDAO {
    void listarCandidatos()
    void inserirCandidato(Candidato candidato)
    void deletarCandidato(String buscaCpf)

    int buscarCpf(String buscaCpf)

    void atualizarNome(String nome, String buscaCpf)
    void atualizarEmail(String email, String buscaCpf)
    void atualizarCep(String cep, String buscaCpf)
    void atualizarEstado(String estado, String buscaCpf)
    void atualizarPais(String pais, String buscaCpf)
    void atualizarDescricao(String descricao, String buscaCpf)
    void atualizarFormacaoAcademica(String formacaoAcademica, String buscaCpf)
    void atualizarIdade(int idade, String buscaCpf)
    void atualizarSenha(String senha, String buscaCpf)
}