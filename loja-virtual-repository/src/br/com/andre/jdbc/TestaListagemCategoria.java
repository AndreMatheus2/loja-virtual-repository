package br.com.andre.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.andre.jdbc.dao.CategoriaDAO;
import br.com.andre.jdbc.modelo.Categoria;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDao.listar();
			categorias.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
		
		
	}

}
