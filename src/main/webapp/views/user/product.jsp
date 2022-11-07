<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/cart?type=add" />
<c:url var="ProductURL" value="/product" />
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
		<h2 class="ltext-105 cl0 txt-center">Product</h2>
	</section>


	<section class="sec-product-detail bg0 p-t-65 p-b-60">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-lg-7 p-b-30">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							<div class="wrap-slick3-dots">
								<ul class="slick3-dots" role="tablist" style="">
									<li class="slick-active" role="presentation"><img
										src="<c:url value='/images/${ product.image }' />">
										<div class="slick3-dot-overlay"></div></li>
									<li role="presentation"><img
										src="<c:url value='/images/${ product.thumbnail_1 }' />">
										<div class="slick3-dot-overlay"></div></li>
									<li role="presentation"><img
										src="<c:url value='/images/${ product.thumbnail_2 }' />">
										<div class="slick3-dot-overlay"></div></li>
									<li role="presentation"><img
										src="<c:url value='/images/${ product.thumbnail_3 }' />">
										<div class="slick3-dot-overlay"></div></li>
								</ul>
							</div>
							<div
								style="position: absolute; z-index: 100; width: 64.933333%; right: 113px; top: calc(50% - 30px);"
								class="wrap-slick3-arrows flex-sb-m flex-w">
								<button class="arrow-slick3 prev-slick3 slick-arrow" style="">
									<i class="fa fa-angle-left" aria-hidden="true"></i>
								</button>
								<button class="arrow-slick3 next-slick3 slick-arrow" style="">
									<i class="fa fa-angle-right" aria-hidden="true"></i>
								</button>
							</div>

							<div
								class="slick3 gallery-lb slick-initialized slick-slider slick-dotted">
								<div class="slick-list draggable">
									<div class="slick-track" style="opacity: 1; width: 1600px;">
										<div
											class="item-slick3 slick-slide slick-current slick-active"
											data-thumb="<c:url value='/images/${ product.image }' />"
											data-slick-index="0" aria-hidden="false" tabindex="0"
											role="tabpanel" id="slick-slide10"
											aria-describedby="slick-slide-control10"
											style="width: 400px; position: relative; left: 0px; top: 0px; z-index: 999; opacity: 1;">
											<div class="wrap-pic-w pos-relative">
												<img src="<c:url value='/images/${ product.image }' />"
													alt="IMG-PRODUCT">
											</div>
										</div>

										<div class="item-slick3 slick-slide"
											data-thumb="<c:url value='/images/${ product.thumbnail_1 }' />"
											data-slick-index="1" aria-hidden="true" tabindex="-1"
											role="tabpanel" id="slick-slide11"
											aria-describedby="slick-slide-control11"
											style="width: 400px; position: relative; left: -301px; top: 0px; z-index: 998; opacity: 0;">
											<div class="wrap-pic-w pos-relative">
												<img
													src="<c:url value='/images/${ product.thumbnail_1 }' />"
													alt="IMG-PRODUCT"> <a
													class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
													href="images/product-detail-02.jpg" tabindex="-1"> <i
													class="fa fa-expand"></i>
												</a>
											</div>
										</div>

										<div class="item-slick3 slick-slide"
											data-thumb="<c:url value='/images/${ product.thumbnail_2 }' />"
											data-slick-index="2" aria-hidden="true" tabindex="-1"
											role="tabpanel" id="slick-slide12"
											aria-describedby="slick-slide-control12"
											style="width: 400px; position: relative; left: -602px; top: 0px; z-index: 998; opacity: 0;">
											<div class="wrap-pic-w pos-relative">
												<img
													src="<c:url value='/images/${ product.thumbnail_2 }' />"
													alt="IMG-PRODUCT"> <a
													class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
													href="images/product-detail-03.jpg" tabindex="-1"> <i
													class="fa fa-expand"></i>
												</a>
											</div>
										</div>


										<div class="item-slick3 slick-slide"
											data-thumb="<c:url value='/images/${ product.thumbnail_3 }' />"
											data-slick-index="2" aria-hidden="true" tabindex="-1"
											role="tabpanel" id="slick-slide12"
											aria-describedby="slick-slide-control12"
											style="width: 400px; position: relative; left: -602px; top: 0px; z-index: 998; opacity: 0;">
											<div class="wrap-pic-w pos-relative">
												<img
													src="<c:url value='/images/${ product.thumbnail_3 }' />"
													alt="IMG-PRODUCT"> <a
													class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
													href="images/product-detail-03.jpg" tabindex="-1"> <i
													class="fa fa-expand"></i>
												</a>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-lg-5 p-b-30">
					<div class="p-r-50 p-t-5 p-lr-0-lg">
						<h4 class="mtext-105 cl2 js-name-detail p-b-14">${ product.name }</h4>

						<span class="mtext-106 cl2"> ${ product.price } VND </span>

						<p class="stext-102 cl3 p-t-23">${ product.description }</p>

						<!--  -->
						<div class="p-t-33">
							<div class="flex-w flex-r-m p-b-10"
								style="display: flex; justify-content: start;">
								<div style="margin-right: 74px;" class="flex-c-m respon6">Size</div>
								<select style="width: 70%;" class="form-control" id="size"
									name="size">
									<c:forEach var="item" items="${size}">
										<option value="${item.code}">${item.name}</option>
									</c:forEach>
								</select>
							</div>

							<div class="flex-w flex-r-m p-b-10"
								style="display: flex; justify-content: start;">
								<div style="margin-right: 68px;" class="flex-c-m respon6">Color</div>
								<select style="width: 70%;" class="form-control" id="colorCode"
									name="colorCode">
									<c:forEach var="item" items="${color}">
										<option value="${item.code}">${item.name}</option>
									</c:forEach>
								</select>
							</div>

							<div class="flex-w flex-r-m p-b-10">
								<div class="size-204 flex-w flex-m respon6-next">
									<div class="wrap-num-product flex-w m-r-20 m-tb-10">
										<div
											class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
											<i class="fs-16 zmdi zmdi-minus"></i>
										</div>

										<input class="mtext-104 cl3 txt-center num-product"
											type="number" id="quantity" name="quantity" value="1" min="1"
											max="10">

										<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
											<i class="fs-16 zmdi zmdi-plus"></i>
										</div>
									</div>

									<c:if test="${empty USERMODEL }">
										<a href="<c:url value='/dang-nhap?action=login' />">
											<button type="submit"
											class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail">
											Add to cart</button>
										</a>
									</c:if>

									<c:if test="${not empty USERMODEL }">
									
										<input name="id" id="id" type="hidden" value="${ product.id }" />
	
										<button id="addToCart" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04">
											Add to cart
										</button>
										
									<%-- <form action="cart" method="post">
										<input name="id" id="id" type="hidden" value="${ product.id }" />

										<button id="addToCart" type="submit"
											class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail">
											Add to cart</button>
									</form> --%>
									</c:if>

								</div>
							</div>
						</div>

						<!--  -->
						<div class="flex-w flex-m p-l-100 p-t-40 respon7">
							<div class="flex-m bor9 p-r-10 m-r-11">
								<a href="#"
									class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 js-addwish-detail tooltip100"
									data-tooltip="Add to Wishlist"> <i
									class="zmdi zmdi-favorite"></i>
								</a>
							</div>

							<a href="#"
								class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
								data-tooltip="Facebook"> <i class="fa fa-facebook"></i>
							</a> <a href="#"
								class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
								data-tooltip="Twitter"> <i class="fa fa-twitter"></i>
							</a> <a href="#"
								class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
								data-tooltip="Google Plus"> <i class="fa fa-google-plus"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<script type="text/javascript">
		$("#addToCart").click(function() {
			var quantity = $(".num-product").val();
			var id = $("#id").val();
			
			
			$.ajax({
	            url: "${APIurl}",
	            type: 'post',
	            data: {
	            	quantity,
	            	id
	            },
	            success: function(result) {
	            	window.location.href = "${ProductURL}?id=" + result;
	            },
	            error: function(error) {
	            	
	            },
	        }); 
		})
	</script>
	
</body>
</html>