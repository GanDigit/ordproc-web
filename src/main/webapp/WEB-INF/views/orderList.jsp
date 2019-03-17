<!DOCTYPE html>
<html lang="en">

<head>
	<title>Order List</title>
</head>
<body>
	<h1 style="color: red">Order List</h1>
	<div class="container">
		<div class="row">
			<h2>User Profiles</h2>
			<ul>
				<c:forEach items="${orderHeaders}" var="orderHeader">
					<li><a href="userDetails?id=${orderHeader.id}">${orderHeader.id}</a></li>
					<li><a href="userDetails?id=${orderHeader.id}">${orderHeader.referenceText}</a></li>
					<li><a href="userDetails?id=${orderHeader.id}">${orderHeader.userName}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
