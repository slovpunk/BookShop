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
<h3>Add new author:</h3>
<form method="post" action="/bookins/authors">
    <label>Surname:
        <input name="name" value="asd">
    </label>
    <input type="submit" name="Add">
    <br>
    <h3>Authors:</h3>
</form>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
    <#list authors as author>
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
            <td>
                <a href="/bookins/book/${author.id}">Books of author</a>
            </td>

        </tr>
    </#list>
</table>
<a href="/bookins/books">Back</a>
</body>
</html>