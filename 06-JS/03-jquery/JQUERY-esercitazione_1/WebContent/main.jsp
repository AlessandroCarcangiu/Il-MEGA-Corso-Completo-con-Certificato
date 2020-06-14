<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>
<html>
	<head>
	
	</head>
	<body>
		
		<!-- header -->
		<jsp:include page="header.jsp" />
		
		<!-- nav -->
		<jsp:include page="nav.jsp" />
		
		<section id="content-main">
			<!-- titolo e presentazione -->
			<div id="titolo">
				<h1>Blog Cinema</h1>
				<button id="aumenta_carattere">+</button>
				<button id="riduci_carattere">-</button>
			</div>
			<p id="paragrafo_sottostante">
				Abbado paragonava la cultura all'acqua. Semplice nella sua forma, ma indispensabile per vivere. I teatri, le biblioteche, i musei e
				i cinema non sono altro che immensi acquedotti che distribuiscono cultura e informazione ovunque e a chiunque senta il bisogno di arrichire il proprio animo.  
				In questi anni bui, si tende quasi a disprezzare la conoscenza e la cultura ma non dovremo mai, e poi mai, sottovalutare l'importanza di tali elementi. 
				Noi, oggi, siamo qui anche grazie ad essi e a chi ha combattuto e lavorato per rendere l'arte e la cultura accessibile a chiunque. 
				In questo blog, mi concentrerò principalmente su uno dei tanti rami da cui è possibile creare cultura: il cinema. I film ci possono regalare un'infinita di sentimenti,
				posso regalarci un sorriso, farci riflettere, ragionare, piangere o semplicemente svuotarci il corpo dallo stress accumulato.  
				Una recensione di un film ogni giorno, con l'obiettivo di analizzare nei minimi dettagli la storia che racconta e i personaggi che la raccontano.
			</p>
			
			<!-- indice sezioni -->
			<c:forEach items="${map}" var="item">
				<c:set var="genere" scope="application" value="${item.key}"/>
				<c:set var="lista_recensioni" scope="application" value="${item.value}"/>				
				
				<section id="${genere.getNome()}">
					<h2>${genere.getNome()}</h2>
					<p>
						${genere.getDescrizione()}
					</p>
					<img src="${genere.getImg()}"
						 alt="Testo da mostrare se l'immagine non viene caricata"
						 title="immagine di descrizione"
					/>
					<div>
						<h4>Recensioni inserite per questo genere</h4>
						<ol>
							<c:forEach items="${lista_recensioni}" var="recensione">
								<li>
									Recensione <b>${recensione.getFilm().getNome()}</b> di ${recensione.getAutore().getUsername()}
									<p>
										${recensione.getContenuto_recensione()}
									</p>
								</li>
							</c:forEach>
						</ol>
					</div>
				</section>
			</c:forEach>
		</section>		
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
	</body>
</html>