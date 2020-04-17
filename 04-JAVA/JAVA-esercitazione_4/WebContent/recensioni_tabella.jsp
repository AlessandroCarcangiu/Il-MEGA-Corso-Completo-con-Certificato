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
				</tbody>
			</table>
		</section>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
		
	</body>
</html>