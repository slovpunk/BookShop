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
<form method="post" action="/bookins/books">
    <label>Title:
        <input name="title" value="asd">
    </label>
    <label>Genre:
        <input name="genre" value="Genre">
    </label>
    <label>Price:
        <input name="price" value=99>
    </label>
    <label>Description:
        <input name="description" value="Description">
    </label>
    <input type="submit" name="Add">
    <br>
    <h3>Products in catalog right now:</h3>
</form>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>price</th>
        <th>genre</th>
        <th>description</th>
    </tr>
    <#list book as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price?c}</td>
            <td>${book.genre}</td>
            <td>${book.description}</td>
            <td>
                <form method="post" action="/bookins/books/${book.id}">
                    <input type="submit" value="delete book">
                </form>
            </td>
        </tr>
    </#list>
</body>
</html>