<!DOCTYPE html>
<html>
<head>
    <title>Exam Result Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Online Exam Result</h2>
<p style="color:red; text-align:center;">
    ${error}
</p>
<form action="result" method="post">

    Name: <input type="text" name="name"><br><br>

    Roll No: <input type="text" name="roll"><br><br>

    Subject 1: <input type="text" name="m1"><br><br>

    Subject 2: <input type="text" name="m2"><br><br>

    Subject 3: <input type="text" name="m3"><br><br>

    <button type="submit">Check Result</button>

</form>

</body>
</html>