             <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
           
		      <%@include file="../shared/flow-header.jsp" %>
		       <div class="container">
		       
		           			<div class="card">
				<div class="card bg-success text-white">
					<div class="card-header">User Registration</div>
				</div>
				<div class="card-body">
					<sf:form modelAttribute="user"
						id="registrationForm" method="POST">
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-4 col-form-label">Enter
								 FirstName:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="firstName" path="firstName"
									placeholder="Enter First Name" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">LastName:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="lastName"
									path="lastName" placeholder="Brand Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Email</label>
							<div class="col-sm-8">
								<sf:input type="email" class="form-control" id="email"
									path="email" placeholder="Enter Email" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>
						<fieldset class="form-group">
					    <div class="row">
					      <legend class="col-form-label col-sm-2 pt-0">Select Role</legend>
					      <div class="col-sm-10">
					        <div class="form-check">
					          <sf:radiobutton class="form-check-input"  path="role" id="role" value="USER" checked="checked"/>
					          <label class="form-check-label"  id="gridRadios">
					            USER
					          </label>
					        </div>
					        <div class="form-check"> 
					          <sf:radiobutton class="form-check-input"  path="role" id="role" value="SUPPLIER"/>
					          <label class="form-check-label" id="gridRadios">
					            SUPPLIER
					          </label>
					        </div>
					     
					      </div>
					    </div>
					  </fieldset>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Contact Number:</label>
							<div class="col-sm-8">
								<sf:input type="number" class="form-control" id="contactNumber"
									path="contactNumber" placeholder="Enter Contact Number" />
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>
						
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Password:</label>
							<div class="col-sm-8">
								<sf:input type="text" class="form-control" id="password"
									path="password" placeholder="Enter Password" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-4 col-form-label">Confirm Password:</label>
							<div class="col-sm-8">
								<sf:input type="password" class="form-control" id="confirmPassword"
									path="confirmPassword" placeholder="Re - Enter Password" />
								<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
							</div>
						</div>
						

						<div class="form-group row">
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary" name="_eventId_billing">
								
								Next - Billing <i class="fa fa-chevron-circle-right"></i> 
								</button>
							</div>
						</div>
					</sf:form>


				</div>
				<div class="card-footer"></div>
			</div>
		       
		       
		       
		       
              </div>					
				<%@include file="../shared/flow-footer.jsp" %>