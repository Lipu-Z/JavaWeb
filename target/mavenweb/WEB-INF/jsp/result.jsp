<%--
  Created by IntelliJ IDEA.
  User: LZHONG
  Date: 10/11/2017
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${age}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr>
</table>
<form:form method="GET" action="/back2main">
    <table>
        <tr>
            <td colspan="2">
                <input type="submit" value="Back to main screen"/>
            </td>
        </tr>
    </table
</form:form>
</body>
</html>