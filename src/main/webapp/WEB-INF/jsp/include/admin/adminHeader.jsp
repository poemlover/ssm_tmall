<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %> 

<html>

<head>
	<script src="js/jquery/2.0.0/jquery.min.js"></script>
	<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<link href="css/back/style.css" rel="stylesheet">
	
<script>
	function checkEmpty(id, name){
		var value = $("#"+id).val();
		if(value.length==0){
			alert(name+ "不能为空");
			$("#"+id)[0].focus(); //作用：提示不能为空 锁定 到该输入框
			return false;
		}
		return true;
	}
	function checkNumber(id, name){
		var value = $("#"+id).val();
		if(value.length==0){
			alert(name+ "不能为空");
			$("#"+id)[0].focus();
			return false;
		}
		if(isNaN(value)){
			alert(name+ "必须是数字");
			$("#"+id)[0].focus();
			return false;
		}
		
		return true;
	}
	function checkInt(id, name){
		var value = $("#"+id).val();
		if(value.length==0){
			alert(name+ "不能为空");
			$("#"+id)[0].focus();
			return false;
		}
		if(parseInt(value)!=value){
			alert(name+ "必须是整数");
			$("#"+id)[0].focus();
			return false;
		}
		
		return true;
	}
	
	$(function(){
		$("a").click(function(){
			var deleteLink = $(this).attr("deleteLink");
			console.log(deleteLink);
			if(deleteLink == "true"){
				if(confirm("确认要删除吗？") == true){
					return true;
				}else{
					return false;
				}
			}
		});
	})
	



</script>	
</head>
<body>

