<%--
  Created by IntelliJ IDEA.
  User: 15954
  Date: 2025/7/9
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>

    <div class="panel admin-panel">

        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <form method="post" action="${pageContext.request.contextPath}/manage/doctorsSearch.do" id="listForm">
            <div class="padding border-bottom">
                <ul class="search" style="padding-left:10px;">

                    <li>
                        <%--设置用户请求的当前页--%>
                        <input type="hidden" name="page" id="page" value="1">
                        <%--    设置科室--%>
                        <select name="departmentId" class="input" style="width:100px; line-height:17px;">
                            <option value="">请选择科室</option>
                            <c:forEach items="${departmentsSecondList}" var="d">
                                <option value="${d.departmentId}" ${param.departmentId==d.departmentId?"selected":""}>${d.departmentName}</option>
                            </c:forEach>
                        </select>
                    </li>
                    <li>
                        <%--    设置职称--%>
                        <select name="titleId" class="input" style="width:100px; line-height:17px;">
                            <option value="">请选择职称</option>
                            <c:forEach items="${titlesList}" var="pt">
                                <option value="${pt.id}" ${param.titleId==pt.id?"selected":""}>${pt.titleName}</option>
                            </c:forEach>
                        </select>
                    </li>

                    <li><input type="text" placeholder="请输入医生姓名" value="${param.doctorName}" name="doctorName" class="input" style="width:150px; line-height:17px;display:inline-block" /></li>
                    <li><input type="text" placeholder="请输入医生工号" value="${param.jobNumber}" name="jobNumber" class="input" style="width:150px; line-height:17px;display:inline-block" /></li>
                    <li><a href="javascript:submitFormData()" class="button border-main icon-search" > 搜索</a></li>
                    <li> <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/manage/doctor/addDoctor.jsp"> 添加内容</a> </li>
                    <li> <a class="button border-red icon-plus-square-o" href="${pageContext.request.contextPath}/manage/announce/addAnnouncement.jsp"> 批量删除</a> </li>
                </ul>
            </div>
        </form>



        <table class="table table-hover text-center">
            <tr>
                <th width="10%">编号</th>
                <th width="10%">工号</th>
                <th width="10%">图片</th>
                <th width="10%">姓名</th>
                <th width="10%">科室</th>
                <th width="10%">职称</th>
                <th>操作</th>
            </tr>

<c:forEach items="${pageInfo.list}" var="doctor">

            <tr>
                <td><input type="checkbox" name="doctorId" value="${doctor.doctorId}" /></td>
                <td>${doctor.jobNumber}</td>
                <td><img src="${pageContext.request.contextPath}/${doctor.avatar}" style="width: 80px"></td>
                <td>${doctor.name}</td>
                <td>${doctor.departments.departmentName}</td>
                <td>${doctor.titles.titleName}</td>
                <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a> </div></td>
            </tr>

</c:forEach>


            <tr>
                <td colspan="4">
                    <div class="pagelist">
                        <!-- 总记录数和总页数信息 -->
                        <span class="info">
                总记录数: ${pageInfo.total}条 |
                总页数: ${pageInfo.pages}页 |
                当前页: ${pageInfo.pageNum}/${pageInfo.pages}
            </span>

                        <%--     页码     --%>
                        <!-- 首页：当前页为第1页时禁用 -->
                        <c:choose>
                            <c:when test="${pageInfo.pageNum == 1}">
                                <span class="current">首页</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/manage/doctorsSearch.do?page=1">首页</a>
                            </c:otherwise>
                        </c:choose>

                        <!-- 页码列表：仅显示当前页前后2页，避免页码过多 -->
                        <c:forEach
                                begin="${pageInfo.pageNum - 2 > 1 ? pageInfo.pageNum - 2 : 1}"
                                end="${pageInfo.pageNum + 2 < pageInfo.pages ? pageInfo.pageNum + 2 : pageInfo.pages}"
                                var="i">
                            <c:choose>
                                <c:when test="${i == pageInfo.pageNum}">
                                    <span class="current">${i}</span>
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/manage/doctorsSearch.do?page=${i}">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <!-- 上一页：当前页为第1页时禁用 -->
                        <c:choose>
                            <c:when test="${pageInfo.pageNum == 1}">
                                <span class="disabled">上一页</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/manage/doctorsSearch.do?page=${pageInfo.pageNum - 1}">上一页</a>
                            </c:otherwise>
                        </c:choose>
                        <!-- 下一页：当前页为最后一页时禁用 -->
                        <c:choose>
                            <c:when test="${pageInfo.pageNum == pageInfo.pages}">
                                <span class="disabled">下一页</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/manage/doctorsSearch.do?page=${pageInfo.pageNum + 1}">下一页</a>
                            </c:otherwise>
                        </c:choose>

                        <!-- 末页：当前页为最后一页时禁用 -->
                        <c:choose>
                            <c:when test="${pageInfo.pageNum == pageInfo.pages}">
                                <span class="current">末页</span>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/manage/doctorsSearch.do?page=${pageInfo.pages}">末页</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </td>
            </tr>



<script type="text/javascript">

    function del(id){
        if(confirm("您确定要删除吗?")){

        }
    }

    $("#checkall").click(function(){
        $("input[name='id[]']").each(function(){
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect(){
        var Checkbox=false;
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
            }
        });
        if (Checkbox){
            var t=confirm("您确认要删除选中的内容吗？");
            if (t==false) return false;
        }
        else{
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body></html>