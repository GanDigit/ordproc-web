<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Order Details</title>
</head>

<body>
	<h1 style="color: red">Order Details</h1>
	    <div>
          <table border="1">
            <tr>
              <td>ID</td>
              <td>${order.id}</td>
              </tr>
              <tr>
              <td>Reference Text</td>
              <td>${order.referenceText}</td>
              </tr>
              <tr>
              <td>User Name</td>
              <td>${order.userName}</td>
              </tr>
            </tr>
          </table>
        </div>

           <div>
        <a href="/orders">Back</a>
           </div>
</body>
</html>