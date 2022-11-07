<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var ="ProductURL" value="/admin-product"/>
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
				<div class="page_title" style="display: flex;">
					<a href='<c:url value="/admin-product?type=list"/>'>
						<h4 style="font-size: 14px; opacity: 0.5;">List Product</h4>
					</a>
					<h2 style="padding: 0 10px;">></h2>
					<c:if test="${empty model.categoryCode}">
						<h4>Add Product</h4>
					</c:if>

					<c:if test="${not empty model.categoryCode}">
						<h4>Update Product</h4>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${not empty messageResponse}">
		<div class="alert alert-${alert}">
  			${messageResponse}
		</div>
	</c:if>

	<form id="formSubmit" class="row g-3" method="post"
		<c:if test="${empty model.id}">
		action="admin-upload-img-product?type=edit&message=insert_success"
		</c:if>
		<c:if test="${not empty model.id}">
		action="admin-upload-img-product?type=list&index=1&message=update_success"
		</c:if>
		enctype="multipart/form-data">
		<div class="col-md-4 form-group">
			<label class="f-label">Thể loại</label> <select class="form-control"
				id="categoryCode" name="categoryCode">
				<c:if test="${empty model.categoryCode}">
					<option value="">-- Category --</option>
					<c:forEach var="item" items="${categories}">
						<option value="${item.code}">${item.name}</option>
					</c:forEach>
				</c:if>
				<c:if test="${not empty model.categoryCode}">
					<option value="">-- Category --</option>
					<c:forEach var="item" items="${categories}">
						<option value="${item.code}"
							<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
							${item.name}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		<div class="col-md-8 form-group">
			<label for="inputEmail4" class="form-label f-label">Name</label> <input
				type="text" class="form-control" id="name" name="name"
				value="${ model.name }">
		</div>
		<div class="col-md-6 form-group">
			<label for="inputPassword4" class="form-label f-label">Image</label>
			<input type="file" class="form-control-file" id="image" name="image">
		</div>
		<div class="col-md-6 form-group">
			<label for="inputPassword4" class="form-label f-label">Thumbnail
				1</label> <input type="file" class="form-control-file" id="thumbnail_1"
				name="thumbnail_1">
		</div>
		<div class="col-md-6 form-group">
			<label for="inputPassword4" class="form-label f-label">Thumbnail
				2</label> <input type="file" class="form-control-file" id="thumbnail_2"
				name="thumbnail_2">
		</div>
		<div class="col-md-6 form-group">
			<label for="inputPassword4" class="form-label f-label">Thumbnail
				3</label> <input type="file" class="form-control-file" id="thumbnail_3"
				name="thumbnail_3">
		</div>

		<div class="col-md-12 form-group">
			<label for="inputPassword4" class="form-label f-label">Description</label>
			<textarea style="min-height: 50vh;width: 100%;" rows="" cols="" id="description" name="description"
				style="min-height: 8vh;">${ model.description }</textarea>
		</div>


		<div class="col-md-4 form-group">
			<label for="inputPassword4" class="form-label f-label">Price</label>
			<input type="text" class="form-control" id="price" name="price"
				value="${ model.price }">
		</div>


		<div class="col-md-4 form-group">
			<label for="inputPassword4" class="form-label f-label">Discount</label>
			<input type="text" class="form-control" id="discount" name="discount"
				value="${ model.discount }">
		</div>


		<div class="col-md-4 form-group">
			<label for="inputPassword4" class="form-label f-label">Quantity</label>
			<input type="text" class="form-control" id="quantity" name="quantity"
				value="${ model.quantity }">
		</div>

		<div class="col-md-6 form-group">
			<label class="f-label">Color</label> <select class="form-control"
				id="colorCode" name="colorCode">
				<c:if test="${empty model.categoryCode}">
					<option value="">-- Color --</option>
					<c:forEach var="item" items="${color}">
						<option value="${item.code}">${item.name}</option>
					</c:forEach>
				</c:if>
				<c:if test="${not empty model.categoryCode}">
					<option value="">-- Color --</option>
					<c:forEach var="item" items="${color}">
						<option value="${item.code}"
							<c:if test="${item.code == model.colorCode}">selected="selected"</c:if>>
							${item.name}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>

		<div class="col-md-6 form-group">
			<label class="f-label">Size</label> <select class="form-control"
				id="size" name="size">
				<c:if test="${empty model.categoryCode}">
					<option value="">-- Size --</option>
					<c:forEach var="item" items="${size}">
						<option value="${item.code}">${item.name}</option>
					</c:forEach>
				</c:if>
				<c:if test="${not empty model.categoryCode}">
				<c:if test="${ model.categoryId == 1 || model.categoryId == 2 }">
					<option value="">-- Size --</option>
					<c:forEach var="item" items="${size}">
						<option value="${item.code}"
							<c:if test="${item.name == model.size}">selected="selected"</c:if>>
							${item.name}</option>
					</c:forEach>
				</c:if>
				</c:if>
			</select>
		</div>



		<div class="col-12 form-group">
			<c:if test="${not empty model.id}">
				<input type="button" class="btn btn-white btn-warning btn-bold"
					value="Update" id="btnAddOrUpdateNew" />
			</c:if>
			<c:if test="${empty model.id}">
				<input type="button" class="btn btn-white btn-warning btn-bold"
					value="Save" id="btnAddOrUpdateNew" />
			</c:if>
		</div>
		<input type="hidden" value="${ model.id }" id="id" name="id" />
	</form>
	
	

<script>

	var editor = '';
	$(document).ready(function() {
	    editor = CKEDITOR.replace('description');
	});
 
    $('#btnAddOrUpdateNew').click(function(e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (index, v) {
            data["" + v.name + ""] = v.value;
        });
        
        var price = $("#price").val();
        for(var i = 0; i < price.length; i++) {
        	if(price[i] == ',') {
                price = price.replace(',', '');
        	}
        	if(price[i] == '.') {
                price = price.replace('.', '');
        	}
        }
        data["price"] = price;
        
        
        var discount = $("#price").val();
        for(var i = 0; i < discount.length; i++) {
        	if(discount[i] == ',') {
        		discount = discount.replace(',', '');
        	}
        	if(discount[i] == '.') {
        		discount = discount.replace('.', '');
        	}
        }
        data["discount"] = price;
        

        var quantity = $("#price").val();
        for(var i = 0; i < quantity.length; i++) {
        	if(quantity[i] == ',') {
        		quantity = quantity.replace(',', '');
        	}
        	if(quantity[i] == '.') {
        		quantity = quantity.replace('.', '');
        	}
        }
        data["quantity"] = price;
        
        
        
        data["description"] = editor.getData();
        
        var today = new Date();
        var date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();
        var time = today.getHours() + "-" + today.getMinutes() + "-" + today.getSeconds();
        var dateTime = date+'-'+time;
        
        data["datetimeimg"] = dateTime;
        

        if($('input[type="file"]')[0].files.length != 0){
        	var nameImg = dateTime + $('input[type="file"]')[0].files[0].name;
            data["image"] = nameImg;
        }else {
        	data["image"] = "";
        }
        
        if($('input[type="file"]')[1].files.length != 0){
        	var nameImg = dateTime + $('input[type="file"]')[1].files[0].name;
            data["thumbnail_1"] = nameImg;
        }else {
        	data["thumbnail_1"] = "";
        }
        
        if($('input[type="file"]')[2].files.length != 0){
        	var nameImg = dateTime + $('input[type="file"]')[2].files[0].name;
            data["thumbnail_2"] = nameImg;
        }else {
        	data["thumbnail_2"] = "";
        }
        
        if($('input[type="file"]')[3].files.length != 0){
        	var nameImg = dateTime + $('input[type="file"]')[3].files[0].name;
            data["thumbnail_3"] = nameImg;
        }else {
        	data["thumbnail_3"] = "";
        }
        
        var id = $('#id').val();
        
        if(id == "") {
            addProduct(data);
        } else {
            updateProduct(data);
        }
        
        

    });

    function addProduct(data) {
        $.ajax({
            url: "${APIurl}",
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                $('#formSubmit').submit();
                /* window.location.href = "${ProductURL}?type=edit&id=" + result.id + "&message=insert_success"; */
            },
            error: function(error) {
                window.location.href = "${ProductURL}?type=edit&message=error_system";
            },
        });
    }

    function updateProduct(data) {
        $.ajax({
            url: "${APIurl}",
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
                $('#formSubmit').submit();
                /* window.location.href = "${ProductURL}?type=list&index=1&message=update_success"; */
            },
            error: function(error) {
                window.location.href = "${ProductURL}?type=edit&message=error_system";
            },
        }); 
    }

</script>

</body>
</html>