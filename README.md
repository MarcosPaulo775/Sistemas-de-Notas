# Sistemas de Notas

Este programa tem como objetivo gravar as notas de uma disciplina gerando assim o boletim do aluno, com as suas informações pessoais gravando tudo em arquivo `.txt`. Alem de gravar no arquivo `.txt` o programa tambem lê o arquivo buscando apartir da matricula do aluno o seu boletim e o imprimi no console.

## Configurações do Sistema

No arquivo `Main.java` existem duas variaveis estaticas que configuram o arquivo`.txt`.

- `public static File dir = new File("C:/Users/nome_do_usuario/Desktop");`  
Onde se encontra `nome_do_usuario` deve-se colocar o seu usuario de forma a direcionar o arquivo para seu desktop, ou    alterar o endereço `C:/Users/nome_do_usuario/Desktop` para qualquer um de sua preferencia.

- `public static File arq = new File(dir, "Dados.txt");`  
Está função nomeia o arquivo, caso deseje altera-lo troque a palavra `Dados` pelo nome desejado.

## Menu do Sistema

Segue abaixo o menu inicial do sistema:

`QUAL OPERAÇÃO DESEJA FAZER?`  
`1- Cadastrar novo boletim;`  
`2- Procurar boletim apartir da matricula do aluno;`  
`3- Sair;`  

Caso o usuario digite qualquer outro numero o programa irá parar de funcionar e exibirá uma mensagem de erro no console(`RESPOSTA INVALIDA`);