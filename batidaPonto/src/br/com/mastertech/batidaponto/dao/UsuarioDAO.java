package br.com.mastertech.batidaponto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.mastertech.batidaponto.beans.Usuario;

public class UsuarioDAO implements IUsuarioDAO{

	public void insertUsuario(Usuario usuario)
			throws SQLException, ClassNotFoundException{
		Connection conection = null;
		PreparedStatement stmt = null;
		
		try{
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(INSERT);
			
			int i = 0;
			stmt.setString(++i, usuario.getNome());
			stmt.setString(++i, usuario.getEmail());
			stmt.setString(++i, usuario.getCpf());
			
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

	public void updateUsuario(Usuario usuario)
			throws SQLException, ClassNotFoundException{
		Connection conection = null;
		PreparedStatement stmt = null;
		
		try{
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(UPDATE);
			
			int i = 0;
			stmt.setString(++i, usuario.getNome());
			stmt.setString(++i, usuario.getCpf());
			stmt.setString(++i, usuario.getEmail());
			//where
			stmt.setInt(++i, usuario.getId());
			
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

	public void deleteUsuario(Usuario usuario) 
			throws SQLException, ClassNotFoundException{
		Connection conection = null;
		PreparedStatement stmt = null;
		
		try{
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(DELETE);
			
			int i = 0;
			//where
			stmt.setInt(++i, usuario.getId());
			
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

	public List<Usuario> listaUsuario()
			throws SQLException, ClassNotFoundException{
		Connection conection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(SELECT) ;
			
			rs = stmt.executeQuery();
			
			List<Usuario> listUsuario = new ArrayList<Usuario>();
			
			while(rs.next()) {
				Usuario usuario = preencheUsuario(rs);
				
				listUsuario.add(usuario);
			}
			
			return listUsuario;
		}finally {
			if(conection != null) {
				rs.close();
				stmt.close();
				conection.close();			
			}
		}
	}

	public Usuario getUsuario(Usuario usuario) 
			throws SQLException, ClassNotFoundException {
		Connection conection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conection = new ConnectionFactory().getConnection();
			stmt = conection.prepareStatement(GET) ;
			
			int i = 0;
			//where
			stmt.setInt(++i, usuario.getId());
			
			rs = stmt.executeQuery();
			
			Usuario usuarioRet = null;
			if(rs.next()) {
				 usuarioRet = preencheUsuario(rs);
			} 
			
			return usuarioRet;
		}finally {
			if(conection != null) {
				rs.close();
				stmt.close();
				conection.close();			
			}
		}
	}

	private Usuario preencheUsuario(ResultSet rs) 
			throws SQLException {
		return new Usuario(
				rs.getInt("ID"), //id 
				rs.getString("NAME"), //nome, 
				rs.getString("CPF"), //cpf, 
				rs.getString("EMAIL"), //email, 
				rs.getTimestamp("DATE_REGISTER", Calendar.getInstance()) //dataCadastro
				);
	}

}
