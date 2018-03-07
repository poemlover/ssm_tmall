<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑产品</title>
</head>
<body>

	<!-- model.addAttribute("p", product); -->

	<div class="workingArea">
		<ol class="breadcrumb">
			<li><a href="admin_category_list">所有分类</a></li>
			<li><a href="admin_product_list?cid=${p.category.id }">${p.category.name }
			</a></li>
			<li class="active">${p.name }</li>
			<li class="active">编辑产品</li>
		</ol>

		<!-- 
			添加时 name 属性，其属性应该和 bean 中的字段相对应
			若不对应则不能封装成对应的 bean
		 -->
		<div class="panel panel-warning addDiv">
			<div class="panel-heading">编辑产品</div>
			<div class="panel-body">
				<form id="addForm" action="admin_product_update" method="post">
					<table class="addTable">
						<tr>
							<td>产品名称</td>
							<td><input id="name" name="name" value="${p.name }"
								type="text" class="form-control" /></td>
						</tr>
						<tr>
							<td>产品小标题</td>
							<td><input id="subTitle" name="subTitle"
								value="${p.subTitle }" type="text" class="form-control" /></td>
						</tr>
						<!-- 这里的 value 是为了添加产品方便 -->
						<tr>
							<td>原价格</td>
							<td><input id="originalPrice" name="originalPrice"
								value="${p.originalPrice }" type="text" class="form-control" /></td>
						</tr>
						<tr>
							<td>优惠价格</td>
							<td><input id="promotePrice" name="promotePrice"
								value="${p.promotePrice }" type="text" class="form-control" /></td>
						</tr>
						<tr>
							<td>库存</td>
							<td><input id="stock" name="stock" value="${p.stock }"
								type="text" class="form-control" /></td>
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