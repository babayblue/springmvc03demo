<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 82008
  Date: 2020/10/31
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button><a href="/addMajor.jsp">添加专业</a></button>

<form action="/major/list" method="post" id="queryForm">
    <input type="hidden" name="page" id="page" value="1">
    学院:<select name="cId">
    <option value="-1">全部</option>
    <c:forEach items="${sessionScope.allCollege}" var="college">
        <option value="${college.cId}"
                <c:if test="${college.cId==requestScope.queryMajor.cId}">selected="selected"</c:if> >${college.cName}</option>
    </c:forEach>
</select>
    专业名称:<input type="text" name="mName" value="${requestScope.queryMajor.mName}">
    学分:<input type="text" name="minCredit" value="${requestScope.queryMajor.minCredit}"/>到
    <input type="text" name="maxCredit" value="${requestScope.queryMajor.maxCredit}"/>
    <input type="submit" value="查询"/>
</form>

<table border="1" width="800" style="text-align: center">
    <tr>
        <th>专业编号</th>
        <th>专业名称</th>
        <th>学制</th>
        <th>学分</th>
        <th>学院名称</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${requestScope.pageInfo.list}" var="major" varStatus="statu">
        <tr <c:if test="${statu.index%2==0}"> bgcolor="#dcdcdc" </c:if>>
            <td>${major.mId}</td>
            <td>${major.mName}</td>
            <td>${major.lifeyear}</td>
            <td>${major.cRedit}</td>
            <td><c:forEach items="${sessionScope.allCollege}" var="college">
                <c:if test="${college.cId==major.cId}">
                    ${college.cName}
                </c:if>
            </c:forEach></td>
            <td><a href="javascript:deleteMajor(${major.mId})">删除</a></td>
            <td><a href="/major/toUpdate?id=${major.mId}&page=${pageInfo.pageNum}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<a href="javascript:goPage(1)">首页</a>
<a href="javascript:goPage(${pageInfo.pageNum-1})">上一页</a>
<a href="javascript:goPage(${pageInfo.pageNum+1})">下一页</a>
<a href="javascript:goPage(${pageInfo.pages})">尾页</a>
共${pageInfo.pages}页/第${pageInfo.pageNum}页
共${pageInfo.total}条记录
<script type="text/javascript">
    function goPage(num) {
        document.getElementById("page").value = num;
        document.getElementById("queryForm").submit();
    }

    function deleteMajor(id) {
        if (confirm('是否删除')) {
            window.location.href = "/major/deleteMajor?id=" + id + "&page=${pageInfo.pageNum}";
        }
    }


</script>
</body>
</html>
