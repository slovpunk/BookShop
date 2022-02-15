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
<h3>Personal cabinet:</h3>
<form method="post" action="/bookins/users/${user.id}/update">
    <label>Name:
        <input name="name" value=${user.name}>
    </label>
    <label>Surname:
        <input name="surname" value=${user.surname}>
    </label>
    <label>Age:
        <input name="age" value=${user.age}>
    </label>
    <label>Favorite Genre:
        <input name="favoriteGenre" value=${user.favoriteGenre}>
    </label>
    <input type="submit" name="Add">
    <br>
</form>
<table>
    <#list books as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price?c}</td>
            <td>${book.genre}</td>
            <td>${book.description}</td>
            <td>${book.bookAuthor.name}</td>
            <td>
                <form method="post" action="/bookins/books/${user.id}/basket/${book.id}">
                    <input type="submit" value="add to basket">
                </form>
            </td>
        </tr>
    </#list>
    </tr>
</table>
<a href="/bookins/${user.id}/basket">Basket</a>
</body>
</html>