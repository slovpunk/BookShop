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
    <a href="/bookins/users">here!</a>
</h3>
<h3>Your personal data is
    <a href="/bookins/${user.id}/user">here!</a>
</h3>
<form method="post" action="/bookins/authors">
    <label>Author:
        <input name="name" placeholder="author">
    </label>
    <input type="submit" name="Add">
</form>
<h3>Add new product:</h3>
<form method="post" action="/bookins/books/save">
    <label>Title:
        <input name="title" value="Some product">
    </label>
    <label>Genre:
        <input name="genre" value="some color">
    </label>
    <label>Price:
        <input name="price" value="99">
    </label>
    <label>Description:
        <input name="description" value="set description">
    </label>
    <input type="submit" name="Add">
    <br>
    <h3>Products in catalog right now:</h3>
</form>
<br><br>
<table>
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
            <td>
                <a href="/bookins/books/update/${book.id}">Update</a>
            </td>
        </tr>
    </#list>
    </tr>
</table>
<br>
<a href="/signIn">Exit</a>
</body>
</html>
