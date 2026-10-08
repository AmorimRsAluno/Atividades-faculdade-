
import java.util.Scanner;

public class TerminalBancario {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Variaveis do sistema
        double saldo = 1000.00;
        double valor;
        int opcao;

        System.out.println("==================================");
        System.out.println("        TERMINAL BANCARIO         ");
        System.out.println("==================================");
        System.out.println("Bem-vindo ao Banco Digital!");

        // Estrutura de repeticao: maximo 5 operacoes
        for (int i = 1; i <= 5; i++) {

            System.out.println("\n==================================");
            System.out.println("OPERACAO " + i + " DE 5");
            System.out.println("==================================");

            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Deposito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Encerrar Atendimento");

            System.out.print("\nEscolha uma opcao: ");
            opcao = entrada.nextInt();

            // Opcao 1: Consultar saldo
            if (opcao == 1) {

                System.out.println("\nCONSULTA DE SALDO");

                System.out.printf(
                    "Saldo disponivel: R$ %.2f%n", saldo
                );

            }

            // Opcao 2: Deposito
            else if (opcao == 2) {

                System.out.println("\nREALIZAR DEPOSITO");

                System.out.print("Digite o valor: R$ ");
                valor = entrada.nextDouble();

                if (valor > 0 && Double.isFinite(valor)) {

                    saldo = saldo + valor;

                    System.out.println(
                        "Deposito realizado com sucesso!"
                    );

                    System.out.printf(
                        "Novo saldo: R$ %.2f%n", saldo
                    );

                } else {

                    System.out.println(
                        "Erro: o valor deve ser maior que zero."
                    );
                }

            }

            // Opcao 3: Saque
            else if (opcao == 3) {

                System.out.println("\nREALIZAR SAQUE");

                System.out.print("Digite o valor: R$ ");
                valor = entrada.nextDouble();

                if (valor <= 0 || !Double.isFinite(valor)) {

                    System.out.println(
                        "Erro: informe um valor positivo."
                    );

                } else if (valor > saldo) {

                    System.out.println(
                        "Saldo Insuficiente."
                    );

                } else {

                    saldo = saldo - valor;

                    System.out.println(
                        "Saque realizado com sucesso!"
                    );

                    System.out.printf(
                        "Novo saldo: R$ %.2f%n", saldo
                    );
                }

            }

            // Opcao 4: Encerrar atendimento
            else if (opcao == 4) {

                System.out.println(
                    "\nAtendimento encerrado pelo usuario."
                );

                break;

            }

            // Opcao invalida
            else {

                System.out.println(
                    "\nOpcao invalida! Tente novamente."
                );
            }

            // Encerramento automatico
            if (i == 5) {

                System.out.println(
                    "\nLimite de 5 operacoes atingido!"
                );

                System.out.println(
                    "Sessao encerrada automaticamente."
                );
            }
        }

        System.out.println("\n==================================");
        System.out.println("Obrigado por utilizar nosso banco!");
        System.out.println("==================================");

        entrada.close();
    }
}
