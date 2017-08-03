<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
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
	<h1>Les collaborateurs</h1>

	<!-- Recherche -->

	<!-- Fin Recherche -->

	<!-- Filtre par departement -->
	<div class="form-group col-lg-12 col-md-12 col-xs-12">
		<label class="col-md-4 control-label" for="filtreDep">Filtrer
			par département</label>
		<div class="col-md-4">
			<select id="filtreDep" name="filtreDep" class="form-control">
				<c:forEach var="dep" items="${listeDep}">
					<option value="1">${dep.nom}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<!-- Fin Filtre par departement -->

	<!--  Liste des noms  -->
	<div class="row">
		<ul>
			<c:forEach var="collab" items="${listeCollab}">
				<li class="thumbnail col-lg-4 col-md-4 col-xs-4">
					<div class="row">
						<div class=" col-lg-4 col-md-4 col-xs-4">${collab.nom}
							${collab.prenom}</div>
					</div>
					<div class="row col-lg-12 col-md-12 col-xs-12">
						<div class="row">
							<div class="col-lg-4 col-md-4 col-xs-4">
								<img src="${collab.photo}" style="width: 100%;">
							</div>
							<div class="col-lg-8 col-md-8 col-xs-8">
								Fonction : ${collab.intitulePoste} <br /> Departement :
								${collab.departement} <br /> Email : ${collab.emailPro}<br />
								Adresse : ${collab.adresse}<br />
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<!--  Fin Liste des noms  -->
</body>
</html>