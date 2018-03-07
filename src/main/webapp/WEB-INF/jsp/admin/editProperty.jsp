<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="workingArea">

		<ol class="breadcrumb">
			<li><a href="admin_category_list">所有分类</a></li>
			<li><a href="admin_property_list?cid=${p.category.id }">${p.category.name } </a></li>
			<li class="active">编辑属性</li>
		</ol>

		<div class="panel panel-warning addDiv">
			<div class="panel-heading">编辑属性</div>
			<div class="panel-body">
				<form id="updateForm" action="admin_property_update" method="post">
					<table class="addTable">
						<tr>
							<td>属性名称</td>
							<td><input id="name" name="name" type="text"
								value="${p.name }" class="form-control" /></td>
						</tr>
						<tr class="submitTR">
							<td colspan="2" align="center"><input type="hidden"
								name="id" value="${p.id }" /><input type="hidden" name="cid"
								value="${p.category.id }" />
								<button type="submit" class="btn btn-success">提 交</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</div>

</body>
</html>