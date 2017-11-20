<%--
  Created by IntelliJ IDEA.
  User: LZHONGl
  Date: 10/25/2017
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>this is the consult page</title>
</head>
<body>
<p>${studentList[1].name}</p>
<table width="100%" border=1>
    <tr>
        <td>name</td>
        <td>age</td>
        <td>id</td>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.id}</td>
            <td><a href="${pageContext.request.contextPath }/deleteStudent.action?idunique=${student.idunique}">delete</a></td>
        </tr>
    </c:forEach>
    <form:form method="GET" action="/back2main">
        <table>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Back to main screen"/>
                </td>
            </tr>
        </table
    </form:form>
</table>
</body>
</html>
