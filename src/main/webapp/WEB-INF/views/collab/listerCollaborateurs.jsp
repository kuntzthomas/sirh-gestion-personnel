<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>
<body>
	<h1>Les collaborateurs</h1>

	<!--  Liste des noms  -->
	<ul>
		<%
			List<Collaborateur> listeCollab = (List<Collaborateur>)request.getAttribute("listeCollab");
			for (Collaborateur collab : listeCollab) {
		%>
		<li><%=collab.getNom()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>