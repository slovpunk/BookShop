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
<h3>Add new user:</h3>
<form method="post" action="/bookins/users/${user.id}/update">
    <label>Name:
        <input name="name" placeholder="name">
    </label>
    <label>Surname:
        <input name="surname" placeholder="Surname">
    </label>
    <label>Age:
        <input name="age" placeholder="">
    </label>
    <label>Favorite Genre:
        <input name="favoriteGenre" placeholder="Description">
    </label>
    <input type="submit" name="Add">
    <br>
</form>
<table>
    <tr>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.age}</td>
        <td>${user.favoriteGenre}</td>
    </tr>
</table>
</body>
</html>