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
    <#list books as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price?c}</td>
            <td>${book.genre}</td>
            <td>${book.description}</td>
            <td>${book.bookAuthor.name}</td>
            <td>
                <form method="post" action="/bookins/books/${book.id}/deleteBasket">
                    <input type="submit" value="delete book from basket">
                </form>
            </td>
        </tr>
    </#list>
</table>
<h3>Favorite authors:</h3>
<table>
    <#list favAuthor as favAuthor>
        <tr>
            <td>${favAuthor}</td>
        </tr>
<#--        <td>-->
<#--            <a href="/bookins/book/${favAuthor.id}">Books of author</a>-->
<#--        </td>-->
    </#list>
</table>
<h3>Total sum: ${sum?c}</h3>
<br>
<br>
<br>
<a href="/bookins/books">Back</a>
</body>
</html>