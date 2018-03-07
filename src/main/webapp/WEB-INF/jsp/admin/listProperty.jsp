<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性管理</title>
<script type="text/javascript">
	$(function() {
		$("#addForm").submit(function() {
			if (checkEmpty("name", "属性名称")) {
				return true;
			}
			return false;
		});
	})
</script>

</head>
<body>

	<div class="workingArea">

		<ol class="breadcrumb">
			<li><a href="admin_category_list">所有分类</a></li>
			<li><a href="admin_property_list?cid=${c.id }">${c.name } </a></li>
			<li class="active">属性管理</li>
		</ol>

		<div class="listDataTableDiv">
			<!-- <div class="col-md-12"> -->
			<table
				class="table table-striped table-bordered table-hover  table-condensed">
				<thead>
					<tr class="success">
						<th>ID</th>
						<th>属性名称</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ps }" var="p">
						<tr>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td><a href="admin_property_edit?id=${p.id }"><span
									class="glyphicon glyphicon-edit"></span></a></td>
							<td><a deleteLink="true"
								href="admin_property_delete?id=${p.id }"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- </div> -->
		</div>

		<div class="pageDiv">
			<%@include file="../include/admin/adminPage.jsp"%>
		</div>

		<div class="panel panel-warning addDiv">
			<div class="panel-heading">新增属性</div>
			<div class="panel-body">
				<form id="addForm" action="admin_property_add" method="post">
					<table class="addTable">
						<tr>
							<td>属性名称</td>
							<td><input id="name" name="name" type="text"
								class="form-control" /></td>
						</tr>
						<tr class="submitTR">
							<td colspan="2" align="center"><input type="hidden"
								name="cid" value="${c.id }" />
								<button type="submit" class="btn btn-success">提 交</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
<%@include file="../include/admin/adminFooter.jsp"%>