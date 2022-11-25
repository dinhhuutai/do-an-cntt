<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-orders"/>
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
		<h2 class="ltext-105 cl0 txt-center">My Order</h2>
	</section>
	
	<!-- breadcrumb -->
	<div class="container">
		<div style="
    display: flex;
    justify-content: center; gap: 70px;
" class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a <c:if test="${ not empty wait }">style="border-bottom: 1px solid #3700a9;"</c:if> href="<c:url value='/my-order?type=wait' />" class="stext-109 cl8 hov-cl1 trans-04">
				<c:if test=""></c:if>
				wait for confirmation
			</a>
			<a <c:if test="${ not empty delivery }">style="border-bottom: 1px solid #3700a9;"</c:if> href="<c:url value='/my-order?type=delivery' />" class="stext-109 cl8 hov-cl1 trans-04">
				Delivering
			</a>
			<a <c:if test="${ not empty delivered }">style="border-bottom: 1px solid #3700a9;"</c:if> href="<c:url value='/my-order?type=delivered' />" class="stext-109 cl8 hov-cl1 trans-04">
				Delivered
			</a>
			<a <c:if test="${ not empty cancelled }">style="border-bottom: 1px solid #3700a9;"</c:if> href="<c:url value='/my-order?type=cancelled' />" class="stext-109 cl8 hov-cl1 trans-04">
				Cancelled
			</a>

		</div>
	</div>
	
	<!-- Shoping Cart -->
	<div class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr style="
    background-color: #f63;
" class="table_head">
									<th style="
    color: #fff;
" class="column-1">Code</th>
									<th style="
    color: #fff;
" class="column-2">Name</th>
									<th style="
    color: #fff;
" class="column-3">Price</th>
									<th style="
    color: #fff;
" class="column-4">Quantity</th>
									<th style="
    color: #fff;
" class="column-5">Total</th>
									<c:if test="${ not empty wait }">
									<th class="column-6"></th>
									</c:if>
								</tr>
								
								<c:forEach var="item" items="${ orders }">
								<tr class="table_row">
									<td class="column-1">
										#${ item.id }
									</td>
									<td class="column-2">
										<c:forEach var="item1" items="${ item.orderDetails }">
										<div class="">
											<a href="<c:url value="/product?id=${ item1.productId }" />">
												${ item1.productName }
											</a>
										</div>
										</c:forEach>
									</td>
									<td class="column-3">
										<c:forEach var="item1" items="${ item.orderDetails }">
										<div class="">${ item1.price }</div>
										</c:forEach>
									</td>
									<td class="column-4">
										<c:forEach var="item1" items="${ item.orderDetails }">
										<div class="">${ item1.quantity }</div>
										</c:forEach>
									</td>
									<td class="column-5">${ item.total }</td>
									<c:if test="${ not empty wait }">
									<td class="column-6">
										<form id="${ item.id }" method="post" action="api-orders?type=cancel&id=${ item.id }">
										<button type="submit" value="${ item.id }" class="cancel-orders" style="
    margin-right: 12px;
    padding: 2px 5px;
    background-color: #f80c0c;
    color: #fff;
    border-radius: 4px;
">cancel</button></form>
									</td>
									</c:if>
								</tr>
								</c:forEach>
							</table>
						</div>

						
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	<!-- var deleteOrders = document.querySelectorAll(".cancel-orders");
	
		deleteOrders.forEach(deleteOrder => {
			deleteOrder.addEventListener("click", () => {
				var id = deleteOrder.getAttribute("value");
				
			 	$.ajax({
			        url: "${APIurl}",
			        type: 'delete',
			        data: {
			            id: id
			        },
			        success: function(result) {
			        	
			        },
			        error: function(error) {
			            	
			        },
			    });
	
			 	
			})
		}); -->
	</script>

</body>
</html>