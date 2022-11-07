<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="LoadUrl" value="/load-product" />
<c:url var="SearchUrl" value="/search-product" />
<c:url var="images" value="/images" />
<c:url var="productid" value="/product" />
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
		<h2 class="ltext-105 cl0 txt-center">Shop</h2>
	</section>
	
	<!-- Product -->
	<div class="bg0 m-t-23 p-b-140">
		<div class="container">
			<div class="flex-w flex-sb-m p-b-52">
				<div class="flex-w flex-l-m filter-tope-group m-tb-10">
					<button
						data-value="0"
						class="category-item filter-link-active stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1 product-search"
						data-filter="*">All Products</button>

					<c:forEach var="item" items="${ category }">
					<button data-value="${ item.id }" class="category-item stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 product-search" data-filter=".category-${ item.id }">
						${ item.name }
					</button>
					</c:forEach>
				</div>

				<div class="flex-w flex-c-m m-tb-10">
					<div
						class="flex-c-m stext-106 cl6 size-104 bor4 pointer hov-btn3 trans-04 m-r-8 m-tb-4 js-show-filter">
						<i
							class="icon-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-filter-list"></i>
						<i
							class="icon-close-filter cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
						Filter
					</div>

					<div
						class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
						<i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
						<i
							class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
						Search
					</div>
				</div>

				<!-- Search product -->
				<div class="dis-none panel-search w-full p-t-10 p-b-15">
					<div class="bor8 dis-flex p-l-15">
						<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04">
							<i class="zmdi zmdi-search"></i>
						</button>

						<input id="search-product-input" class="mtext-107 cl2 size-114 plh2 p-r-15" type="text"
							name="search-product-input" placeholder="Search">
					</div>
				</div>

				<!-- Filter -->
				<div class="dis-none panel-filter w-full p-t-10">
					<div
						class="wrap-filter flex-w bg6 w-full p-lr-40 p-t-27 p-lr-15-sm">
						<div class="filter-col1 p-r-15 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Sort By</div>

							<ul>
								<li class="p-b-6"><button
									data-value="all"
									class="sort-item filter-link stext-106 trans-04 filter-link-active product-search"> Default </button></li>

								<li class="p-b-6"><button
									data-value="popularity"
									class="sort-item filter-link stext-106 trans-04 product-search"> Popularity </button></li>

								<li class="p-b-6"><button
									data-value="createddate"
									class="sort-item filter-link stext-106 trans-04 product-search">
										New </button></li>

								<li class="p-b-6"><button
									data-value="low"
									class="sort-item filter-link stext-106 trans-04 product-search"> Price: Low to High
								</button></li>

								<li class="p-b-6"><button
									data-value="high"
									class="sort-item filter-link stext-106 trans-04 product-search"> Price: High to Low
								</button></li>
							</ul>
						</div>

						<div class="filter-col2 p-r-15 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Price</div>

							<ul>
								<li class="p-b-6"><button
									data-value="all"
									class="price-item filter-link stext-106 trans-04 filter-link-active product-search">
										All </button></li>

								<li class="p-b-6"><button
									data-value="1"
									class="price-item filter-link stext-106 trans-04 product-search"> 0 - 200,000 </button></li>

								<li class="p-b-6"><button
									data-value="2"
									class="price-item filter-link stext-106 trans-04 product-search"> 200,000 - 500,000 </button>
								</li>

								<li class="p-b-6"><button
									data-value="3"
									class="price-item filter-link stext-106 trans-04 product-search"> 500,000 - 1,000,000
								</button></li>


								<li class="p-b-6"><button
									data-value="4"
									class="price-item filter-link stext-106 trans-04 product-search"> 1,000,000+ </button></li>
							</ul>
						</div>

						<div class="filter-col3 p-r-15 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Color</div>

							<ul>
								<li class="p-b-6"><button
									data-value="0"
									class="color-item filter-link stext-106 trans-04 filter-link-active product-search">
										All </button></li>
								<c:forEach var="item" items="${ color }">
								<li class="p-b-6">
									<span class="fs-15 lh-12 m-r-6" style="color: ${ item.code };">
										<i class="zmdi zmdi-circle"></i>
									</span>

									<button data-value="${ item.id }" class="color-item filter-link stext-106 trans-04 product-search">
										${ item.name }
									</button>
								</li>
								</c:forEach>
							</ul>
						</div>

						<div class="filter-col4 p-b-27">
							<div class="mtext-102 cl2 p-b-15">Tags</div>

							<div class="flex-w p-t-4 m-r--5">
								<a href="#"
									class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									Fashion </a> <a href="#"
									class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									Lifestyle </a> <a href="#"
									class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									Denim </a> <a href="#"
									class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									Streetstyle </a> <a href="#"
									class="flex-c-m stext-107 cl6 size-301 bor7 p-lr-15 hov-tag1 trans-04 m-r-5 m-b-5">
									Crafts </a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="container-product-shop" class="row">  <!-- isotope-grid -->
				<c:forEach var="item" items="${ product }">
				<div class="product col-sm-6 col-md-4 col-lg-3 p-b-35 category-${ item.categoryId }"> <!-- isotope-item -->
					<!-- Block2 -->
					<div class="block2">
						<div class="block2-pic hov-img0" data-label="New" style="min-height: 334px;"> <!-- label-new -->
							<img style="image-rendering: pixelated;" src="<c:url value='/images/${ item.image }' />" alt="IMG-PRODUCT">

							<a style="box-shadow: 1px 1px 1px #333;" href="<c:url value="/product?id=${ item.id }" />" class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04">
								Quick View
							</a>
						</div>

						<div class="block2-txt flex-w flex-t p-t-14">
							<div class="block2-txt-child1 flex-col-l ">
								<span class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
									${ item.name }
								</span>

								<span class="stext-105 cl3">
									${ item.price }
								</span>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			
				
			<!-- Load more -->
			<div class="flex-c-m flex-w w-full p-t-45">
				<button onclick="loadMore()"
					class="flex-c-m stext-101 cl5 size-103 bg2 bor1 hov-btn1 p-lr-15 trans-04">
					Load More </button>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		var category = document.querySelector(".category-item.filter-link-active").getAttribute("data-value");
		var sort = document.querySelector(".sort-item.filter-link-active").getAttribute("data-value");
		var price = document.querySelector(".price-item.filter-link-active").getAttribute("data-value");
		var color = document.querySelector(".color-item.filter-link-active").getAttribute("data-value");
		var name = document.querySelector('#search-product-input').value;
	
		var sortItems = document.querySelectorAll(".sort-item");
		sortItems.forEach(sortItem => {
			sortItem.onclick = function() {
				document.querySelector(".sort-item.filter-link-active").classList.remove("filter-link-active");
				
				this.classList.add("filter-link-active");
				
				sort = document.querySelector(".sort-item.filter-link-active").getAttribute("data-value");
				
				handle();
			}
		})
		var priceItems = document.querySelectorAll(".price-item");
		priceItems.forEach(priceItem => {
			priceItem.onclick = function() {
				document.querySelector(".price-item.filter-link-active").classList.remove("filter-link-active");
				
				this.classList.add("filter-link-active");
				
				price = document.querySelector(".price-item.filter-link-active").getAttribute("data-value");
				
				handle();
			}
		})
		var colorItems = document.querySelectorAll(".color-item");
		colorItems.forEach(colorItem => {
			colorItem.onclick = function() {
				document.querySelector(".color-item.filter-link-active").classList.remove("filter-link-active");
				
				this.classList.add("filter-link-active");
				
				color = document.querySelector(".color-item.filter-link-active").getAttribute("data-value");
				
				handle();
			}
		})
		
		var categoryItems = document.querySelectorAll(".category-item");
		categoryItems.forEach(categoryItem => {
			categoryItem.onclick = function() {
				document.querySelector(".category-item.filter-link-active").classList.remove("filter-link-active");
				
				this.classList.add("filter-link-active");
				

				category = document.querySelector(".category-item.filter-link-active").getAttribute("data-value");
				
				handle();
			}
		})

		document.querySelector('#search-product-input').oninput = function() {
			name = this.value;
			
			handle();
		}
		
		
		function handle() {
			$.ajax({
				url: "${SearchUrl}",
				type: "get",
				data: {
					category,
					sort,
					price,
					color,
					name,
				},
				success: function(datas){
					
					/* var row = document.getElementById("container-product-shop");
					
					
					row.innerHTML = datas;
					
					var htmls = document.querySelectorAll(".product");
					row = document.getElementById("container-product-shop");
					
					var product = "";
					row.innerHTML = "";
					htmls.forEach(html => {

						row.innerHTML += "<div class=\"product col-sm-6 col-md-4 col-lg-3 p-b-35\">" + html.innerHTML + "</div>";
						
					}); */
					
					
					var row = document.getElementById("container-product-shop");
					var html = "";
					
					datas.forEach(data => {
						html += 
						"<div class=\"product col-sm-6 col-md-4 col-lg-3 p-b-35 category-" + data.categoryId + "\">" +
							
							"<div class=\"block2\">" +
								"<div class=\"block2-pic hov-img0\" data-label=\"New\" style=\"min-height: 334px;\">" +
									"<img style=\"image-rendering: pixelated;\" src=\"${images}/" + data.image + "\" alt=\"IMG-PRODUCT\">" +

									"<a style=\"box-shadow: 1px 1px 1px #333;\" href=\"${productid}?id=" + data.id + "\"  class=\"block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04\">" +
										"Quick View" +
									"</a>" +
								"</div>" +

								"<div class=\"block2-txt flex-w flex-t p-t-14\">" +
									"<div class=\"block2-txt-child1 flex-col-l \">" +
										"<span class=\"stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6\">" +
											data.name +
										"</span>" +

										"<span class=\"stext-105 cl3\">" +
											data.price +
										"</span>" +
									"</div>" +
								"</div>" +
							"</div>" +
						"</div>";
					})
					
					row.innerHTML = html;
					
				},
				error: function(xhr){
					
				}
			});
		}
		
		
	
	
	
		function loadMore() {
			category = document.querySelector(".category-item.filter-link-active").getAttribute("data-value");
			sort = document.querySelector(".sort-item.filter-link-active").getAttribute("data-value");
			price = document.querySelector(".price-item.filter-link-active").getAttribute("data-value");
			color = document.querySelector(".color-item.filter-link-active").getAttribute("data-value");
			name = document.querySelector('#search-product-input').value;
		
			
			var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url: "${LoadUrl}",
				type: "get",
				data: {
					exits: amount,
					category,
					sort,
					price,
					color,
					name,
				},
				success: function(datas){
					var row = document.getElementById("container-product-shop");
					
					var html = "";
					
					datas.forEach(data => {
						html += 
						"<div class=\"product col-sm-6 col-md-4 col-lg-3 p-b-35 category-" + data.categoryId + "\">" +
							
							"<div class=\"block2\">" +
								"<div class=\"block2-pic hov-img0\" data-label=\"New\" style=\"min-height: 334px;\">" +
									"<img style=\"image-rendering: pixelated;\" src=\"${images}/" + data.image + "\" alt=\"IMG-PRODUCT\">" +

									"<a style=\"box-shadow: 1px 1px 1px #333;\" href=\"${productid}?id=" + data.id + "\"  class=\"block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04\">" +
										"Quick View" +
									"</a>" +
								"</div>" +

								"<div class=\"block2-txt flex-w flex-t p-t-14\">" +
									"<div class=\"block2-txt-child1 flex-col-l \">" +
										"<span class=\"stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6\">" +
											data.name +
										"</span>" +

										"<span class=\"stext-105 cl3\">" +
											data.price +
										"</span>" +
									"</div>" +
								"</div>" +
							"</div>" +
						"</div>";
					})
					
					row.innerHTML += res;
					
				},
				error: function(xhr){
					
				}
			});
		}
	</script>
	
</body>
</html>