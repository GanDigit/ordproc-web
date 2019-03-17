<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Product List</title>
</head>

<body>
	<h1 style="color: red">Product Details</h1>
	    <div>
          <table border="1">
            <tr>
              <td>ID</td>
              <td>${product.id}</td>
              </tr>
              <tr>
              <td>Category</td>
              <td>${product.category}</td>
              </tr>
              <tr>
              <td>Name</td>
              <td>${product.name}</td>
              </tr>
              <tr>
              <td>Price</td>
              <td>${product.price}</td>
            </tr>
          </table>
        </div>

           <div>
        <a href="/products">Back</a>
           </div>
</body>
</html>