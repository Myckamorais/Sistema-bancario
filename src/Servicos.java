import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Servicos extends ContaBancaria {

    private double deposito;
    private double saque;
    private double saldo;

    public Servicos(double deposito, double saque, double saldo) {
        this.deposito = deposito;
        this.saque = saque;
        this.saldo = saldo;
    }

    public double getDeposito() {return deposito;}

    public double getSaque() {return saque;}

    public double getSaldo() {return saldo;}

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Movimentacao> extrato = new ArrayList<>();
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public String opcoes;{
        System.out.println("\nDigite qual operação deseja realizar: \n" +
        "[1] DEPÓSITO \n" + "[2] SAQUE \n" + "[3] CONSULTAR SALDO \n" +
                "[4] EXTRATO \n" + "[5] SAIR");
    }

    public double depositar (double valor){
        System.out.println("\nQual valor deseja depositar?");
        valor = scanner.nextDouble();
        saldo += valor;
        extrato.add(new Movimentacao("DEPÓSITO", valor, LocalDateTime.now()));
        System.out.printf("Depósito de R$ %.2f realizado em %s%n", valor, LocalDateTime.now().format(fmt));
        return saldo;
    }

    public double sacar(double valor){
        System.out.println("\nQual valor deseja sacar?");
        valor = scanner.nextDouble();

        if (valor > saldo){
            System.out.println("Saldo insuficiente para esse valor de saque");
        }
        else {
            saldo -= valor;
            extrato.add(new Movimentacao("SAQUE", valor, LocalDateTime.now()));
            System.out.printf("Saque de R$ %.2f realizado em %s%n", valor, LocalDateTime.now().format(fmt));
        }
        return saldo;
    }

    public double consultarSaldo(double saldo){
        System.out.printf("\nSeu saldo é de R$ %.2f", getSaldo());
        return saldo;
    }

    public void consultarExtrato(){
        System.out.println("\n---EXTRATO---");
        System.out.printf("Titular: ", getTitular());
        System.out.printf("Conta: ", getNumeroConta());
        if (extrato.isEmpty()){
            System.out.println("\nNenhuma movimentação registrada");
        }
        for (Movimentacao m: extrato ){
            System.out.printf(
                    "%s | R$%.2f | %s%n",
                    m.getTipo(),
                    m.getValor(),
                    m.getDatahora().format(fmt));
        }
        System.out.printf("Saldo atual: R$%.2f%n", saldo);
    }

}
