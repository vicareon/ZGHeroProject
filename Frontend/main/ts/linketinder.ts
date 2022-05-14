const botaoCadastroCandidato = document.getElementById("botaoCadastroCandidato");
const botaoCadastroEmpresa = document.getElementById("botaoCadastroEmpresa");
const botaoListaVagas = document.getElementById("botaoListaVagas");
const botaoListaCandidatos = document.getElementById("botaoListaCandidatos");
const botaoSalvarCadastroCandidato = document.getElementById("botaoSalvarCadastroCandidato");
const botaoSalvarCadastroEmpresa = document.getElementById("botaoSalvarCadastroEmpresa");
const botaoFecharListaVagas = document.getElementById("botaoFecharListaVagas");
const botaoFecharListaCandidatos = document.getElementById("botaoFecharListaCandidatos");

const modalContainerCadastroCandidato = document.getElementById("modal_container_cadastro_candidato");
const modalContainerCadastroEmpresa = document.getElementById("modal_container_cadastro_empresa");
const modalContainerListaVagas = document.getElementById("modal_container_lista_vagas");
const modalContainerListaCandidatos = document.getElementById("modal_container_lista_candidatos");

const nomeCandidato = (<HTMLInputElement>document.getElementById("nomeCandidato")).value;
const emailCandidato = (<HTMLInputElement>document.getElementById("emailCandidato")).value;
const cepCandidato = (<HTMLInputElement>document.getElementById("cpfCandidato")).value;
const estadoCandidato = (<HTMLInputElement>document.getElementById("estadoCandidato")).value;
const paisCandidato = (<HTMLInputElement>document.getElementById("paisCandidato")).value;
const descricaoCandidato = (<HTMLInputElement>document.getElementById("descricaoCandidato")).value;
const linkedinCandidato = (<HTMLInputElement>document.getElementById("linkedinCandidato")).value;
const telefoneCandidato = (<HTMLInputElement>document.getElementById("telefoneCandidato")).value;
const cpfCandidato = (<HTMLInputElement>document.getElementById("cpfCandidato")).value;
const idadeCandidato = (<HTMLInputElement>document.getElementById("idadeCandidato")).value;
const competenciaPython = (<HTMLInputElement>document.getElementById("python")).defaultChecked;
const competenciaJava = (<HTMLInputElement>document.getElementById("java")).defaultChecked;
const competenciaGroovy = (<HTMLInputElement>document.getElementById("groovy")).defaultChecked;
const competenciaTypescript = (<HTMLInputElement>document.getElementById("typescript")).defaultChecked;
const competenciaJavascript = (<HTMLInputElement>document.getElementById("javascript")).defaultChecked;

const nomeEmpresa = (<HTMLInputElement>document.getElementById("nomeEmpresa")).value;
const emailEmpresa = (<HTMLInputElement>document.getElementById("emailEmpresa")).value;
const cepEmpresa = (<HTMLInputElement>document.getElementById("cepEmpresa")).value;
const estadoEmpresa = (<HTMLInputElement>document.getElementById("estadoEmpresa")).value;
const paisEmpresa = (<HTMLInputElement>document.getElementById("paisEmpresa")).value;
const descricaoEmpresa = (<HTMLInputElement>document.getElementById("descricaoEmpresa")).value;
const telefoneEmpresa = (<HTMLInputElement>document.getElementById("telefoneEmpresa")).value;
const cnpjEmpresa = (<HTMLInputElement>document.getElementById("cnpjEmpresa")).value;

let listaCandidatos: Candidato[] = [];
let listaEmpresas: Empresa[]= [];

botaoCadastroCandidato.addEventListener('click', () => {
    modalContainerCadastroCandidato.classList.add('show');
})

botaoSalvarCadastroCandidato.addEventListener('click', () => {
    cadastrarCandidato();
    modalContainerCadastroCandidato.classList.remove('show');
})

botaoCadastroEmpresa.addEventListener('click', () => {
    modalContainerCadastroEmpresa.classList.add('show');
})

botaoSalvarCadastroEmpresa.addEventListener('click', () => {
    cadastrarEmpresa();
    modalContainerCadastroEmpresa.classList.remove('show');
})

botaoListaVagas.addEventListener('click', () => {
    modalContainerListaVagas.classList.add('show');
})

botaoFecharListaVagas.addEventListener('click', () => {
    modalContainerListaVagas.classList.remove('show');
})

botaoListaCandidatos.addEventListener('click', () => {
    modalContainerListaCandidatos.classList.add('show');
})

botaoFecharListaCandidatos.addEventListener('click', () => {
    modalContainerListaCandidatos.classList.remove('show');
})

function cadastrarCandidato(){
    const candidato: { _estado: string; _cep: string; _email: string; _telefone: string; _pais: string; _nome: string; _cpf: string; _linkedin: string; _idade: string; _descricao: string } = {
        _nome: nomeCandidato,
        _idade: idadeCandidato,
        _cpf : cpfCandidato,
        _linkedin: linkedinCandidato,
        _telefone: telefoneCandidato,
        _descricao: descricaoCandidato,
        _pais: paisCandidato,
        _estado: estadoCandidato,
        _cep: cepCandidato,
        _email: emailCandidato
    }

    if(competenciaPython){
        candidato._competencias.push("python");
    }
    if(competenciaJava){
        candidato._competencias.push("Java");
    }
    if(competenciaGroovy){
        candidato._competencias.push("Groovy");
    }
    if(competenciaTypescript){
        candidato._competencias.push("Typescript");
    }
    if(competenciaJavascript){
        candidato._competencias.push("Javascript");
    }

    candidato.validaDados()

    /*validaNome(nomeCandidato);
    validaLinkedin(linkedinCandidato);
    validaTelefone(telefoneCandidato);
    validaCEP(cepCandidato);
    validaCPF(cpfCandidato);*/

    listaCandidatos.push(candidato);
    console.log(candidato);
    console.log(candidato._competencias);
    console.log(listaCandidatos.length);
}

function cadastrarEmpresa(){
    /*validaNome(nomeEmpresa);
    validaEmail(emailEmpresa);
    validaCEP(cepEmpresa);
    validaTelefone(telefoneEmpresa);
    validaCNPJ(cnpjEmpresa);*/

    let empresa = new PessoaJuridica(nomeEmpresa, emailEmpresa, cepEmpresa, estadoEmpresa, paisEmpresa, descricaoEmpresa, telefoneEmpresa, cnpjEmpresa);

    empresa.validaDados()

    listaEmpresas.push(empresa);
    console.log(empresa);
    console.log(listaEmpresas.length);
}