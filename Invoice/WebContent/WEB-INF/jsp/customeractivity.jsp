<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Customer Details</h2>
<form:form method="POST" action="/Invoice/addCustomeractivity">
   <table>
    <tr>
        <td><form:label path="emailid">EmailID</form:label></td>
        <td><form:input path="emailid" /></td>
    </tr>
    <tr>
        <td><form:label path="days">Set Invoice Generation Time (in days)</form:label></td>
        <td><form:input path="days" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>