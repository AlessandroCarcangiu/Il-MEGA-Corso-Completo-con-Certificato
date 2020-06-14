package blog_cinema.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog_cinema.db.RecensioneQuery;
import blog_cinema.dominio.Recensione;

/**
 * Servlet implementation class MostraRecensione
 */
@WebServlet("/MostraRecensione")
public class MostraRecensione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraRecensione() {
        super();
        // TODO Auto-generated constructor stub
    }
        
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// verifica se esiste una sessione già creata
		// se no: reindirizzo l'utente in login.html
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("loggedIn")==null || !session.getAttribute("loggedIn").equals(true)) {
			response.sendRedirect("login.html");
			return;
		}
		
		// prendi dalla richiesta cmd e id - NB cmd può essere null
		String cmd = request.getParameter("cmd");
		int id_recensione = Integer.parseInt(request.getParameter("id"));
		
		if(cmd != null && id_recensione > 0) {// richiesta ajax
			// prendi dal db la recensione (in base all'operazione da eseguire)
			Recensione recensione = null;
			
			if (cmd.equals("recensione_successiva")) {
				recensione = RecensioneQuery.recensione_successiva(id_recensione);
			}
			else if(cmd.equals("recensione_precedente")){
				recensione = RecensioneQuery.recensione_precedente(id_recensione);
			}
			// produci il json che descrive la recensione richiesta
			request.setAttribute("recensione", recensione);
			 
			// quando si restituisce del json e' importante segnalarlo ed evitare il caching
			response.setContentType("application/json");
			response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			// genero il json con una jsp
			request.getRequestDispatcher("recensioneJSON.jsp").forward(request, response);
		}
		else if (id_recensione > 0) { 
			// controlla se esiste, altrimenti mostra un errore
			Recensione recensione = RecensioneQuery.get_recensione(id_recensione);
			if (recensione != null) {
				request.setAttribute("recensione", recensione);
			}
			else {
				request.setAttribute("recensione_non_trovata", true);
			}
				
			request.getRequestDispatcher("mostra_recensione.jsp").forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
