package com.akku.DemoFront.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private static final String ABS_PATH="C:/Users/hp/eclipse-workspace/DemoFront/src/main/webapp/assets/images/";
    private static String REAL_PATH=null;
    
    public static boolean uploadFile(HttpServletRequest request,MultipartFile file,String code) {
    	REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
    	
    	//create the directories if it does not exit
    	
    	if(!new File(REAL_PATH).exists()) {
    		new File(REAL_PATH).mkdirs();
    	}
    	
    	if(!new File(ABS_PATH).exists()) {
    		new File(ABS_PATH).mkdirs();
    	}
    	try {
    		//transfer the file to both the location
    		
    		file.transferTo(new File(REAL_PATH+code+".jpg"));
    		file.transferTo(new File(ABS_PATH+code+".jpg"));
    	}
    	catch(IOException ex) {
    		ex.printStackTrace();
    	}
    	return true;
    }
}
