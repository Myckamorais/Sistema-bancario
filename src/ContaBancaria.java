import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private double deposito;
    private double saque;
    private double saldo;
    private String senha;

    public String getTitular() {return titular;}
    public String getNumeroConta() {return numeroConta;}
    public double getSaldo() {return saldo;}

    Scanner scanner = new Scanner(System.in);

    public void cliente(){
        System.out.print("Digite o nome do Titular da conta: ");
        this.titular = scanner.nextLine();
        System.out.print("Digite o numero da conta: ");
        this.numeroConta = scanner.nextLine();
    }

    public String validacaoSenha (){
        do {
            System.out.print("Digite sua senha: ");
            this.senha = scanner.nextLine();
            if (!senha.matches("\\d{6}")){
                System.out.print("Senha inválida. Digite sua senha com 6 digitos numéricos. \n");
            }
        }while (!senha.matches("\\d{6}"));
        return senha;
    }

    private ArrayList<Movimentacao> extrato = new ArrayList<>();
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public int mostrarOpcoes(){
        System.out.println("\nDigite qual operação deseja realizar: \n" +
                "[1] DEPÓSITO \n" + "[2] SAQUE \n" + "[3] CONSULTAR SALDO \n" +
                "[4] EXTRATO \n" + "[5] SAIR");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public double depositar (double valor){

        saldo += valor;
        extrato.add(new Movimentacao("DEPÓSITO", valor, LocalDateTime.now()));
        System.out.printf("Depósito de R$ %.2f realizado em %s%n", valor, LocalDateTime.now().format(fmt));
        return saldo;
    }

    public double sacar(double valor){
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

    public double consultarSaldo(){
        System.out.printf("\nSeu saldo é de R$ %.2f", getSaldo());
        return saldo;
    }

    public void consultarExtrato(){
        System.out.println("\n---EXTRATO---");
        System.out.printf("Titular: %s%n", getTitular());
        System.out.printf("Conta: %s%n", getNumeroConta());
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

