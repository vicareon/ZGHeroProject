var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var botaoCadastroCandidato = document.getElementById("botaoCadastroCandidato");
var botaoCadastroEmpresa = document.getElementById("botaoCadastroEmpresa");
var botaoListaVagas = document.getElementById("botaoListaVagas");
var botaoListaCandidatos = document.getElementById("botaoListaCandidatos");
var botaoSalvarCadastroCandidato = document.getElementById("botaoSalvarCadastroCandidato");
var botaoSalvarCadastroEmpresa = document.getElementById("botaoSalvarCadastroEmpresa");
var botaoFecharListaVagas = document.getElementById("botaoFecharListaVagas");
var botaoFecharListaCandidatos = document.getElementById("botaoFecharListaCandidatos");
var modalContainerCadastroCandidato = document.getElementById("modal_container_cadastro_candidato");
var modalContainerCadastroEmpresa = document.getElementById("modal_container_cadastro_empresa");
var modalContainerListaVagas = document.getElementById("modal_container_lista_vagas");
var modalContainerListaCandidatos = document.getElementById("modal_container_lista_candidatos");
var listaCandidatos = [];
var listaEmpresas = [];
botaoCadastroCandidato.addEventListener('click', function () {
    modalContainerCadastroCandidato.classList.add('show');
});
botaoSalvarCadastroCandidato.addEventListener('click', function () {
    cadastroCandidato();
    modalContainerCadastroCandidato.classList.remove('show');
});
botaoCadastroEmpresa.addEventListener('click', function () {
    modalContainerCadastroEmpresa.classList.add('show');
});
botaoSalvarCadastroEmpresa.addEventListener('click', function () {
    cadastroEmpresa();
    modalContainerCadastroEmpresa.classList.remove('show');
});
botaoListaVagas.addEventListener('click', function () {
    modalContainerListaVagas.classList.add('show');
});
botaoFecharListaVagas.addEventListener('click', function () {
    modalContainerListaVagas.classList.remove('show');
});
botaoListaCandidatos.addEventListener('click', function () {
    modalContainerListaCandidatos.classList.add('show');
});
botaoFecharListaCandidatos.addEventListener('click', function () {
    modalContainerListaCandidatos.classList.remove('show');
});
function cadastroCandidato() {
    var nome = document.getElementById("nomeCandidato").value;
    var email = document.getElementById("emailCandidato").value;
    var cep = document.getElementById("cpfCandidato").value;
    var estado = document.getElementById("estadoCandidato").value;
    var pais = document.getElementById("paisCandidato").value;
    var descricao = document.getElementById("descricaoCandidato").value;
    var cpf = document.getElementById("cpfCandidato").value;
    var idade = document.getElementById("idadeCandidato").value;
    var python = document.getElementById("python").defaultChecked;
    var java = document.getElementById("java").defaultChecked;
    var groovy = document.getElementById("groovy").defaultChecked;
    var typescript = document.getElementById("typescript").defaultChecked;
    var javascript = document.getElementById("javascript").defaultChecked;
    var candidato = new PessoaFisica(nome, email, cep, estado, pais, descricao, cpf, idade);
    //criando a array com as competências a partir do checkbox do formulário de cadastro
    if (python) {
        candidato._competencias.push("python");
    }
    if (java) {
        candidato._competencias.push("Java");
    }
    if (groovy) {
        candidato._competencias.push("Groovy");
    }
    if (typescript) {
        candidato._competencias.push("Typescript");
    }
    if (javascript) {
        candidato._competencias.push("Javascript");
    }
    listaCandidatos.push(candidato);
    console.log(candidato);
    console.log(candidato._competencias);
    console.log(listaCandidatos.length);
}
function cadastroEmpresa() {
    var nome = document.getElementById("nomeEmpresa").value;
    var email = document.getElementById("emailEmpresa").value;
    var cep = document.getElementById("cepEmpresa").value;
    var estado = document.getElementById("estadoEmpresa").value;
    var pais = document.getElementById("paisEmpresa").value;
    var descricao = document.getElementById("descricaoEmpresa").value;
    var cnpj = document.getElementById("cnpjEmpresa").value;
    var empresa = new PessoaJuridica(nome, email, cep, estado, pais, descricao, cnpj);
    listaEmpresas.push(empresa);
    console.log(empresa);
    console.log(listaEmpresas.length);
}
var Pessoa = /** @class */ (function () {
    function Pessoa(nome, email, cep, estado, pais, descricao) {
        this._nome = nome;
        this._email = email;
        this._cep = cep;
        this._estado = estado;
        this._pais = pais;
        this._descricao = descricao;
    }
    return Pessoa;
}());
var PessoaFisica = /** @class */ (function (_super) {
    __extends(PessoaFisica, _super);
    function PessoaFisica(nome, email, cep, estado, pais, descricao, cpf, idade) {
        var _this = _super.call(this, nome, email, cep, estado, pais, descricao) || this;
        _this._cpf = cpf;
        _this._idade = idade;
        return _this;
    }
    return PessoaFisica;
}(Pessoa));
var PessoaJuridica = /** @class */ (function (_super) {
    __extends(PessoaJuridica, _super);
    function PessoaJuridica(nome, email, cep, estado, pais, descricao, cnpj) {
        var _this = _super.call(this, nome, email, cep, estado, pais, descricao) || this;
        _this._cnpj = cnpj;
        return _this;
    }
    return PessoaJuridica;
}(Pessoa));
