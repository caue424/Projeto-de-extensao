package service;

import model.Estagiario;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EstagioService {

    private final int META_DIARIA = 5;

    public void registrarEntrada(Estagiario estagiario) {
        String horario = LocalTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        estagiario.setHorarioEntrada(horario);
        System.out.println(estagiario.getNome() + " registrou entrada às " + horario);
    }


   public void registrarSaida(Estagiario estagiario) {

        String horario = LocalTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        estagiario.setHorarioSaida(horario);
        System.out.println(estagiario.getNome() + " registrou saída às " + horario);
    }

    public void adicionarTicket(Estagiario estagiario) {
        estagiario.setTickets(estagiario.getTickets() + 1);

        double produtividade = calcularProdutividade(estagiario);
        estagiario.setProdutividade(produtividade);
        System.out.println(estagiario.getNome() + " completou um ticket. Total: " + estagiario.getTickets());

    }


    public double calcularProdutividade(Estagiario estagiario) {
        if (estagiario.getTickets() == 0) {
            return 0;
        }
        return (double) estagiario.getTickets() / META_DIARIA * 100;


}
}