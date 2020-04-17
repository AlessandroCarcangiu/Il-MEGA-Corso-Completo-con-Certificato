package blog_cinema.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog_cinema.dominio.Film;
import blog_cinema.dominio.Utente;
import blog_cinema.dominio.Utente.TipoUtente;
import blog_cinema.factories.FilmFactory;

/**
 * Servlet implementation class AggiungiRecensione
 */
@WebServlet("/AggiungiRecensione")
public class AggiungiRecensione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiRecensione() {
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
		// nella pagina AggiungiRecensione possono entrare solo gli utenti di tipo Admin
		// se non è un admin, mostragli un messaggio di errore
		Utente utente = (Utente)session.getAttribute("utente");
		if(utente.getTipo() != TipoUtente.ADMIN) {
			// crea nella request una variabile "error"=True
            request.setAttribute("error", true);
		}
		else {
			// prendi tutti i generi
			ArrayList<Film> lista_film = FilmFactory.get_instance().getLista_film();
			
			// salva la lista nella request
			request.setAttribute("lista_film",lista_film);
		}

		
		// restituisci contenuto generato aggiungi_recensione.jsp
		request.getRequestDispatcher("aggiungi_recensione.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
