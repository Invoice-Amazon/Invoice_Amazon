<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Customer Details</h2>
   <table>
    <tr>
        <td>EmailID</td>
        <td>${emailid}</td>
    </tr>
    <tr>
        <td>Invoice Generation Time (in secs)</td>
        <td>${secs}</td>
    </tr>
</table>  
</body>
</html>