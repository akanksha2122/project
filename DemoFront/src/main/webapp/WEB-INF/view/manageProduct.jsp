<div class="row">

	<div class="col-lg-12">

		


		<form:form class="form-horizontal" modelAttribute="product" action="${cp}/manage/${actionURL}" method="post" enctype="multipart/form-data">
			<fieldset>
				<form:hidden path="id"/>
				<!-- Form Name -->
				<legend>${title} Product</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name">Product
						Name</label>
					<div class="col-md-5">
						<form:input path="name" name="name" 
							placeholder="Product Name" class="form-control input-md"
							required=""/> <span class="help-block">Enter
							Product Name</span>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="brand">Product
						Brand</label>
					<div class="col-md-5">
						<form:input path="brand" name="brand" 
							placeholder="Product Brand" class="form-control input-md"
							required=""/> <span class="help-block">Enter
							Product Brand</span>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="unitPrice">Unit Price</label>
					<div class="col-md-5">
						<form:input path="unitPrice" name="unitPrice" 
							placeholder="Unit Price" class="form-control input-md"
							required=""/> <span class="help-block">Enter
							Unit Price</span>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="quantity">Quantity</label>
					<div class="col-md-5">
						<form:input path="quantity" name="quantity" 
							placeholder="Product Quantity" class="form-control input-md"
							required=""/> <span class="help-block">Enter
							Product Quantity</span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="quantity">Category</label>
					<div class="col-md-5">
					<form:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control input-md"></form:select>
						 <span class="help-block">Category</span>
					</div>
					<div class="col-md-3">
						<!-- Button trigger modal -->
						<button class="btn btn-primary" type="button" data-toggle="modal" data-target="#categoryModal">
  							Add Category
						</button>
					</div>
				</div>
				
				
				
				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="description">Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="description" name="description"></form:textarea>
					</div>
				</div>
				
				
              <!-- uploading files -->
                <div class="form-group">
                <label class="col-md-4 control-label" for="uploadfile" >UploadFile</label>
                <div class="col-md-8">
                <form:input type="file" path="file" class="form-control" />
                <span class="help-block"></span>
                </div>

</div>
				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-8">
						<button id="submit" type="submit" name="submit" class="btn btn-success">Submit</button>
						<button id="cancle" type="reset" name="cancle" class="btn btn-danger">Reset</button>
					</div>
				</div>

			</fieldset>
		</form:form>
		
		
		<table border="2px" >
		<tr>
			<th>Id</th>
			<th></th>
			<th>Name</th>
			<th>Brand</th>
			<th>Description</th>
			<th>unitPrice</th>
			<th>Quantity</th>
			<th>Active/De-active</th>
			<th>Action</th>
			
		</tr>
		
		<c:forEach items="${products}" var="product">
        		<tr>
			<td>${product.id}</td>
			<td><img src="${cp}/assets/images/${product.code}.jpg" height="200px" width="200px"></td>
			<td>${product.name}</td>
			<td>${product.brand}</td>
			<td>${product.description}</td>
			<td>${product.unitPrice}</td>
			<td>${product.quantity}</td>
			<td>${product.active}</td>
			<td>
			<a href="${cp}/manage/updateProduct/${product.id}">Edit</a>
			
			<c:if test="${product.active}">
				<a href="${cp}/manage/changeStatus/${product.id}">De-active</a>
			</c:if>
			<c:if test="${!product.active}">
				<a href="${cp}/manage/changeStatus/${product.id}">Active</a>
			</c:if>
			</td>
		</tr>
            </c:forEach>
		</table>
	</div>
	<!-- /.col-lg-12-->
	
	<!-- Modal -->

</div>
<div class="modal fade" id="categoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form class="form-horizontal" modelAttribute="category" action="${cp}/manage/addCat" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Add Category</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-6 control-label" for="name">Category
						Name</label>
					<div class="col-md-6">
						<form:input path="name" name="name" 
							placeholder="Category Name" class="form-control input-md"
							required=""/> <span class="help-block">Enter
							Category Name</span>
					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-6 control-label" for="description">Description</label>
					<div class="col-md-6">
						<form:textarea class="form-control" path="description" name="description"></form:textarea>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-6 control-label" for="submit"></label>
					<div class="col-md-12">
						<button id="submit" type="submit" name="submit" class="btn btn-success">Save</button>
						<button id="cancle" type="reset" data-dismiss="modal" name="cancle" class="btn btn-danger">Reset</button>
					</div>
				</div>

				</fieldset>
			</form:form>
      </div>
      
    </div>
  </div>
</div>

<!-- /.row -->			
