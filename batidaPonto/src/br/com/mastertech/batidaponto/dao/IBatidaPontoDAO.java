package br.com.mastertech.batidaponto.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mastertech.batidaponto.beans.Batida;
import br.com.mastertech.batidaponto.beans.Usuario;

public interface IBatidaPontoDAO {
	
	String INSERT = "INSERT INTO WORKCLOCK"
			+ " (ID_USER, DATETIME_WORKCLOCK, TYPE_WORKCLOCK)"
			+ " VALUES "
			+ " (?, ? , ?)";
	
	String LISTAR_POR_USUARIO = "SELECT ID_USER, DATETIME_WORKCLOCK, TYPE_WORKCLOCK "
			+ " FROM WORKCLOCK"
			+ " WHERE ID_USER = ? "
			+ " ORDER BY DATETIME_WORKCLOCK";
			
	public void insertBatida(Batida batida)
			throws SQLException, ClassNotFoundException;
	
	public List<Batida> listaBatidaPorUsuario(Usuario usario)
			throws SQLException, ClassNotFoundException;

}
