
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@include file="../shared/flow-header.jsp"%>

<div class="container">
<div class="row">

	<div class="col-md-6">

		<div class="card">
			<div class="card bg-success text-white">
				<div class="card-header">Personal Details</div>
			</div>
			<div class="card-body">
			
			   <div class="text-center">
			     <h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
			     <h5>Email :${registerModel.user.email}</h5>
			     <h5>Contact Number :${registerModel.user.contactNumber}</h5>
			     <h5>Role :${registerModel.user.role}</h5>
			   
			   </div>
			
			</div>
			<div class="card-footer">
			   <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Personal</a>
			</div>
		</div>
	</div>

	<div class="col-md-6">
		<div class="card">
			<div class="card bg-success text-white">
				<div class="card-header">Billing Address</div>
			</div>
			<div class="card-body">
			      
			        <div class="text-center">
			     <h4>${registerModel.billing.addressLineOne}</h4>
			     <h4>${registerModel.billing.addressLineTwo}</h4>
			     <h4>${registerModel.billing.addressLineOne}</h4>
			     <h4>${registerModel.billing.city} - ${registerModel.billing.postalCode}</h4>
			     <h4>${registerModel.billing.state} - ${registerModel.billing.country}</h4>
			
			   </div>
			
			
			
			</div>
			<div class="card-footer">
			
			<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Billing</a>
			</div>
		</div>
	</div>
	</div>
	
	<div class="container">
	<div class="row">
	
	   <div class="col-auto ml-1">
	   
	       <div class="text-center">
	       
	       <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary mr-2">Confirm</a>
	       
	       </div>
	   
	   </div>
	</div>
	</div>
	
	<%@include file="../shared/flow-footer.jsp" %>







</div>
