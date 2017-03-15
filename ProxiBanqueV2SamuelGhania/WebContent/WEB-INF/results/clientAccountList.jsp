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

				<td>${Card.type }</td>
				

			</tr>
		</table>

		<h2>Compte épargne</h2>

		<table>
			<tr>

				<th>Numéro de compte</th>
				<th>Solde</th>
			</tr>

			<tr>

				<td>${sa.numAccount}</td>

				<td>${sa.sold}</td>

			</tr>

		</table>
	</div>
</body>
</html>