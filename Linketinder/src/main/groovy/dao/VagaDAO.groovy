package dao

import model.Vaga

interface VagaDAO {
    void listarVagas()
    void inserirVaga(Vaga vaga)
    void deletarVaga(String cnpj)
    void atualizarVaga(String buscaCnpj, int escolhaAtualizarVaga, String dadoAtualizado)

    boolean buscarCnpjEmpresa(String buscaCnpj)

    void atualizarNome(String nomeAtualizado, String buscaCnpj)
    void atualizarEstado(String estadoAtualizado, String buscaCnpj)
    void atualizarDescricao(String descricaoAtualizada, String buscaCnpj)
}