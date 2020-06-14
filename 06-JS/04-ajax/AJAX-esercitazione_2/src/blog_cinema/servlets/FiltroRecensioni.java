package blog_cinema.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog_cinema.db.RecensioneQuery;
import blog_cinema.dominio.Recensione;

/**
 * Servlet implementation class FiltroRecensioni
 */
@WebServlet("/FiltroRecensioni")
public class FiltroRecensioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltroRecensioni() {
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
		
		// prendi dalla richiesta l'input dell'utente
		String input_utente = request.getParameter("input_utente");
		
		if(input_utente != null) {
			// prendi dal db tutte le recensioni il cui titolo contiene la stringa inserita dall'utente
			ArrayList<Recensione> recensioni = RecensioneQuery.get_recensioni(input_utente);;

			// produci il json che descrive la recensione richiesta
			request.setAttribute("recensioni", recensioni);
			 
			// quando si restituisce del json e' importante segnalarlo ed evitare il caching
			response.setContentType("application/json");
			response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			request.getRequestDispatcher("recensioniJSON.jsp").forward(request, response);
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
