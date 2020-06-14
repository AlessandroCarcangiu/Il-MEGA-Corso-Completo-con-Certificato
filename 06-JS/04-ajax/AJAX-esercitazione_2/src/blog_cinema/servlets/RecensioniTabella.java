package blog_cinema.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog_cinema.dominio.Recensione;
import blog_cinema.dominio.Utente;
import blog_cinema.dominio.Utente.TipoUtente;
import blog_cinema.db.RecensioneQuery;

/**
 * Servlet implementation class RecensioniTabella
 */
@WebServlet("/RecensioniTabella")
public class RecensioniTabella extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecensioniTabella() {
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
		
		// Controlla se l'utente ha i diritti necessari
		// nella pagina RecensioniTabella possono entrare solo gli utenti di tipo Admin
		// se non è un admin, mostragli un messaggio di errore
		Utente utente = (Utente)session.getAttribute("utente");
		if(utente.getTipo() != TipoUtente.ADMIN) {
			// crea nella request una variabile "error"=True
            request.setAttribute("error", true);
		}else {
			// prendi tutte le recensioni scritte dall'utente e salvale nella request
			ArrayList<Recensione> recensioni = new ArrayList<Recensione>();
			try {
				recensioni = RecensioneQuery.get_recensioni(utente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("recensioni",recensioni);
		}
				
		// restituisci contenuto generato recensioni_tabella.jsp
		request.setAttribute("pagina_attuale", "recensioni_tabella");
		request.getRequestDispatcher("recensioni_tabella.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
