# Sistema para Gestão de Floricultura (SGF)

Sistema desenvolvido em Java para obtenção de créditos na disciplina de Paradigmas de Linguagens de Programação 
da Universidade Federal de Lavras (UFLA) 2019/1.  


## Compilação

O projeto usa interface gráfica, portanto faz uso de algumas bibliotecas e necessita de alguns parâmetros específicos para compilação. 
Para facilitar todo o processo, recomenda-se o uso de [Apache Ant](https://ant.apache.org/) 
(ferramenta utilizada para automação de compilação na construção de software). 

### Pré-requisitos
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
* [Apache Ant](https://ant.apache.org/manual-1.9.x/index.html)

### Processo de compilação
Para compilar o projeto (após instalação do JDK e Apache Ant), deve-se:

* Alterar o arquivo sgf.properties, definindo a variável 'jdk.home.1.8' para o diretório onde encontra-se instalado o JDK. Exemplo para Ubuntu:


```
jdk.home.1.8=/usr/lib/jvm/java-1.8.0-openjdk-amd64
```
 
 * Abrir o terminal no diretório raiz deste projeto (SGF) e executar o seguinte comando: 
```
ant
```

Pronto! O projeto foi compilado e os arquivos .class encontram-se na pasta:  

> out\production\SGF

o arquivo .jar encontra-se na pasta:

> out\artifacts\SGF_jar

## Executando após compilação

Para executar o projeto após a compilação pode-se usar o .jar ( out\artifacts\SGF_jar\ ) ou executar o seguinte comando na pasta raiz:

```
java -cp out/production/SGF Controller/MainController
``` 

