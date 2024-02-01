<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	<form action="ImagenControlador" method="POST" enctype="multipart/form-data">
		<input type="file" name="imagen"/>
		<button>Subir</button>
	</form>
	${mensaje}
</body>
</html>