<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Module</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:linear-gradient(135deg,#1e3c72,#2a5298);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:500px;
    background:white;
    padding:35px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h2{
    margin-bottom:25px;
    color:#1e3c72;
    font-size:32px;
}

a{
    display:block;
    margin:15px 0;
    padding:15px;
    text-decoration:none;
    color:white;
    border-radius:10px;
    font-size:18px;
    transition:0.3s;
}

a:hover{
    transform:scale(1.03);
    opacity:0.9;
}

.add{
    background:#007bff;
}

.view{
    background:#28a745;
}

.update{
    background:#ff9800;
}

.delete{
    background:#dc3545;
}

.back{
    background:#6c757d;
}

</style>

</head>

<body>

<div class="container">

<h2>Registration Module</h2>

<!-- ADD REGISTRATION -->

<a href="registration/add"
   class="add">

   Register Student

</a>

<!-- VIEW REGISTRATIONS -->

<a href="registration/list"
   class="view">

   View Registrations

</a>

<!-- UPDATE STATUS -->

<a href="registration/edit"
   class="update">

   Update Registration Status

</a>

<!-- DELETE REGISTRATION -->

<a href="registration/delete"
   class="delete">

   Delete Registration

</a>

<!-- BACK -->

<a href="dashboard"
   class="back">

   Back To Dashboard

</a>

</div>

</body>
</html>