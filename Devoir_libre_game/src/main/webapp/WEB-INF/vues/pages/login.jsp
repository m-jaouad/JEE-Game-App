<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>App Game</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/style/signin.css"
	rel="stylesheet">
</head>

<body>




	<form class="form-signin" method="POST"
		action="${pageContext.request.contextPath}/LoginServlet">
		<div>
			<div class="container">
				<c:choose>
					<c:when test="${requestScope.msg.type == Message.WARN}">
						<p style="color: yellow;">${requestScope.msg.text}</p>
					</c:when>
					<c:when test="${requestScope.msg.type == Message.INFO}">
						<p style="color: green;">${requestScope.msg.text}</p>
					</c:when>
					<c:when test="${requestScope.msg.type == Message.ERROR}">
						<p style="color: red;">${requestScope.msg.text}</p>
					</c:when>
					<c:otherwise>
						<p>${msg.text}</p>
					</c:otherwise>
				</c:choose>
				<a href="${pageContext.request.contextPath}/register">S'inscrire</a>
			</div>
			<h2 class="form-signin-heading">Connexion</h2>
			<label for="inputEmail" class="sr-only">Nom d'utilisateur</label> <input
				type="text" class="form-control" placeholder="Nom d'utilisateur"
				required autofocus name="login"> <label for="inputPassword"
				class="sr-only">Mot de passe</label> <input type="password"
				id="inputPassword" class="form-control" placeholder="Password"
				name="password" required>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
	</form>

	</div>
</body>
</html>