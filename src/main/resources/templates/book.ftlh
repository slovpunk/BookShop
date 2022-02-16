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
<form method="post" action="/bookins/books/${book.id}/update">
    <label>Title:
        <input name="title" value=${book.title}>
    </label>
    <label>Genre:
        <input name="genre" value=${book.genre}>
    </label>
    <label>Price:
        <input name="price" value=${book.price?c}>
    </label>
    <label>Description:
        <input name="description" value=${book.description}>
    </label>
<#--    <label>Author:-->
<#--        <input name="bookAuthor" value=${book.bookAuthor}>-->
<#--    </label>-->
    <input type="submit" name="update">
</form>
</body>
</html>