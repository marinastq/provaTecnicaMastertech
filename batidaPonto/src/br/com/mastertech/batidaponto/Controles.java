package br.com.mastertech.batidaponto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controles")
public class Controles extends HttpServlet {
	private static final String GESTAOUSUARIOS = "/usuariogestao.jsp";
	private static final String BATIDAPONTO = "/batidainclusao.jsp";
	private static final String VOLTAR = "/bemvindo.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String botao = request.getParameter("action");
		String pagina = "";
		
		if(botao != null && botao.equals("Voltar")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(VOLTAR);
			requestDispatcher.forward(request, response);	
			return;
		} else if(botao.equals("Gestão de Usuários")) {
			pagina = GESTAOUSUARIOS;
		} else if(botao.equals("Batida de Ponto")) {
			pagina = BATIDAPONTO;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
		requestDispatcher.forward(request, response);
	}	

}
