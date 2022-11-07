<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop thời trang</title>
</head>
<body>
	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92"
		style="background-image: url(<c:url value='/template/user/images/bg-01.jpg' />);">
		<h2 class="ltext-105 cl0 txt-center">About</h2>
	</section>


	<!-- Content page -->
	<section class="bg0 p-t-75 p-b-120">
		<div class="container">
			<% int i = 0; %>
			<c:forEach var="item" items="${ about }">
			<div class="row p-b-148">
				<div 
					class="<% if(i++%2 != 0){ out.print("order-md-2"); } %> col-md-7 col-lg-8"
				>
					<div class="p-t-7 p-r-85 p-r-15-lg p-r-0-md">
						<h3 class="mtext-111 cl2 p-b-16">${ item.name }</h3>

						<p class="stext-113 cl6 p-b-26">${ item.description }</p>
					</div>
				</div>

				<div class="col-11 col-md-5 col-lg-4 m-lr-auto">
					<div class="how-bor1 ">
						<div class="hov-img0">
							<img src="<c:url value='/images/${ item.image }' />" alt="IMG">
						</div>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>
	</section>
</body>
</html>