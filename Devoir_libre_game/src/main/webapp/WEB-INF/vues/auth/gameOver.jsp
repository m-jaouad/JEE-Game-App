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

	<div class="container">
		<div class="form-signin">
			<h2 class="form-signin-heading">Game Over</h2>
			Votre score :
			<c:out value="${sessionScope.gameState.score}" />
			| Best Score :
			<c:out value="${sessionScope.user.bestScore}" />
			<div class="container">
				<a href="${pageContext.request.contextPath}/auth/play"> play
					again</a>
			</div>
			
		</div>

	</div>

</body>
</html>