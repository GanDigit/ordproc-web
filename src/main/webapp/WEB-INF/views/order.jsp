<!DOCTYPE html>
<html lang="en">

<head>
	<title>Order List</title>
</head>

<body>
	<h1 style="color: red">Product details</h1>
	<div class="container">
		<div class="row">
			<h2>User Profiles</h2>
			<ul>
				<c:forEach items="${products}" var="product">
					<li><a href="userDetails?id=${product.userId}">${product.id}</a></li>
					<li><a href="userDetails?id=${product.userId}">${product.category}</a></li>
					<li><a href="userDetails?id=${product.userId}">${product.name}</a></li>
					<li><a href="userDetails?id=${product.userId}">${product.price}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>