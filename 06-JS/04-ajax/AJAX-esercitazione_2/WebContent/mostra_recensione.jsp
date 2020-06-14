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
			<!-- titolo film -->
			<input type="hidden" id="id" value="${recensione.getId()}">
			<div id="titolo">
				<h1 id="titolo_film">${recensione.getFilm().getNome()}</h1>
				<button id="recensione_precedente"> precedente </button>
				<button id="recensione_successiva"> successiva </button>
			</div>
			<p id="dettagli_recensione">
				Autore: ${recensione.getAutore().getUsername()} - voto: ${recensione.getVoto()}
			</p>
			<p id="contenuto_recensione">
				${recensione.getContenuto_recensione()}
			</p>
		</section>		
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
	</body>
</html>