package br.com.andre.jdbc;
import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory cf = new ConnectionFactory();
		
		for(int i = 1; i <= 20; i++) {
			cf.recuperaConexao();
			System.out.println("Conexão de número: " + i);
		}
		
	}

}
