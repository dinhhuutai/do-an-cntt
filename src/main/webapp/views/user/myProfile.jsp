<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-user"/>
<c:url var ="UserURL" value="/my-profile"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form id="formSubmit"  method="post"
		<c:if test="${empty model.id}">
		action="upload-img-user?type=edit&message=insert_success"
		</c:if>
		<c:if test="${not empty model.id}">
		action="upload-img-user?type=list&index=1&message=update_success"
		</c:if>
		enctype="multipart/form-data" style="background-color: #242323ed; padding: 130px 16px 100px;">

			<div class="row">
				<div class="col-lg-4">
					<div class="card mb-4">
						<div class="card-body text-center" style="
    padding-bottom: 56px;
">
							<img
								src="<c:url value='/images/${ USERMODEL.avatar }' />"
								alt="avatar" class="rounded-circle img-fluid"
								style="width: 150px;">
							<h5 class="my-3">${ USERMODEL.fullName }</h5>
							<div class="d-flex justify-content-center mb-2" style="margin-top: 50px">
							
								<input value="${ USERMODEL.avatar }" name="avatar" id="avatar" type="file" style="
    margin-left: 50%;
    transform: translateX(-50%);
" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Full Name</p>
								</div>
								<div class="col-sm-9">
									<input type="text" value="${ USERMODEL.fullName }" name="fullName" id="fullName" style="
    width: 100%;
" />
									
								</div>
							</div>
							<hr>
							
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Password</p>
								</div>
								<div class="col-sm-9">
									<input type="text" value="${ USERMODEL.password }" name="password" id="password" style="
    width: 100%;
" />
									
								</div>
							</div>
							<hr>
							
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Email</p>
								</div>
								<div class="col-sm-9">
									<input type="email" value="${ USERMODEL.email }" name="email" id="email" style="
    width: 100%;
" />
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Phone</p>
								</div>
								<div class="col-sm-9">
									<input type="text" value="${ USERMODEL.phone }" name="phone" id="phone" style="
    width: 100%;
" />
								</div>
							</div>
							<hr>
							
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Address</p>
								</div>
								<div class="col-sm-9">
									<input type="text" value="${ USERMODEL.address }" name="address" id="address" style="
    width: 100%;
" />
								</div>
							</div>
						</div>
						
						
						<input type="hidden" value="${ USERMODEL.id }" id="id" name="id" />
              			<button style="
    width: 100px;
    margin: 20px 15px;
" type="submit" class="btn btn-primary" id="UpdataUser">Update</button>

<c:if test="${not empty messageResponse}">
		<div style="
    width: 200px;
    position: absolute;
    top: 82%;
    text-align: center;
    right: 5%;
" class="alert alert-${alert}">
  			${messageResponse}
		</div>
	</c:if>
					</div>
					
				</div>
			</div>
	</form>
	
	<script type="text/javascript">
		
	$('#UpdataUser').click(function(e) {
		
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();

        $.each(formData, function (index, v) {
            data["" + v.name + ""] = v.value;
        });
        
        
        var today = new Date();
        var date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();
        var time = today.getHours() + "-" + today.getMinutes() + "-" + today.getSeconds();
        var dateTime = date+'-'+time;
        
        data["datetimeimg"] = dateTime;
        
        console.log(document.querySelector('input[type="file"]').getAttribute("value"));
        

        if($('input[type="file"]')[0].files.length != 0){
        	var nameImg = dateTime + $('input[type="file"]')[0].files[0].name;
            data["avatar"] = nameImg;
        }else {
        	data["avatar"] = document.querySelector('input[type="file"]').getAttribute("value");
        }
        
        
        $.ajax({
            url: "${APIurl}",
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result) {
            	if($('input[type="file"]')[0].files.length != 0){
                    $('#formSubmit').submit();
                }else {
                	window.location.href = "${UserURL}?type=list&index=1&message=update_success";
                }
                
            },
            error: function(error) {
                window.location.href = "${UserURL}?type=edit&message=error_system";
            },
        });         
        

    });
		
		
	</script>

</body>
</html>