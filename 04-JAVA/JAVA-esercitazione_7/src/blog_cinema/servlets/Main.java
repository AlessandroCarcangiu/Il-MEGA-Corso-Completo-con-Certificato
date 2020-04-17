package blog_cinema.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog_cinema.dominio.Genere;
import blog_cinema.dominio.Recensione;
import blog_cinema.factories.GenereFactory;
import blog_cinema.factories.RecensioneFactory;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
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
				
		// crea mappa che associa genere->lista recensioni
		Map<Genere, ArrayList<Recensione>> map = new HashMap<Genere, ArrayList<Recensione>>();
		
		// prendi la lista generi da GenereFactory
		ArrayList<Genere> lista_generi = GenereFactory.get_instance().getGeneri();
		
		// prendi le recensioni per ogni genere
		for(Genere genere : lista_generi) {
			try {
				map.put(genere, RecensioneFactory.get_instance().get_recensione(genere));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// salva la map nella request
		request.setAttribute("map", map);
		
		// restituisci contenuto generato main.jsp
		request.setAttribute("pagina_attuale", "main");
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
