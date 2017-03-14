<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste de comptes</title>
</head>
<body>

	<div>
		<h1>Voici la liste des comptes de ${Client.lastName }
			${Client.firstName } :</h1>
	</div>

	<table>
		<tr>
			<th>Type de compte</th>
			<th>Numéro de compte</th>
			<th>Solde</th>
			<th>Carte associée</th>
		</tr>
<tr>
<td><b>Compte courant</b></td>

<td>${sc.numAccount}</td>

<td>${sc.sold}</td>

<td>${sc.type }</td>

</tr>

<tr>
<td><b>Compte épargne</b></td>

<td>${sc.num }</td>

<td></td>

<td></td>

</tr>

	</table>

</body>
</html>