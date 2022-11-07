<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-contact"/>
<c:url var ="ContactURL" value="/admin-contact"/>
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
					<a href='<c:url value="/admin-contact"/>'>
						<h2>Update Contact</h2>
					</a>
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
		action="admin-upload-img-contact?&message=update_success"
		enctype="multipart/form-data">
		
		<div class="col-md-12 form-group">
			<label for="inputEmail4" class="form-label f-label">Name</label> <input
				type="text" class="form-control" id="name" name="name"
				value="${ model.name }">
		</div>
		<div class="col-md-12 form-group">
			<label for="inputEmail4" class="form-label f-label">Phone</label> <input
				type="text" class="form-control" id="phone" name="phone"
				value="${ model.phone }">
		</div>
		<div class="col-md-12 form-group">
			<label for="inputEmail4" class="form-label f-label">Email</label> <input
				type="text" class="form-control" id="email" name="email"
				value="${ model.email }">
		</div>
		<div class="col-md-12 form-group">
			<label for="inputEmail4" class="form-label f-label">Address</label> <input
				type="text" class="form-control" id="address" name="address"
				value="${ model.address }">
		</div>
		

		<div class="col-12 form-group">
			<input type="button" class="btn btn-white btn-warning btn-bold"
					value="Update" id="btnAddOrUpdateNew" />
		</div>
		<input type="hidden" value="${ model.id }" id="id" name="id" />
	</form>
	
	

<script>

 
    $('#btnAddOrUpdateNew').click(function(e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (index, v) {
            data["" + v.name + ""] = v.value;
        });
        

        updateContact(data);
        
        

    });

    function updateContact(data) {
        $.ajax({
            url: "${APIurl}",
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
               	window.location.href = "${ContactURL}?message=update_success";
            },
            error: function(error) {
                window.location.href = "${ContactURL}?message=error_system";
            },
        }); 
    }

</script>

</body>
</html>