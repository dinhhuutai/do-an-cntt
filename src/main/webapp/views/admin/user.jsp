<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row column_title">
			<div class="col-md-12">
				<div class="page_title">
					<h2>List Customer</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="page-content">
		<div class="row">
			<div class="col-12">
				<div style="border-radius: 8px; overflow: hidden;">
					<table class="table table-striped"
						style="margin-bottom: 0 !important;">
						<thead style="background-color: #e3ed9c; color: #fff;">
							<tr>
								<th scope="col">STT</th>
								<th scope="col">Username</th>
								<th scope="col">Password</th>
								<th scope="col">Fullname</th>
								<th scope="col">Email</th>
								<th scope="col">Phone</th>
								<th scope="col">Address</th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = (((int) session.getAttribute("pagei"))) * (int) session.getAttribute("itemInPage") + 1;
							%>
							<c:forEach var="item" items="${ user }">
								<tr>
									<td>
										<%
										out.print(i++);
										%>
									</td>
									<td>${ item.userName }</td>
									<td>${ item.password }</td>
									<td>${ item.fullName }</td>
									<td>${ item.email }</td>
									<td>${ item.phone }</td>
									<td>${ item.address }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 50px;">

		<ul class="pagination modal-5">
			<li><a href="#" class="prev fa fa-arrow-left"> </a></li>
			<c:forEach begin="1" end="${ endP }" var="i">
				<li><a class="page"
					href="<c:url value="/admin-user?index=${ i }" />">${ i }</a></li>
			</c:forEach>
			<li><a href="#" class="next fa fa-arrow-right"></a></li>
		</ul>
	</div>


	<script type="text/javascript">
	
	
		var pages = document.querySelectorAll(".page");
		pages[${page}].classList.add("active");

		if(${inext} <= ${ endP }){
			var next = document.querySelector(".next");
			next.addEventListener('click', function() {
				window.location.href = "<c:url value="/admin-user?index=${inext}" />";
			})
		}
		
		if(${page} > 0) {
			var prev = document.querySelector(".prev");
			prev.addEventListener('click', function() {
				window.location.href = "<c:url value="/admin-user?index=${page}" />";
			})
		}


	</script>

</body>
</html>