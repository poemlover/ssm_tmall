<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  
		model.addAttribute("us", us);
		model.addAttribute("page", page);
	-->

	<div class="workingArea">
		<h1 class="label label-info">用户管理</h1>
		<br> <br>

		<div class="listDataTableDiv">
			<table
				class="table table-striped table-bordered table-hover  table-condensed">
				<thead>
					<tr class="success">
						<th>ID</th>
						<th>用户名称</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${us }" var="u">
						<tr>
							<td>${u.id }</td>
							<td>${u.name }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="pageDiv">
			<%@include file="../include/admin/adminPage.jsp"%>
		</div>

	</div>


</body>
</html>

<%@include file="../include/admin/adminFooter.jsp"%>