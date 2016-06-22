import java.util.Scanner;

public class Brolimp {
	boolean isOlimpiadasIniciadas;

	public static void main(String[] args) {
		menu();
	}

	static void menu() {
        int opcao;
        Controle controle = new Controle();
        ComissaoEsporte comissaoEsporte = new ComissaoEsporte();
        ComissaoEquipe comissaoEquipe = new ComissaoEquipe();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("* MENU DO JOGO *\n");
            System.out.println("1 - Iniciar as Olimpíadas");
            System.out.println("2 - Ver tabelas das Olimpíadas");
            System.out.println("3 - Ver ranking das Olimpíadas");
            System.out.println("4 - Simular uma partida");
            System.out.println("5 - Ver esportes cadastradas");
            System.out.println("6 - Ver equipes cadastradas");
            System.out.println("7 - Cadastrar equipe");
            System.out.println("8 - Remover equipe");
            System.out.println("9 - Resetar as Olimpíadas");
            System.out.println("0 - Sair\n");

            System.out.print("Escolha uma opcao: ");
            opcao = sc.nextInt();
            switch(opcao) {
                case 1: {
                    if(this.isOlimpiadasIniciadas){
                    	System.out.println("As Olimpíadas já foram iniciadas.");
                    	break;
                    } else {
                    	controle.setIniciarOlimpiadas();
                    	break;
                    }
                }
                case 2: {
                	if(this.isOlimpiadasIniciadas){
                		comissaoEsporte.getTabelas();
                		ComissaoEquipe comissaoEquipe = new ComissaoEquipe();
                		break;
                	} else {
                		System.out.println("As Olimpíadas não iniciaram, portanto não há tabelas.");
                		break;
                	}
                }
                case 3: {
                	if(this.isOlimpiadasIniciadas){
                		controle.getRankingCompeticao();
                		break;
                	} else {
                		System.out.println("As Olimpíadas não iniciaram, portanto não há ranking.");
                		break;
                	}
                }
                case 4: {
                	if(this.isOlimpiadasIniciadas){
                		controle.simularPartida();
                		break;
                	} else {
                		System.out.println("As Olimpíadas não iniciaram, portanto não há o que simular.");
                		break;
                	}
                }
                case 5: {
                	comissaoEsporte.getEsportesCadastrados();
                	break;
                }
                case 6: {
                	comissaoEquipe.getEquipesCadastradas();
                	break;
                }
                case 7: {
                	comissaoEquipe.cadastrarEquipe();
                	break;
                }
                case 8: {
                	comissaoEquipe.removerEquipe();
                	break;
                }
                case 9: {
                	controle.resetarOlimpiadas();
                	break;
                }
                default: {
                	System.out.println("Opção inválida");
                	break;
                }
            }
        } while(opcao != 0);
    }
}