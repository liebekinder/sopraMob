<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h2>Systeme de notifications</h2>
	
    <form action="SendMessage" method="get">
		<label>Message a diffuser </label>
		<br/><textarea name="Message" rows="3" cols="60" > </textarea> 
		<br/><input type="submit" name="submit" value="Submit" />
	</form>	
</body>
</html>