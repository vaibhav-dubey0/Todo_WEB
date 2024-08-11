
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value='/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />" rel="stylesheet">
    <title>List Todos Page</title>
</head>
<body>
    <div class="container mt-5">

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



        <h1 class="mb-4">Enter Todo Details</h1>
        <form:form action="addtodo" method="post" modelAttribute="todo">
            <div class="mb-3">
                <label for="id" class="form-label">Id:</label>
                <form:input type="number" class="form-control" id="id" path="id" required="true"/>
                <form:errors path="id" cssClass="text-danger"/>
            </div>
        

            <div class="mb-3">
                <label for="name" class="form-label">Username:</label>
                <form:input type="text" class="form-control" id="name" path="name" required="true"/>
                <form:errors path="name" cssClass="text-danger"/>
            </div>
            
            <div class="mb-3">
                <label for="complete" class="form-label">Description:</label>
                <form:input type="text" class="form-control" id="complete" path="complete" required="true"/>
                <form:errors path="complete" cssClass="text-danger"/>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Date:</label>
                <form:input type="date" class="form-control" id="date" path="date" required="true"/>
                <form:errors path="date" cssClass="text-danger"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    
        <c:if test="${result.hasErrors()}">
            <div class="alert alert-danger mt-3" role="alert">
                Please correct the errors in the form!
            </div>
        </c:if>
    
        <p class="mt-3 text-danger">${errormsg}</p>
    </div>
    <script src="<c:url value='/webjars/jquery/3.6.0/jquery.min.js' />"></script>
    <script src="<c:url value='/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>



