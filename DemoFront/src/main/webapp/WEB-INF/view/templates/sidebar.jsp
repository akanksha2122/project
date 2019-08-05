<div class="col-lg-3">

        <h1 class="my-4">Shop Name</h1>
        <div class="list-group">
        <a href="${cp}/category/All" class="list-group-item">All</a>
		  <c:forEach items="${categories}" var="category">
          <a href="${cp}/category/${category.id}/products" class="list-group-item">${category.name}</a>
		  </c:forEach>
        </div>

</div>
      