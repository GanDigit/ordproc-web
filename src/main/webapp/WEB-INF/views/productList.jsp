<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Product List</title>
</head>

<body>
	<h1 style="color: red">Product List</h1>

       <div>
            <a href="/addProduct">Add</a>
       </div>


	    <div>
          <table border="1">
            <tr>
              <th>ID</th>
              <th>Category</th>
              <th>Name</th>
              <th>Price</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
            <c:forEach  items="${products}" var ="product">
            <tr>
              <td><a href="/products/${product.id}">${product.id}</a></td>
              <td>${product.category}</td>
              <td>${product.name}</td>
              <td>${product.price}</td>
              <td><a href="/editProducts/${product.id}">Edit</a></td>
              <td><a href="/deleteProduct/${product.id}">Delete</a></td>
            </tr>
            </c:forEach>
          </table>
        </div>


</body>
</html>