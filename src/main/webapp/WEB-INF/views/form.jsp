<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h1>Enter User Details</h1>
    <form action="submit-user" method="post">
        <label>Username:</label>
        <input type="text" name="username"/><br/>
        <label>Email:</label>
        <input type="text" name="email"/><br/>
        <label>Password:</label>
        <input type="password" name="password"/><br/>
        <input type="submit" value="Submit"/>
    </form>
    <p>${errormsg}</p>
</body>
</html>


