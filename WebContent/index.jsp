<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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