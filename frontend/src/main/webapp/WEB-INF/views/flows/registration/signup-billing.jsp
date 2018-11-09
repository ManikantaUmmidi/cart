             <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
           
		      <%@include file="../shared/flow-header.jsp" %>
		       <div class="container">
		       
		           			<div class="card">
				<div class="card bg-success text-white">
					<div class="card-header">Sign Up - Address </div>
				</div>
				<div class="card-body">
					<sf:form modelAttribute="billing"
						id="registrationForm" method="POST">
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-4 col-form-label">Address Line1:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="addressLineOne" path="addressLineOne"
									placeholder="Enter Address Line1" />
								<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Address Line2:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="addressLineTwo"
									path="addressLineTwo" placeholder="Enter Address Line2" />
								<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">City</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="city"
									path="city" placeholder="Enter City" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Postal Code</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="postalCode"
									path="postalCode" placeholder="Enter Postal Code" />
								<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">State</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="state"
									path="state" placeholder="Enter State" />
								<sf:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Country</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="country"
									path="country" placeholder="Enter Country" />
								<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>
						

						<div class="form-group row">
							<div class="col-sm-10">
							    
							    <button type="submit" class="btn btn-primary" name="_eventId_personal">
								
								<i class="fa fa-chevron-circle-left"></i>Previous - Personal  
								</button>
							
							
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">
								
								Next - Confirm <i class="fa fa-chevron-circle-right"></i> 
								</button>
							</div>
						</div>
					</sf:form>


				</div>
				<div class="card-footer"></div>
			</div>
		       
		       
		       
		       
              </div>					
				<%@include file="../shared/flow-footer.jsp" %>