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
public abstract class Esporte {
    int id;
    String nome;
    
    abstract int jogar(String equipe1, String equipe2);
}
