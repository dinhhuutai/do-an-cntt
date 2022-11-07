<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%-- <c:url var="APIurl" value="/cart?type=delete" /> --%>
<c:url var="OrdersAPI" value="/orders" />
<c:url var="APIurl" value="/api-orders" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>

	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92"
		style="background-image: url(<c:url value='/template/user/images/bg-01.jpg' />);">
		<h2 class="ltext-105 cl0 txt-center">Orders</h2>
	</section>

	
	<!-- Shoping Cart -->
	<div class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-1">Product</th>
									<th class="column-2"></th>
									<th class="column-3">Price</th>
									<th class="column-4">Quantity</th>
									<th class="column-5">Total</th>
									<th class="column-6"></th>
								</tr>
								
								<c:forEach var="item" items="${ cart }">
								<tr class="table_row">
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="images/${ item.image }" alt="IMG">
										</div>
									</td>
									<td class="column-2">${ item.name }</td>
									<td class="column-3">${ item.price }</td>
									<td class="column-4">${ item.quantity }</td>
									<td class="column-5">${ item.total() }</td>
									<td class="column-6">
										<form id="${ item.id }" method="post" action="cart?type=delete&id=${ item.id }">
										<button type="submit" value="${ item.id }" class="deleteProductInCart" style="
    margin-right: 12px;
    padding: 2px 5px;
    background-color: #f80c0c;
    color: #fff;
    border-radius: 4px;
">delete</button></form>
									</td>
								</tr>
								</c:forEach>
							</table>
						</div>

						<div
							class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<div class="flex-w flex-m m-r-20 m-tb-5">
								<input
									class="stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
									type="text" name="coupon" placeholder="Coupon Code">

								<div
									class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5">
									Apply coupon</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div
						class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">Cart Totals</h4>


						<div class="flex-w flex-t bor12 p-t-15 p-b-30">
							<div class="size-208 w-full-ssm">
								<span class="stext-110 cl2"> Shipping: </span>
							</div>

							<div style="margin-top: 20px; width: 100%;" class="p-r-18 p-r-0-sm w-full-ssm">
								<input class="shipping-input" style="
    width: 100%;
    border-bottom: 2px solid #2510d6;
" type="text" name="address" id="address" value="${ USERMODEL.address }">

								<span style="
    margin-top: 4px;
    font-size: 14px;
    display: block;
    color: red;
" class="message-shipping"></span>
								
							</div>
							
							
							<div style="
    margin-top: 50px;
" class="size-208 w-full-ssm">
								<span class="stext-110 cl2"> Phone: </span>
							</div>

							<div style="margin-top: 20px; width: 100%;" class="p-r-18 p-r-0-sm w-full-ssm">
								<input class="phone-input" style="
    width: 100%;
    border-bottom: 2px solid #2510d6;
" type="text" name="phone" id="phone" value="${ USERMODEL.phone }">


								<span style="
    margin-top: 4px;
    font-size: 14px;
    display: block;
    color: red;
" class="message-phone"></span>
								
							</div>
						</div>

						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size-208">
								<span class="mtext-101 cl2"> Total: </span>
							</div>

							<div class="size-209 p-t-1">
								<span class="mtext-110 cl2"> ${ totalPrice } VND </span>
							</div>
						</div>

						<button
							id="pay-btn"
							class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
							Proceed to Checkout</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div style="
    position: fixed;
    top: 0;
    right: 0;
    left: 0;
    bottom: 0;
    display: none;
    justify-content: center;
    align-items: center;
    background-color: #514f4f40;
    z-index: 9999;
" class="wrap-model">
		<div style="
    background-color: #fff;
    padding: 60px 130px;
    position: relative;
    border-radius: 4px;
" class="model">
			<div style="
    position: absolute;
    top: 0;
    font-size: 20px;
    right: 0;
    padding: 4px 10px;
    background: #da1919f5;
    color: #fff;
    cursor: pointer;
    border-top-right-radius: 4px;
" class="model-icon-close">
				<i class="fa fa-times" aria-hidden="true"></i>
			</div>
			<div style="
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
" class="">
				<i style="
    margin-bottom: 16px;
    font-size: 56px;
    color: #00cc00;
" class="fa fa-check-circle-o" aria-hidden="true"></i>
				<span style="
    font-size: 20px;
    color: #106810;
" class="model-word">Order Success</span>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		var payBtn = document.getElementById("pay-btn");
		var shippingInput;
		var phoneInput;

		var messageShipping = document.querySelector(".message-shipping");
		var messagePhone = document.querySelector(".message-phone");

		payBtn.onclick = () => {
			shippingInput = document.querySelector(".shipping-input").value.trim();
			phoneInput = document.querySelector(".phone-input").value.trim();
			
			if(shippingInput == "") {
				messagePhone.innerHTML = "";
				messageShipping.innerHTML = "Please enter your address";
			} else if (phoneInput.length < 9 || phoneInput.length > 12) {
				messageShipping.innerHTML = "";
				messagePhone.innerHTML = "Incorrect phone number";

			} else {
				messageShipping.innerHTML = "";
				messagePhone.innerHTML = "";
				
				$.ajax({
			        url: "${APIurl}",
			        type: 'post',
			        data: {
			        	shippingInput,
			        	phoneInput,
			        	type: "buy",
			        },
			        success: function(result) {
						var tables = document.querySelectorAll(".table_row");
						tables.forEach(table => {
							table.outerHTML = "";
						});
						var numberProductInCart = document.getElementById("numberProductInCart");
						numberProductInCart.outerHTML = "";
						
						var model = document.querySelector(".wrap-model");
						model.style.display = "flex";
			        },
			        error: function(error) {
			        	console.log("error");
			        },
			    });
				
				
			}
		}

		var close = document.querySelector(".model-icon-close");
		close.onclick = function() {
			var model = document.querySelector(".wrap-model");
			model.style.display = "none";
		}

		var wrapModel = document.querySelector(".wrap-model");
		wrapModel.onclick = function() {
			wrapModel.style.display = "none";
		}

		var modal = document.querySelector(".model");
		modal.onclick = function(e) {
			e.stopPropagation();
		}

	
		/* var deleteProducts = document.querySelectorAll(".deleteProductInCart");

		deleteProducts.forEach(deleteProduct => {
			deleteProduct.addEventListener("click", () => {
				var id = deleteProduct.getAttribute("value");
				
			 	$.ajax({
			        url: "${APIurl}",
			        type: 'post',
			        data: {
			            id
			        },
			        success: function(result) {
			            window.location.href = "${OrdersAPI}";
			        },
			        error: function(error) {
			            	
			        },
			    });

			 	
			})
		});*/
	</script>

</body>
</html>