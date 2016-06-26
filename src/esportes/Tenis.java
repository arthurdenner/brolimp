package esportes;

import java.util.ArrayList;

import persistencia.ConexaoBanco;

public class Tenis extends Esporte {
	
	@Override
	public void jogar(ConexaoBanco db) {
		String equipe1, equipe2;
		ArrayList<String> equipes = new ArrayList<String>();
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
        
        db.conectar();
        equipes = db.getProximaPartida("Tenis");
        try {
        	int numeroPartida = Integer.parseInt(equipes.get(0));
            equipe1 = equipes.get(1);
            equipe2 = equipes.get(2);
            System.out.println("\n" + equipe1 + " " + ptsEquipe1 + " x " + ptsEquipe2 + " " + equipe2);
            db.armazenarResultadoPartida("Tenis", ptsEquipe1, ptsEquipe2, numeroPartida);
            
            if(ptsEquipe1 == ptsEquipe2){
            	db.registrarPontuacao("Tenis", equipe1, 1);
            	db.registrarPontuacao("Tenis", equipe2, 1);
            } else if (ptsEquipe1 > ptsEquipe2){
            	db.registrarPontuacao("Tenis", equipe1, 3);
            } else {
            	db.registrarPontuacao("Tenis", equipe2, 3);
            }
        } catch (Exception e){
        	return;
        }
	}
}
