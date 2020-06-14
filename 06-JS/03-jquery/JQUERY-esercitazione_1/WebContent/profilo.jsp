<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- header -->
		<jsp:include page="header.jsp" />
		
		<!-- nav -->
		<jsp:include page="nav.jsp" />
		
		<section id="content-main">
			<h1>Profilo</h1>
			
			<!-- mostra dei messaggi di conferma se l'operazione di salvataggio è avvenuta con successo o meno -->
    		<p>
    			<c:if test="${ok.equals(true)}">
    				Salvataggio eseguito correttamente!
    			</c:if>
    			<c:if test="${errore.equals(true)}">
    				Errore nei dati! Riprova.
    			</c:if>
    		</p>
		        
			<form method="post" action="profilo.html">

				<!-- Dati dell'utente -->
				<div>
					<label for="nome">Nome</label>
					<input type="text" name="nome" id="nome" readonly value="${utente.getNome()}"/>
				</div>
				
				<div>
					<label for="cognome">Cognome</label>
					<input type="text" name="nome" id="cognome" readonly value="${utente.getCognome()}"/>
				</div>
				
				<div>
					<label for="email">Email</label>
					<input type="text" name="email" id="email" value="${utente.getEmail()}"/>
				</div>
				
				<div>
					<label for="username">Username</label>
					<input type="text" name="username" id="username" readonly value="${utente.getUsername()}"/>
				</div>
				
				<div>
					<label for="Password">Password</label>
					<input type="password" name="password" id="password"/>
				</div>
				
				<div>
					<label for="tipo">Tipo</label>
					<input type="text" name="tipo" id="tipo" readonly value="${utente.getTipo().name()}"/>
				</div>
				
				<!-- Pulsante invia -->
				<input type="submit" name="Salva" value="Salva modifiche">
				
				<!-- Pulsante elimina -->
				<input type="submit" name="Elimina" value="Elimina profilo">
		    
			</form>
		</section>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
	</body>
</html>