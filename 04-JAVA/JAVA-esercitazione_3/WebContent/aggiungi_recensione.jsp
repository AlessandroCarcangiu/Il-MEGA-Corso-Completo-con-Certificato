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
			<h1>Scrivi Recensione</h1>
			
			<form>
				
				<!-- Film -->
				<div>
					<label for="nome_film">Nome Film</label>
					<select id="film" name="film" size="3">
					</select>
				</div>
				
				<!-- Contenuto Recensione -->
				<div>
					<label for="contenuto_recensione">Contenuto Recensione</label>
					<textarea id="contenuto_recensione" name="contenuto_recensione" rows="10" cols="20"></textarea>
				</div>
				
				<!-- Voto Finale -->
				<div>
					<label for=voto_finale>Voto Finale</label>
					<!-- <select id="voto_finale" name="voto_finale">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select> -->
				</div>
				
				<!-- Pulsante Salva -->
				<div>
					<input type="submit" name="Submit" value="Inserisci Recensione">
				</div>
				
			</form>
		</section>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
		
	</body>
</html>