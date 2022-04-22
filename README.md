# ZG Hero Project: Linketinder

Esse é o repositório do projeto **Linketinder** do programa Acelera ZG, sendo que este é um programa intensivo promovido pela empresa ZG Soluções para a capacitação de novos estagiários em potencial.
Está dividindo em etapas, sendo que capa etapa contém trilhas semanais com 2 desafios: um projeto introdutório e um projeto avançado que simula uma rotina da empresa. Cada trilha introduz um assunto diferente, como uma prática de programação ou contato com uma nova linguagem. 
Nem toda trilha trabalha utilizando esse repositório, então aqui estão somente as que se relacionam diretamente com o projeto.
Minhas IDEs escolhidas foram Intellij IDEA e WebStorm.

## Trilha 1: Versionamento de Código
**Assunto**: Git e Github

**Descrição do desafio**: Criar o repositório que dará origem às branchs de desenvolvimento do projeto.

**Data de entrega**: 22/01/22

## Trilha 3: Java e Groovy
**Assunto**: Groovy

**Descrição do desafio**: Primeiro contato com o conceito do Linketinder através da simulação de uma reunião com um cliente em potencial. O cliente deseja um programa que combine as funcionalidades do Linkedin + Tinder, ou seja, um programa que permite o match entre um candidato e uma empresa através de competências/habilidades do candidato. 
Os requisitos foram:
- Array de candidatos com no mínimo 5 candidatos cadastrados, sendo que cada candidato tem um atributo de competências pré-definidas que também é um array
- Array de empresas com no mínimo 5 empresas cadastradas
- Listagem de todas as empresas e todos os candidatos para validação de dados
- Atributos do candidato: nome, email, CPF, idade, estado, CEP e descrição pessoal
- Atributos da empresa: nome, email corporativo, CNPJ, país, estado, CEP e descrição  da empresa

**Data de entrega**: 26/02/22

 ## Trilha 4: Testes Unitários
 **Assunto**: JUnit
 
 **Descrição do desafio**: implementação de testes com os métodos criados na trilha anterior.
 
 **Data de entrega**: 07/03/22

## Trilha 5: JavaScript/TypeScript
**Assunto**: TypeScript, HTML e CSS

**Descrição do desafio**: Implementação do frontend com os seguintes requisitos (sem a comunicação com o backend):
- 4 funcionalidades convertidas em telas: cadastro de candidato, cadastro de empresa e o perfil de ambos
- Gráfico de barras de usuários por competência (não atendido no momento devido à restrições de tempo)
- 
**Observação pessoal**: Foi a trilha mais divertida mesmo sendo meu primeiro contato com TypeScript e CSS (já tive alguma experiência com edição de código fonte de blogs pessoais para personalização na adolescência).

**Data de entrega**: 28/03/22

![imagem de página inicial do frontend](/Frontend/linketinder-frontend-pagina-inicial.png)

## Trilha 6: Regex
**Assunto**: Expressões regulares aplicadas em TypeScript

**Descrição do desafio**: Validação de dados de cadastro, sendo que em caso de erro o usuário é avisado com uma mensagem de alerta.
Do candidato:
- Nome
- Email
- CPF
- telefone
- URL do perfil do Linkedin

Da empresa:
- Nome
- CNPJ
- Email
- CEP

**Data de entrega**: 01/04/22

## Trilha 7: Banco de Dados
**Assunto**: PostgreSQL

**Descrição do desafio**: Desenvolvimento da integração em Groovy com o BD baseado em JDBC. As informações do candidato são coletadas e salvas na tabela de candidatos, e suas competências são inseridas na tabela de competências, com a relação de N:N de Candidato para Competência.
Já as informações da empresa são coletadas e salvas na tabela de empresas, e a empresa possui a opção de inserir vagas. Cada vaga pertence a somente uma empresa, mas uma empresa pode ter várias vagas (relação 1:N entre tabelas).
Além disso, há 4 CRUDs diferentes na aplicação (candidato, vaga, empresa e competências).
A modelagem de representação do banco foi realizada com o MySQLWorkbench, e a administração de tabelas é realizada com o PgAdmin4.

**Observação pessoal**: Foi uma trilha especialmente desafiadora para mim, pois foi meu primeiro contato com o assunto em um espaço curtíssimo de tempo.

**Data de entrega**: 08/04/22


![imagem de modelagem do banco de dados](Database/modelo_db_v2.png)

## Trilha 8: Gradle
**Assunto**: Gradle

**Descrição do desafio**: adaptação do projeto inteiro com a ferramenta Gradle.

**Data de entrega**: 11/04/22

## Trilha 1, Parte 2: Clean Code
**Assunto**: Boas práticas de programação e Código Limpo

**Descrição do desafio**: análise e refatoração do projeto até o momento utilizando os conceitos aprendidos de Clean Code, como:
1. Nomes autoexplicativos
2. Regra do Escoteiro
3. Funções pequenas
4. Don't Repeat Yourself (DRY)
5. Comentários somente se necessários
6. Tratamento de erros
7. Testagem

**Observações pessoais**: Tirei uma manhã para analisar o meu código e elaborei a seguinte lista de requisitos para entrega (os que consegui implementar a tempo estão marcados com um ✔️)
- Retirada de comentários desnecessários na classe Database ✔️
- Renomeação de métodos na classe pessoa física e jurídica para verbos ✔️
- Renomeação de competências para melhor entendimento no frontend ✔️
- Renomeação de métodos no linketinder.ts para verbos ✔️
- Remoção de método de regex de CPF ou CNPJ duplicados ✔️
- Alteração de regex de telefone para um que pegue celular ou telefone fixo do Brasil ✔️
- Adição de retorno esperado das funções de validação ✔️
- Adição de testes para métodos de regex ✔️
- Adição de testes para o cadastro de frontend
- Correção de testes unitários de pessoa física e jurídica
- Adição de feature: requisito de gráfico
- Adição de feature: adição de vagas pela empresa
- Correção de pasta raiz de frontend ✔️
- Retirada da versão 1 da entrega da trilha de Banco de Dados ✔️
- Refazer o readme ✔️

**Data de entrega**: pendente
