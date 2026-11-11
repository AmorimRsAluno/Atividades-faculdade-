/*
Projeto Folha de Pagamento

Esse programa tem como objetivo desenvolver uma folha de pagamento em Java, sem se aprofundar nos conceitos de
POO. O programa irá cadastrar vários tipos de colaboradores, calcular seus salários dependendo do tipo do colaborador,
e exibir as informações desses colaboradores e de seus respectivos salarios.
As informações serão cadastradas em uma ArrayList.
O programa irá começar solicitando qual opção o usuário irá escolher. Abaixo estão as opções:

1 - Cadastrar Colaborador Padrão: irá cadastrar o colaborador padrão, solicitando a matricula e nome.

2 - Cadastrar Colaborador Comissionado: irá cadastrar um colaborador comissionado, , solicitando a 
matricula, nome, valor de vendas e percentual de comissão.

3 - Cadastrar Colaborador Produção: irá cadastrar um colaborador de produção, solicitando a matricula, nome,
quantidade de peças e valor por peça.

4 - Gerar Folha de Pagamento: irá exibir as seguintes informações: matrícula, nome, tipo do colaborador, salário base,
benefício adicional(comissão ou bonus, se existirem) e salário final.

5 - Exibir Resumo da Folha: irá exibir as seguintes informações: quantidade total de colaboradores, 
soma total da folha de pagamento e média salarial dos colaboradores.

0 - Sair do Programa: irá encerrar o programa.

E aqui estão os tipos de colaboradores:
1-Funcionário padrão: Recebe apenas o salário base.

2-Funcionário comissionado: Recebe salário base + comissão. A comissão é calculada pela 
seguinte fórmula: Comissão = (vendas * percentual / 100)

3-Funcionário de produção: Recebe salário base + bônus por produtividade. O bônus é calculado pela 
seguinte fórmula: Bônus = (valorPorPeça * quantidadeProduzida)

O salário base é de 2000.

*/
import java.util.Scanner;
import java.util.ArrayList;

public class a1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final float SALARIO_BASE = 2000;

        /*Para armazenar as informações necessárias, vamos usar uma ArrayList. Ela é uma lista dinamica, onde, nela, 
        elementos podem ser adicionados ou removidos livremente.
        Para declarar um ArrayList, é necessário usar o operador "new". Ele serve para já alocar um espaço na memória para
        essa ArrayList. */
        ArrayList<Integer> matriculas = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<Float> beneficios = new ArrayList<>();
        ArrayList<Float> salarios = new ArrayList<>();

        int opcao = -1;
        
        /*Aqui, vamos solicitar que o usuário escolha uma opção entre 0 a 5. Se nenhuma dessas opções for digitada,
        será exibida uma mensagem de erro e o programa irá solicitar novamente uma opção.*/
        while (opcao != 0) {

            System.out.println("\n===== FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Cadastrar Colaborador Padrao");
            System.out.println("2 - Cadastrar Colaborador Comissionado");
            System.out.println("3 - Cadastrar Colaborador Producao");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("5 - Exibir Resumo da Folha");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            /*Esse método nextLine serve para evitar um bug que pode ocorrer no código: ao apertar enter, o código pode 
            acabar lendo o comando /n e atribui-lo a próxima variável, causando um erro.
            Como exemplo, o /n, causado ao apertar Enter, poderia acabar sendo atribuído a variável matricula logo abaixo. */
            sc.nextLine();

            if (opcao == 1) {

                System.out.println("\n--- COLABORADOR PADRAO ---");

                System.out.print("Matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();
                
                /*Aqui, estamos declarando as variáveis matricula e nome dentro desse if, ao invés de no começo do código
                para poupar memória. Elas só serão usadas para serem atribuidas ao ArrayList. Assim que o if for encerrado,
                as variáveis serão apagadas da memória. */

                System.out.print("Nome: ");
                String nome = sc.nextLine();
                
                /*Para adicionar as variáveis dentro da ArrayList, usamos o método add. Lembrando que a ArrayList é dinamica,
                então se um elemento já existir dentro de um índice, o novo elemento será automaticamente
                atribuído ao próximo índice.
                 */
                matriculas.add(matricula);
                nomes.add(nome);
                tipos.add("Padrao");

                /*Vamos atribuir 0f ao Array beneficios. O 0f que é um zero usado para atribuir para variáveis do tipo float.
                Mesmo que esse colaborador não tenha benefício, é necessário atribuir um valor para que os índices de todos os Arrays sejam preenchidos.
                E, estamos usando o 0f pois, quando formos puxar as informações das Arrays com a opção 4, será exibido 
                no benefícios a frase "Benefício: Nenhum", graças a um if que está dentro da opção 4. */
                beneficios.add(0f);
                salarios.add(SALARIO_BASE);

                System.out.println("Colaborador cadastrado!");

            } else if (opcao == 2) {
            /*Faremos o mesmo na opção 2, vamos declarar variáveis, atribuir a elas o valor digitado e depois
            atribui-las ao seus respectivos ArrayLists com o método add, além de fazer o cálculo da comissão. */
                System.out.println("\n--- COLABORADOR COMISSIONADO ---");

                System.out.print("Matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Valor de vendas: ");
                float vendas = sc.nextFloat();

                System.out.print("Percentual de comissao: ");
                float percentual = sc.nextFloat();
                sc.nextLine();

                float comissao = vendas * percentual / 100;
                float salarioComissao = SALARIO_BASE + comissao;

                matriculas.add(matricula);
                nomes.add(nome);
                tipos.add("Comissionado");
                beneficios.add(comissao);
                salarios.add(salarioComissao);

                System.out.println("Colaborador cadastrado!");

            } else if (opcao == 3) {
            /*E também faremos o mesmo com a opção 3. */

                System.out.println("\n--- COLABORADOR PRODUCAO ---");

                System.out.print("Matricula: ");
                int matricula = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Quantidade de pecas: ");
                int quantidade = sc.nextInt();

                System.out.print("Valor por peca: ");
                float valorPeca = sc.nextFloat();
                sc.nextLine();

                float produtividade = quantidade * valorPeca;
                float salarioProducao = SALARIO_BASE + produtividade;

                matriculas.add(matricula);
                nomes.add(nome);
                tipos.add("Producao");
                beneficios.add(produtividade);
                salarios.add(salarioProducao);

                System.out.println("Colaborador cadastrado!");

            } else if (opcao == 4) {
                /*Agora, vamos exibir as informações dos colaboradoes cadastradas nas Arrays. Mas, antes disso, vamos verificar
                se existe algo na Array nomes. Caso não exista, significa que não há nada cadastrado em nenhuma das Arrays.
                Vamos fazer isso usando o método size, que detecta o tamanho da Array, */
                System.out.println("\n===== FOLHA DE PAGAMENTO =====");

                if (nomes.size() == 0) {
                /* Como o tamanho da Array nomes é igual a zero, significa que ela, assim com as outras Arrays estão vazias. */
                    System.out.println("Nenhum colaborador cadastrado.");

                } else {
                    /*Vamos percorrer todas as Arraylists usando o for, retornar e exibir o conteúdo de seus índices
                    usando o método .get. */
                    for (int i = 0; i < nomes.size(); i++) {

                        System.out.println("\nMatricula: " + matriculas.get(i));
                        System.out.println("Nome: " + nomes.get(i));
                        System.out.println("Tipo: " + tipos.get(i));
                        System.out.println("Salario Base: R$ " + SALARIO_BASE);
                        
                        /*Aqui está o if que mencionamos na opção 1. Quando o benefício for menor ou igual a zero,
                        será exibido a mensagem que o colaborador não possuí nenhum benefício adicional. */
                        if (beneficios.get(i) > 0) {

                            System.out.println("Beneficio adicional: R$ " + beneficios.get(i));

                        } else {

                            System.out.println("Beneficio adicional: Nenhum");

                        }

                        System.out.println("Salario Final: R$ " + salarios.get(i));
                        System.out.println("-----------------------------");

                    }
                }

            } else if (opcao == 5) {
            /* E, por fim, na opção 5, vamos exibir um resumo da folha. */

                System.out.println("\n===== RESUMO DA FOLHA =====");

            /* Para exibir a quantidade de colaboradores, vamos contar todo o conteúdo da Array nomes usando o método size
            e atribuir a variável totalColaboradores */

                int totalColaboradores = nomes.size();
                float totalFolha = 0;
                float mediaSalarial = 0;
                
                //Vamos usar um for para atribuir e somar os salários ao totalFolha.
                for (int i = 0; i < salarios.size(); i++) {

                    totalFolha = totalFolha + salarios.get(i);

                }
                /*E, por fim, vamos calcular a média salarial usando a soma de todos os salários e a quantidade
                total de colaboradores. */
                if (totalColaboradores > 0) {

                    mediaSalarial = totalFolha / totalColaboradores;

                }

                System.out.println("Total de colaboradores: " + totalColaboradores);
                System.out.println("Total da folha: R$ " + totalFolha);
                System.out.println("Media salarial: R$ " + mediaSalarial);

            } else if (opcao == 0) {

                System.out.println("Encerrando o programa...");
            
            //Por fim, aqui está o if para caso o usuário não digite uma opção entre 0 e 5.
            } else {

                System.out.println("Opcao invalida!");

            }

        }

        sc.close();

    }
}
