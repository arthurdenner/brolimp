/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.olimpiadas;

/**
 *
 * @author Denner
 */
public class Volei extends Esporte {
    
    @Override
    int jogar(String equipe1, String equipe2) {
        int ptsEquipe1, ptsEquipe2 = 0;
        double pontos;

        pontos = Math.random() * 4;
        ptsEquipe1 = (int)pontos;
        if(ptsEquipe1 < 3) {
            ptsEquipe2 = 3;
        } else if(ptsEquipe1 == 3){
            pontos = Math.random() * 2;
            ptsEquipe2 = (int)pontos;
        }
        System.out.println(ptsEquipe1 + "," + ptsEquipe2 + " = " + (ptsEquipe1 + ptsEquipe2));

        if(ptsEquipe1 > ptsEquipe2) {
            return 1;
        } else {
            return 2;
        }
    }
}
