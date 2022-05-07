package dao

import model.Vaga

interface VagaDAO {
    void listarVagas()
    void inserirVaga(Vaga vaga)
    void deletarVaga(String cnpj)

    void buscarCnpj()

    void atualizarNome(String nomeAtualizado, String buscaCnpj)
    void atualizarEstado(String estadoAtualizado, String buscaCnpj)
    void atualizarDescricao(String descricaoAtualizada, String buscaCnpj)
}
