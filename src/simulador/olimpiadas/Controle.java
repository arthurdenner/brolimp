package simulador.olimpiadas;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denner
 */
public class Controle {

    void getEquipesCadastradas() {
         //fazer query para ver equipes cadastradas.
    }
    
    boolean adicionarEquipe(String nome) {
        int quantidadeEquipes;
        
        quantidadeEquipes = 0; //fazer count de quantas equipes estão cadastradas.
        if(quantidadeEquipes == 16) {
            System.out.println("Não há mais espaço nessa competição. Aguarde as próximas Olimpíadas.");
            return false;
        }
        if(quantidadeEquipes < 16) {
            System.out.println("Vagas para equipes: " + (16 - quantidadeEquipes));
        }
        
        Scanner sc = new Scanner(System.in);
        String novaEquipe;
        boolean isEquipeCadastrada;
        
        System.out.print("\nDigite a equipe que deseja cadastrar: ");
        novaEquipe = sc.nextLine();
        isEquipeCadastrada = true; //fazer query para ver se equipe está cadastrada.
        if (isEquipeCadastrada) {
            System.out.println("Essa equipe já está cadastrada. Por favor, escolha outra.");
            return false;
        } else {
            //cadastrar a equipe
            System.out.println("A equipe foi cadastrada com sucesso.");
            return true;
        }
    }
}
