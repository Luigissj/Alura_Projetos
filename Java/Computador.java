package Java;

public class Computador extends Jogador {
    String nome;
    public Computador(String nome) {
        super(nome);
    }
    
    static String nomeAleatorio(){
        int valor;
        String nomeBot = "BOT";
        valor = (int)(Math.random() * 4);
        switch (valor) {
            case 0:
                return "Carlos das Porcas";
    
            case 1:
                return "José Ferreira";        
            case 2:
                return "Pedro MedoTal";
        
            case 3:
                return "Carlos Paranco dos Fusos";
        
            case 4:
                return "Marco Pregode";

            default:
                return nomeBot;
        }
    }

    public int valorAleatorio(){
        int aleatorio = ((int) (Math.random() * 10));
        return aleatorio;
    }
}
