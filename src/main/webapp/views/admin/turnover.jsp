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
					<h2>Turnover</h2>
				</div>
			</div>
		</div>
	</div>
	
	<div style="
    display: flex;
    gap: 110px;
    margin-bottom: 30px;
">
		<div style="
    display: flex;
    gap: 20px;font-size: 17px;
    font-weight: 400;
">
			<span style="
    color: #000;
    font-weight: 600;
">Today's revenue</span>
			<span>${ today }</span>
		</div>
		
		<div style="
    display: flex;
    gap: 20px;font-size: 17px;
    font-weight: 400;
">
			<span style="
    color: #000;
    font-weight: 600;
">Compared to yesterday</span>
			<span>
				<c:if test="${ yesterday  >= 0 }">
				 	+${ yesterday }
				</c:if>
				<c:if test="${ yesterday  < 0 }">
				 	${ yesterday }
				</c:if>
			</span>
		</div>
	</div>

	<div>
		<canvas id="myChart"></canvas>
	</div>
	
	<input type="hidden" value="${ t1 }" id="t1">
	<input type="hidden" value="${ t2 }" id="t2">
	<input type="hidden" value="${ t3 }" id="t3">
	<input type="hidden" value="${ t4 }" id="t4">
	<input type="hidden" value="${ t5 }" id="t5">
	<input type="hidden" value="${ t6 }" id="t6">
	<input type="hidden" value="${ t7 }" id="t7">
	<input type="hidden" value="${ t8 }" id="t8">
	<input type="hidden" value="${ t9 }" id="t9">
	<input type="hidden" value="${ t10 }" id="t10">
	<input type="hidden" value="${ t11 }" id="t11">
	<input type="hidden" value="${ t12 }" id="t12">
	
	<div style="
    text-align: center;
    margin-top: 30px;
">
		<h4>${ year }</h4>
	</div>
	
	
	<script>
		var t1 = $('#t1').val();
		var t2 = $('#t2').val();
		var t3 = $('#t3').val();
		var t4 = $('#t4').val();
		var t5 = $('#t5').val();
		var t6 = $('#t6').val();
		var t7 = $('#t7').val();
		var t8 = $('#t8').val();
		var t9 = $('#t9').val();
		var t10 = $('#t10').val();
		var t11 = $('#t11').val();
		var t12 = $('#t12').val();
		
		var max = Math.max(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12) + 100;
	
		const labels = [ 'January', 'February', 'March', 'April', 'May',
				'June', 'July', 'August', 'September', 'October', 'November', 'December', ];

		const data = {
			labels : labels,
			datasets : [ {
				label : '',
				backgroundColor : 'rgb(255, 99, 132)',
				borderColor : 'rgb(255, 99, 132)',
				data : [ t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, max],
			} ]
		};

		const config = {
			type : 'line',
			data : data,
			options : {}
		};
		
		const myChart = new Chart(
			document.getElementById('myChart'),
			config
		);
	</script>

</body>
</html>