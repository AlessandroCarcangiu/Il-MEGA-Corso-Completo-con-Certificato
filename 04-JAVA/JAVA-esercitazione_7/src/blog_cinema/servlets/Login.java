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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// verifica se esiste una sessione già creata
		// se si: reindirizzo l'utente in main.html
		// altrimenti: crea una nuova sessione
		HttpSession session = request.getSession(true);
		if(session.getAttribute("loggedIn") != null) {
			response.sendRedirect("main.html");
			return;
		}
		
		
		// controlla se l'utente ha compilato il form
		if(request.getParameter("Submit") != null) {
			// preleva i dati inviati
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			
			Utente utente = UtenteFactory.get_instance().get_utente(username, password);
			if(utente != null) {
				session.setAttribute("loggedIn", true);
				session.setAttribute("utente", utente);
				response.sendRedirect("main.html");
				return;
			}
			else {
				// scrivi messaggio di errore
				request.setAttribute("error", true);
			}
		}
		
		// restituisci contenuto generato login.jsp
		request.setAttribute("pagina_attuale", "login");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
