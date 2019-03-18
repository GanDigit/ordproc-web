<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Product List</title>
</head>

<body>
	<h1 style="color: red">Product Update</h1>
	<form action='/saveProduct' method='post'>
	    <div>
          <table border="1">
            <tr>
              <td>ID</td>
              <td>${product.id}</td>
              </tr>
              <tr>
              <td>Category</td>
              <td><input type=text name=category value="${product.category}"></td>
              </tr>
              <tr>
              <td>Name</td>
              <td><input type=text name=name value="${product.name}"></td>
              </tr>
              <tr>
              <td>Price</td>
              <td><input type=text name=price value="${product.price}"></td>
            </tr>
          </table>
        </div>
            <input type='hidden' id='id' name='id' value="${product.id}"/>
           <div>
        <a href="/products">Back</a>
           </div>
          <div>
       <button type="submit" >Save </button>
          </div>
        </form>
</body>
</html>