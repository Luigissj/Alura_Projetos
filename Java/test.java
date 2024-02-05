package Java;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decisao = " ";
        boolean repetido = false;
        int numeroVencedor = (int) (Math.random() * 10);
        while (true){
        textoPausado("Bem vindo ao meu Jogo, Deseja jogar?\n");
        System.out.print("Y/N   ");
        decisao =  scanner.nextLine();
        switch (decisao.toUpperCase()) {
            case "Y":
                textoPausado("\nQual é o seu nome?\n");
                System.out.print("-> ");
                decisao = scanner.next();
                Jogador novoJogador = new Jogador(decisao);
                Computador robo = new Computador(Computador.nomeAleatorio());
                numeroVencedor = (int)(Math.floor(Math.random() * 10));
                while (true) {
                    textoPausado("\nEscolha um número de 1 á 10: ");
                    novoJogador.setNumero(scanner.nextInt());
                    
                    if (!novoJogador.valores.isEmpty()) {
                        repetido = false;
                        for (int i = 1; i < novoJogador.valores.size(); i++){
                            if (novoJogador.valores.get(i) == novoJogador.getNumero()){
                                textoPausado("Você ja escolheu esse número\n");
                                pausaCurta(500);
                                repetido = true;
                            }
                        }
                    }

                    if (novoJogador.valores.isEmpty()) {
                        novoJogador.valores.add(novoJogador.getNumero());
                    } 

                    if (repetido){
                        continue;
                    } else {
                        novoJogador.valores.add(novoJogador.getNumero());
                    }
                    pontos();
                    if (novoJogador.getNumero() == numeroVencedor){
                        System.out.println("\nVocê ganhou!!!");
                        break;
                    } else {
                        textoPausado("Você errou\n\n");
                        pausaCurta(1000);
                        textoPausado("Proximo a adivinhar: " + robo.getNome() + "\n");
                        pontos();
                        if (robo.valorAleatorio() == numeroVencedor){
                            System.out.println("\n" + robo.getNome() + " Ganhou\n");
                            break;
                        } else {
                            textoPausado(robo.getNome() + " errou\n");
                        }
                    }
                }
                scanner.close();
                break;
            
            case "N":
                textoPausado("Okay, te vejo na proxima ;-3");
                scanner.close();
                break;
        
            default:
                continue;
        }
        break;
        }
    }   

    static void pontos(){
        for (int i = 0; i < 3; i++){
            pausaCurta(1000);
            System.out.print(".");
        }
        pausaCurta(1000);
        System.out.println("\n");
    }

    static void pausaCurta(int tempo){
        try {
            TimeUnit.MILLISECONDS.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void textoPausado(String texto){
        for(int i = 0; i < texto.length(); i++){
            System.out.print(texto.substring(i, (i + 1)));
            if (texto.substring(i, (i + 1)) != " "){
            pausaCurta(50);
            }
        }
    }
}
