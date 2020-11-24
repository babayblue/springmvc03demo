<%--
  Created by IntelliJ IDEA.
  User: 82008
  Date: 2020/10/31
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/major/doUpdate?page=${requestScope.page}" method="post">
    <table border="1" width="800">
        <tr>
            <td>专业编号</td>
            <td><input type="text" name="mId" value="${requestScope.updateMajor.mId}"/></td>
        </tr>
        <tr>
            <td>专业名称</td>
            <td><input type="text" name="mName" value="${requestScope.updateMajor.mName}"/><br/></td>
        </tr>
        <tr>
            <td>学分</td>
            <td><input type="text" name="cRedit" value="${requestScope.updateMajor.cRedit}"/><br/></td>
        </tr>
        <tr>
            <td>毕业年限</td>
            <td><input type="text" name="lifeyear" value="${requestScope.updateMajor.lifeyear}"/></td>
        </tr>
        <tr>
            <td>专业介绍</td>
            <td><textarea name="introduction" cols="40"
                          rows="10">${requestScope.updateMajor.introduction}</textarea><br/></td>
        </tr>
        <tr>
            <td>学院名称</td>
            <td><select name="cId">
                <c:forEach items="${sessionScope.allCollege}" var="college">
                    <option value="${college.cId}"
                            <c:if test="${requestScope.updateMajor.cId==college.cId}"> selected="selected"</c:if>
                    >${college.cName}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="修改"/><input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
