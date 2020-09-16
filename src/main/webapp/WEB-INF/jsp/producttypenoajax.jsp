<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script type="text/javascript">
    function addproducttypepage(){
    	window.location.href="${pageContext.request.contextPath}/addproducttypepage";//get
    }
</script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/list.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bright.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/addBook.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/kkpage.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/kkpage.js"></script>
<title></title>
</head>

<body>
	<div id="brall">
		<div id="nav">
			<p>商品类型管理>商品类型列表</p>
		</div>
		<div id="table">
			<div id="top">
				<input type="button" class="btn btn-warning" id="btn1" value="新增商品类型" onclick="addproducttypepage()">
			</div>
			<!--显示没有分页的商品信息-->
			<div id="middle">
				<table class="table table-bordered table-striped">
					<tr>
						<th>商品类型名称</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${producttypes}" var="pt">
						<tr>

							<td>${pt.name}</td>
							<td>
								<button type="button" class="btn btn-info myupdate"
									onclick="pmodify(${pt.id})">修改</button>
								<button type="button" class="btn btn-warning" id="mydel"
									onclick="pdel(${pt.id})">删除</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
    //修改函数
    function modify(id) {
        location.href = "${pageContext.request.contextPath}/toupdateprotypepage?id="+id;//get
    }
    //删除函数
	function pdel(id) {
        if (confirm("确定删除吗")) {
            location.href = "${pageContext.request.contextPath}/delproducttype?id="+id;//get
        }
    }
</script>
</html>