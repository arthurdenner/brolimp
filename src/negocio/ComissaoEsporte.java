package negocio;

import java.util.Scanner;

import persistencia.ConexaoBanco;

public class ComissaoEsporte {

	public void getTabelas(ConexaoBanco db) {
		int opcao;
		String esporte;
		Scanner sc = new Scanner(System.in);

		do {
            System.out.println("\n* MENU DE ESPORTES *\n");
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
                	db.conectar();
            		db.getTabelas("Basquete");
                    break;
                }
                case 2: {
                	db.conectar();
            		db.getTabelas("Futebol");
                	break;
                }
                case 3: {
                	db.conectar();
            		db.getTabelas("Handebol");
                	break;
                }
                case 4: {
                	db.conectar();
            		db.getTabelas("Tenis");
                	break;
                }
                case 5: {
                	db.conectar();
            		db.getTabelas("Volei");
                	break;
                }
                case 0: {
                	System.out.println();
                	return;
                }
                default: {
                	System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0);
	}
}
