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
<h3>number in database ${studentNumber}</h3>
<h2>Student Information</h2>
<form:form method="POST" action="/addStudent">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">Age</form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
<form:form method="GET" action="/consultStudent">
    <table>
        <tr>
            <td colspan="2">
                <input type="submit" value="Consult"/>
            </td>
        </tr>
    </table>
</form:form>
<form:form method="GET" action="/welcome">
    <table>
        <tr>
            <td colspan="2">
                <input type="submit" value="Welcome"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>