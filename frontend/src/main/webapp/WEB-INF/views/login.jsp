<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
             
             
              <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
       
        </div>
      </div>
    </nav>


		<div class="content">
		
		
		
<div class="container">

			<div class="row">
				<c:if test="${message ne null}">
					<div class="col-lg-12">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							${message}
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
		
					</div>
				</c:if>
				</div>
 

	<div class="row">

		<div class="col-md-8 offset-md-2">
			<div class="card">
				<div class="card bg-success text-white">
					<div class="card-header">login</div>
				</div>
				<div class="card-body">
					<form id="loginForm"
						action="${contextRoot}/login" method="POST">
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-4 col-form-label">UserName:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="username" name="username"
									placeholder="Enter User Name" />
								<em id="username" class="help-block"></em> 
								
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Password:</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Enter Password" />
									
									
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								<em id="password" class="help-block"></em> 
							</div>
						</div>

						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">Sign in</button>
							</div>
						</div>
					</form>


				</div>
				<div class="card-footer"></div>
			</div>



		</div>

	</div>


</div>
		
		

		</div>
		<%--   <%@include file="./shared/footer.jsp" %>
 --%>
		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js" type="text/javascript"></script>

	</div>
</body>

</html>
