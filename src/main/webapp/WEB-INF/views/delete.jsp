<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="<c:url value='/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />" rel="stylesheet">
    <title>List Todos Page</title>
</head>
<body>
    <div class="container mt-5">
        <div class="alert alert-success" role="alert">
            The Todo has been deleted successfully.
        </div>
        <div class="d-flex justify-content-between">
            <a href="addtodo" class="btn btn-primary">Add Todo</a>
            <a href="todolist" class="btn btn-secondary">View Todos</a>
        </div>
        <div class="mt-3">
            <p class="text-danger">${errormsg}</p>
        </div>
    </div>
    <script src="<c:url value='/webjars/jquery/3.6.0/jquery.min.js' />"></script>
    <script src="<c:url value='/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>

