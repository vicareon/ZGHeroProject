/**
 * @jest-environment jsdom
 */

test('use jsdom in this test file', () => {
    const element = document.createElement('div');
    expect(element).not.toBeNull();
});

/*describe("Teste de cadastro de candidato", () => {
    test("Verifica o retorno do cadastro de candidato", () => {
        const candidatoTeste: PessoaFisica = {
            cadastrarCandidato(nomeCandidato: string, emailCandidato: string, cepCandidato: string, estadoCandidato: string, paisCandidato: string, descricaoCandidato: string, telefoneCandidato: string, linkedinCandidato: string, cpfCandidato: string, idadeCandidato: string) {
            }
        }
        //const candidatoTeste = new PessoaFisica("Candidato da Silva", "teste@zgsolucoes.com", "Goiânia", "Goiás", "Brasil", "Descrição de teste", "(62)9900-2000", "www.linkedin.com/candidato", "017.935.110-98", "23")
        expect(console.log(candidatoTeste))
    });
    test("Verifica se o candidato foi adicionado à array", () => {
        expect()
    });
    test("Verifica se as competências do candidato foram adicionadas e atreladas à ele", () => {
        expect()
    });
});

describe("Teste de cadastro de empresa", () => {
    test("Verifica o retorno do cadastro de empresa", () => {
        expect()
    });
    test("Verifica se a empresa foi adicionada à array", () => {
        expect()
    });
});*/

describe("Teste de regex de nome", () => {
    test("Verifica se o nome dado está de A até Z, sem números ou caracteres especiais", () => {
        expect("Candidato da Silva").toMatch(/^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi)
    });
    test("Verifica se retorna falso com a inserção de caracteres especiais", () => {
        expect(("C*ndid*to d@ Silva!").match(/^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi)).toBeFalsy()
    });
    test("Verifica se retorna falso com a inserção de números", () => {
        expect(("C4ndid4t0 d4 S1lv4").match(/^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi)).toBeFalsy()
    });
});

describe("Teste de regex de CPF ou CNPJ", () => {
    test("Verifica se o CPF informado é composto apenas por números, sem pontuação", () => {
        expect("34228136087").toMatch(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)
    });
    test("Verifica se o CPF informado é composto apenas por números, com pontuação", () => {
        expect("714.649.870-09").toMatch(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)
    });
    test("Verifica se o CPF retorna falso com a inserção de caracteres no meio (sem ser pontuação)", () => {
        expect(("342a281b360c87").match(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)).toBeFalsy()
    });
    test("Verifica se o CNPJ informado é composto apenas por números, sem pontuação", () => {
        expect("19522392000187").toMatch(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)
    });
    test("Verifica se o CNPJ informado é composto apenas por números, com pontuação", () => {
        expect("56.215.539/0001-12").toMatch(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)
    });
    test("Verifica se o CNPJ retorna falso com a inserção de caracteres no meio (sem ser pontuação)", () => {
        expect(("19522sdfsdfsfsdf392000187").match(/([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/)).toBeFalsy()
    });
});

describe("Teste de regex de CEP", () => {
    test("Verifica se o dado informado é composto apenas por números, sem pontuação", () => {
        expect("75690971").toMatch(/([0-9]{5}[-\. ]?[0-9]{3})/)
    });
    test("Verifica se o dado informado é composto apenas por números, com pontuação", () => {
        expect("75690-970").toMatch(/([0-9]{5}[-\. ]?[0-9]{3})/)
    });
    test("Verifica se retorna falso com a inserção de caracteres no meio (sem ser pontuação)", () => {
        expect(("756asd9097!@#1").match(/([0-9]{5}[-\. ]?[0-9]{3})/)).toBeFalsy()
    });
});

describe("Teste de regex de URL de Linkedin utilizando comparador", () => {
    const regexLinkedin = /\./gi;
    function validaLinkedin(linkedin:string) : boolean{
        let comparadorLinkedin = "linkedin";
        let comparadoLinkedin = linkedin.split(regexLinkedin);
        if(!((comparadorLinkedin === comparadoLinkedin[1]) || (comparadorLinkedin === comparadoLinkedin[0]))){
            return false
        }
        else{
            return true
        }
    }
    test("Verifica returna verdadeiro se a URL tem linkedin com www", () => {
        expect(validaLinkedin("www.linkedin.com/candidato")).toBeTruthy()
    });
    test("Verifica returna verdadeiro se a URL tem linkedin com https", () => {
        expect(validaLinkedin("https://www.linkedin.com/candidato")).toBeTruthy()
    });
    test("Verifica returna verdadeiro se a URL tem linkedin no início", () => {
        expect(validaLinkedin("linkedin.com/candidato")).toBeTruthy()
    });
    test("Verifica returna falso se a URL não tem linkedin", () => {
        expect(validaLinkedin("www.google.com")).toBeFalsy()
    });
});

describe("Teste de regex de email", () => {
    test("Verifica se o email completo retorna verdadeiro", () => {
        expect("exemplo@acelerazg.com").toMatch(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)
    });
    test("Verifica se retorna falso se faltar o nome de usuário", () => {
        expect(("@acelerazg.com").match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)).toBeFalsy()
    });
    test("Verifica se retorna falso se faltar o provedor", () => {
        expect(("exemplo@.com").match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)).toBeFalsy()
    });
    test("Verifica se retorna falso se faltar o domínio", () => {
        expect(("exemplo@acelerazg").match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)).toBeFalsy()
    });
    test("Verifica se retorna falso se faltar a pontuação", () => {
        expect(("exemplo@acelerazgcom").match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)).toBeFalsy()
    });
    test("Verifica se retorna falso se faltar @", () => {
        expect(("exemploacelerazg.com").match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)).toBeFalsy()
    });
    test("Verifica se retorna falso com a inserção de caracteres especiais", () => {
        expect(("exemplo!*#@acelerazg.com").match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/)).toBeFalsy()
    });
});

describe("Teste de regex de telefone móvel e fixo", () => {
    test("Verifica se o telefone celular completo retorna verdadeiro com parênteses e hífen", () => {
        expect("(62)98202-0000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone celular completo retorna verdadeiro sem parênteses", () => {
        expect("6298202-0000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone celular completo retorna verdadeiro sem hífen", () => {
        expect("(62)982020000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone celular completo retorna verdadeiro sem parênteses nem hífen", () => {
        expect("62982020000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone fixo completo retorna verdadeiro com parênteses e hífen", () => {
        expect("(62)3280-0000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone fixo completo retorna verdadeiro sem parênteses", () => {
        expect("623280-0000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone fixo completo retorna verdadeiro sem hífen", () => {
        expect("(62)32800000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se o telefone fixo completo retorna verdadeiro sem parênteses nem hífen", () => {
        expect("6232800000").toMatch(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)
    });
    test("Verifica se retorna falso sem o DDD", () => {
        expect(("98202-0000").match(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)).toBeFalsy()
    });
    test("Verifica se retorna falso com o DDD inválido", () => {
        expect(("(00)98202-0000").match(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)).toBeFalsy()
    });
    test("Verifica se retorna falso com mais de 10 números", () => {
        expect(("(62)98202-00000").match(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)).toBeFalsy()
    });
    test("Verifica se retorna falso com menos de 10 números", () => {
        expect(("(62)98202-000").match(/^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$/)).toBeFalsy()
    });
});