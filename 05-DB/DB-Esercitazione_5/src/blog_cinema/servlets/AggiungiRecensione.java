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
import blog_cinema.dominio.Recensione;
import blog_cinema.dominio.Utente;
import blog_cinema.dominio.Utente.TipoUtente;
import blog_cinema.db.FilmQuery;
import blog_cinema.db.RecensioneQuery;

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
			// Operazioni da gestire: salva - modifica - eliminazione
			// 1) l'utente ha premuto sul pulsante "Salva" del form -> Salva != null
			// 2) l'utente vuole visualizzare una recensione già inserita -> Modifica != null
			if (request.getParameter("Salva") != null) {
				// prendiamo tutti i dati inviati tramite il form
				// prendiamo il film
				Film film = null;
				if (request.getParameter("film") != null) {
					film = FilmQuery.get_film(Integer.parseInt(request.getParameter("film")));
				}
				
				// prendiamo il contenuto della recensione
				String contenuto_recensione = request.getParameter("contenuto_recensione");
				
				// prendiamo il voto
				Integer voto = 0;
				if(request.getParameter("voto_finale")!=null) {
					voto = Integer.parseInt(request.getParameter("voto_finale"));
				}
				
				// controlla se i dati sono corretti
				if(film != null && contenuto_recensione != null && voto != null) {
					if(request.getParameter("id")==null) {
						try {
							// crea una nuova recensione e salvala nella factory
							Recensione recensione = new Recensione();
							recensione.setId(RecensioneQuery.get_recensioni().size());
							recensione.setFilm(film);
							recensione.setContenuto_recensione(contenuto_recensione);
							recensione.setVoto(voto);
							recensione.setAutore(utente);
							
							RecensioneQuery.inserisci_recensione(recensione);
							
							// comunica all'utente che l'operazione ha avuto successo
							request.setAttribute("ok", true);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						// salva le modifiche apportate dall'utente
						Integer id = Integer.parseInt(request.getParameter("id"));
						Recensione recensione;
						try {
							recensione = RecensioneQuery.get_recensione(id);
							recensione.setFilm(film);
							recensione.setContenuto_recensione(contenuto_recensione);
							recensione.setVoto(voto);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// comunica all'utente che l'operazione ha avuto successo
						request.setAttribute("ok", true);
					}
					
				}else {
					request.setAttribute("errore", true);
				}
			}else if(request.getParameter("Modifica")!=null) {
				// l'utente vuole visualizzare una recensione già inserita (e forse anche modificare)
				// prendiamo l'id della recensione
				String temp_id = (String)request.getParameter("id");
				if(temp_id!=null) {
					Integer id = Integer.parseInt(temp_id);
					Recensione recensione;
					try {
						recensione = RecensioneQuery.get_recensione(id);
						// controlliamo se recensione != null e se l'utente == autore
						// se si, salva nella richiesta la recensione (i cui dati verrrano mostrati nel form)
						if(recensione!=null && recensione.getAutore().equals(utente)) {
							request.setAttribute("recensione", recensione);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else if (request.getParameter("Elimina")!=null) {
				// l'utente vuole eliminare una recensione già inserita
				// prendi l'id della recensione
				String temp_id = (String) request.getParameter("id");
				if (temp_id!=null) {
					Integer id = Integer.parseInt(request.getParameter("id"));
					// controlla se esiste e se l'utente è il suo autore
					// se si cancella
					Recensione recensione;
					try {
						recensione = RecensioneQuery.get_recensione(id);
						if (recensione != null && recensione.getAutore().equals(session.getAttribute("utente"))) {
							RecensioneQuery.rimuovi_recensione(recensione);
							// qui puoi decidere se restituire il controllo alla servlet RecensioniTabella
							// oppure se re-indirizzare l'utente sulla pagina di inserimento. 
							// io ho optato per la prima opzione
							request.setAttribute("ok",true);
							response.sendRedirect("recensioni_tabella.html");
							return;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			// prendi tutti i generi
			ArrayList<Film> lista_film = FilmQuery.get_film();
			
			// salva la lista nella request
			request.setAttribute("lista_film",lista_film);
		}

		
		// restituisci contenuto generato aggiungi_recensione.jsp
		request.setAttribute("pagina_attuale", "aggiungi_recensione");
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
