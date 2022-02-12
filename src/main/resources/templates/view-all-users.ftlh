<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Add new book:</h3>
<form method="post" action="/bookins/users">
    <label>Name:
        <input name="name" value="asd">
    </label>
    <label>Surname:
        <input name="surname" value="Surname">
    </label>
    <label>Age:
        <input name="age" value=99>
    </label>
    <label>Favorite Genre:
        <input name="favoriteGenre" value="Description">
    </label>
    <input type="submit" name="Add">
    <br>
    <h3>Products in catalog right now:</h3>
</form>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>age</th>
        <th>favorite genre</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.age}</td>
            <td>${user.favoriteGenre}</td>
        </tr>
    </#list>
</body>
</html>