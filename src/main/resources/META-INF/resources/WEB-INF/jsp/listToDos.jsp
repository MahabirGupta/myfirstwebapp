<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
<h1>Your ToDos</h1>

    <table class="table">
          <thead>
            <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Completion Status</th>
            <th></th>
            <th></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.completionStatus}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE </a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE </a></td>


            </tr>
            </c:forEach>
          </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add ToDo</a>
</div>

<%@ include file="common/footer.jspf" %>
