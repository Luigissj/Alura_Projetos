package Java;

import java.util.ArrayList;

public class Jogador {
    ArrayList <Integer> valores = new ArrayList<Integer>();
    private String nome;
    private int numero;

    public Jogador(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
