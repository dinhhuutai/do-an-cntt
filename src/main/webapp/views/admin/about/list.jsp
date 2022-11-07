<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-about" />
<c:url var="AboutURL" value="/admin-about" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>List About</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row column_title">
			<div class="col-md-12">
				<div class="page_title">
					<h2>List About</h2>
				</div>
			</div>
		</div>
	</div>
	
	<c:if test="${not empty messageResponse}">
		<div class="alert alert-${alert}">
  			${messageResponse}
		</div>
	</c:if>

	<div class="widget-box table-filter"
		style="display: flex; justify-content: end; margin-bottom: 10px; border: none;">
		<div class="table-btn-controls">
			<div class="pull-right tableTools-container">
				<div class="dt-buttons btn-overlap btn-group"
					style="display: flex; gap: 2px;">
					
					<button id="btnDelete" type="button"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold check-all-submit-btn"
						data-toggle="tooltip" title='Xóa bài viết'
						style="border-radius: 5px;">
						<span> <i class="fa fa-trash-o bigger-110 pink"></i>
						</span>
					</button>
					
					<a flag="info"
						class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Thêm bài viết'
						href='<c:url value="/admin-about?type=edit"/>'
						style="border-radius: 5px;"> <span> <i
							class="fa fa-plus-circle bigger-110 purple"></i>
					</span>
					</a>
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
						<thead style="background-color: #673ab7; color: #fff;">
							<tr>
								<th scope="col">
									<div class="form-check" style="margin-bottom: 20px">
										<input class="form-check-input" type="checkbox" value=""
											id="checkbox-all" />
									</div>
								</th>
								<th scope="col">STT</th>
								<th scope="col">Name</th>
								<th scope="col">Description</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<%
							int i = (((int) session.getAttribute("pagei"))) * (int) session.getAttribute("itemInPage") + 1;
							%>
							<c:forEach var="item" items="${ about }">
								<tr>
									<th>
										<div class="form-check">
											<input class="form-check-input" type="checkbox"
												name="ids[]" id="checkbox_${ item.id }"
												value="${ item.id }" />
										</div>
									</th>
									<td>
										<%
										out.print(i++);
										%>
									</td>
									<td style="max-width: 150px;overflow: hidden;">${ item.name }</td>
									<td style="
    flex: 1;
    width: 470px;
    height: 32px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
">${ item.description }</td>
									<td><c:url var="editURL" value="/admin-about">
											<c:param name="type" value="edit" />
											<c:param name="id" value="${ item.id }" />
										</c:url> <a class="btn btn-sm btn-primary btn-edit"
										data-toggle="tooltip" title="Cập nhật bài viết"
										href='${ editURL }' style="border-radius: 5px;"> <i
											class="fa fa-pencil-square-o" aria-hidden="true"></i>
									</a></td>
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
					href="<c:url value="/admin-about?type=list&index=${ i }" />">${ i }</a></li>
			</c:forEach>
			<li><a href="#" class="next fa fa-arrow-right"></a></li>
		</ul>
	</div>


	<script type="text/javascript">
		var checkAll = $("#checkbox-all");
		var itemCheckbox = $("input[name='ids[]']");
		var checkAllSubmitBtn = $(".check-all-submit-btn");
		
		checkAll.change(function() {
			var isCheckAll = $(this).prop("checked");
			itemCheckbox.prop("checked", isCheckAll);
			renderCheckAllSubmitBtn();
			
		})
		
		itemCheckbox.change(function() {
			var isCheckAll = itemCheckbox.length === $("input[name='ids[]']:checked").length;
			checkAll.prop("checked", isCheckAll);
			renderCheckAllSubmitBtn();
		})
		
		
		function renderCheckAllSubmitBtn() {
			var checkCount = $("input[name='ids[]']:checked").length;
			if(checkCount > 0){
				checkAllSubmitBtn.removeClass("check-all-submit-btn");
			} else {
				checkAllSubmitBtn.addClass("check-all-submit-btn");
			}
		}
	
	
		var pages = document.querySelectorAll(".page");
		pages[${page}].classList.add("active");

		if(${inext} <= ${ endP }){
			var next = document.querySelector(".next");
			next.addEventListener('click', function() {
				window.location.href = "<c:url value="/admin-about?type=list&index=${inext}" />";
			})
		}
		
		if(${page} > 0) {
			var prev = document.querySelector(".prev");
			prev.addEventListener('click', function() {
				window.location.href = "<c:url value="/admin-about?type=list&index=${page}" />";
			})
		}
		
		$("#btnDelete").click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();

			data['ids'] = ids;

			deleteAbout(data);

		});
		
		function deleteAbout(data) {
	        $.ajax({
	            url: "${APIurl}",
	            type: 'delete',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function(result) {
	                window.location.href = "${AboutURL}?type=list&index=${ pagecurr }&message=delete_success";
	            },
	            error: function(error) {
	                window.location.href = "${AboutURL}?type=list&index=${ pagecurr }&message=error_system";
	            },
	        });
		}


	</script>
</body>
</html>
