<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
<h1>Hi, ${user.name}!</h1>
<h3>Your status is Admin and you have more opportunities.</h3>
<h3>Firstly, you can change registered users
    <a href="/bookins/users/${user.id}/update">here!</a></h3>
<#--<h3>-->
<#--    Also you can add and change products from catalog-->
<#--    <a href="/product">here!</a>-->
<#--</h3>-->
<#--<h3>Your personal data is-->
<#--    <a href="/bookins/users/${user.id}">here!</a>-->
<#--</h3>-->
<br>
<a href="/signIn">Exit</a>
</body>
</html>
