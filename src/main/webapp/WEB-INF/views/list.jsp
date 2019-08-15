<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息表</title>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<%-- <link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/static/js/jquery-1.8.3.min.js"></script> --%>

<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			 <div class="col-md-6 col-md-offset-6">
			 	<!-- <button class="btn btn-success btn-sm">
			 		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
			 		新增
			 	</button>
			 	<button class="btn btn-danger btn-sm">
			 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			 		删除
			 	</button> -->
				<button class="btn btn-primary btn-lg btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">
  					<span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
					导入Excel
				</button>
				<button class="btn btn-success btn-sm" id="toExcel">
					<span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
					导出Excel
				</button>
			 </div>
		</div>
		<!-- 列表信息 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
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
							<!-- <th>操作</th> -->
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${pageInfo.list }" var="stu">
							<tr>
								<th>#</th>
								<th>${stu.studentid }</th>
								<th>${stu.studentname }</th>
								<th>${stu.studentsex }</th>
								<th>${stu.studentage }</th>
								<th>${stu.studenttel }</th>
								<th>${stu.studentaddress }</th>
								<th>${stu.classInfo.classname }</th>
								<!-- <th>
									<button class="btn btn-info btn-sm">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										编辑
									</button>
									<button class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										删除
									</button>
								</th> -->
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
		<!-- 分页信息 -->
		<div class="row">
			<!-- 分页信息 -->
			<div class="col-md-6">
				当前第【${pageInfo.pageNum }】页 / 共【${pageInfo.pages }】页 / 共【${pageInfo.total }】条记录
			</div>
			<!-- 分页条 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<li><a href="${path }/studentInfo/getAll?pageNo=1">首页</a></li>
				  	<c:if test="${pageInfo.hasPreviousPage }">
					  	<li>
					      <a href="${path }/studentInfo/getAll?pageNo=${pageInfo.pageNum-1 }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				  	</c:if>
				    <c:forEach items="${pageInfo.navigatepageNums }" var="pageNo">
				    	<c:if test="${pageNo == pageInfo.pageNum }">
				    		<li class="active"><a href="#">${pageNo }</a></li>
				    	</c:if>
				    	<c:if test="${pageNo != pageInfo.pageNum }">
				    		<li><a href="${path }/studentInfo/getAll?pageNo=${pageNo }">${pageNo }</a></li>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageInfo.hasNextPage }">
				    	<li>
				      		<a href="${path }/studentInfo/getAll?pageNo=${pageInfo.pageNum+1 }" aria-label="Next">
				        		<span aria-hidden="true">&raquo;</span>
				      		</a>
				    	</li>
				    </c:if>
				    <li><a href="${path }/studentInfo/getAll?pageNo=${pageInfo.pages }">末页</a></li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						导入Excel
					</h4>
				</div>
				
				<div class="modal-body">
					<form id="inExcel" action="${path }/studentInfo/importExcel" enctype="multipart/form-data" method="post">
						<input name="file" type="file" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						关闭
					</button>
					<button id="btn" type="button" class="btn btn-primary">
						提交
					</button>
				</div>
				
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
	
	<script type="text/javascript"> 
		$("#btn").click(function(){
			$("#inExcel").submit();
		});
		$("#toExcel").click(function(){
			location.href="${path}/studentInfo/export?pageNo=" + ${pageInfo.pageNum };
		});
	</script>
</body>
</html>