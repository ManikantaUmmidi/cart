<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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


		<div class="col-md-8 offset-md-2">
			<div class="card">
				<div class="card bg-success text-white">
					<div class="card-header">Product Management</div>
				</div>
				<div class="card-body">
					<sf:form modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-4 col-form-label">Enter
								Product Name:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="name" path="name"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Enter
								Brand Name:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="brand"
									path="brand" placeholder="Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>


						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Product
								Description:</label>
							<div class="col-sm-8">
								<sf:textarea class="form-control" path="description" rows="5"
									id="comment" placeholder="Enter Description"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Enter
								Unit Price:</label>
							<div class="col-sm-8">
								<sf:input type="number" class="form-control" id="unitPrice"
									path="unitPrice" placeholder="Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Quantity
								Available:</label>
							<div class="col-sm-8">
								<sf:input type="number" class="form-control" id="quantity"
									path="quantity" placeholder="Enter Quantity" />
				
				
							</div>
						</div>
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Select Image </label>
							<div class="col-sm-8">
								<sf:input type="file" class="form-control" id="file"
									path="file" />
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Select
								Category:</label>
							<div class="col-sm-8">
								<sf:select class="form-control" path="categoryId" id="categoryId"
									items="${categories}" itemLabel="name" itemValue="id" />
								<!-- <em class="help-block">Please Select Category!</em> -->


								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>



						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">Sign in</button>
							</div>
						</div>
					</sf:form>


				</div>
				<div class="card-footer"></div>
			</div>



		</div>

	</div>

</div>