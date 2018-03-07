<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>



<title>分类管理</title>
<%-- <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%> --%>
<script type="text/javascript">
	$(function() {

		$("#addForm").submit(function() {
			if (!checkEmpty("name", "分类名称"))
				return false;
			if (!checkEmpty("categoryPic", "分类图片"))
				return false;
			return true;
		});
	});
</script>


<div class="workingArea">
	<!-- 标题：分类管理 -->
	<h1 class="label label-info">分类管理</h1>
	<br>
	<br>

	<!-- 显示表格数据 -->
	<div class="listDataTableDiv">
		<!-- <div class="col-md-12"> -->
		<table
			class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>图片</th>
					<th>分类名称</th>
					<th>属性管理</th>
					<th>产品管理</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cs }" var="c">
					<tr>
						<td>${c.id }</td>
						<td><img height="40px" src="img/category/${c.id}.jpg"></td>
						<td>${c.name }</td>
						<td><a href="admin_property_list?cid=${c.id }"><span
								class="glyphicon glyphicon-th-list"></span></a></td>
						<td><a href="admin_product_list?cid=${c.id}"><span
								class="glyphicon glyphicon-shopping-cart"></span></a></td>
						<td><a href="admin_category_edit?id=${c.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a deleteLink="true"
							href="admin_category_delete?id=${c.id}"><span
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
		<div class="panel-heading">新增分类</div>
		<div class="panel-body">
			<form id="addForm" action="admin_category_add" method="post"
				enctype="multipart/form-data">
				<!-- action: 表示表单提交的 Servlet -->
				<table class="addTable">
					<tr>
						<td>分类名称</td>
						<td><input id="name" name="name" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>分类图片</td>
						<td><input id="categoryPic" accept="image/*" type="file"
							name="image" /></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>



<%@include file="../include/admin/adminFooter.jsp"%>