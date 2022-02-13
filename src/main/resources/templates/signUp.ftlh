<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
</head>
<body>
<form method="post" action="/signUp">
    <label>Name:
        <input name="name" placeholder="Type your name">
    </label>
    <label>Surname:
        <input name="surname" placeholder="Type your surname">
    </label>
    <label>Age:
        <input name="age" placeholder="Type your age">
    </label>
    <label>Email:
        <input type="email" name="email" placeholder="Type your email">
    </label>
    <label>Password:
        <input type="password" name="password" placeholder="Type your password">
    </label>
    <input type="submit" value="Registration">

</form>
</body>
</html>
