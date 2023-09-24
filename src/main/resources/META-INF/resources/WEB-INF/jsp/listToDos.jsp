<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>List ToDos Page</title>
</head>
<body>
<div>Welcome ${name}</div>
<hr>
<h1>Your ToDos</h1>

<table>
      <thead>
            <tr>
            <th>id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Completion Status</th>
            </tr>
      </thead>
      <tbody>
            <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.completionStatus}</td>
            </tr>
            </c:forEach>
      </tbody>
</table>


</body>
</html>