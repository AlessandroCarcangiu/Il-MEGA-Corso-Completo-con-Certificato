<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- 
X Crea una tabella che abbia come righe gli oggetti che vorresti gestire con la tua applicazione web, e per colonne i campi che li descrivono.
X Utilizzare in modo corretto i vari tag per specificare i titoli ed i contenuti delle colonne.
 -->
 
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
					<h1>Recensioni Inserite</h1>
					
					<table>
						<thead>
							<tr>
								<th>Nome Film</th>
								<th>Genere</th>
								<th>Contenuto Recensione</th>
								<th>Voto Finale</th>
								<th>Modifica</th>
								<th>Rimuovi</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recensioni}" var="recensione">	
								<tr>
									<td>${recensione.getFilm().getNome()}</td>
									<td>${recensione.getFilm().getGenere().getNome()}</td>
									<td>${recensione.getContenuto_recensione()}</td>
									<td>${recensione.getVoto()}</td>
									<td>
										<form method="post" action="aggiungi_recensione.html?Modifica=true&id=${recensione.getId()}">
											<input type="image" 
											src="images/edit.png" alt="modifica img" title="modifica recensione" width="25" height="25">	
										</form>
									</td>
									<td>
										<form method="post" action="aggiungi_recensione.html?Elimina=true&id=${recensione.getId()}">
											<input type="image" 
											src="images/delete.jpg" alt="elimina img" title="elimina recensione" width="25" height="25">	
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</section>
				
			</c:otherwise>
		</c:choose>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
		
	</body>
</html>