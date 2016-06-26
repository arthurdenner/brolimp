package brolimp;

import java.util.Scanner;
import negocio.ComissaoEquipe;
import negocio.ComissaoEsporte;
import negocio.Controle;
import persistencia.ConexaoBanco;

public class Brolimp {
	
	public static int isOlimpiadasIniciadas;
	
	public static void main(String[] args) {
		ConexaoBanco db = new ConexaoBanco();
		db.conectar();
		if(db.estaConectado()){
			int situacao = db.isOlimpiadasIniciadas();
			isOlimpiadasIniciadas = situacao;
			//System.out.println(isOlimpiadasIniciadas);
			menu(db);
		}
	}
	
	static void menu(ConexaoBanco db) {
        Controle controle = new Controle();
        ComissaoEsporte comissaoEsporte = new ComissaoEsporte();
        ComissaoEquipe comissaoEquipe = new ComissaoEquipe();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
        	db.desconectar();
        	System.out.println("* MENU DO JOGO *\n");
            System.out.println("1 - Iniciar as Olimpíadas");
            System.out.println("2 - Ver tabelas das Olimpíadas");
            System.out.println("3 - Ver ranking das Olimpíadas");
            System.out.println("4 - Simular uma partida");
            System.out.println("5 - Ver esportes cadastrados");
            System.out.println("6 - Ver equipes cadastradas");
            System.out.println("7 - Cadastrar equipe");
            System.out.println("8 - Remover equipe");
            System.out.println("9 - Resetar as Olimpíadas");
            System.out.println("0 - Sair\n");

            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            switch(opcao) {
                case 1: {
                    if(isOlimpiadasIniciadas != 0){
                    	System.out.println("\nAs Olimpíadas já foram iniciadas.\n");
                    	break;
                    } else {
                    	if(controle.iniciarOlimpiadas(db)){
                    		System.out.println("\nBoa sorte às equipes!\n");
                    	};
                    	break;
                    }
                }
                case 2: {
                	if(isOlimpiadasIniciadas != 0){
                		comissaoEsporte.getTabelas(db);
                		break;
                	} else {
                		System.out.println("\nAs Olimpíadas não iniciaram, portanto não há tabelas.\n");
                		break;
                	}
                }
                case 3: {
                	if(isOlimpiadasIniciadas != 0){
                		controle.getRankingCompeticao(db);
                		break;
                	} else {
                		System.out.println("\nAs Olimpíadas não iniciaram, portanto não há ranking.\n");
                		break;
                	}
                }
                case 4: {
                	if(isOlimpiadasIniciadas != 0){
                		controle.menuSimulacoes(db);
                		break;
                	} else {
                		System.out.println("\nAs Olimpíadas não iniciaram, portanto não há o que simular.\n");
                		break;
                	}
                }
                case 5: {
                	listarEsportes();
                	break;
                }
                case 6: {
                	comissaoEquipe.getEquipesCadastradas(db);
                	break;
                }
                case 7: {
                	if(isOlimpiadasIniciadas != 0){
                		System.out.println("\nAs Olimpíadas já foram iniciadas.\n");
                    	break;
                	} else {
                		comissaoEquipe.cadastrarEquipe(db);
                		break;
                	}
                }
                case 8: {
                	if(isOlimpiadasIniciadas != 0){
                		System.out.println("\nAs Olimpíadas já foram iniciadas.\n");
                    	break;
                	} else {
                		db.conectar();
                		if(db.getQntdEquipesCadastradas() > 0){
                			comissaoEquipe.removerEquipe(db);
                		} else {
                			System.out.println("\nVocê não cadastrou nenhuma equipe.\n");
                		}
                		
                		break;
                	}
                }
                case 9: {
                	if(isOlimpiadasIniciadas != 0){
                		controle.resetarOlimpiadas(db);
                    	break;
                	} else {
                		System.out.println("\nAs Olimpíadas não foram iniciadas, portanto não há o que resetar.\n");
                		break;
                	}
                }
                case 0: {
                	System.out.println("\nObrigado por usar!");
                	break;
                }
                default: {
                	System.out.println("\nOpção inválida!\n");
                	break;
                }
            }
        } while(opcao != 0);
        sc.close();
    }

	private static void listarEsportes() {
		System.out.println("\n- ESPORTES A SEREM DISPUTADOS -\n");
		System.out.println("- BASQUETE");
		System.out.println("- FUTEBOL");
		System.out.println("- HANDEBOL");
		System.out.println("- TENIS");
		System.out.println("- VOLEI\n");
	}
}