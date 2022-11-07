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
					<h2>List orders delivered</h2>
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
						<thead style="background-color: #00d8ff; color: #fff;">
							<tr>
								<th scope="col">STT</th>
								<th scope="col">Code orders</th>
								<th scope="col">Code customer</th>
								<th scope="col">Name</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = (((int) session.getAttribute("pagei"))) * (int) session.getAttribute("itemInPage") + 1;
							%>
							<c:forEach var="item" items="${ orders }">
								<tr>
									<td>
										<%
										out.print(i++);
										%>
									</td>
									<td style="max-width: 150px;overflow: hidden;">${ item.id }</td>
									<td style="">${ item.userId }</td>
									<td style="text-transform: uppercase;">
										<c:forEach var="item1" items="${ item.orderDetails }">
										<div>${ item1.productName }</div>
										</c:forEach>
									</td>
									<td>
										<c:forEach var="item1" items="${ item.orderDetails }">
										<div class="">${ item1.price }</div>
										</c:forEach>
									</td>
									<td>
										<c:forEach var="item1" items="${ item.orderDetails }">
										<div class="">${ item1.quantity }</div>
										</c:forEach>
									</td>
									<td style="">${ item.total }</td>
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
					href="<c:url value="/admin-orders?type=delivered&index=${ i }" />">${ i }</a></li>
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
				window.location.href = "<c:url value="/admin-delivered?type=wait&index=${inext}" />";
			})
		}
		
		if(${page} > 0) {
			var prev = document.querySelector(".prev");
			prev.addEventListener('click', function() {
				window.location.href = "<c:url value="/admin-delivered?type=wait&index=${page}" />";
			})
		}
		
		$("#btnDelete").click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();

			data['ids'] = ids;

			deleteProduct(data);

		});
		
		function deleteProduct(data) {
	        $.ajax({
	            url: "${APIurl}",
	            type: 'delete',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function(result) {
	                window.location.href = "${ProductURL}?type=list&index=${ pagecurr }&message=delete_success";
	            },
	            error: function(error) {
	                window.location.href = "${ProductURL}?type=list&index=${ pagecurr }&message=error_system";
	            },
	        });
		}


	</script>

</body>
</html>