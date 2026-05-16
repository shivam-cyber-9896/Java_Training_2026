<%
String theme="Light", language="English", font="Medium";

Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(Cookie c : cookies){
        if(c.getName().equals("theme")) theme = c.getValue();
        if(c.getName().equals("language")) language = c.getValue();
        if(c.getName().equals("font")) font = c.getValue();
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>

<style>
body {
    font-family: Poppins;

    <% if(theme.equals("Dark")) { %>
        background:#121212;
        color:white;
    <% } else { %>
        background:#f4f4f4;
        color:black;
    <% } %>

    <% if(font.equals("Small")) { %> font-size:14px;
    <% } else if(font.equals("Medium")) { %> font-size:18px;
    <% } else { %> font-size:22px;
    <% } %>

    text-align:center;
    padding-top:100px;
}
</style>
</head>

<body>

<h2>🏠 Home Page</h2>

<p>Selected Theme: <b><%= theme %></b></p>
<p>Selected Language: <b><%= language %></b></p>
<p>Selected Font Size: <b><%= font %></b></p>

<br>

<a href="preferenceform.jsp">Change Preferences</a><br><br>
<a href="resetPref">Reset Preferences</a>

</body>
</html>