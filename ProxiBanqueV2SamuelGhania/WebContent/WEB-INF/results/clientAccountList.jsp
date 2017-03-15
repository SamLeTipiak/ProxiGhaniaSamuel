<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste de comptes</title>
</head>
<body>

	<div>
		<h1>Voici la liste des comptes de ${Client.lastName }
			${Client.firstName } :</h1>
	</div>
	
	<table>
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

				<td class="col-md-2"><a href=""><input type="submit" value="Modifier"></a></td>
				
				<td class="col-md-2"><a href="AccountListServlet"><input type="submit" value="Comptes" name=""/></a></td>


			</tr>


		</c:forEach>
	</table>
	
	<div>
		<h2>Compte courant</h2>
		<table>
			<tr>

				<th>Numéro de compte</th>
				<th>Solde</th>
				<th>Carte associée</th>
			</tr>
			<tr>

				<td>${ca.numAccount}</td>

				<td>${ca.sold}</td>

				<td>${ca.type }</td>
				

			</tr>
		</table>

		<h2>Compte épargne</h2>

		<table>
			<tr>

				<th>Numéro de compte</th>
				<th>Solde</th>
				<th>Carte associée</th>
			</tr>

			<tr>

				<td>${sa.numAccount}</td>

				<td>${sa.sold}</td>

				<td>${sa.type }</td>

			</tr>

		</table>
	</div>
</body>
</html>