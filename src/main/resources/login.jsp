

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ласкаво просимо</title>
</head>

<body>
<div>
    <form  method="POST" action="/login" modelAttribute="userForm">
        <div>
            <form:input type="text" path="username" placeholder="Username"
                        autofocus="true"></form:input>
        </div>

        <button type="submit">Увійти</button>

</div>
</body>
</html>