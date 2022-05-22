/**
 * @jest-environment jsdom
 */

test('use jsdom in this test file', () => {
    const element = document.createElement('div');
    expect(element).not.toBeNull();
});

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