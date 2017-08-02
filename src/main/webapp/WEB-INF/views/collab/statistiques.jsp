<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.VisiteWeb"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
<title>SGP - App</title>
</head>
<body>
	<h1>Statistiques</h1>

	<!--  Liste des noms  -->
	<table style="border: 2px solid black;"
		class="col-lg-10 col-md-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-xs-offset-1">
		<thead>
			<tr>
				<th style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">Chemin</th>
				<th style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">Nombre de visites</th>
				<th style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">Min</th>
				<th style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">Max</th>
				<th style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">Moyenne</th>
			</tr>
		</thead>
		<c:forEach var="stat" items="${listeStatistiques}">
			<tr>
				<td style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">${stat.chemin}</td>
				<td style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">${stat.nbVisites}</td>
				<td style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">${stat.tempsMin}</td>
				<td style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">${stat.tempsMax}</td>
				<td style="text-align : center;" class="col-lg-4 col-md-4 col-xs-4">${stat.tempsMoyenne}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>