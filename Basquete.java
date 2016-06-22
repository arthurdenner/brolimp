public class Basquete extends Esporte {

    /*public Basquete(int id, String nome) {
        super(id, nome);
    }
*/
    @Override
    int jogar(String equipe1, String equipe2) {
        int ptsEquipe1 = 0, ptsEquipe2 = 0;
        double pontos;
        
        int i;
        for (i = 0; i <= 100; i++) {
            pontos = Math.random() * 100;
            ptsEquipe1 = (int)pontos;
            pontos = Math.random() * 100;
            ptsEquipe2 = (int)pontos;
            System.out.println(ptsEquipe1 + "," + ptsEquipe2);
        }
        
        if(ptsEquipe1 > ptsEquipe2) {
            return 1;
        } else {
            return 2;
        }
    }
}
