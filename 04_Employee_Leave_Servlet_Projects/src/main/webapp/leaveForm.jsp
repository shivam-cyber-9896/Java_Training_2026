<!DOCTYPE html>
<html>
<head>
    <title>Leave Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h2>Apply for Leave</h2>

    <p class="error">${error}</p>

    <form action="leave" method="post">

        <input type="text" name="name" placeholder="Employee Name" value="${name}"><br>

        <input type="text" name="id" placeholder="Employee ID" value="${id}"><br>

        <input type="text" name="dept" placeholder="Department" value="${dept}"><br>

        <select name="type">
            <option value="">Select Leave Type</option>
            <option ${type=="Sick Leave"?"selected":""}>Sick Leave</option>
            <option ${type=="Casual Leave"?"selected":""}>Casual Leave</option>
            <option ${type=="Emergency Leave"?"selected":""}>Emergency Leave</option>
            <option ${type=="Work From Home"?"selected":""}>Work From Home</option>
        </select><br>

        <input type="number" name="days" placeholder="Number of Days" value="${days}"><br>

        <textarea name="reason" placeholder="Enter Reason (min 10 chars)">${reason}</textarea><br>

        <button type="submit">Submit</button>

    </form>
</div>

</body>
</html>