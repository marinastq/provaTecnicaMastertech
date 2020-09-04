package br.com.mastertech.batidaponto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.mastertech.batidaponto.beans.Batida;
import br.com.mastertech.batidaponto.beans.Usuario;

public class BatidaDAO implements IBatidaPontoDAO{

	public void insertBatida(Batida batida)
			throws SQLException, ClassNotFoundException {
		Connection conection = null;
		PreparedStatement stmt = null;
		
		try{
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(INSERT);
			
			int i = 0;
			stmt.setInt(++i, batida.getId());
			stmt.setTimestamp(++i, new Timestamp(batida.getDataBatida().getTime()));
			stmt.setString(++i, batida.getTipo());
			
			stmt.execute();
			stmt.close();
			conection.close();
			
		}finally {
			if(conection != null) {
				stmt.close();
				conection.close();			
			}
		}
		
	}

	public List<Batida> listaBatidaPorUsuario(Usuario usario) throws SQLException, ClassNotFoundException {
		Connection conection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(LISTAR_POR_USUARIO) ;
			
			int i = 0;
			//where
			stmt.setInt(++i, usario.getId());
			
			rs = stmt.executeQuery();
			
			List<Batida> listaBatida = new ArrayList<Batida>();
			
			while(rs.next()) {
				Batida batida = preencheBatida(rs);
				
				listaBatida.add(batida);
			}
			
			return listaBatida;
		}finally {
			if(conection != null) {
				rs.close();
				stmt.close();
				conection.close();			
			}
		}
	}

	private Batida preencheBatida(ResultSet rs) 
			throws SQLException {
		return new Batida(
				rs.getInt("ID_USER"), //id 
				rs.getTimestamp("DATETIME_WORKCLOCK", Calendar.getInstance()), //dataBatida
				rs.getString("TYPE_WORKCLOCK") //tipo 
				);
	}

}
