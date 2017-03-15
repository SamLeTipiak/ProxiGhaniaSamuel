<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="C:/Users/adminl/Desktop/ProxiSamuel/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Liste clients</title>
</head>
<body>
	<h1>Liste clients :</h1>

	<p>A partir de cette liste vous pourrez modifier les informations
		d'un client et effectuer des virements entre autres.</p>

	<table>

		<tr class="row">
			<th class="col-md-1">Id Client</th>

			<th class="col-md-1">Nom</th>

			<th class="col-md-1">Prénom</th>

			<th class="col-md-1">Conseiller attitré</th>

			<th class="col-md-1">Adresse</th>

			<th class="col-md-1">Code Postal</th>

			<th class="col-md-1">Ville</th>

			<th class="col-md-1">Téléphone</th>

		</tr>

		<c:forEach items="${ClientList}" var="Client">
			<tr class="row">
				<td class="col-md-1">${Client.idClient}</td>
				<td class="col-md-1">${Client.lastName}</td>
				<td class="col-md-1">${Client.firstName}</td>
				<td class="col-md-1">${Client.idAdviser}</td>
				<td class="col-md-1">${Client.address}</td>
				<td class="col-md-1">${Client.zipCode}</td>
				<td class="col-md-1">${Client.town}</td>
				<td class="col-md-1">${Client.telNumber}</td>

			</tr>


		</c:forEach>
	</table>

	<form action="EditServlet" method="post" class="col-md-5">
		<fieldset>
			<legend>Modification client</legend>
			<select name="Identifiant">
				<c:forEach items="${ClientList }" var="Client">
					<option>${Client.idClient}</option>
				</c:forEach>
			</select> <input type="submit" value="Modifier" />
		</fieldset>

	</form>


	<form action="AccountListServlet" method="post" class="col-md-5">
		<fieldset>
			<legend>Comptes client</legend>
			<select name="Identifiant">
				<c:forEach items="${ClientList}" var="Client">
					<option>${Client.idClient}</option>
				</c:forEach>
			</select> <input type="submit" value="Comptes" />
		</fieldset>

	</form>

</body>
</html>