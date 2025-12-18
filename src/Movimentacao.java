import java.time.LocalDateTime;
public class Movimentacao {

    private String tipo;
    private double valor;
    LocalDateTime datahora;

    public Movimentacao(String tipo, double valor, LocalDateTime datahora) {
        this.tipo = tipo;
        this.valor = valor;
        this.datahora = datahora;
    }

    public String getTipo() {return tipo;}
    public double getValor() {return valor;}
    public LocalDateTime getDatahora() {return datahora;}
}
