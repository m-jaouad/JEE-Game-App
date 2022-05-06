<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Game App</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/style/signin.css"
	rel="stylesheet">

</head>
<body>

	<div class="container">
		Bonjour
		<c:out value="${sessionScope.user.prenom}" />
		<div class="good">
			<a href="${pageContext.request.contextPath}/auth/bestScores">
				BestScores </a> <a
				href="${pageContext.request.contextPath}/auth/logout">Logout</a>
		</div>

		<br> <br>
		<form class="form-signin" method="POST"
			action="${pageContext.request.contextPath}/auth/play">

			<p class="form-signin-heading">Entrer Le numéro de Dé à Lancer</p>
			<input type="number" class="form-control" min="1" max="3"
				placeholder="Nombre de Dé" required autofocus name="number">
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Lancer
				Le Dé</button>
		</form>

	</div>

</body>
</html>