const regexCPFouCNPJ = /([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/;
const regexCEP = /([0-9]{5}[-\. ]?[0-9]{3})/;
const regexNome = /^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi;
const regexLinkedin = /\./gi;
const regexEmail = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
const regexTelefone = /^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/;

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