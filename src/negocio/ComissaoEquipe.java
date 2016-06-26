package negocio;

import java.util.Scanner;

import persistencia.ConexaoBanco;

public class ComissaoEquipe {
	public void getEquipesCadastradas(ConexaoBanco db){
		db.conectar();
		db.getEquipesCadastradas();
	}
	
	public void cadastrarEquipe(ConexaoBanco db) {
		Scanner sc = new Scanner(System.in);
		String novaEquipe;
		System.out.print("\nDigite o nome da equipe: ");
		novaEquipe = sc.nextLine();
		if(!novaEquipe.equals("")){
			db.conectar();
			if(db.cadastrarEquipe(novaEquipe)){
				System.out.println("A equipe foi cadastrada com sucesso.\n");
			} else {
				System.out.println("A equipe já está cadastrada.\n");
			}
		} else {
			System.out.println("\nErro: Você deve informar um nome.\n");
		}
	}
	
	public void removerEquipe(ConexaoBanco db) {
		Scanner sc = new Scanner(System.in);
		String equipeParaRemover;
		System.out.print("\nDigite o nome da equipe: ");
		equipeParaRemover = sc.nextLine();
		if(!equipeParaRemover.equals("")){
			db.conectar();
			if(db.removerEquipe(equipeParaRemover)){
				System.out.println("A equipe foi removida com sucesso.\n");
			} else {
				System.out.println("A equipe não está cadastrada.\n");
			}
		} else {
			System.out.println("\nErro: Você deve informar um nome.\n");
		}
	}
}
