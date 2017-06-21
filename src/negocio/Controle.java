package negocio;

import java.util.ArrayList;
import java.util.Scanner;

import brolimp.Brolimp;
import esportes.Basquete;
import esportes.Esporte;
import esportes.Futebol;
import esportes.Handebol;
import esportes.Tenis;
import esportes.Volei;
import persistencia.ConexaoBanco;

public class Controle {
	public boolean iniciarOlimpiadas(ConexaoBanco db){
		db.conectar();
		if(db.getQntdEquipesCadastradas() == 0){
			System.out.println("\nVocê não cadastrou nenhuma equipe.\n");
			return false;
			
		} else if (db.getQntdEquipesCadastradas() == 1){
			System.out.println("\nVocê precisa de, no mínimo, duas equipes.\n");
			return false;
		} else {
			Brolimp.isOlimpiadasIniciadas = 1;
			db.iniciarOlimpiadas();
	        this.gerarTabelas(db);
	        this.clonarTabelas(db);
	        this.gerarTabelaPontuacao(db);
	        return true;
		}
	}

	private void gerarTabelaPontuacao(ConexaoBanco db) {
		ArrayList<String> equipes = new ArrayList<String>();
		equipes = db.getNomesEquipes();
		for(int i = 0; i < equipes.size(); i++){
			db.inserirEmTabelaPontuacao("Basquete", equipes.get(i));
			db.inserirEmTabelaPontuacao("Futebol", equipes.get(i));
			db.inserirEmTabelaPontuacao("Handebol", equipes.get(i));
			db.inserirEmTabelaPontuacao("Tenis", equipes.get(i));
			db.inserirEmTabelaPontuacao("Volei", equipes.get(i));
		}
	}

	public void resetarOlimpiadas(ConexaoBanco db){
		Scanner sc = new Scanner(System.in);
		String opcao;
		System.out.print("\n'S' ou Enter para confirmar / Outra tecla para voltar: ");
		opcao = sc.nextLine();
		try {
			if((opcao.charAt(0) == 's') || (opcao.charAt(0) == 'S')) {
				Brolimp.isOlimpiadasIniciadas = 0;
				db.conectar();
				db.resetarOlimpiadas();
				System.out.println("\nAs Olimpíadas foram resetadas.");
			}
		} catch (Exception e){
			Brolimp.isOlimpiadasIniciadas = 0;
			db.conectar();
			db.resetarOlimpiadas();
			System.out.println("\nAs Olimpíadas foram resetadas.");
		}
		System.out.println();
	}
	
	private void gerarTabelas(ConexaoBanco db) { //adaptada de http://www.guj.com.br/t/gerar-tabela-do-campeonato-brasileiro/86868/11
		ArrayList<String> equipes = new ArrayList<String>();
        String equipe1, equipe2;
        equipes = db.getNomesEquipes();
        if (equipes.size() % 2 == 1) {
            equipes.add(0, "");
        }
        //System.out.println(equipes);
        int t = equipes.size();
        int m = equipes.size() / 2;
        for (int i = 0; i < t - 1; i++) {
            for (int j = 0; j < m; j++) {
                //equipe está de fora nessa rodada?              
                if (equipes.get(j).isEmpty())
                    continue;

                //teste para ajustar o mando de campo
                if (j % 2 == 1 || i % 2 == 1 && j == 0) {
                    equipe1 = equipes.get(t - j - 1);
                    equipe2 = equipes.get(j);
                    //System.out.println(equipe1 + ", " + equipe2);
                    this.cadastrarPartidaTabela(db, equipe1, equipe2);
                } else {
                    equipe1 = equipes.get(j);
                    equipe2 = equipes.get(t - j - 1);
                    //System.out.println(equipe1 + ", " + equipe2);
                    this.cadastrarPartidaTabela(db, equipe1, equipe2);
                }
            }
            //Gira os equipes no sentido horário, mantendo o primeiro no lugar
            equipes.add(1, equipes.remove(equipes.size()-1));
        }
	}

	private void cadastrarPartidaTabela(ConexaoBanco db, String equipe1, String equipe2) {
		db.cadastrarPartidaTabela(db, equipe1, equipe2);	
	}

	private void clonarTabelas(ConexaoBanco db) {
		db.clonarTabelas(db);
	}

	public void menuSimulacoes(ConexaoBanco db) {
		int opcao;
		Scanner sc = new Scanner(System.in);
		Esporte esporte;
		
		do {
			System.out.println("\n* MENU DE SIMULAÇÕES *\n");
            System.out.println("1 - Basquete");
            System.out.println("2 - Futebol");
            System.out.println("3 - Handebol");
            System.out.println("4 - Tenis");
            System.out.println("5 - Volei");
            System.out.println("0 - Voltar\n");

            System.out.print("Escolha um esporte: ");
            opcao = sc.nextInt();
            switch(opcao) {
                case 1: {
                    esporte = new Basquete();
                    esporte.jogar(db);
                    break;
                }
                case 2: {
                	esporte = new Futebol();
                    esporte.jogar(db);
                	break;
                }
                case 3: {
                	esporte = new Handebol();
                    esporte.jogar(db);
                	break;
                }
                case 4: {
                	esporte = new Tenis();
                    esporte.jogar(db);
                	break;
                }
                case 5: {
                	esporte = new Volei();
                    esporte.jogar(db);
                	break;
                }
                case 0: {
                	System.out.println();
                	return;
                }
                default: {
                	System.out.println("\nOpção inválida.");
                }
            }
            //iniciarSimulacao(esporte);
        } while(opcao != 0);
	}

	public void getRankingCompeticao(ConexaoBanco db) {
		int opcao;
		Scanner sc = new Scanner(System.in);
		
		do {
			db.desconectar();
			System.out.println("\n* MENU DE RANKINGS *\n");
            System.out.println("1 - Ranking Basquete");
            System.out.println("2 - Ranking Futebol");
            System.out.println("3 - Ranking Handebol");
            System.out.println("4 - Ranking Tenis");
            System.out.println("5 - Ranking Volei");
            System.out.println("6 - Ranking Geral");
            System.out.println("0 - Voltar\n");

            System.out.print("Escolha um ranking: ");
            opcao = sc.nextInt();
            switch(opcao) {
                case 1: {
                    db.conectar();
                	db.getRankingEsporte("BASQUETE");
                    break;
                }
                case 2: {
                	db.conectar();
                	db.getRankingEsporte("FUTEBOL");
                	break;
                }
                case 3: {
                	db.conectar();
                	db.getRankingEsporte("HANDEBOL");
                	break;
                }
                case 4: {
                	db.conectar();
                	db.getRankingEsporte("TENIS");
                	break;
                }
                case 5: {
                	db.conectar();
                	db.getRankingEsporte("VOLEI");
                	break;
                }
                case 6: {
                	db.conectar();
                	db.getRankingGeral();
                	break;
                }
                case 0: {
                	System.out.println();
                	return;
                }
                default: {
                	System.out.println("\nOpção inválida.");
                }
            }
            //iniciarSimulacao(esporte);
        } while(opcao != 0);
	}
}
