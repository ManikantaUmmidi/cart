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
	case 'Manage Products':
		$("#manageProducts").addClass("active");
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
	
	
	
	 var $table = $("#productListTable");
	 
	 if($table.length)
	 {
		 
		 var jsonUrl = '';
		 
		 if(window.categoryId == '')
			 {
			 jsonUrl = window.contextRoot +"/json/data/all/products";
			 }
		 else
			 {
			 jsonUrl = window.contextRoot+"/json/data/category/"+window.categoryId+"/products";
			 }
		 
		 $table.DataTable({
			 
			lengthMenu:[[3,5,10,-1],["3 Records","5 Records","10 Records","ALL Records",]],
			pageLength:5,
			ajax:{
				url:jsonUrl,
				dataSrc:'',
			},
			columns:[
			         
			         {
			        	data:'code',
			        	mRender: function(data,type,row){
			        		return '<img class="dataTableImg" style="width:100px;height:100px;" src="'+window.contextRoot+'/resources/images/'+data+'.jpg"/>';
			        		
			        	}
			         },
			                 
			         {
			        	  data:'name'
			         },
			         {
			        	  data:'brand'
			         },
			         {
			        	  data:'unitPrice',
			        	  mRender: function(data,type,row){
			        		  return '&#8377; '+data
			        	  }
			         },
			         {
			        	  data:'quantity',
			        	  mRender: function(data, type, row){
			        		  if(data < 1)
			        			  {
			        			  
			        			    return '<span style="color:red">Out of Stoke!</span>';
			        			  }
			        		  return data;
			        	  }
			         },
			         {
			        	 data:'id',
			        	 mRender:function(data,type,row){
			        		 var str = '';
			        		 
			        		 if(row.quantity < 1)
			        			 {
			        			 str +='<a href="javascript:void(0)" class="btn btn-success disabled"><i class="fa fa-shopping-cart"></i></a>';
			        			 }
			        		 else
			        			 {
			        			 str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><i class="fa fa-shopping-cart"></i></a>';
			        			 }
			        		 str +='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><i class="fa fa-eye"></i></a>&nbsp;';
			        		 return str;
			        	 }
			         }
			         ]
		 })
	 }
	 
	 
	 
	 //closing alert box
	 
	 var $alert = $('.alert');
	 if($alert.length)
		 {
		   setTimeout(function(){
			   
			   $alert.fadeOut("slow");
		   },3000)
		 
		 }
	 
	
});
