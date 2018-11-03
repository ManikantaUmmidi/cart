package com.app.frontend.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "D:/shopCart/cart/frontend/src/main/webapp/asserts/images/";
	
	private static String REAL_PATH = "";
	
	public static void uploadFile(HttpServletRequest request,MultipartFile file,String code){
	
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
    if(!new File(ABS_PATH).exists())
    {
    	new File(ABS_PATH).mkdirs();
    	
    }
    
    if(!new File(REAL_PATH).exists())
    {
    	new File(REAL_PATH).mkdirs();
    }
    
    try {
		
    	file.transferTo(new File(REAL_PATH + code + ".jpg"));
    	file.transferTo(new File(ABS_PATH + code + ".jpg"));
    	
	} catch (Exception e) {
		// TODO: handle exception
	}
    
	}

}
