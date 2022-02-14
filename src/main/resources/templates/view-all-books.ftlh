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
<a href="/bookins/users">Users</a>
<a href="/bookins/authors">Authors</a>
</body>
</html>