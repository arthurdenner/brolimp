import java.util.Scanner;

public class Controle{
	void setIniciarOlimpiadas(){
		this.isOlimpiadasIniciadas = true;
		//setar isOlimpiadasIniciadas no banco
	}

	void getRankingCompeticao(){
		//fazer query para pegar as pontuações no banco
	}

	void simularPartida(){
		int opcao;
		String esporte;
		Scanner sc = new Scanner(System.in);

		do {
            System.out.println("* MENU DE SIMULAÇÕES *\n");
            System.out.println("1 - Basquete");
            System.out.println("2 - Futebol");
            System.out.println("3 - Handebol");
            System.out.println("4 - Tenis");
            System.out.println("5 - Volei");
            System.out.println("0 - Voltar\n");

            System.out.print("Escolha um esporte para simular: ");
            opcao = sc.nextInt();
            switch(opcao) {
                case 1: {
                    esporte = "Basquete";
                    iniciarSimulacao(esporte);
                    break;
                }
                case 2: {
                	esporte = "Futebol";
                	iniciarSimulacao(esporte);
                	break;
                }
                case 3: {
                	esporte = "Handebol";
                	iniciarSimulacao(esporte);
                	break;
                }
                case 4: {
                	esporte = "Tenis";
                	iniciarSimulacao(esporte);
                	break;
                }
                case 5: {
                	esporte = "Volei";
                	iniciarSimulacao(esporte);
                	break;
                }
                case 0: {
                	return;
                	break;
                }
                default: {
                	System.out.println("Opção inválida.");
                }
            }
            //iniciarSimulacao(esporte);
        } while(opcao != 0);
	}

	void iniciarSimulacao(String esporte){
		//falta pensar nisso
	}

	void resetarOlimpiadas(){
		//resetar todas as tabelas
		this.isOlimpiadasIniciadas = false;
	}
}