package dao

import model.Competencia

interface CompetenciaDAO {
    void listarCompetencias()
    void inserirCompetencia(Competencia competencia)
    void deletarCompetencia(String nome)
    void atualizarCompetencia(String nome, String nomeAtualizado)
}