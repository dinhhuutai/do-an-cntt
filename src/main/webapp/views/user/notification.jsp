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

	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92"
		style="background-image: url(<c:url value='/template/user/images/bg-01.jpg' />);">
		<h2 class="ltext-105 cl0 txt-center">Notification</h2>
	</section>
	

	<div style="
    padding: 100px 200px;
    display: flex;
    flex-direction: column;
    gap: 26px;
">
	<c:if test="${ empty notificationModel }">
		<h1 style="
    text-align: center;
    color: #e0790e;
">No Notification</h1>
	</c:if>
		<c:forEach var="item" items="${ notificationModel }">
		<div style="
    width: 100%;
    display: block;
" class="row notification-container">
			<div <c:if test="${ item.statusOrders == 1 }">style="
    color: #151212;
    box-shadow: 0px 0px 120px 0px #2bff00 inset;
"</c:if> <c:if test="${ item.statusOrders == 0 }">style="
    box-shadow: 0px 0px 120px 0px red inset;
    color: #fff;
"</c:if> class="card notification-card notification-invitation">
				<div class="card-body">
					<table style="width: 100%;">
						<tr>
							<td style="width: 90%, padding-left: 30px;"><div class="card-title">
									${ item.content }
								</div></td>
							<td style="width: 10%">
							<c:if test="${ item.statusOrders == 1 }">
								<a href="<c:url value='/my-order?type=delivery' />" class="btn btn-primary">View</a>
							</c:if>
							
							<c:if test="${ item.statusOrders == 0 }">
								<a href="<c:url value='/my-order?type=cancelled' />" class="btn btn-primary">View</a>
							</c:if>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>


</body>
</html>