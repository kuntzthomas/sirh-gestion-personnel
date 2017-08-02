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

	<!--  Liste des noms  -->	
	<div class="row">
    <ul>
        <c:forEach var="collab" items="${listeCollab}">
        <li class="thumbnail col-lg-4 col-md-4 col-xs-4" >
            <div class="row">
                <div class="col-lg-5 col-md-5 col-xs-5" ><img src="${collab.photo}" style="width:100px"></div>
                <div class="col-lg-7 col-md-7 col-xs-7" >Matricule : ${collab.matricule} <br/>
                Nom Prénom : ${collab.nom} ${collab.prenom} <br/> 
                Date de Naissance : ${collab.dateNaissance} <br/> 
                Adresse : ${collab.adresse} <br/> 
                Numéro de sécurité sociale : ${collab.numSecu} <br/> 
                Email : ${collab.emailPro} <br/> 
                Date de création du compte : ${collab.dateHeureCreation} <br/></div>
            </div>
        </li>
        </c:forEach>
        
    </ul>
   </div> (
</body>
</html>