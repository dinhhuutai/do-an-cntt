<%@page import="murach.model.ProductCart"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Header -->
<header class="header-v3">
	<!-- Header desktop -->
	<div class="container-menu-desktop trans-03">
		<div class="wrap-menu-desktop" style="
    box-shadow: .5px 0px 1px #fff;
    top: 0px;
">
			<nav class="limiter-menu-desktop p-l-45">

				<!-- Logo desktop -->
				<a href="<c:url value='/trang-chu' />" class="logo"> <img
					src="<c:url value='/template/user/images/icons/logo-01.png' />"
					alt="IMG-LOGO">
				</a>

				<!-- Menu desktop -->
				<div class="menu-desktop">
					<ul class="main-menu">
						<li><a href="<c:url value='/trang-chu' />">Home</a></li>

						<li><a href="<c:url value='/shop' />">Shop</a></li>



						<li><a href="<c:url value='/about' />">About</a></li>

						<li><a href="<c:url value='/contact' />">Contact</a></li>
					</ul>
				</div>

				<!-- Icon header -->
				<div class="wrap-icon-header flex-w flex-r-m h-full">
				
				<div style="
    padding-left: 20px;
" class="flex-c-m h-full p-r-25 bor6">
					
						<c:if test="${empty USERMODEL }" >
							<a href="<c:url value='/dang-nhap?action=login' />"
								class="flex-c-m trans-04 p-lr-25" style="color: #fff; padding: 0;">
								<div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-cart" data-notify="">
									<i style="
    font-size: 22px;
" class="fa fa-bell"></i>
								</div>
							</a> 
						</c:if>
						
						<c:if test="${not empty USERMODEL }" >
						<a href="<c:url value='/notification' />">
								<div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11">
									<i style="
    font-size: 22px;
" class="fa fa-bell"></i>
									
										<c:if test="${not empty notification }" >
											<span id="notificationNumber" style="
    font-size: 12px;
    padding: 2px 4px;
    position: absolute;
    background: #5454e4;
    top: -6px;
    right: 4px;
">
											<c:if test="${notificationSize <= 10 }" >
												${ notificationSize }
											</c:if>
											<c:if test="${notificationSize > 10 }" >
												10+
											</c:if>
									</span>
										</c:if>
								</div>
						</a>
						</c:if>
						
					
					</div>
				
				
					<div style="
    padding-left: 20px;
" class="flex-c-m h-full p-r-25 bor6">
					
						<c:if test="${empty USERMODEL }" >
							<a href="<c:url value='/dang-nhap?action=login' />"
								class="flex-c-m trans-04 p-lr-25" style="color: #fff; padding: 0;">
								<div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-cart" data-notify="2">
									<i class="zmdi zmdi-shopping-cart"></i>
								</div>
							</a> 
						</c:if>
						
						<c:if test="${not empty USERMODEL }" >
								<div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11 js-show-cart">
									<i class="zmdi zmdi-shopping-cart"></i>
									
										<c:if test="${not empty cartSize }" >
											<span id="numberProductInCart" style="
    font-size: 12px;
    padding: 2px 4px;
    position: absolute;
    background: #5454e4;
    top: -8px;
    right: -2px;
">
											<c:if test="${cartSize <= 10 }" >
												${ cartSize }
											</c:if>
											<c:if test="${cartSize > 10 }" >
												10+
											</c:if>
									</span>
										</c:if>
								</div>
						</c:if>
						
					
					</div>

					<div class="flex-c-m h-full p-lr-19">
						<div class="icon-header-item cl0 hov-cl1 trans-04 p-lr-11">
							<c:if test="${empty USERMODEL }" >
							<a href="<c:url value='/dang-nhap?action=login' />"
								class="flex-c-m trans-04" style="color: #fff;">
								<i class="fa fa-sign-in" aria-hidden="true"></i>
							</a> 
							</c:if>
							<c:if test="${not empty USERMODEL }" >
							<ul class="user_profile_dd">
								<li>
									<a class="" data-toggle="dropdown" style="
    width: 35px;
    display: block;
">
										<img class="img-responsive rounded-circle"
										style="
    width: 100%;
    height: 100%;
    border: .5px solid #fff;
"
											 src="<c:url value='/images/${ USERMODEL.avatar }' />" alt="#" />
									</a>
									<div class="dropdown-menu">
										<a style="
    padding: 12px 22px;
" class="dropdown-item" href="<c:url value='/my-profile' />">My Profile <i style="
    margin-left: 10px; float: right;
" class="fa fa-address-card-o" aria-hidden="true"></i></a>
										<a style="
    padding: 12px 22px;
" class="dropdown-item" href="<c:url value='/my-order?type=wait' />">My Order <i style="
    margin-left: 10px; float: right;
" class="fa fa-list-alt" aria-hidden="true"></i></a>
										<a style="
    padding: 12px 22px; border-top: 1px solid #d3caca54;
" class="dropdown-item" href="<c:url value='/thoat?action=logout' />">
											<span>Log Out</span>
											<i style="
    margin-left: 10px; float: right;
" class="fa fa-sign-out"></i>
										</a>
									</div>
								</li>
							</ul>
							</c:if>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>

	<!-- Header Mobile -->
	<div class="wrap-header-mobile">
		<!-- Logo moblie -->
		<div class="logo-mobile">
			<a href="index.html"><img
				src="<c:url value='/template/user/images/icons/logo-01.png' />"
				alt="IMG-LOGO"></a>
		</div>

		<!-- Icon header -->
		<%-- <div class="wrap-icon-header flex-w flex-r-m h-full m-r-15">
			<div class="flex-c-m h-full p-r-5">
				<div
					class="icon-header-item cl2 hov-cl1 trans-04 p-lr-11 js-show-cart"
					data-notify="
					<c:if test="${empty cartSize }" >
						0
					</c:if>
					<c:if test="${not empty cartSize }" >
						${ cartSize }
					</c:if>
					">
					<i class="zmdi zmdi-shopping-cart"></i>
				</div>
			</div>
		</div> --%>

		<!-- Button show menu -->
		<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
			<span class="hamburger-box"> <span class="hamburger-inner"></span>
			</span>
		</div>
	</div>


	<!-- Menu Mobile -->
	<div class="menu-mobile">
		<ul class="main-menu-m">
			<li><a href="#">Home</a> <span class="arrow-main-menu-m">
					<i class="fa fa-angle-right" aria-hidden="true"></i>
			</span></li>

			<li><a href="#">Shop</a></li>



			<li><a href="#">About</a></li>

			<li><a href="#">Contact</a></li>
		</ul>
	</div>

	<!-- Modal Search -->
	<!-- <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
		<button class="flex-c-m btn-hide-modal-search trans-04">
			<i class="zmdi zmdi-close"></i>
		</button>

		<form class="container-search-header">
			<div class="wrap-search-header">
				<input class="plh0" type="text" name="search"
					placeholder="Search...">

				<button class="flex-c-m trans-04">
					<i class="zmdi zmdi-search"></i>
				</button>
			</div>
		</form>
	</div> -->
</header>

<!-- <aside class="wrap-sidebar js-sidebar">
	<div class="s-full js-hide-sidebar"></div>

	<div class="sidebar flex-col-l p-t-22 p-b-25">
		<div class="flex-r w-full p-b-30 p-r-27">
			<div
				class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-sidebar">
				<i class="zmdi zmdi-close"></i>
			</div>
		</div>

		<div class="sidebar-content flex-w w-full p-lr-65 js-pscroll">
			<ul class="sidebar-link w-full">
				<li class="p-b-13"><a href="home-03.html"
					class="stext-102 cl2 hov-cl1 trans-04"> Home </a></li>

				<li class="p-b-13"><a href="#"
					class="stext-102 cl2 hov-cl1 trans-04"> My Wishlist </a></li>

				<li class="p-b-13"><a href="#"
					class="stext-102 cl2 hov-cl1 trans-04"> My Account </a></li>

				<li class="p-b-13"><a href="#"
					class="stext-102 cl2 hov-cl1 trans-04"> Track Oder </a></li>

				<li class="p-b-13"><a href="#"
					class="stext-102 cl2 hov-cl1 trans-04"> Refunds </a></li>

				<li class="p-b-13"><a href="#"
					class="stext-102 cl2 hov-cl1 trans-04"> Help & FAQs </a></li>
			</ul>

			<div class="sidebar-gallery w-full p-tb-30">
				<span class="mtext-101 cl5"> @ TNstore </span>



				<div class="sidebar-gallery w-full">
					<span class="mtext-101 cl5"> About Us </span>


				</div>
			</div>
		</div>
</aside> -->

<!-- Cart -->
<div id="model-cart" class="wrap-header-cart js-panel-cart">
	<div class="s-full js-hide-cart"></div>

	<div class="header-cart flex-col-l p-l-65 p-r-25">
		<div class="header-cart-title flex-w flex-sb-m p-b-8">
			<span class="mtext-103 cl2"> Your Cart </span>

			<div
				class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
				<i class="zmdi zmdi-close"></i>
			</div>
		</div>

		<div class="header-cart-content flex-w js-pscroll">
			<ul class="header-cart-wrapitem w-full" style="padding-right: 50px;">
			<c:forEach var="item" items="${ cart }">
				<li class="header-cart-item flex-w flex-t m-b-12">
					<div class="header-cart-item-img">
						<img
							src="<c:url value='/images/${ item.image }' />"
							alt="IMG">
					</div>

					<div class="header-cart-item-txt p-t-8">
						<a style="
    overflow: hidden;
    width: 150px;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
" href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
							${ item.name } </a>
							<span class="header-cart-item-info"> ${ item.quantity } x ${ item.price } VND </span>
					</div>
				</li>
			</c:forEach>

				<%-- <li class="header-cart-item flex-w flex-t m-b-12">
					<div class="header-cart-item-img">
						<img
							src="<c:url value='/template/user/images/item-cart-02.jpg"' /> alt="IMG"'>
					</div>

					<div class="header-cart-item-txt p-t-8">
						<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
							Converse All Star </a> <span class="header-cart-item-info"> 1
							x $39.00 </span>
					</div>
				</li>

				<li class="header-cart-item flex-w flex-t m-b-12">
					<div class="header-cart-item-img">
						<img
							src="<c:url value='/template/user/images/item-cart-03.jpg"' /> alt="IMG">
					</div>

					<div class="header-cart-item-txt p-t-8">
						<a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
							Nixon Porter Leather </a> <span class="header-cart-item-info">
							1 x $17.00 </span>
					</div>
				</li> --%>
			</ul>

		</div>
		
			<div class="w-full">
				<c:if test="${ not empty cart }" >
				<div class="header-cart-total w-full p-tb-40">Total: ${ totalPrice } VND</div>
				</c:if>

				<div class="header-cart-buttons flex-w w-full">
					<a href="<c:url value='/orders' />"
						class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
						View Cart </a>
				</div>
			</div>
	</div>
</div>
