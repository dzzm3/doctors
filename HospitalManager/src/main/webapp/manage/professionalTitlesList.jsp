<%--
  Created by IntelliJ IDEA.
  User: 15954
  Date: 2025/7/10
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%--  base标签  --%>
    <%
        String contextPath = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
    %>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <a class="button border-yellow" href="${pageContext.request.contextPath}/manage/addProfessionalTitles.jsp">

            <span class="icon-plus-square-o"></span> 添加内容</a>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="5%">编号</th>
            <th width="20%">职称名称</th>
            <th width="50%">职称简介</th>
            <th width="25%">操作</th>
        </tr>
        <c:forEach items="${pageInfoTitles.list}" var="professionalTitles">
            <tr>
                <td>${professionalTitles.id}</td>
                <td>${professionalTitles.titleName}</td>
                <td>${professionalTitles.description}</td>
                <td>
                    <div class="button-group">
                        <a type="button" class="button border-main" href="${pageContext.request.contextPath}/manage/selectById.do?id=${professionalTitles.id}">
                            <span class="icon-edit"></span>修改
                        </a>

                        <a class="button border-red" href="javascript:void(0)" onclick="return del(${professionalTitles.id})"><span class="icon-trash-o"></span> 删除</a>
                    </div>
                </td>
            </tr>
        </c:forEach>


        <tr>
            <td colspan="4">
                <div class="pagelist">
                    <!-- 总记录数和总页数信息 -->
                    <span class="info">
                总记录数: ${pageInfoTitles.total}条 |
                总页数: ${pageInfoTitles.pages}页 |
                当前页: ${pageInfoTitles.pageNum}/${pageInfoTitles.pages}
            </span>

                     <%--     页码     --%>
                    <!-- 首页：当前页为第1页时禁用 -->
                    <c:choose>
                        <c:when test="${pageInfoTitles.pageNum == 1}">
                            <span class="current">首页</span>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/manage/selectProfessionalTitles.do?page=1">首页</a>
                        </c:otherwise>
                    </c:choose>

                    <!-- 页码列表：仅显示当前页前后2页，避免页码过多 -->
                    <c:forEach
                            begin="${pageInfoTitles.pageNum - 2 > 1 ? pageInfoTitles.pageNum - 2 : 1}"
                            end="${pageInfoTitles.pageNum + 2 < pageInfoTitles.pages ? pageInfoTitles.pageNum + 2 : pageInfoTitles.pages}"
                            var="i">
                        <c:choose>
                            <c:when test="${i == pageInfoTitles.pageNum}">
                                <span class="current">${i}</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/manage/selectProfessionalTitles.do?page=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <!-- 上一页：当前页为第1页时禁用 -->
                    <c:choose>
                        <c:when test="${pageInfoTitles.pageNum == 1}">
                            <span class="disabled">上一页</span>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/manage/selectProfessionalTitles.do?page=${pageInfoTitles.pageNum - 1}">上一页</a>
                        </c:otherwise>
                    </c:choose>
                    <!-- 下一页：当前页为最后一页时禁用 -->
                    <c:choose>
                        <c:when test="${pageInfoTitles.pageNum == pageInfoTitles.pages}">
                            <span class="disabled">下一页</span>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/manage/selectProfessionalTitles.do?page=${pageInfoTitles.pageNum + 1}">下一页</a>
                        </c:otherwise>
                    </c:choose>

                    <!-- 末页：当前页为最后一页时禁用 -->
                    <c:choose>
                        <c:when test="${pageInfoTitles.pageNum == pageInfoTitles.pages}">
                            <span class="current">末页</span>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/manage/selectProfessionalTitles.do?page=${pageInfoTitles.pages}">末页</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </td>
        </tr>

    </table>
</div>
<script>
    function del(id){
        if(confirm("您确定要删除吗?")){
// 跳转到删除接口，携带id参数
            location.href = "${pageContext.request.contextPath}/manage/DelProfessionalTitles.do?id=" + id;
        }
    }
</script>

</body></html>