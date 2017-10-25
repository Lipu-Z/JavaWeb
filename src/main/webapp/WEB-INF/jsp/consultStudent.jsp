<%--
  Created by IntelliJ IDEA.
  User: LZHONG
  Date: 10/25/2017
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${studentList}" var="student">
    ${student.name} ${student.age} ${student.id}
    <br />
</c:forEach>
</body>
</html>
