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
			<h1>Login</h1>
			
			<form method="post" action="login.html">
				
				<!-- Username -->
				<div>
					<label for="username">Username</label>
					<input type="text" name="username" id="username"  value="Inserisci username">
				</div>
				
				<!-- Password -->
				<div>
					<label for="password">Password</label>
					<input type="password" name="password" id="password"  value="Inserisci password">
				</div>
				
				<!-- Pulsante invia -->
				<input type="submit" name="Submit" value="Login">
				
				<c:if test="${error==true}">
					Username o password sbagliate, riprova.
				</c:if>				
				
			</form>
		</section>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
		
	</body>
</html>