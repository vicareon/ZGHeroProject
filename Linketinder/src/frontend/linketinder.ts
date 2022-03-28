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

let listaCandidatos: PessoaFisica[] = [];
let listaEmpresas: PessoaJuridica[]= [];

botaoCadastroCandidato.addEventListener('click', () => {
    modalContainerCadastroCandidato.classList.add('show');
})

botaoSalvarCadastroCandidato.addEventListener('click', () => {
    cadastroCandidato();
    modalContainerCadastroCandidato.classList.remove('show');
})

botaoCadastroEmpresa.addEventListener('click', () => {
    modalContainerCadastroEmpresa.classList.add('show');
})

botaoSalvarCadastroEmpresa.addEventListener('click', () => {
    cadastroEmpresa();
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

function cadastroCandidato(){
    const nome = (<HTMLInputElement>document.getElementById("nomeCandidato")).value;
    const email = (<HTMLInputElement>document.getElementById("emailCandidato")).value;
    const cep = (<HTMLInputElement>document.getElementById("cpfCandidato")).value;
    const estado = (<HTMLInputElement>document.getElementById("estadoCandidato")).value;
    const pais = (<HTMLInputElement>document.getElementById("paisCandidato")).value;
    const descricao = (<HTMLInputElement>document.getElementById("descricaoCandidato")).value;
    const cpf = (<HTMLInputElement>document.getElementById("cpfCandidato")).value;
    const idade = (<HTMLInputElement>document.getElementById("idadeCandidato")).value;
    const python = (<HTMLInputElement>document.getElementById("python")).defaultChecked;
    const java = (<HTMLInputElement>document.getElementById("java")).defaultChecked;
    const groovy = (<HTMLInputElement>document.getElementById("groovy")).defaultChecked;
    const typescript = (<HTMLInputElement>document.getElementById("typescript")).defaultChecked;
    const javascript = (<HTMLInputElement>document.getElementById("javascript")).defaultChecked;
    let candidato = new PessoaFisica(nome, email, cep, estado, pais, descricao, cpf, idade);
    //criando a array com as competências a partir do checkbox do formulário de cadastro
    if(python){
        candidato._competencias.push("python");
    }
    if(java){
        candidato._competencias.push("Java");
    }
    if(groovy){
        candidato._competencias.push("Groovy");
    }
    if(typescript){
        candidato._competencias.push("Typescript");
    }
    if(javascript){
        candidato._competencias.push("Javascript");
    }
    listaCandidatos.push(candidato);
    console.log(candidato);
    console.log(candidato._competencias);
    console.log(listaCandidatos.length);
}

function cadastroEmpresa(){
    const nome = (<HTMLInputElement>document.getElementById("nomeEmpresa")).value;
    const email = (<HTMLInputElement>document.getElementById("emailEmpresa")).value;
    const cep = (<HTMLInputElement>document.getElementById("cepEmpresa")).value;
    const estado = (<HTMLInputElement>document.getElementById("estadoEmpresa")).value;
    const pais = (<HTMLInputElement>document.getElementById("paisEmpresa")).value;
    const descricao = (<HTMLInputElement>document.getElementById("descricaoEmpresa")).value;
    const cnpj = (<HTMLInputElement>document.getElementById("cnpjEmpresa")).value;
    let empresa = new PessoaJuridica(nome, email, cep, estado, pais, descricao, cnpj);
    listaEmpresas.push(empresa);
    console.log(empresa);
    console.log(listaEmpresas.length);
}

class Pessoa{
    _nome: string;
    _email: string;
    _cep: string;
    _estado: string;
    _pais: string;
    _descricao: string;

    constructor(nome: string, email:string, cep: string, estado: string, pais: string, descricao: string){
        this._nome = nome;
        this._email = email;
        this._cep = cep;
        this._estado = estado;
        this._pais = pais;
        this._descricao = descricao;
    }
}

class PessoaFisica extends Pessoa{
    private _cpf: string;
    private _idade: string;
    _competencias: string[];

    constructor(nome: string, email: string, cep: string, estado: string, pais: string, descricao: string, cpf: string, idade: string) {
        super(nome, email, cep, estado, pais, descricao);
        this._cpf = cpf;
        this._idade = idade;
    }
}

class PessoaJuridica extends Pessoa{
    private _cnpj: string;

    constructor(nome: string, email: string, cep: string, estado: string, pais: string, descricao: string, cnpj: string) {
        super(nome, email, cep, estado, pais, descricao);
        this._cnpj = cnpj;
    }
}