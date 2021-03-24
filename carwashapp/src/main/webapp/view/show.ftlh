<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
</head>
<body>
    <h1>Number of Car : ${car.number}</h1>
    <h1>Time : ${car.time}</h1>
    <h1>Type of service: ${car.service}</h1>



    <div>
        <form method="post" action="/car/${car.id}">
        <input type="submit" value="Delete"></form></td>
    </div>

<br>

<a href="/car">Show CarList</a>

</body>
</html>