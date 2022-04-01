//declaração de constantes e variáveis
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

//variáveis utilizadas no cadastro do candidato e empresa
const nomeCandidato = (<HTMLInputElement>document.getElementById("nomeCandidato")).value;
const emailCandidato = (<HTMLInputElement>document.getElementById("emailCandidato")).value;
const cepCandidato = (<HTMLInputElement>document.getElementById("cpfCandidato")).value;
const estadoCandidato = (<HTMLInputElement>document.getElementById("estadoCandidato")).value;
const paisCandidato = (<HTMLInputElement>document.getElementById("paisCandidato")).value;
const descricaoCandidato = (<HTMLInputElement>document.getElementById("descricaoCandidato")).value;
const linkedinCandidato = (<HTMLInputElement>document.getElementById("linkedinCandidato")).value;
const telefoneCandidato = (<HTMLInputElement>document.getElementById("telefoneCandidato")).value;
const cpf = (<HTMLInputElement>document.getElementById("cpfCandidato")).value;
const idade = (<HTMLInputElement>document.getElementById("idadeCandidato")).value;
const python = (<HTMLInputElement>document.getElementById("python")).defaultChecked;
const java = (<HTMLInputElement>document.getElementById("java")).defaultChecked;
const groovy = (<HTMLInputElement>document.getElementById("groovy")).defaultChecked;
const typescript = (<HTMLInputElement>document.getElementById("typescript")).defaultChecked;
const javascript = (<HTMLInputElement>document.getElementById("javascript")).defaultChecked;

const nomeEmpresa = (<HTMLInputElement>document.getElementById("nomeEmpresa")).value;
const emailEmpresa = (<HTMLInputElement>document.getElementById("emailEmpresa")).value;
const cepEmpresa = (<HTMLInputElement>document.getElementById("cepEmpresa")).value;
const estadoEmpresa = (<HTMLInputElement>document.getElementById("estadoEmpresa")).value;
const paisEmpresa = (<HTMLInputElement>document.getElementById("paisEmpresa")).value;
const descricaoEmpresa = (<HTMLInputElement>document.getElementById("descricaoEmpresa")).value;
const telefoneEmpresa = (<HTMLInputElement>document.getElementById("telefoneEmpresa")).value;
const cnpj = (<HTMLInputElement>document.getElementById("cnpjEmpresa")).value;

//inicialização das arrays
let listaCandidatos: PessoaFisica[] = [];
let listaEmpresas: PessoaJuridica[]= [];

//definição dos regexs a serem utilizados nos métodos de validação
let regexCPFouCNPJ = /([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/;
let regexCEP = /([0-9]{5}[-\. ]?[0-9]{3})/;
let regexNome = /^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi;
let regexLinkedin = /\./gi;
let regexEmail = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
let regexTelefone = /^(?:(?:\+?1\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?$/gi;

//botões utilizados na página principal
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

//funções
function cadastroCandidato(){
    let candidato = new PessoaFisica(nomeCandidato, emailCandidato, cepCandidato, estadoCandidato, paisCandidato, descricaoCandidato, telefoneCandidato, linkedinCandidato, cpf, idade);
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

    validaNome(nomeCandidato);
    validaLinkedin(linkedinCandidato);
    validaTelefone(telefoneCandidato);
    validaCEP(cepCandidato);
    validaCPF(cpf);

    listaCandidatos.push(candidato);
    console.log(candidato);
    console.log(candidato._competencias);
    console.log(listaCandidatos.length);
}

function cadastroEmpresa(){
    validaNome(nomeEmpresa);
    validaEmail(emailEmpresa);
    validaCEP(cepEmpresa);
    validaTelefone(telefoneEmpresa);
    validaCNPJ(cnpj);

    let empresa = new PessoaJuridica(nomeEmpresa, emailEmpresa, cepEmpresa, estadoEmpresa, paisEmpresa, descricaoEmpresa, telefoneEmpresa, cnpj);
    listaEmpresas.push(empresa);
    console.log(empresa);
    console.log(listaEmpresas.length);
}

//validação
function validaNome(nome:string){
    if(!(nome.match(regexNome))){
        alert("Nome inválido!");
    }
}

function validaLinkedin(linkedin:string){
    let comparadorLinkedin = "linkedin";
    let comparadoLinkedin = linkedin.split(regexLinkedin);
    if(!(comparadorLinkedin === comparadoLinkedin[1])){
        alert("Linkedin inválido!");
    }
}

function validaCPF(cpf:string){
    if(!(cpf.match(regexCPFouCNPJ))){
        alert("CPF inválido!");
    }
}

function validaCNPJ(cnpj:string){
    if(!(cnpj.match(regexCPFouCNPJ))){
        alert("CNPJ inválido!");
    }
}

function validaEmail(email:string){
    if(!(email.match(regexEmail))){
        alert("Email inválido!");
    }
}

function validaCEP(cep:string){
    if(!(cep.match(regexCEP))){
        alert("CEP inválido!");
    }
}

function validaTelefone(telefone:string){
    if(!(telefone.match(regexTelefone))){
        alert("Telefone inválido!");
    }
}

//classes
class Pessoa{
    _nome: string;
    _email: string;
    _cep: string;
    _estado: string;
    _pais: string;
    _descricao: string;
    _telefone: string;

    constructor(nome: string, email:string, cep: string, estado: string, pais: string, descricao: string, telefone: string){
        this._nome = nome;
        this._email = email;
        this._cep = cep;
        this._estado = estado;
        this._pais = pais;
        this._descricao = descricao;
        this._telefone = telefone;
    }
}

class PessoaFisica extends Pessoa{
    private _cpf: string;
    private _idade: string;
    _competencias: string[];
    private _linkedin: string;

    constructor(nome: string, email: string, cep: string, estado: string, pais: string, descricao: string, telefone:string, linkedin: string, cpf: string, idade: string) {
        super(nome, email, cep, estado, pais, descricao, telefone);
        this._cpf = cpf;
        this._idade = idade;
        this._linkedin = linkedin;
    }
}

class PessoaJuridica extends Pessoa{
    private _cnpj: string;

    constructor(nome: string, email: string, cep: string, estado: string, pais: string, descricao: string, telefone: string, cnpj: string) {
        super(nome, email, cep, estado, pais, descricao, telefone);
        this._cnpj = cnpj;
    }
}