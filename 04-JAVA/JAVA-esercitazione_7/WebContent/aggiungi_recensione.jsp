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
		
		<c:choose>
		    <c:when test="${error==true}">
		        Non hai i privilegi per entrare in questa pagina
		    </c:when>    
		    <c:otherwise>
				<section id="content-main">
					<h1>Scrivi Recensione</h1>
					
					<!-- mostra dei messaggi di conferma se il salvataggio è avvenuto con successo oppure no -->
					<p>
						<c:if test="${ok.equals(true)}">
							Salvataggio eseguito correttamente!
						</c:if>
						<c:if test="${errore.equals(true)}">
							Errore nei dati! Riprova.
						</c:if>
					</p>
					
					
					<form method="post" action="aggiungi_recensione.html">
						
						<!-- Film -->
						<div>
							<label for="film">Nome Film</label>
							<!-- carica automaticamente i film che l'utente può selezionare -->
							<select id="film" name="film" multiple size="3">
								<c:forEach items="${lista_film}" var="film">
									<option value="${film.getId()}"
									<c:if test="${recensione!=null && recensione.getFilm().equals(film)}">selected</c:if>>
										${film.getNome()}
									</option>
								</c:forEach>	
							</select>
						</div>
						
						<!-- Contenuto Recensione -->
						<div>
							<label for="contenuto_recensione">Contenuto Recensione</label>
							<textarea id="contenuto_recensione" name="contenuto_recensione" rows="10" cols="20">
								<c:if test="${recensione != null }">
									${recensione.getContenuto_recensione()}
								</c:if>
							</textarea>
						</div>
						
						<!-- Voto Finale -->
						<div>
							<label for=voto_finale>Voto Finale</label>
							<select id="voto_finale" name="voto_finale">
								<!-- genera automaticamente i voti che l'utente può selezionare -->
								<c:forEach var="i" begin="0" end="10" step="1">
									<option value="${i}"
									<c:if test="${recensione!=null && recensione.getVoto()==i}">selected</c:if>>
										${i}
									</option>
								</c:forEach>
							</select>
						</div>
						
						<!-- se l'utente vuole modificare una recensione, crea un elemento input nascosto che conservi l'id della recensione -->
						<c:if test="${recensione != null }">
							<input type="hidden" id="id" name="id" value="${recensione.id}">
						</c:if>
						<!-- Pulsante Salva -->
						<div>
							<input type="submit" name="Salva" value="Inserisci Recensione">
						</div>
						
					</form>
				</section>
				
			</c:otherwise>
		</c:choose>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
		
	</body>
</html>