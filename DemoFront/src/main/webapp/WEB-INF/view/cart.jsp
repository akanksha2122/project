<div class="row">
	<div class="col-md-12">
		<table border="2px">
			<tr>
				<th></th>
				<th>Name</th>
				<th>Brand</th>
				<th>Description</th>
				<th>unitPrice</th>
				<th>Quantity</th>
				<th>Sub Total</th>
				<th></th>
			</tr>

			<c:forEach items="${listItems}" var="ci">
				<tr>
					<td><img src="${cp}/assets/images/${ci.product.code}.jpg"
						height="200px" width="200px"></td>
					<td>${ci.product.name}</td>
					<td>${ci.product.brand}</td>
					<td>${ci.product.description}</td>
					<td>${ci.buyingPrice}</td>
					
					<form action="${cp}/cart/update/${ci.id}">
					<td><input type="number" min="1" max="3" name="qty" value="${ci.productCount}" /></td>
					
					<td>${ci.total}</td>
					
					<td>
					<input type="submit" value="Update" class="btn btn-info"/>
					</form>
					<a href="${cp}/cart/delete/${ci.id}" class="btn btn-danger">Remove X</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">Grand Total</td>
				<td>Rs.${GT}/-</td>
			</tr>
		</table>
	</div>
</div>