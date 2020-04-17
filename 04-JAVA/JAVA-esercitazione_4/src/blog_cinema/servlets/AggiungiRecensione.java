package blog_cinema.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog_cinema.dominio.Film;
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
		// prendi tutti i generi
		ArrayList<Film> lista_film = FilmFactory.get_instance().getLista_film();
		
		// salva la lista nella request
		request.setAttribute("lista_film",lista_film);

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
