<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
	<c:forEach var="recensione" items="${recensioni}">
		<json:object>
			<json:property name="id" value="${recensione.getId()}"/>
		  	<json:property name="contenuto_recensione" value="${recensione.getContenuto_recensione()}"/>
		  	<json:property name="voto" value="${recensione.getVoto()}"/>
		  	<json:object name="film">		  	
		  		<json:property name="nome" value="${recensione.getFilm().getNome()}"/>
		  	</json:object>
		  	<json:object name="autore">
		  		<json:property name="username" value="${recensione.getAutore().getUsername()}"/>
		  	</json:object>
		</json:object>
	</c:forEach>
</json:array>