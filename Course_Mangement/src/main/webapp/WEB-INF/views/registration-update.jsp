<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.shivam.monocept.studentcourse.model.Registration" %>

<%

Registration r =
(Registration)request.getAttribute("registration");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Registration</title>

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
    width:450px;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    margin-bottom:20px;
    color:#1e3c72;
}

input,
select{
    width:100%;
    padding:12px;
    margin:10px 0;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:8px;
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

.fetch{
    background:#007bff;
}

.fetch:hover{
    background:#0056b3;
}

.update{
    background:#28a745;
}

.update:hover{
    background:#1e7e34;
}

.back{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    background:#6c757d;
    color:white;
    padding:12px;
    border-radius:8px;
}

.back:hover{
    background:#545b62;
}

.dashboard{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    background:#ff9800;
    color:white;
    padding:12px;
    border-radius:8px;
}

.dashboard:hover{
    background:#e68900;
}

</style>

</head>

<body>

<div class="container">

<h2>Update Registration Status</h2>

<!-- FETCH FORM -->

<form action="../registration/edit"
      method="get">

<input type="number"
       name="id"
       placeholder="Enter Registration ID"
       required>

<button type="submit"
        class="fetch">

    Fetch Registration

</button>

</form>

<br>

<%

if(r != null){

%>

<!-- UPDATE FORM -->

<form action="../registration/edit"
      method="post">

<input type="hidden"
       name="id"
       value="<%= r.getRegistrationId() %>">

<select name="status">

<option value="Active">
    Active
</option>

<option value="Completed">
    Completed
</option>

<option value="Cancelled">
    Cancelled
</option>

</select>

<button type="submit"
        class="update">

    Update Status

</button>

</form>

<%
}
%>

<!-- BACK BUTTON -->

<a href="../registration/list"
   class="back">

   Back To Registrations

</a>

<!-- DASHBOARD BUTTON -->

<a href="../dashboard"
   class="dashboard">

   Back To Dashboard

</a>

</div>

</body>
</html>