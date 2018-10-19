$(function(){
	
	switch(menu)
	{
	case 'About Us':
		$("#about").addClass("active");
		break;
	case 'Contact Us':
		$("#contact").addClass("active");
		break;
	case 'All Products':
		$("#listProducts").addClass("active");
		 $("#a_"+menu).addClass("active");
		break;
	case 'Home':
		$("#home").addClass("active");
		break;
	default:
		$("#listProducts").addClass("active");
	    $('#a_'+menu).addClass("active");
	    break;
	
	}
	
	
	//code for jquery data Table
	
	var products = [
	                ['1','ABC'],
	                ['2','FSA'],
	                ['3','RTS'],
	                ['4','DFC'],
	                ['5','GSD'],
	                ['6','NDF'],
	                ['7','FGS'],
	                ['8','VAD'],
	                ['9','JGG']
	               
	               ];
	
	 var $table = $("#productListTable");
	 
	 if($table.length)
	 {
		 
		 $table.DataTable({
			 
			lengthMenu:[[3,5,10,-1],["3 Records","5 Records","10 Records","ALL Records",]],
			pageLength:5,
			data: products
		 })
	 }
	 
	 
	
});
