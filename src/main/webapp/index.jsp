<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:forward page="/studentInfo/getAll"></jsp:forward>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/static/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h4>SSM-orclproject</h4>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			 <div class="col-md-4 col-md-offset-8">
			 	<button class="btn btn-success">
			 		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
			 		新增
			 	</button>
			 	<button class="btn btn-danger">
			 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			 		删除
			 	</button>
			 </div>
		</div>
		<!-- 列表信息 -->
		<div class="row">
			<div class="col-md-12">
				<!-- 表头 -->
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>#</th>
							<th>ID</th>
							<th>NAME</th>
							<th>SEX</th>
							<th>AGE</th>
							<th>TEL</th>
							<th>ADDRESS</th>
							<th>CLASSINFO.NAME</th>
							<th>操作</th>
						</tr>
					</thead>
					<!-- 表数据 -->
					<tbody></tbody>
				</table>
			</div>
		</div>
		<!-- 分页信息 -->
		<div class="row">
			<!-- 分页信息 -->
			<div class="col-md-6" id="page_info"></div>
			<!-- 分页条 -->
			<div class="col-md-6" id="page_nav"></div>
		</div>
	</div>
	
	<!-- <script type="text/javascript">
		$(function(){
			to_page(1);
		});
		
		function to_page(pageNo){
			$.ajax({
				url:"${path}/studentInfo/getAllWithMsg",
				type:"GET",
				data:"pageNo=" + pageNo,
				dataType:"json",
				success:function(result){
					build_studentInfo_table(result);
					build_page_info(result);
					build_page_nav(result);
				}
			});
		};
		
		function build_studentInfo_table(result){
			
		};
		function build_page_info(result){
			
		};
		function build_page_nav(result){
			
		}
		
	
	
	
	
	
	
	
	</script> -->
</body>
</html>