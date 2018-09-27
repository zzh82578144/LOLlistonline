<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>在线LOL段位查询</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" onclick="show()">Rank查询</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form action="insertPeople.do" method="POST"
						class="navbar-form navbar-left">
						<div class="form-group">

							<input type="text" name="iname" class="form-control"
								placeholder="请输入召唤师名字"> <input type="text"
								name="idistrct" class="form-control" placeholder="请输入召唤师区服">

							<input type="text" name="irank" class="form-control"
								placeholder="请输入召唤师段位">
						</div>
						<button type="submit" class="btn btn-default">新增</button>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<c:if test="${result == 'SUCCESS' }">
			<div class="alert alert-success" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				提示：操作成功
			</div>
		</c:if>
		<c:if test="${result == 'ERROR' }">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				警告：操作失败
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>召唤师</th>
							<th>区服</th>
							<th>Rank</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="showBox">

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script>
$(function() {
	show();//初始化界面之后立即显示帖子列表
});

	function show() {
		$.ajax({
			url : 'showIndex.do',
			type : 'POST',
			dataType : 'text',
			data : {},

			success : function(res) {
				$("#showBox").html("");
				var json = eval("("+res+")");
				for(var i = 0; i < json.length; i++){
					$("#showBox").append("<tr><td>"+json[i].lolId+"</td><td>"+json[i].lolName+"</td><td>"+json[i].lolDistrct+"</td><td>"+json[i].lolRank+"</td><td><a href='remove.do?lolId="+json[i].lolId+"'><span class='glyphicon glyphicon-remove'></span>删除</td></tr>");
				}
			}
		});
	}
</script>
</html>