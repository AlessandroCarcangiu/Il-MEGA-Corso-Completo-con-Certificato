<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			
			<form>
				
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
				
			</form>
		</section>
		
		<!-- footer -->
		<jsp:include page="footer.jsp" />
		
	</body>
</html>