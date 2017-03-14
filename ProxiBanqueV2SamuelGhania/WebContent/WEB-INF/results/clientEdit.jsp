<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification client</title>
</head>
<body>


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
			<th class="col-md-4"></th>

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

				<td class="col-md-2"><input type="submit" value="Modifier" /></td>
				<td class="col-md-2"><input type="submit" value="Comptes" /></td>


			</tr>


		</c:forEach>
	</table>


</body>
</html>