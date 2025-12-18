import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria();
        Scanner scanner = new Scanner(System.in);
        double valor;

        conta.cliente();
        conta.validacaoSenha();

        boolean encerrar = false;

        while (!encerrar) {
             int opcao = conta.mostrarOpcoes();

             switch (opcao) {
                case 1:
                    System.out.println("Qual valor deseja depositar?");
                    valor = scanner.nextDouble();
                    conta.depositar(valor);
                    break;

                case 2:
                    System.out.println("\nQual valor deseja sacar?");
                    valor = scanner.nextDouble();
                    conta.sacar(valor);
                    break;

                case 3:
                    conta.consultarSaldo();
                    break;

                case 4:
                    conta.consultarExtrato();
                    break;

                case 5:
                    encerrar = true;
                    System.out.println("Operação encerrada");
                    break;
            }

        }
    }
}
