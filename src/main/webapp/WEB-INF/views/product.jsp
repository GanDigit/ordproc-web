<!DOCTYPE html>
<html lang="en">

<head>
	<title>Product List</title>
</head>

<body>
	<h1 style="color: red">Product details</h1>
	<div class="container">
		<div class="row">
			<h2>User Profiles</h2>
			<ul>
				<c:forEach items="${orderHeaders}" var="orderHeader">
					<li><a href="userDetails?id=${product.userId}">${orderHeader.id}</a></li>
					<li><a href="userDetails?id=${product.userId}">${orderHeader.referenceText}</a></li>
					<li><a href="userDetails?id=${product.userId}">${orderHeader.userName}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>