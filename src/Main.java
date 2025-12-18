public class Main {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria();
        conta.cliente();
        conta.validacaoSenha();

        double deposito = 0.0;
        double saque = 0.0 ;
        double saldo = 0.0;
        Servicos servicos = new Servicos(deposito, saque, saldo);

    }
    }
