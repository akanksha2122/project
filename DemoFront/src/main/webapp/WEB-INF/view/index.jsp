<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<c:set var="cp" value="${pageContext.request.contextPath}"/>
  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="${cp}/assets/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${cp}/assets/css/shop-homepage.css" rel="stylesheet">

</head>

<body ng-app="myApp">
 <%@include file="templates/header.jsp" %>
  <!-- Page Content -->
  <div class="container" style="margin-bottom:60px;margin-top:60px;">
  
	<c:if test="${userClickedHome==true}">
		<%@include file="Home.jsp" %>
	</c:if>
   <%--  <c:if test="${userClickedAddCat==true}">
		<%@include file="addCategory.jsp" %>
	</c:if> --%>
    
      <c:if test="${userClickedManageProd==true}">
		<%@include file="manageProduct.jsp" %>
	</c:if>
<c:if test="${userClickedRegister==true}">
        <%@include file="personalInfo.jsp" %>
</c:if>
<c:if test="${userClickedSaveUser==true}">
        <%@include file="addressDetails.jsp" %>
</c:if>
<c:if test="${userClickedLogin==true}">
        <%@include file="login.jsp" %>
</c:if>

<c:if test="${userClickedViewCart==true}">
        <%@include file="cart.jsp" %>
</c:if>

  <!-- /.container -->

 <%@include file="templates/footer.jsp" %> 

  <!-- Bootstrap core JavaScript -->
  <script src="${cp}/assets/js/jquery-3.3.1.slim.min.js"></script>
  <script src="${cp}/assets/js/popper.min.js"></script>
  <script src="${cp}/assets/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
  <script src="${cp}/assets/js/myApp.js"></script>
</body>

</html>
