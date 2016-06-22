public class Volei extends Esporte {

    /*public Volei(int id, String nome) {
        super(id, nome);
    }*/

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
