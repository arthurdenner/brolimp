package persistencia;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class ConexaoBanco {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/proo";
		String usuario = "root";
		String senha = ""; //verificar se é essa mesmo.
		String driver = "com.mysql.jdbc.Driver";
		try{
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int isOlimpiadasIniciadas() {
		try {
			String query = "SELECT ISOLIMPIADASINICIADAS FROM T_OLIMPIADAS";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			int situacao = 0;
			while(this.resultset.next()){
				situacao = this.resultset.getInt(1);
			}
			return situacao;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return 0;
		}
	}
	
	public void iniciarOlimpiadas() {
		try {
			String query = "UPDATE T_OLIMPIADAS SET ISOLIMPIADASINICIADAS = 1";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void resetarOlimpiadas() {
		try {
			String query = "UPDATE T_OLIMPIADAS SET ISOLIMPIADASINICIADAS = 0";
			this.statement.executeUpdate(query);
			/*query = "DELETE FROM T_EQUIPES";
			this.statement.executeUpdate(query);*/
			query = "DELETE FROM T_BASQUETE";
			this.statement.executeUpdate(query);
			query = "DROP TABLE T_FUTEBOL";
			this.statement.executeUpdate(query);
			query = "DROP TABLE T_HANDEBOL";
			this.statement.executeUpdate(query);
			query = "DROP TABLE T_TENIS";
			this.statement.executeUpdate(query);
			query = "DROP TABLE T_VOLEI";
			this.statement.executeUpdate(query);
			query = "DELETE FROM T_PONTUACAO";
			this.statement.executeUpdate(query);
			//resetar todas as tabelas
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void getEquipesCadastradas() {
		try {
			String query = "SELECT NOME_EQUIPE FROM T_EQUIPES ORDER BY NOME_EQUIPE";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			System.out.println();
			System.out.println("- EQUIPES CADASTRADAS -");
			while(this.resultset.next()){
				System.out.print("\n- " + this.resultset.getString("NOME_EQUIPE"));
			}
			System.out.println("\n");
			/*if(this.resultset == null) {
				System.out.println("Não existe equipe cadastrada!");
				sc.nextLine();
			}*/
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public ArrayList<String> getNomesEquipes() {
		try {
			String query = "SELECT NOME_EQUIPE FROM T_EQUIPES ORDER BY NOME_EQUIPE";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			ArrayList<String> equipes = new ArrayList<String>();
			while(this.resultset.next()){
				equipes.add(this.resultset.getString("NOME_EQUIPE"));
			}
			return equipes;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}
	
	public int getQntdEquipesCadastradas() {
		try {
			String query = "SELECT NOME_EQUIPE FROM T_EQUIPES ORDER BY NOME_EQUIPE";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			int quantidade = 0;
			while(this.resultset.next()){
				quantidade ++;
			}
			return quantidade;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return -1;
		}
	}

	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean cadastrarEquipe(String novaEquipe) {
		try {
			String query = "SELECT NOME_EQUIPE FROM T_EQUIPES ORDER BY NOME_EQUIPE";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			System.out.println();
			while(this.resultset.next()){
				if(this.resultset.getString("NOME_EQUIPE").equals(novaEquipe)){
					return false;
				}
			}
			query = "INSERT INTO T_EQUIPES (NOME_EQUIPE) VALUES ('" + novaEquipe + "');";
			this.statement.executeUpdate(query);
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return false;
		}
	}
	
	public boolean removerEquipe(String equipeParaRemover) {
		try {
			String query = "SELECT NOME_EQUIPE FROM T_EQUIPES ORDER BY NOME_EQUIPE";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			System.out.println();
			while(this.resultset.next()){
				if(this.resultset.getString("NOME_EQUIPE").equals(equipeParaRemover)){
					query = "DELETE FROM T_EQUIPES WHERE NOME_EQUIPE = '" + equipeParaRemover + "';";
					this.statement.executeUpdate(query);
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return false;
		}
	}

	public void cadastrarPartidaTabela(ConexaoBanco db, String equipe1, String equipe2) {
		try{
			String query = "INSERT INTO T_BASQUETE (NOME_EQUIPE1, NOME_EQUIPE2) VALUES ('" + equipe1 + "', '" + equipe2 + "');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void clonarTabelas(ConexaoBanco db) {
		try{
			String query = "CREATE TABLE T_FUTEBOL AS SELECT * FROM T_BASQUETE;";
			this.statement.executeUpdate(query);
			query = "CREATE TABLE T_HANDEBOL AS SELECT * FROM T_BASQUETE;";
			this.statement.executeUpdate(query);
			query = "CREATE TABLE T_TENIS AS SELECT * FROM T_BASQUETE;";
			this.statement.executeUpdate(query);
			query = "CREATE TABLE T_VOLEI AS SELECT * FROM T_BASQUETE;";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void getTabelas(String esporte) {
		try {
			String query = "SELECT NOME_EQUIPE1, NOME_EQUIPE2, PLACAR_EQUIPE1, PLACAR_EQUIPE2 FROM T_" + esporte + " ORDER BY numero_partida";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			System.out.println();
			while(this.resultset.next()){
				System.out.print("" + String.format("%1$10s", (this.resultset.getString("NOME_EQUIPE1"))));
				System.out.print(" " + this.resultset.getInt("PLACAR_EQUIPE1"));
				System.out.print(" x ");
				System.out.print(this.resultset.getInt("PLACAR_EQUIPE2"));
				System.out.print(" " + this.resultset.getString("NOME_EQUIPE2"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public ArrayList<String> getProximaPartida(String esporte) {
		try {
			String query = "SELECT NOME_EQUIPE1, NOME_EQUIPE2, NUMERO_PARTIDA FROM T_" + esporte + " WHERE PLACAR_EQUIPE1 IS NULL ORDER BY NUMERO_PARTIDA LIMIT 1;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			ArrayList<String> equipes = new ArrayList<String>();
			while(this.resultset.next()){
				equipes.add(this.resultset.getString("NUMERO_PARTIDA"));
				equipes.add(this.resultset.getString("NOME_EQUIPE1"));
				equipes.add(this.resultset.getString("NOME_EQUIPE2"));
			}
			if(equipes.isEmpty()){
				System.out.println("\nTodas as partidas desse esporte já foram simuladas.");
				return null;
			} else {
				return equipes;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}

	public void armazenarResultadoPartida(String esporte, int ptsEquipe1, int ptsEquipe2, int numeroPartida) {
		try {
			String query = "UPDATE t_" + esporte + " SET PLACAR_EQUIPE1 = " + ptsEquipe1 + ", PLACAR_EQUIPE2 = " + ptsEquipe2 + " WHERE numero_partida = " + numeroPartida + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void registrarPontuacao(String esporte, String equipe, int pontosAdicionar) {
		try {
			String query = "UPDATE T_PONTUACAO SET PONTUACAO = PONTUACAO + " + pontosAdicionar + " WHERE ESPORTE = '" + esporte + "' AND NOME_EQUIPE = '" + equipe + "'";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void inserirEmTabelaPontuacao(String esporte, String nomeEquipe) {
		try {
			String query = "INSERT INTO T_PONTUACAO (ESPORTE, NOME_EQUIPE, PONTUACAO) VALUES ('" + esporte + "', '" + nomeEquipe + "', 0)";
			this.statement.executeUpdate(query);
		} catch (Exception e ){
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void getRankingEsporte(String esporte) {
		try {
			String query = "SELECT NOME_EQUIPE, PONTUACAO FROM T_PONTUACAO WHERE ESPORTE = '" + esporte + "' ORDER BY PONTUACAO DESC;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			int i = 1;
			System.out.println("\n* RANKING " + esporte + " *\n");
			while(this.resultset.next()){
				System.out.println(i + "º lugar: " + this.resultset.getString("NOME_EQUIPE") + " - " + this.resultset.getInt("PONTUACAO"));
				i++;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void getRankingGeral() {
		try {
			String query = "SELECT NOME_EQUIPE, SUM(PONTUACAO) FROM T_PONTUACAO GROUP BY NOME_EQUIPE ORDER BY SUM(PONTUACAO) DESC;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			int i = 1;
			System.out.println("\n* RANKING GERAL *\n");
			while(this.resultset.next()){
				System.out.println(i + "º lugar: " + this.resultset.getString("NOME_EQUIPE") + " - " + this.resultset.getInt("SUM(PONTUACAO)"));
				i++;
			}
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
