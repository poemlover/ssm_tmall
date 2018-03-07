<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
	//将 class="disabled" 的响应屏蔽掉
	$(function() {
		$("ul.pagination li.disabled a").click(function() {
			return false;
		});
	});
</script>
</head>
<body>
	<!-- 分页这块还需要再打磨清楚 -->
	<nav aria-label="Page navigation">
	<ul class="pagination">
		<li <c:if test="${!page.hasPreviouse }">class="disabled"</c:if>>
			<a href="?start=0${page.param }" aria-label="Previous"> <span
				aria-hidden="true">首页</span>
		</a>
		</li>

		<li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>><a
			href="?start=${page.start-page.count}${page.param }"
			aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
		</a></li>

		<c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
			<!-- varStatus: 用来存放现在指到的相关成员信息 
			 这里的 status 代表第几页的所有属性
			 status.index:表示第几项，从 0 开始
			 start: 超链接中的 start 直接赋值给了page 对象
			 status.count: 总共指到成员的总数,遍历到哪就记当前的总数
		-->
			<li
				<c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
				<a href="?start=${status.index*page.count}${page.param }"
				<c:if test="${status.index*page.count==page.start}">class="current"</c:if>>${status.count}</a>
			</li>

		</c:forEach>


		<li <c:if test="${!page.hasNext}">class="disabled"</c:if>><a
			href="?start=${page.start+page.count}${page.param }"
			aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>

		<li <c:if test="${!page.hasNext }">class="disabled"</c:if>><a
			href="?start=${page.last}${page.param}" aria-label="Next"> <span
				aria-hidden="true">末页</span>
		</a></li>
	</ul>
	</nav>

</body>
</html>