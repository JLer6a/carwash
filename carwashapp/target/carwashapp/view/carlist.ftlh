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
<div>
    <table>
        <colgroup>
            <col style="background-color:LightCyan">
            <col span="2" style="background:Khaki">
        </colgroup>
        <tr>
            <th>Time</th>
            <th>Number</th>
            <th>Service</th>
        </tr>
        <#list cars as car>
        <tr>
           <td>
               <a href="/car/${car.id}">${car.time}</a>
           </td>
            <td>${car.number}</td>
            <td>${car.service}</td>
        </tr>
    </#list>
    </table>

</div>

<br/>


<div>
    <form action="/car" method="post" >
        <label>FILL THE FORM</label><br/>
        <input type="text" value="number of car" required="" name="number"><br/>
        <input type="text" value="time" required="" name="time"><br/>
        <input type="text" value="type of service" required="" name="service"><br/>
        <input type="submit" value="Submit">
    </form>
</div>


</body>
</html>