<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html style="
    scroll-behavior: smooth;
">
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<!-- basic -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- site icon -->
<link rel="icon"
	href="<c:url value='/template/admin/images/fevicon.png' />"
	type="image/png" />
<!-- bootstrap css -->

<link rel="stylesheet"
	href="<c:url value='/template/admin/css/bootstrap.min.css' />" />
<!-- site css -->
<!-- list css -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/list.css' />" />
<!-- responsive css -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/responsive.css' />" />
<!-- color css -->
<!-- select bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/bootstrap-select.css' />" />
<!-- scrollbar css -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/perfect-scrollbar.css' />" />
<!-- custom css -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/custom.css' />" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
<link rel="stylesheet"
	href="<c:url value='/template/admin/style.css' />" />
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<!--[if lt IE 9]>
      <script src="<c:url value='/template/admin/https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js' />"></script>
      <script src="<c:url value='/template/admin/https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js' />"></script>
      <![endif]-->
</head>
<body class="dashboard dashboard_1">

	<div class="full_container">
		<div class="inner_container">
			<!-- menu -->
			<%@ include file="/common/admin/menu.jsp"%>
			<!-- menu -->

			<div id="content">
				<!-- header -->
				<%@ include file="/common/admin/header.jsp"%>
				<!-- header -->


				<div class="midde_cont">
					<dec:body />


					
				</div>
				
				<!-- footer -->
					<%@ include file="/common/admin/footer.jsp"%>
				<!-- footer -->

			</div>


		</div>
	</div>



	<!-- jQuery -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/popper.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/bootstrap.min.js' />"></script>
	<!-- wow animation -->
	<script src="<c:url value='/template/admin/js/animate.js' />"></script>
	<!-- select country -->
	<script src="<c:url value='/template/admin/js/bootstrap-select.js' />"></script>
	<!-- owl carousel -->
	<script src="<c:url value='/template/admin/js/owl.carousel.js' />"></script>
	<!-- chart js -->
	<script src="<c:url value='/template/admin/js/Chart.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/Chart.bundle.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/utils.js' />"></script>
	<script src="<c:url value='/template/admin/js/analyser.js' />"></script>
	
	<!-- page specific plugin scripts -->
	<!-- nice scrollbar -->
	<script
		src="<c:url value='/template/admin/js/perfect-scrollbar.min.js' />"></script>
	<script>
		var ps = new PerfectScrollbar('#sidebar');
	</script>
	<!-- custom js -->

</body>
</html>