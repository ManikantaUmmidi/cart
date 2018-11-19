<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<style>
  .help-block{
    color:red;
  }
  .adminDataTableImg{
    height:50px;  
    width:50px;
  }

</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Online Shopping - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}/bootstrap-watch-style.css" rel="stylesheet">


</head>

<body>
	<div class="wrapper">


		<%@include file="shared/navbar.jsp"%>


		<div class="content">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@include file="aboutus.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="contactus.jsp"%>
			</c:if>

			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<c:if
				test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<c:if
				test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>

		</div>
		<%--   <%@include file="./shared/footer.jsp" %>
 --%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<%-- <script src="${js}/dataTables.bootstrap.js"></script> --%>
		<script src="${js}/bootbox.min.js" type="text/javascript"></script>
		<script src="${js}/myapp.js" type="text/javascript"></script>

	</div>
</body>

</html>
