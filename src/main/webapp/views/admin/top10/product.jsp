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

	<div style="
    padding: 80px 160px;
" class="">
		<% int i = 1; %>
		<c:forEach var="item" items="${ top10 }">
		<div style="
    background-color: #ffffffc4;
    color: #000;
    padding: 10px 30px;
    border-radius: 10px;
    display: flex;
    min-height: 110px;
    align-items: center;
    font-weight: 500;
    box-shadow: 0px 0px 2px #333;
    margin-bottom: 40px;
" class="">
			<div>
				<span>Top <%= i++ %></span>
				<img style="
    width: 70px;
    margin-left: 20px;
" src="<c:url value='/images/${ item.image }' />" alt="">
			</div>

			<div style="
    display: flex;
    flex-direction: column;
    margin: 0 40px;
    gap: 8px;
" class="">
				<span>${ item.name }</span>
				<span>Customer bought: ${ item.popularity }</span>
			</div>


		</div>
		</c:forEach>
	</div>

</body>
</html>