<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<form:form modelAttribute="user" action="${cp}/register" method="post" class="form-horizontal">
				<fieldset>

					<!-- Form Name -->
					<legend>Register</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="firstName">First
							Name</label>
						<div class="col-md-5">
							<form:input path="firstName" name="firstName" type="text"
								placeholder="First Name" class="form-control input-md"
								required=""/>

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="lastName">Last
							Name</label>
						<div class="col-md-5">
							<form:input path="lastName" name="lastName" type="text"
								placeholder="Last Name" class="form-control input-md"
								required=""/>

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="contactNumber">Contact
							Number</label>
						<div class="col-md-5">
							<form:input path="contactNumber" name="contactNumber" type="number"
								placeholder="Contact Number" class="form-control input-md"
								required=""/>

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="email">Email</label>
						<div class="col-md-5">
							<form:input path="email" name="email" type="email" placeholder="Email"
								class="form-control input-md" required=""/>

						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="password">Password
						</label>
						<div class="col-md-5">
							<form:password path="password" name="password" 
								placeholder="Password" class="form-control input-md" required=""/>

						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="confirmPassword">Confirm
							Password </label>
						<div class="col-md-5">
							<form:password path="confirmPassword" name="confirmPassword"
								placeholder="Confirm Password"
								class="form-control input-md" required=""/>

						</div>
					</div>

					<!-- Button (Double) -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="submit"></label>
						<div class="col-md-8">
							<button type="submit" name="submit" class="btn btn-success">Save</button>
							<button type="reset" name="reset" class="btn btn-danger">Cancel</button>
						</div>
					</div>

				</fieldset>
			</form:form>

		</div>
	</div>
</div>