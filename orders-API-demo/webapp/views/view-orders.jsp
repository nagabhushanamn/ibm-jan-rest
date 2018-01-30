<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body class="container">

	<div class="page-header">Orders Management</div>

	<table class="table table-bordered">
	<c:forEach var="order" items="${orders}">
		<tr>
			<td>${order.id}</td>
			<td>${order.price}</td>
			<td>${order.completed}</td>
			<td>${order.description}</td>
			<td><a href="orders/${order.id}"><i class="glyphicon glyphicon-edit"></i></a></td>
			<td><a href="orders/${order.id}"><i class="glyphicon glyphicon-trash"></i></a></td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>