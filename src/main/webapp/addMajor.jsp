<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 82008
  Date: 2020/10/31
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/major/addMajor" method="post">
<table border="1" width="800">
    <tr>
        <td>专业名称</td>
        <td><input type="text" name="mName"/><br/></td>
    </tr>
    <tr>
        <td>学分</td>
        <td><input type="text" name="cRedit"/><br/></td>
    </tr>
    <tr>
        <td>毕业年限</td>
        <td><input type="text" name="lifeyear"/><br/></td>
    </tr>
    <tr>
        <td>专业介绍</td>
        <td><textarea name="introduction" cols="40" rows="10"></textarea><br/></td>
    </tr>
    <tr>
        <td>学院名称</td>
        <td><select name="cId">
            <c:forEach items="${sessionScope.allCollege}" var="college">
                <option value="${college.cId}">${college.cName}</option>
            </c:forEach>
        </select></td>
    </tr>
    <tr >
        <td colspan="2" style="text-align: center"><input type="submit" value="增加"/><input type="reset" value="重置"/></td>
    </tr>
</table>
</form>
</body>
</html>
