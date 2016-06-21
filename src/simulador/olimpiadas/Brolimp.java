/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.olimpiadas;

//import java.util.Scanner;

/**
 *
 * @author Denner
 */
public class Brolimp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        menu();
        Handebol teste = new Handebol();
        teste.jogar("Flamengo", "Vasco");
    }
    
    static void menu() {
        int opcao;
        do {
            System.out.println("* MENU DO JOGO *\n");
            System.out.println("1 - Ver equipes cadastradas");
            System.out.println("2 - Cadastrar uma equipe");
            System.out.println("3 - Simular uma partida");
            System.out.println("4 - Ver tabela das Olimpíadas");
            System.out.println("5 - Resetar as Olimpíadas\n");

            System.out.print("Escolha uma opcao: ");
            //Scanner sc = new Scanner(System.in);
            //opcao = sc.nextInt();
            opcao = 3;
            switch(opcao) {
                case 1: {
                    
                    break;
                }
            }
        } while((opcao != 1) && (opcao != 2) && (opcao != 3));
    }
}
