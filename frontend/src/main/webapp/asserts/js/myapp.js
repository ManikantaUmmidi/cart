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
	
	
	// code for jquery data Table
	
	
	
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
	 
	 
	 // closing alert box
	 
	 var $alert = $('.alert');
	 if($alert.length)
		 {
		   setTimeout(function(){
			   
			   $alert.fadeOut("slow");
		   },3000)
		 
		 }
	 
	 // toggle button
	 
	
	 $(document).on('change',".switch input[type='checkbox']",function(){
		 
		 alert("working");
		 
		 var checkbox = $(this);
		 var checked = checkbox.prop('checked');
		 var dMsg = (checked)?'You Want to Active the Product':'You Want to Deactive The Product';
		 var value =checkbox.prop("value");
		 
		 bootbox.confirm({
			 
			 size:'medium',
			 title:'Product Active & DeActivate',
			 message:dMsg,
			 callback:function(confirmed){
				 
				 if(confirmed)
					 {
				 var activationUrl = window.contextRoot+'/manage/product/'+value+'/activation';
				 
				 $.post(activationUrl,function(data){
					 
					 bootbox.alert({
						 size:'medium',
						 title:'Information',
						 message:data
						 
					 });
					 
				 })
				 	 
				 }else{
					 
					 checkbox.prop('checked',!checked);
				 }
				 
			 }
			 
			 
		 })
		 
		 
		 
	 });
	 
            // --------------admin data table---------------//
	 
	 var $adminProductsTable = $("#adminProductsTable");
	 
	 if($adminProductsTable.length)
	 {
		 
		 var jsonUrl =window.contextRoot+'/json/data/admin/all/products';
		 console.log(jsonUrl);
		 
		
		 $adminProductsTable.DataTable({
			 
			lengthMenu:[[10,30,50,-1],["10 Records","30 Records","50 Records","ALL Records",]],
			pageLength:30,
			ajax:{
				url:jsonUrl,
				dataSrc:'',
			},
			columns:[
			         {
			        	data:'id' 
			         },
			         {
			        	data:'code',
			        	mRender: function(data,type,row){
			        		return '<img class="adminDataTableImg"  src="'+window.contextRoot+'/resources/images/'+data+'.jpg"/>';
			        		
			        	}
			         },
			                 
			         {
			        	  data:'name'
			         },
			         {
			        	  data:'brand'
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
			        	  data:'unitPrice',
			        	  mRender: function(data,type,row){
			        		  return '&#8377; '+data
			        	  }
			         },
			          {
			        	 data:'active',
			        	 bSortable:false,
			        	 mRender:function(data,type,row){
			        		 
			        		 var str='';
			        		 
                                 str +='<label class="switch">';
					         
                                 if(data)
                                	 {
                                	 str +='<input type="checkbox" checked="checked" value="'+row.id+'"/>';
                                	 }
                                 else
                                	 {
                                	 str +='<input type="checkbox" value="'+row.id+'"/>';
                                	 }
                                 
                                 
					         
					         str +='<div class="slider"></div>';
					      
					        str +='</label>';
			        		 
			        	
                                 return str;
			        	 }
					   
			        	 },
			        	 {
			        		 data:'id',
			        		 bSortable:false,
			        		 mRender:function(data,type,row){
			        			 
			        			 var str = '';
			        			 str +='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
								 str += '<i class="fa fa-pencil"></i></a>';
								 
								 return str;
					
									     
			        		 }
			        	 }
			        	 
			        	
			         ]
		 })
	 }
         
	 
     // validate category form
     
	 var $categoryForm = $("#categoryForm");
	 
	 if($categoryForm.length)
		 {
		 
		 $categoryForm.validate({
			 
			 rules :{
				 
				 name:{
					 
					 required:true,
					 minlength:2
				 },
				 description:{
					 required:true,
					 
				 }
				 
			 },
			 messages:{
				 
				 name:{
					 
					 required:'Please  Add the Category Name!',
					 minLength:'The Category Name Should not be less than 2 characters!'
				 },
				 description:{
					 
					 required:'Please Add Description for Category!'
				 }
			 },
			 errorElement:'em',
			 errorPlacement:function(error,element){
				 
				 error.addClass('help-block');
				 error.insertAfter(element);
			 }
			 
		 })
		 }
	 
	 } )

