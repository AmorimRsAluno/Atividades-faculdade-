
import java.util.Scanner;

public class sistemaestacionamento {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Variaveis do sistema
        int horas;
        int tipoVeiculo;

        int totalVeiculos = 0;
        int totalEletricos = 0;
        int totalConvencionais = 0;
        int totalDiarias = 0;

        double valor;
        double desconto;
        double faturamentoTotal = 0;

        System.out.println("======================================");
        System.out.println("     SISTEMA DE ESTACIONAMENTO        ");
        System.out.println("======================================");

        System.out.println("Bem-vindo ao sistema de cobranca!");

        // Laco FOR: atendimento de 4 veiculos
        for (int i = 1; i <= 4; i++) {

            System.out.println("\n======================================");
            System.out.println("       ATENDIMENTO DO VEICULO " + i);
            System.out.println("======================================");

            // Entrada do tempo de permanencia
            System.out.print("Tempo de permanencia (horas): ");
            horas = entrada.nextInt();

            // Entrada do tipo de veiculo
            System.out.println("\nTipo de veiculo:");
            System.out.println("1 - Convencional");
            System.out.println("2 - Eletrico");

            System.out.print("Escolha uma opcao: ");
            tipoVeiculo = entrada.nextInt();

            // Validacao dos dados
            if (horas <= 0 ||
                (tipoVeiculo != 1 && tipoVeiculo != 2)) {

                System.out.println(
                    "\nErro: dados invalidos!"
                );

                System.out.println(
                    "Informe horas maiores que zero e " +
                    "tipo de veiculo 1 ou 2."
                );

                // Repete o atendimento atual
                i--;
                continue;
            }

            // Calculo do valor de permanencia
            if (horas == 1) {

                valor = 10.00;

            } else if (horas <= 3) {

                valor = 10.00 + (horas - 1) * 5.00;

            } else {

                valor = 30.00;
                totalDiarias++;
            }

            // Verifica o tipo de veiculo
            if (tipoVeiculo == 2) {

                totalEletricos++;

                // Desconto de 20%
                desconto = valor * 0.20;
                valor = valor - desconto;

                System.out.println(
                    "\nVeiculo eletrico: desconto de 20%!"
                );

            } else {

                totalConvencionais++;
                desconto = 0;
            }

            // Atualiza faturamento
            faturamentoTotal += valor;

            // Atualiza quantidade de veiculos
            totalVeiculos++;

            // Exibe o comprovante
            System.out.println("\n--------------------------------------");
            System.out.println("        COMPROVANTE DE PAGAMENTO       ");
            System.out.println("--------------------------------------");

            System.out.println(
                "Tempo de permanencia: " + horas + " hora(s)"
            );

            if (tipoVeiculo == 1) {
                System.out.println("Tipo: Convencional");
            } else {
                System.out.println("Tipo: Eletrico");
            }

            System.out.printf(
                "Desconto aplicado: R$ %.2f%n", desconto
            );

            System.out.printf(
                "Valor a pagar: R$ %.2f%n", valor
            );

            System.out.println("--------------------------------------");
            System.out.println("Atendimento finalizado com sucesso!");
        }

        // Relatorio consolidado
        System.out.println("\n======================================");
        System.out.println("      RELATORIO DO EXPEDIENTE         ");
        System.out.println("======================================");

        System.out.println(
            "Total de veiculos atendidos: " + totalVeiculos
        );

        System.out.printf(
            "Faturamento total: R$ %.2f%n", faturamentoTotal
        );

        System.out.println(
            "Veiculos convencionais: " + totalConvencionais
        );

        System.out.println(
            "Veiculos eletricos: " + totalEletricos
        );

        System.out.println(
            "Veiculos com diaria: " + totalDiarias
        );

        System.out.println("======================================");
        System.out.println("Expediente encerrado!");
        System.out.println("======================================");

        entrada.close();
    }
}
