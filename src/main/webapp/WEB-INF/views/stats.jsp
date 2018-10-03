<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>${title}</title>
</head>

<body>

	<div class="jumbotron">

	<h1>${statsTitle}</h1>

	Computer wins accumulator: <c:out value="${gameService.computerWinsAcc}"/> <br>
	Computer wins accumulator: <c:out value="${gameService.playerWinsAcc}"/> <br>
	Total Games: <c:out value="${gameService.gamesAcc}"/> <br>
	<a href="/goBack">${ret}</a>
	</div>
</body>
</html>