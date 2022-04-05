CREATE TABLE `CANDIDATOS` (
  `Id_Cnd` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Nome_Cnd` varchar(255) NOT NULL,
  `Email_Cnd` varchar(255) NOT NULL,
  `Cep_Cnd` varchar(255) NOT NULL,
  `Estado_Cnd` varchar(255) NOT NULL,
  `Pais_Cnd` varchar(255) NOT NULL,
  `Descricao_Cnd` varchar(255) NOT NULL,
  `Telefone_Cnd` varchar(255) NOT NULL,
  `Linkedin_Cnd` varchar(255) NOT NULL,
  `Cpf_Cnd` varchar(255) NOT NULL,
  `Idade_Cnd` integer NOT NULL,
  `Senha_Cnd` char(10) NOT NULL,
  `Formacao_Cnd` varchar(255) NOT NULL
);

CREATE TABLE `EMPRESAS` (
  `Id_Emp` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Nome_Emp` varchar(255) NOT NULL,
  `Email_Emp` varchar(255) NOT NULL,
  `Estado_Emp` varchar(255) NOT NULL,
  `Pais_Emp` varchar(255) NOT NULL,
  `Descricao_Emp` varchar(255) NOT NULL,
  `Telefone_Emp` varchar(255) NOT NULL,
  `Cnpj_Emp` varchar(255) NOT NULL,
  `Senha_Emp` char(10) NOT NULL
);

CREATE TABLE `VAGAS` (
  `Id_Vgs` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Nome_Vgs` varchar(255) NOT NULL,
  `Estado_Vgs` varchar(255) NOT NULL,
  `Descricao_Vgs` varchar(255) NOT NULL,
  `Competencias_Vgs` boolean[],
  `Empresa_Vgs` varchar(255) NOT NULL
);

CREATE TABLE `COMPETENCIAS` (
  `Id_Cmp` int NOT NULL AUTO_INCREMENT,
  `Nome_Cmp` varchar(255) NOT NULL
);

CREATE TABLE `CANDIDATOS_COMPETENCIAS` (
  `Id_Cnd` int NOT NULL,
  `Id_Cmp` int NOT NULL
);

ALTER TABLE `VAGAS` ADD FOREIGN KEY (`Empresa_Vgs`) REFERENCES `EMPRESAS` (`Id_Emp`);

ALTER TABLE `CANDIDATOS_COMPETENCIAS` ADD FOREIGN KEY (`Id_Cnd`) REFERENCES `CANDIDATOS` (`Id_Cnd`);

ALTER TABLE `CANDIDATOS_COMPETENCIAS` ADD FOREIGN KEY (`Id_Cmp`) REFERENCES `COMPETENCIAS` (`Id_Cmp`);
