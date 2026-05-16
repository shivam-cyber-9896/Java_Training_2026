<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.shivam.monocept.studentcourse.model.Student" %>

<%

Student s =
(Student)request.getAttribute("student");

String error =
(String)request.getAttribute("error");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:500px;
    margin:40px auto;
    background:white;
    padding:25px;
    border-radius:10px;
}

input{
    width:100%;
    padding:10px;
    margin:10px 0;
}

button{
    padding:10px 20px;
    border:none;
    color:white;
    margin:10px;
}

.fetch{
    background:blue;
    width:100%;
}

.delete{
    background:red;
}

.back{
    background:green;
    text-decoration:none;
    padding:10px 20px;
    color:white;
}

.error{
    color:red;
}

.info{
    margin:10px 0;
}

</style>

</head>

<body>

<div class="container">

<h2>Delete Student</h2>

<!-- FETCH BY ID -->

<form action="delete" method="get">

<input type="number"
       name="id"
       placeholder="Enter Student ID"
       required>

<button type="submit"
        class="fetch">
    Fetch Student
</button>

</form>

<hr>

<%

if(error != null){

%>

<p class="error">
<%= error %>
</p>

<%
}

if(s != null){

%>

<div class="info">
<b>ID:</b>
<%= s.getStudentId() %>
</div>

<div class="info">
<b>Name:</b>
<%= s.getStudentName() %>
</div>

<div class="info">
<b>Email:</b>
<%= s.getEmail() %>
</div>

<div class="info">
<b>Phone:</b>
<%= s.getPhone() %>
</div>

<div class="info">
<b>Age:</b>
<%= s.getAge() %>
</div>

<div class="info">
<b>City:</b>
<%= s.getCity() %>
</div>

<!-- DELETE BUTTON -->

<form action="delete" method="post">

<input type="hidden"
       name="id"
       value="<%= s.getStudentId() %>">

<button type="submit"
        class="delete">
    Delete Student
</button>

<a href="../student/list"
   class="back">
   Back
</a>

</form>

<%
}
%>

</div>

</body>
</html>