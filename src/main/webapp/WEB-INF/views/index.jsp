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
	<br>

</head>

<body>

	<div class="jumbotron">

		<h1>${welcome}</h1> <br>

		<form action="<c:url value="play"/>">
			<h2>
				<button type="submit">${playButton}</button>
			</h2>
		</form> <br>

		<c:if test="${!empty games}">
			<table>
				<!-- This table display all the games... -->
				<tr>
					<th><c:out value="${playerChoice}" /></th>
					<th><c:out value="${computerChoice}" /></th>
					<th><c:out value="${result}" /></th>
				</tr>
				<c:forEach var="game" items="${games}">
					<tr>
						<td><c:out value="${game.playerChoice}" /></td>
						<td><c:out value="${game.computerChoice}" /></td>
						<td><c:out value="${game.result}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<form action="<c:url value="restart"/>">
			<h2>
				<button type="submit">${restartButton}</button>
			</h2>
		</form>

		<div>
			<c:out value="${rounds}" />
			<c:out value="${numGames}" />
			<br> <a href="/stats">${goToStats}</a> <br>
		</div>
	</div>

</body>
</html>