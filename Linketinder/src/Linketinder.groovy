/*
    veronica scislewski
 */

def listaCandidatos = []

PessoaFisica c1 = new PessoaFisica("Candidato 1", "candidato1@zg.com.br", "00000-001", "Goiás","Brasil", "Gosto de batata", "00000000001", 20)
PessoaFisica c2 = new PessoaFisica("Candidato 2", "candidato2@zg.com.br", "00000-002", "São Paulo","Brasil", "Gosto de estudar", "00000000002", 18)
PessoaFisica c3 = new PessoaFisica("Candidato 3", "candidato3@zg.com.br", "00000-003", "Santa Catarina","Brasil", "Gosto de bala", "00000000003", 27)
PessoaFisica c4 = new PessoaFisica("Candidato 4", "candidato4@zg.com.br", "00000-004", "Espírito Santo","Brasil", "Gosto de Monster sabor uva", "00000000004", 32)
PessoaFisica c5 = new PessoaFisica("Candidato 5", "candidato5@zg.com.br", "00000-005", "Distrito Federal","Brasil", "Gosto de Monster sabor mango loco", "00000000005", 23)

listaCandidatos << c1
listaCandidatos << c2
listaCandidatos << c3
listaCandidatos << c4
listaCandidatos << c5

println(listaCandidatos.toString())

def listaEmpresas = []

PessoaJuridica e1 = new PessoaJuridica("Empresa 1", "empresa1@zg.com.br", "00000-006", "Goiás", "Brasil", "Empresa de batatas", "00000000006")
PessoaJuridica e2 = new PessoaJuridica("Empresa 2", "empresa2@zg.com.br", "00000-007", "São Paulo", "Brasil", "Empresa de estudo", "00000000007")
PessoaJuridica e3 = new PessoaJuridica("Empresa 3", "empresa3@zg.com.br", "00000-008", "Santa Catarina", "Brasil", "Empresa de balas", "00000000008")
PessoaJuridica e4 = new PessoaJuridica("Empresa 4", "empresa4@zg.com.br", "00000-009", "Espírito Santo", "Brasil", "Filial da Monster de Uva", "00000000009")
PessoaJuridica e5 = new PessoaJuridica("Empresa 5", "empresa5@zg.com.br", "00000-010", "Distrito Federal", "Brasil", "Filial da Monster de Mango Loco", "00000000010")

listaEmpresas << e1
listaEmpresas << e2
listaEmpresas << e3
listaEmpresas << e4
listaEmpresas << e5

println(listaEmpresas.toString())




