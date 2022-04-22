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

//inicialização das arrays
let listaCandidatos: PessoaFisica[] = [];
let listaEmpresas: PessoaJuridica[]= [];

//definição dos regexs a serem utilizados nos métodos de validação
const regexCPFouCNPJ = /([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/;
const regexCEP = /([0-9]{5}[-\. ]?[0-9]{3})/;
const regexNome = /^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi;
const regexLinkedin = /\./gi;
const regexEmail = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
const regexTelefone = /^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/;

//botões utilizados na página principal
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

function validaNome(nome:string): boolean{
    if(!(nome.match(regexNome))){
        alert("Nome inválido!");
    }
    else{
        return true
    }
}

function validaLinkedin(linkedin:string) : boolean{
    let comparadorLinkedin = "linkedin";
    let comparadoLinkedin = linkedin.split(regexLinkedin);
    if(!((comparadorLinkedin === comparadoLinkedin[1]) || (comparadorLinkedin === comparadoLinkedin[0]))){
        alert("Linkedin inválido!");
    }
    else{
        return true
    }
}

function validaCPFouCNPJ(cpfOuCnpj:string): boolean{
    if(!(cpfOuCnpj.match(regexCPFouCNPJ))){
        alert("CPF/CNPJ inválido!");
    }
    else{
        return true
    }
}

function validaEmail(email:string): boolean{
    if(!(email.match(regexEmail))){
        alert("Email inválido!");
    }
    else{
        return true
    }
}

function validaCEP(cep:string): boolean{
    if(!(cep.match(regexCEP))){
        alert("CEP inválido!");
    }
    else{
        return true
    }
}

function validaTelefone(telefone:string): boolean{
    if(!(telefone.match(regexTelefone))){
        alert("Telefone inválido!");
    }
    else{
        return true
    }
}

class Pessoa{
    _nome: string;
    _email: string;
    _cep: string;
    _estado: string;
    _pais: string;
    _descricao: string;
    _telefone: string;

    validaDados(){
        validaNome(this._nome)
        validaCEP(this._cep)
        validaTelefone(this._telefone)
        validaEmail(this._email)
    }
}

export class PessoaFisica extends Pessoa{
    private _cpf: string;
    private _idade: string;
    _competencias: string[];
    private _linkedin: string;

    validaDados() {
        super.validaDados()
        validaCPFouCNPJ(this._cpf)
        validaLinkedin(this._linkedin)
    }

    cadastrarCandidato(nomeCandidato: string, emailCandidato: string, cepCandidato: string, estadoCandidato: string, paisCandidato: string, descricaoCandidato: string, telefoneCandidato: string, linkedinCandidato: string, cpfCandidato: string, idadeCandidato: string){
        this._nome = nomeCandidato
        this._email = emailCandidato
        this._cep = cepCandidato
        this._estado = estadoCandidato
        this._pais = paisCandidato
        this._descricao = descricaoCandidato
        this._telefone = telefoneCandidato
        this._linkedin = linkedinCandidato
        this._cpf = cpfCandidato
        this._idade = idadeCandidato
    }
}

export class PessoaJuridica extends Pessoa{
    private _cnpj: string;

    validaDados() {
        super.validaDados()
        validaCPFouCNPJ(this._cnpj)
    }
}