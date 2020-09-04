package br.com.mastertech.batidaponto;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mastertech.batidaponto.beans.Batida;
import br.com.mastertech.batidaponto.beans.Usuario;
import br.com.mastertech.batidaponto.dao.BatidaDAO;
import br.com.mastertech.batidaponto.dao.IBatidaPontoDAO;
import br.com.mastertech.batidaponto.dao.IUsuarioDAO;
import br.com.mastertech.batidaponto.dao.UsuarioDAO;

@WebServlet("/BatidaPonto")
public class BatidaPonto extends HttpServlet {
		private static final String ERRO = "/erro.jsp";
		private static final String VOLTAR = "/bemvindo.jsp";
		private static final String LISTA = "/batidalistar.jsp";
		private static final String INCLUIR = "/batidainclusao.jsp";
		
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			doPost(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			try {
				String id = request.getParameter("id");
				String dataBatida = request.getParameter("dataBatida");
				String tipoBatida = request.getParameter("tipo");
				
				String botao = request.getParameter("action");
				String pagina = "";
				
				if(botao != null && botao.equals("Voltar")) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher(VOLTAR);
					requestDispatcher.forward(request, response);	
					return;
				} else {
					int idInt = parseStringInt(id);
					
					IBatidaPontoDAO batidaDAO = new BatidaDAO();
					
					if(!existeUsuario(idInt)) {
						throw new Exception("Id de usuário não cadastrado");
					}
					
					if(botao != null && botao.equals("Ok")){ //incluir
						Date dataBatidaDate = formataData(dataBatida);
						
						Batida batida = new Batida(
								idInt,
								dataBatidaDate,
								tipoBatida);
					
						batidaDAO.insertBatida(batida);
						request = listarBatida(batidaDAO, request, idInt);
						pagina = LISTA;
					} else if(botao != null && botao.equals("Consultar")) {
						request = listarBatida(batidaDAO, request, idInt);
						pagina = LISTA;
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
		
		private Date formataData(String dataBatida) 
				throws ParseException {
			//2020-09-02T23:59
			dataBatida = dataBatida.replace("T", " ");
			Date data = new SimpleDateFormat("yyyy-mm-dd HH:mm").parse(dataBatida);
			return data;
		}

		private boolean existeUsuario(int idInt) 
				throws ClassNotFoundException, SQLException {
			Usuario usuario = new Usuario(idInt);
			IUsuarioDAO usuarioDAO = new UsuarioDAO();
			usuario = usuarioDAO.getUsuario(usuario);
			return usuario != null; //se existe eh difernte de null
		}

		private HttpServletRequest listarBatida(IBatidaPontoDAO batidaDAO, HttpServletRequest request,
				int id) 
				throws ClassNotFoundException, SQLException {
			Usuario usuario = new Usuario(id);
			List<Batida> batida = batidaDAO.listaBatidaPorUsuario(usuario);
			request.setAttribute("listaBatida", batida);
			
			String horasTrabalhadas =  calculaHoras(batida);
			request.setAttribute("horasTrabalhadas", horasTrabalhadas);
			return request;
		}


		private String calculaHoras(List<Batida> batida) {
			
			long diferenca = 0;
			long diferencaHoras = 0;
			long diferencaMinutos = 0;
			for(int i=0; i < batida.size()-1; i+=2) {
				diferenca = diferenca +
						 (batida.get(i+1).getDataBatida().getTime() - batida.get(i).getDataBatida().getTime());
			}
			
			diferencaMinutos = (diferenca/(1000 * 60)) % 60; 
			  
			diferencaHoras = (diferenca/(1000 * 60 * 60)) % 24;
			 
			return diferencaHoras + ":" + diferencaMinutos;
		}

		private int parseStringInt(String numero) {
			return numero != null && !numero.equals("") ? Integer.parseInt(numero) : 0;
		}

}
