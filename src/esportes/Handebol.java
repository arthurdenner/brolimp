package esportes;

import java.util.ArrayList;

import persistencia.ConexaoBanco;

public class Handebol extends Esporte {
	@Override
	public void jogar(ConexaoBanco db) {
		String equipe1, equipe2;
		ArrayList<String> equipes = new ArrayList<String>();
		int ptsEquipe1, ptsEquipe2;
        double pontos;
        
        pontos = Math.random() * 20;
        ptsEquipe1 = (int)pontos;
        pontos = Math.random() * 20;
        ptsEquipe2 = (int)pontos;

        db.conectar();
        equipes = db.getProximaPartida("Handebol");
        try {
        	int numeroPartida = Integer.parseInt(equipes.get(0));
            equipe1 = equipes.get(1);
            equipe2 = equipes.get(2);
            System.out.println("\n" + equipe1 + " " + ptsEquipe1 + " x " + ptsEquipe2 + " " + equipe2);
            db.armazenarResultadoPartida("Handebol", ptsEquipe1, ptsEquipe2, numeroPartida);
            
            if(ptsEquipe1 == ptsEquipe2){
            	db.registrarPontuacao("Handebol", equipe1, 1);
            	db.registrarPontuacao("Handebol", equipe2, 1);
            } else if (ptsEquipe1 > ptsEquipe2){
            	db.registrarPontuacao("Handebol", equipe1, 3);
            } else {
            	db.registrarPontuacao("Handebol", equipe2, 3);
            }
        } catch (Exception e){
        	return;
        }
    }
}
