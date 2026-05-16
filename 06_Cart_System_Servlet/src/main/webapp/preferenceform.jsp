<!DOCTYPE html>
<html>
<head>
<title>Preferences</title>

<style>
body {
    font-family: Poppins;
    background: linear-gradient(135deg,#1f1c2c,#928dab);
    color: white;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.card {
    background: rgba(255,255,255,0.1);
    padding: 30px;
    border-radius: 15px;
    backdrop-filter: blur(10px);
    width: 300px;
}

select, button {
    width:100%;
    padding:10px;
    margin:10px 0;
    border-radius:5px;
    border:none;
}

button {
    background:#00c6ff;
    color:white;
}
</style>
</head>

<body>

<div class="card">
<h2>User Preferences</h2>

<form action="savePref" method="post">

Theme:
<select name="theme">
    <option>Light</option>
    <option>Dark</option>
</select>

Language:
<select name="language">
    <option>English</option>
    <option>Hindi</option>
    <option>Marathi</option>
</select>

Font Size:
<select name="font">
    <option>Small</option>
    <option>Medium</option>
    <option>Large</option>
</select>

<button type="submit">Save Preferences</button>

</form>
</div>

</body>
</html>