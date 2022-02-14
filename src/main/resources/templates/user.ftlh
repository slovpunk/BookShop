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
</form>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>price</th>
        <th>genre</th>
        <th>description</th>
        <th>author</th>
    </tr>
    <#list book as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price?c}</td>
            <td>${book.genre}</td>
            <td>${book.description}</td>
            <td>${book.bookAuthor.name}</td>
            <td>
                <form method="post" action="/bookins/books/${book.id}">
                    <input type="submit" value="delete book">
                </form>
            </td>
        </tr>
    </#list>
</table>
</html>