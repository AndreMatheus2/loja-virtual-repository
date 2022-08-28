import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		connection.setAutoCommit(false);

		try { 
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("SmartTV", "LG", stm);
		adicionarVariavel("Micro-Ondas", "Electrolux", stm);
		
		connection.commit();
		
		stm.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		
		connection.close();
	}
	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println(id);
		}
		
		rst.close();
	}

}
