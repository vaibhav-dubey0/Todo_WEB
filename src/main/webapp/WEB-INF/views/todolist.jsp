<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="<c:url value='/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />" rel="stylesheet">
    <title>List Todos Page</title>
</head>
<body>
    <div class="container">

        <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
            <a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/todolist">Todos</a></li>
                </ul>
            </div>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="<c:url value='/logout' />">Logout</a></li>
            </ul>
                
        </nav>

        <h1>Your Todos</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.complete}</td>
                        <td>${todo.date}</td>
                        <td>
                            <a href="delete?id=${todo.id}" class="btn btn-danger">Delete${todo.id}</a>    

                        </td>
                        
                        <td>
                            <a href="addtodo?id=${todo.id}" class="btn btn-success">Update${todo.id} </a>  

                        </td>
                        
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
 <a href="addtodo" class="btn btn-success"> Add Todo  </a>
    </div>
    <script src="<c:url value='/webjars/jquery/3.6.0/jquery.min.js' />"></script>
    <script src="<c:url value='/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>






