<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="${cp}">Home
						<span class="sr-only">(current)</span>
				</a></li>

				<%--  <li class="nav-item">
            <a class="nav-link" href="${cp}/manage/addCat">Add Category</a>
          </li> --%>

				<li class="nav-item"><a class="nav-link" href="#">About</a></li>

				<security:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="${cp}/register">Register</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${cp}/login">Login</a>
					</li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">

					<security:authorize access="hasAuthority('ROLE_ADMIN')">
						<li class="nav-item"><a class="nav-link"
							href="${cp}/manage/product">Manage Product</a></li>
					</security:authorize>

					<li  id="userModel"><a
						class="btn btn-default text-white" 
						id="dropdownMenu1"> ${user.firstName} ${user.lastName} </a></li>
						
					<li class="nav-item"><a class="nav-link"
						href="${cp}/logout">Logout</a></li>
					<security:authorize access="hasAuthority('USER')">
						<li class="nav-item"><a class="nav-link"
							href="${cp}/cart">View Cart</a></li>
					</security:authorize>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
