CREATE TABLE empresas (
	id_emp serial,
	nome_emp VARCHAR(255) NOT NULL,
	email_emp VARCHAR(255) NOT NULL,
	estado_emp VARCHAR(255) NOT NULL,
	pais_emp VARCHAR(255) NOT NULL,
	descricao_emp VARCHAR(255) NOT NULL,
	cnpj_emp VARCHAR(255) PRIMARY KEY,
	senha_emp VARCHAR(255) NOT NULL,
	cep_emp VARCHAR(255) NOT NULL
);

CREATE TABLE vagas (
	id_vgs serial PRIMARY KEY,
	nome_vgs VARCHAR(255) NOT NULL,
	estado_vgs VARCHAR(255) NOT NULL,
	descricao_vgs VARCHAR(255) NOT NULL,
	empresa_vgs VARCHAR(255) NOT NULL,
	competencias_vgs VARCHAR[] NOT NULL,
	CONSTRAINT fk_vagas
		FOREIGN KEY(empresa_vgs)
			REFERENCES empresas(cnpj_emp)
);

CREATE TABLE candidatos (
    id_cnd serial,
    nome_cnd VARCHAR(255) NOT NULL,
    email_cnd VARCHAR(255) NOT NULL,
    cep_cnd VARCHAR(255) NOT NULL,
    estado_cnd VARCHAR(255) NOT NULL,
    pais_cnd VARCHAR(255) NOT NULL,
    descricao_cnd VARCHAR(255) NOT NULL,
    cpf_cnd VARCHAR(255) PRIMARY KEY,
    formacao_cnd VARCHAR(255) NOT NULL,
    idade_cnd VARCHAR(255) NOT NULL,
    senha_cnd VARCHAR(10) NOT NULL
);

CREATE TABLE competencias (
    id_cmp serial,
    nome_cmp VARCHAR(255) PRIMARY KEY
);

CREATE TABLE candidatos_competencias (
    id_cnd VARCHAR(255) NOT NULL,
    id_cmp VARCHAR(255) NOT NULL,
    CONSTRAINT fk_competencias_id_cnd
        FOREIGN KEY (id_cnd)
            REFERENCES candidatos(cpf_cnd),
    CONSTRAINT fk_competencias_nome_cmp
        FOREIGN KEY (id_cmp)
            REFERENCES competencias(nome_cmp)
);

INSERT INTO public.candidatos (id_cnd, nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, formacao_cnd, idade_cnd, senha_cnd) VALUES (1, 'Candidato 1', 'candidato1@zg.com.br', '00000-001', 'Goiás', 'Brasil', 'Descrição do Candidato 1.', '00000000001', 'Ensino Técnico', '19', 'senha001');
INSERT INTO public.candidatos (id_cnd, nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, formacao_cnd, idade_cnd, senha_cnd) VALUES (2, 'Candidato 2', 'candidato2@zg.com.br', '00000-002', 'São Paulo', 'Brasil', 'Descrição do Candidato 2.', '00000000002', 'Bacharelado', '23', 'senha002');
INSERT INTO public.candidatos (id_cnd, nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, formacao_cnd, idade_cnd, senha_cnd) VALUES (3, 'Candidato 3', 'candidato3@zg.com.br', '00000-003', 'Santa Catarina', 'Brasil', 'Descrição do Candidato 3.', '00000000003', 'Mestrado', '26', 'senha003');
INSERT INTO public.candidatos (id_cnd, nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, formacao_cnd, idade_cnd, senha_cnd) VALUES (4, 'Candidato 4', 'candidato4@zg.com.br', '00000-004', 'Espírito Santo', 'Brasil', 'Descrição do Candidato 4.', '00000000004', 'Ensino Médio', '21', 'senha004');
INSERT INTO public.candidatos (id_cnd, nome_cnd, email_cnd, cep_cnd, estado_cnd, pais_cnd, descricao_cnd, cpf_cnd, formacao_cnd, idade_cnd, senha_cnd) VALUES (5, 'Candidato 5', 'candidato5@zg.com.br', '00000-005', 'Rio de Janeiro', 'Brasil', 'Descrição do Candidato 5.', '00000000005', 'Tecnólogo', '18', 'senha005');

INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000001', 'Java');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000001', 'Python');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000001', 'Groovy');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000002', 'Javascript');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000002', 'Typescript');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000003', 'Java');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000004', 'Python');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000004', 'Groovy');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000005', 'Java');
INSERT INTO public.candidatos_competencias (id_cnd, id_cmp) VALUES ('00000000005', 'Javascript');

INSERT INTO public.competencias (id_cmp, nome_cmp) VALUES (1, 'Java');
INSERT INTO public.competencias (id_cmp, nome_cmp) VALUES (2, 'Python');
INSERT INTO public.competencias (id_cmp, nome_cmp) VALUES (3, 'Groovy');
INSERT INTO public.competencias (id_cmp, nome_cmp) VALUES (4, 'Typescript');
INSERT INTO public.competencias (id_cmp, nome_cmp) VALUES (5, 'Javascript');

INSERT INTO public.empresas (id_emp, nome_emp, email_emp, estado_emp, pais_emp, descricao_emp, cnpj_emp, senha_emp, cep_emp) VALUES (1, 'Empresa 1', 'empresa1@zg.com.br', 'Goiás', 'Brasil', 'Descrição da Empresa 1', '00000000006', 'senha600', '00000-006');
INSERT INTO public.empresas (id_emp, nome_emp, email_emp, estado_emp, pais_emp, descricao_emp, cnpj_emp, senha_emp, cep_emp) VALUES (2, 'Empresa 2', 'empresa2@zg.com.br', 'São Paulo', 'Brasil', 'Descrição da Empresa 2', '00000000007', 'senha700', '00000-007');
INSERT INTO public.empresas (id_emp, nome_emp, email_emp, estado_emp, pais_emp, descricao_emp, cnpj_emp, senha_emp, cep_emp) VALUES (3, 'Empresa 3', 'empresa3@zg.com.br', 'Santa Catarina', 'Brasil', 'Descrição da Empresa 3', '00000000008', 'senha800', '00000-008');
INSERT INTO public.empresas (id_emp, nome_emp, email_emp, estado_emp, pais_emp, descricao_emp, cnpj_emp, senha_emp, cep_emp) VALUES (4, 'Empresa 4', 'empresa4@zg.com.br', 'Espírito Santo', 'Brasil', 'Descrição da Empresa 4', '00000000009', 'senha900', '00000-009');
INSERT INTO public.empresas (id_emp, nome_emp, email_emp, estado_emp, pais_emp, descricao_emp, cnpj_emp, senha_emp, cep_emp) VALUES (5, 'Empresa 5', 'empresa5@zg.com.br', 'Distrito Federal', 'Brasil', 'Descrição da Empresa 5', '00000000010', 'senha1000', '00000-010');

INSERT INTO public.vagas (id_vgs, nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (1, 'Vaga 1', 'Goiás', 'Descrição da vaga 1.', '00000000006', '{Python,Java}');
INSERT INTO public.vagas (id_vgs, nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (2, 'Vaga 2', 'Goiás', 'Descrição da vaga 2.', '00000000006', '{Python}');
INSERT INTO public.vagas (id_vgs, nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (3, 'Vaga 3', 'Bahia', 'Descrição da vaga 3.', '00000000007', '{Javascript,Typescript}');
INSERT INTO public.vagas (id_vgs, nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (4, 'Vaga 4', 'Amapá', 'Descrição da vaga 4.', '00000000008', '{Groovy,Java}');
INSERT INTO public.vagas (id_vgs, nome_vgs, estado_vgs, descricao_vgs, empresa_vgs, competencias_vgs) VALUES (5, 'Vaga 5', 'Tocantins', 'Descrição da vaga 5.', '00000000009', '{Java}');



