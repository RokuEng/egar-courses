<!doctype html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>ask details</title>
    </head>

    <body>
        <h2>Dear Employee, Please enter your details</h2>
        <br>
        <br>

        <p>Your name: ${param.employeeName}</p>

        <form action="show" method="get">
            <label>
                <input type="text" name="employeeName" placeholder="Write your name"/>
            </label>
            <input type="submit"/>
        </form>

    </body>

</html>