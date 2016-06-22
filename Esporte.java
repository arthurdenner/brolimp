public abstract class Esporte {
    int id;
    String nome;
    
    /*public Esporte(int id, String nome) {
    	this.id = id;
    	this.nome = nome;
    }*/
    
    abstract int jogar(String equipe1, String equipe2);
}
