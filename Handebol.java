public class Handebol extends Esporte {

    /*public Handebol(int id, String nome) {
        super(id, nome);
    }*/

    @Override
    int jogar(String equipe1, String equipe2) {
        int ptsEquipe1, ptsEquipe2;
        double pontos;
        
        pontos = Math.random() * 5;
        ptsEquipe1 = (int)pontos;
        pontos = Math.random() * 5;
        ptsEquipe2 = (int)pontos;
        System.out.println(ptsEquipe1 + "," + ptsEquipe2);
        
        if(ptsEquipe1 == ptsEquipe2) {
            return 0;
        } else if(ptsEquipe1 > ptsEquipe2) {
            return 1;
        } else {
            return 2;
        }
    }
}
