package blog_cinema.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog_cinema.dominio.Utente;
import blog_cinema.factories.UtenteFactory;

/**
 * Servlet implementation class Profilo
 */
@WebServlet("/Profilo")
public class Profilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profilo() {
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
		if (session == null || session.getAttribute("loggedIn")==null || !session.getAttribute("loggedIn").equals(true)) {
			request.getRequestDispatcher("login.html").forward(request, response);
			return;
		}
			
		// Operazioni da gestire: salva - cancella
		// 1) l'utente ha premuto il tasto "Salva" del form -> Salva != null
		// 3) l'utente vuole eliminare il suo profilo -> Elimina != null
		if (request.getParameter("Salva") != null) {
			// prendi i dati inviati tramite il form
			// prendi l'email
			String email = request.getParameter("email");
			// prendi la password
			String password = request.getParameter("password");
				
			// controlla se i dati sono corretti
			if (email != null & password != null) {
				Utente utente = (Utente) session.getAttribute("utente");
				utente.setEmail(email);
				utente.setPassword(password);
				// comunica all'utente che l'operazione ha avuto successo
				request.setAttribute("ok", true);
				
			} else {
				// comunica all'utente che i dati non sono corretti
				request.setAttribute("errore", true);
			}
		}else if (request.getParameter("Elimina")!=null) {
			// l'utente vuole eliminare il suo profilo
			Utente utente = (Utente) session.getAttribute("utente");
			UtenteFactory.get_instance().getUtenti().remove(utente);
			// richiama la logout che provvederà a distruggere l'attuale sessione
			request.getRequestDispatcher("logout.html").forward(request, response);
			return;
		}

		// inserisci nella risposta l'html generato dalla pagina aggiungi_recensione.jsp
		request.setAttribute("pagina_attuale", "profilo");
        request.getRequestDispatcher("profilo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
