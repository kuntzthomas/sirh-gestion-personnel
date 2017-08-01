<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>
<body>

	<form class="form-horizontal" method="post" action="">
		<fieldset>

			<!-- Form Name -->
			<legend>Form Name</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">Nom</label>
				<div class="col-md-4">
					<input id="nom" name="nom" placeholder="Nom"
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prenom">Prenom</label>
				<div class="col-md-4">
					<input id="prenom" name="prenom" placeholder="Prenom"
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="dateNaissance">Date
					de Naissance</label>
				<div class="col-md-4">
					<input id="dateNaissance" name="dateNaissance"
						placeholder="jj/mm/aaaa" class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">Adresse</label>
				<div class="col-md-4">
					<input id="adresse" name="adresse" placeholder=""
						class="form-control input-md" type="text">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="numSecu">Numero
					de sécurité sociale</label>
				<div class="col-md-4">
					<input id="numSecu" name="numSecu" placeholder=""
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="creer">Single
					Button</label>
				<div class="col-md-4">
					<button name="creer"
						class="btn btn-primary pull-right">Créer</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>
