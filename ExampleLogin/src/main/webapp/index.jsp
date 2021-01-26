<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
    <form action="LoginServlet" method="post">
        Username:<input name="user" type="text"/><br>
        Password:<input name="pass" type="text"/><br>
        <input value="Sign in" type="submit"/><br>
    </form>

</body>
</html>