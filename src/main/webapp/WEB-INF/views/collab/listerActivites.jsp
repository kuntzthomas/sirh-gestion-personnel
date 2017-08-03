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
	<h1>Activités</h1>

	<!--  Liste des activités  -->
	<table style="border: 2px solid black;"
		class="col-lg-10 col-md-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-xs-offset-1">
		<thead>
			<tr style="border: 2px solid black;">
				<th class="col-lg-4 col-md-4 col-xs-4">Date/Heure</th>
				<th class="col-lg-8 col-md-8 col-xs-8">Libellé</th>
			</tr>
		</thead>
		<c:forEach var="activite" items="${activites}">
			<tr>
				<td class="col-lg-4 col-md-4 col-xs-4">${activite.dateHeure}</td>
				<td class="col-lg-8 col-md-8 col-xs-8">${activite.type.libelle} ${activite.matricule}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>