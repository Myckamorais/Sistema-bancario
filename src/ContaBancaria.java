import java.util.Scanner;

public class ContaBancaria {

    private String titular;
    private String numeroConta;
    private String senha;

    public String getTitular() {
        return titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

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
}
