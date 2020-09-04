package br.com.mastertech.batidaponto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mastertech.batidaponto.beans.Usuario;
import br.com.mastertech.batidaponto.dao.IUsuarioDAO;
import br.com.mastertech.batidaponto.dao.UsuarioDAO;

@WebServlet("/CadastraUsuario")
public class CadastraUsuario extends HttpServlet {
	private static final String INSERT = "/usuarioinclusao.jsp";
	private static final String LISTA = "/usuariolistar.jsp";
	private static final String CONSULTA = "/usuarioconsulta.jsp";
	private static final String ALTERAR_TABELA = "/usuarioalteracao.jsp";
	private static final String EXCLUIR_TABELA = "/usuarioexclusao.jsp";
	private static final String ERRO = "/erro.jsp";
	private static final String VOLTAR = "/bemvindo.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String botao = request.getParameter("action");
			String botaoTabela = request.getParameter("actionTable");
			String pagina = "";
			
			if(botao != null && botao.equals("Voltar")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(VOLTAR);
				requestDispatcher.forward(request, response);	
				return;
			}
			
			//camada de dados
			IUsuarioDAO usuarioDAO = new UsuarioDAO();
			
			Usuario usuario = new Usuario(
					parseStringInt(id), //id,
					nome, 
					cpf, 
					email, 
					null //dataCadastro
					);
			
			if(botao != null) {
				if(botao.equals("Pesquisar")) {
					if(id == null || id.equals("")) {
						request = listarUsuarios(usuarioDAO, request);
						
						pagina = LISTA;
					}else { //consulta com id
						request = preencheTelaUsuario(usuarioDAO, request, usuario);
						
						pagina = CONSULTA;
					}
					
				}else if(botao.equals("Incluir")){ //botao insere
					usuarioDAO.insertUsuario(usuario);
					request = listarUsuarios(usuarioDAO, request);
					
					pagina = LISTA;
				} else if(botao.equals("Alterar")){ //botao alterar tela
					usuarioDAO.updateUsuario(usuario);
					request = listarUsuarios(usuarioDAO, request);
					
					pagina = LISTA;
				} else if(botao.equals("Excluir")){ //botao excluir tela
					usuarioDAO.deleteUsuario(usuario);
					request = listarUsuarios(usuarioDAO, request);
					
					pagina = LISTA;
				}
				
			} else { // action da table
				request = preencheTelaUsuario(usuarioDAO, request, usuario);
				
				if(botaoTabela.equals("Alterar")){ //botao excluir tela
					pagina = ALTERAR_TABELA;
				} else if(botaoTabela.equals("Excluir")){ //botao excluir tela
					pagina = EXCLUIR_TABELA;
				}
			}
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
			requestDispatcher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(ERRO);
			request.setAttribute("erro", e.toString());
			requestDispatcher.forward(request, response);
		}
		
	}
	
	private HttpServletRequest preencheTelaUsuario(
			IUsuarioDAO usuarioDAO, 
			HttpServletRequest request, 
			Usuario usuario) 
			throws ClassNotFoundException, SQLException {
		usuario = usuarioDAO.getUsuario(usuario);
		
		request.setAttribute("usuario", usuario);
		request.setAttribute("mensagem", usuario == null ? "Usuário não encontrado" : "");
		return request;
	}
	
	private HttpServletRequest listarUsuarios(IUsuarioDAO usuarioDAO, 
			HttpServletRequest request) 
			throws ClassNotFoundException, SQLException {
		List<Usuario> usuarios = usuarioDAO.listaUsuario();
		request.setAttribute("listaUsuario", usuarios);
		
		return request;
	}
	
	private int parseStringInt(String numero) {
		
		return numero != null && !numero.equals("") ? Integer.parseInt(numero) : 0;
	}

}
