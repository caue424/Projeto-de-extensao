package model;

public class Estagiario {

private String nome;
private String horarioEntrada;
private String horarioSaida;
private int tickets;
private double produtividade;

public Estagiario(String nome) {
    this.nome = nome;   
    this.tickets = 0;
    this.produtividade = 0;
}   
 public String getNome() {
    return nome;
 }

 public void setNome(String nome) {
    this.nome = nome;
 }

 public String getHorarioEntrada() {
    return horarioEntrada;
 }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public double getProdutividade() {
        return produtividade;
    }

    public void setProdutividade(double produtividade) {
        this.produtividade = produtividade;
    }

}