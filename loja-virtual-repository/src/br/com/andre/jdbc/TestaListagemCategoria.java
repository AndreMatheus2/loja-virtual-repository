package br.com.andre.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.andre.jdbc.dao.CategoriaDAO;
import br.com.andre.jdbc.modelo.Categoria;
import br.com.andre.jdbc.modelo.Produto;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDao.listarComProdutos();
			categorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}

}
