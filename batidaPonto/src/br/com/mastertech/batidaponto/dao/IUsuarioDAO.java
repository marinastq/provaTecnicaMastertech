package br.com.mastertech.batidaponto.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mastertech.batidaponto.beans.Usuario;

public interface IUsuarioDAO {
	
	String INSERT = "INSERT INTO USER " +
			"(NAME, EMAIL, CPF, DATE_REGISTER)" +
			" VALUES " +
			"(?, ?, ?, now())";
	
	String UPDATE = "UPDATE USER " +
			"SET NAME = ?, CPF = ?, EMAIL = ? " +
			" WHERE " +
			" ID = ? ";
	
	String DELETE = " DELETE FROM USER " +
			" WHERE " +
			" ID = ? ";
	
	String SELECT = "SELECT ID, NAME, EMAIL, CPF, DATE_REGISTER "
			+ " FROM USER ";
	
	String GET = "SELECT ID, NAME, EMAIL, CPF, DATE_REGISTER"
			+ " FROM  USER "
			+ " WHERE "
			+ " ID = ? ";
	
	public void insertUsuario(Usuario usuario)
			throws SQLException, ClassNotFoundException;
	
	public void updateUsuario(Usuario usuario) 
			throws SQLException, ClassNotFoundException;
	
	public void deleteUsuario(Usuario usuario)
			throws SQLException, ClassNotFoundException;

	public List<Usuario> listaUsuario()
			throws SQLException, ClassNotFoundException;

	public Usuario getUsuario(Usuario usuario)
			throws SQLException, ClassNotFoundException;

}
