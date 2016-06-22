import java.util.Scanner;

public class ComissaoEquipe{
	void getEquipesCadastradas(){
		//fazer query para pegar as equipes cadastradas
	}

	void cadastrarEquipe(){
		Scanner sc = new Scanner(System.in);
		String novaEquipe;
		System.out.print("Digite o nome da equipe: ");
		novaEquipe = sc.nextLine();
		//fazer query para ver se a equipe já está cadastrada
		if(/*query*/){
			System.out.println("A equipe já está cadastrada.");
			return;
		} else {
			//cadastrar a equipe no banco
			System.out.println("A equipe foi cadastrada com sucesso.");
			return;
		}
	}

	void removerEquipe(){
		Scanner sc = new Scanner(System.in);
		String equipeParaRemover;
		System.out.print("Digite o nome da equipe: ");
		equipeParaRemover = sc.nextLine();
		//fazer query para ver se a equipe está cadastrada
		if(//query){
			System.out.println("A equipe foi removida com sucesso.");
			return;
		} else {
			//cadastrar a equipe no banco
			System.out.println("A equipe não está cadastrada.");
			return;
		}
	}
}