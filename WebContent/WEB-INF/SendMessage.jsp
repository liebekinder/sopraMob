<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Systeme de notifications</h2>

	<form action="SendMessage" method="get">
		<label>Message a diffuser </label> <br />
		<p>
			<textarea name="Message" rows="3" cols="60"> </textarea>
		</p>
		<p>
			<select name="id">
				<c:forEach var="item" items="${liste_id}" varStatus="status">
					<option value="${item}"> ${item} </option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" name="submit" value="Submit" />
	</form>
</body>
</html>