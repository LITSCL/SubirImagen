<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ImagenControlador" method="POST" enctype="multipart/form-data">
		<input type="file" name="imagen"/>
		<button>Subir</button>
	</form>
	${mensaje}
</body>
</html>