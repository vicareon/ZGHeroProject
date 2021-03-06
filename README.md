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

![imagem de página inicial do frontend](/linketinder-frontend-pagina-inicial.png)

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
- Adição de testes para o cadastro de frontend (ver trilha 2)
- Correção de testes unitários de pessoa física e jurídica (ver trilha 2)
- Adição de feature: requisito de gráfico
- Adição de feature: adição de vagas pela empresa
- Correção de pasta raiz de frontend ✔️
- Retirada da versão 1 da entrega da trilha de Banco de Dados ✔️
- Refazer o readme ✔️

**Data de entrega**: 22/04/22

## Trilha 2: Princípios S.O.L.I.D
**Assunto**: Boas práticas de programação com aplicação dos princípios S.O.L.I.D

**Descrição do desafio**: análise e refatoração do projeto até o momento utilizando os conceitos aprendidos:

>S: Responsabilidade única
>
>O: Princípio aberto/fechado
>
>L: Substituição de Liskov
>
>I: Segregação de interface
>
>D: Inversão de dependência

Para facilitar o entendimento, separei as modificações realizadas por letra.
- S: as classes PessoaFisica e PessoaJuridica estavam com a responsabilidade de método de cadastro que não será mais utilizada ao longo do programa devido às implementações de frontend e database.
- O: as classes Pessoa, PessoaFisica e PessoaJuridica possuem escopos bem definidos e não há a necessidade de alterá-las, apenas extendê-las caso necessário.
- L: as classes PessoaFisica e PessoaJuridica extendem completamente a classe Pessoa e não há comportamentos exclusivos de cada classe.
- I: como as classes não possuem métodos, não há a necessidade de implementação de interface.
- D: a implementação desse princípio na classe de Database será especificada na trilha de design patterns. 

**Data de entrega**: 01/05/2022

## Trilha 3: Padrões de Projeto
**Assunto**: Design Patterns em Java

**Descrição do desafio**: Refatoração do projeto com base em padrões de projeto à escolha do participante. As patterns escolhidas foram *DAO* e *Singleton*. Além disso, escolhi renomear PessoaFisica e PessoaJuridica para Candidato e Empresa, respectivamente, e eliminei a interface Pessoa para melhorar a leitura do código e torná-lo mais intuitivo. 

- DAO: essa pattern foi escolhida com o objetivo de abstração e encapsulamento das classes Candidato, Empresa, Vaga e Competência.
- Singleton: como a conexão com o banco de dados precisa apenas de uma instância, essa pattern foi escolhida para dar conta do recado.

**Data de entrega**: 08/05/2022

## Trilha 4: Padrão MVC
**Assunto**: Pattern de Model, View e Controller em Java

**Descrição do desafio**: Refatoração do projeto com base no padrão MVC. O frontend realiza a visão de View, portanto, o backend foi dividido em 3 pacotes: model, dao e controller. Já com a bagagem das trilhas anteriores, também implementei mudanças que eliminaram as violações do princípio S.O.L.I.D:

>S: a classe Database possuía várias responsabilidades, sendo considerada uma "God Class". Isso fez sentido na trilha 7, pois meus conhecimentos não eram suficientes para reconhecer a necessidade de otimização e também devido ao prazo de entrega. Assim, os métodos da classe foram distribuídos nas classes de controller. 
>
>O: As classes de Candidato, Empresa, Vaga e Competência já tinham escopos bem definidos, então não houve uma alteração significativa com base nesse princípio.
>
>L: como houve a refatoração de Candidato e Empresa, a herança de Pessoa para PessoaFisica e PessoaJuridica foi eliminada.
>
>I: as interfaces aplicadas nas classes tem todos os métodos implementados.
>
>D: no projeto havia uma forte dependência no input do usuário. Assim, concentrei todos os inputs capturados pelo Scanner em uma só classe, a Main; todos os métodos implementados nas classes Controller recebem o input, permitindo a realização de testes unitários sem a necessidade de mock (o que exigiria um prazo maior de entrega devido à complexidade). 

**Data de entrega**: 08/05/2022

## Trilha 5: Webservices e Microservices
**Assunto**: Microserviço de Cadastro de Candidato e Empresa

**Descrição do desafio**: Implementação de microserviço de cadastro de candidato e empresa no frontend com inserção no banco de dados no backend com caráter exploratório:

>Repare que a integração do frontend com o microsserviço é de caráter exploratório, ou seja, você irá buscar uma solução e tentar aplicá-la em tempo hábil, caso não dê certo, basta entregar até o ponto explorado com a descrição do que foi pesquisado e tentado (é um aspecto experimental da entrega).

**Comentários pessoais**: Foi a trilha que senti pela primeira vez a sensação de frustração por causa de sua complexidade. Antes de começar a implementação do microserviço, foi necessário gastar um bom tempo revisando o conteúdo de Typescript/Javascript (pois já fazia um bom tempo que eu não tinha contato) e tentando aplicar os conhecimentos adquiridos nas trilhas anteriores de Clean Code e SOLID. Depois de muita tentativa de trabalhar com módulos de exportação e importação em Typescript, optei pela conveniência/má prática de deixar todo o código em uma classe só (linketinder.ts) já que já tinha desperdiçado muito tempo nessa tentativa de refatoração. 

Além disso, tive que corrigir a implementação do Gradle que não fazia sentido nesse módulo. Assim, corrigi a lacuna de conhecimento na configuração dos arquivos json de package e config porque a transpilação de TS para JS não estava funcionando corretamente - agora as dependências Babel, Jest e TSC estão devidamente instaladas e atualizadas no projeto. 

Depois, veio a surpresa que o input do usuário nos formulários de cadastro não estavam mais sendo captados porque os valores estavam sendo pegos antes mesmo de ter o input de verdade: isso foi resolvido ao retirar o .value na captura de elemento e transferir para o parâmetro da função. 

Também foram feitas as seguintes atualizações para alinhamento de parâmetros entre frontend e backend:
- Retirada de declaração de classes de Candidato e Empresa, já que não tem mais a permanência separada em front e back
- Retirada de parâmetros Linkedin e Telefone dos objetos, regex e testes unitários

... e também a substituição de janelas modais para páginas HTML separadas. Não fica mais tão bonitinho, mas estão mais de acordo com meu nível de conhecimento atual.

Por fim, vem a adição de fetch() com POST para os métodos de cadastro, o que nos leva para o backend. 

A ideia do desafio no backend foi a seguinte: implementar um microserviço totalmente independente do resto, com uma instância de conexão com o banco de dados e o reaproveitamento dos códigos de inserção de elementos implementado nos Controllers. Infelizmente por limitação de conhecimento (além do tempo) não consegui implementar totalmente os métodos de POST (apenas o de GET), mas consegui implementar os seus endpoints por meio da criação de um servidor na porta 8080 do localhost. Assim, quando roda o main, ele dá uma mensagem quando o servidor é iniciado:

![imagem de terminal com endpoint](/endpoint-microservico.jpeg)

Aqui estão os tutoriais e artigos que me foram mais úteis:
- [How to make a REST API in Java](https://www.educative.io/edpresso/how-to-make-a-rest-api-in-java), por Divine Odazie
- [JavaScript: Fetch](https://www.devmedia.com.br/javascript-fetch/41206), da DevMedia
- [Aprendendo Java com JDBC](https://www.devmedia.com.br/aprendendo-java-com-jdbc/29116), da DevMedia
- [Creating a REST API](https://happycoding.io/tutorials/java-server/rest-api), por Kevin Workman

Para dar uma olhada no código, navegue até a branch microservice :)

**Data de entrega**: 21/05/2022

## Trilha 6: REST/RESTFUL API
**Assunto**: APIs e integração definitiva entre front e backend

**Descrição do desafio**: Como uma expansão da trilha anterior, também tive dificuldades nessa trilha devido ao seu alto nível de complexidade com o prazo extremamente curto de entrega - a ideia foi a implementação de uma api REST/RESTFUL de cadastro de candidato e empresa. 

Essas foram as implementações do desafio:
- Configuração do Apache Tomcat para rodar dentro do Intellij com deploy de artefatos
- Criação de servlets mapeados para servir como endpoints no backend junto com o controller, aproveitando a lógica de implementação do programa direto no terminal (para mais informações, ver classe Main)
- Blocos try/catch com erros em protocolo HTTP
- Criação de arquivo .war na pasta local de webapps do Apache Tomcat
- Adição de suporte à aplicação web no Intellij: os arquivos que ficavam na pasta de Frontend, separada do resto do programa, agora ficam na pasta webapp dentro da src/main
- Criação das páginas HTML para o cadastro de Competências e cadastro de Vagas

Expandindo a lista de tutoriais, dúvidas respondidas e artigos da trilha anterior:
- [A Step by Step Guide to Installing Apache Tomcat 9 Linux](https://www.makeuseof.com/a-step-by-step-guide-to-installing-apache-tomcat-linux/), por Jerome Davidson
- [Enable Web application support](https://www.jetbrains.com/help/idea/enabling-web-application-support.html#:~:text=In%20the%20Project%20tool%20window,version%20of%20the%20Servlet%20specification), da Jetbrains
- [What is RESTful API?](https://www.techtarget.com/searchapparchitecture/definition/RESTful-API), por Alexander S. Gillis
- [Java servlet RESTful Client with RESTEasy](https://zetcode.com/javaservlet/restclient/), da Zetcode
- [Intellij fails deploying exploded war to Tomcat](https://stackoverflow.com/questions/47078199/intellij-fails-deploying-exploded-war-to-tomcat), no Stackoverflow
- [Generating a War file from a plain Intellij project](https://dzone.com/articles/generating-war-file-plain), por Zemian Deng

**Data de entrega**: 27/05/2022
