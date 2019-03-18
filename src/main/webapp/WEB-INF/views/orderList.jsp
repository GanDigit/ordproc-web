<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Order List</title>
</head>
<body>
	<h1 style="color: red">Order List</h1>
   <div>
        <a href="/addOrder">Add</a>
   </div>

    <div>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>Reference Text</th>
          <th>User Name</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
        <c:forEach  items="${orders}" var ="order">
        <tr>
          <td><a href="/orders/${order.id}">${order.id}</a></td>
          <td>${order.referenceText}</td>
          <td>${order.userName}</td>
          <td><a href="/editOrders/${order.id}">Edit</a></td>
          <td><a href="/deleteOrder/${order.id}">Delete</a></td>
        </tr>
        </c:forEach>
      </table>
    </div>

</body>
</html>
