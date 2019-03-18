<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Order List</title>
</head>

<body>
	<h1 style="color: red">Order Update</h1>
	<form action='/saveOrder' method='post'>
	    <div>
          <table border="1">
            <tr>
              <td>ID</td>
              <td>${order.id}</td>
              </tr>
              <tr>
              <td>Reference Text</td>
              <td><input type=text name=referenceText value="${order.referenceText}"></td>
              </tr>
              <tr>
              <td>User Name</td>
              <td><input type=text name=userName value="${order.userName}"></td>
              </tr>
          </table>
        </div>
            <input type='hidden' id='id' name='id' value="${order.id}"/>
           <div>
        <a href="/orders">Back</a>
           </div>
          <div>
       <button type="submit" >Save </button>
          </div>
        </form>
</body>
</html>