package com.neo.trainer.serviceimp.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neo.trainer.model.demoApp.UploadDemoApp;

public class UploadFileHelper {
	

public static void uploadFile(Upload uploadDemoApp,String path,HttpServletRequest request)
{
	CommonsMultipartFile file = uploadDemoApp.getFileData();
    String fileName = null;  
    InputStream inputStream = null;
    OutputStream outputStream = null;
    if (file.getSize() > 0) {
            try { 
			        
            
            fileName = request.getRealPath("")+path; 
           
            outputStream = new FileOutputStream(fileName); 
           
            inputStream=file.getInputStream();
 
        	IOUtils.copy(inputStream,outputStream);
   
            outputStream.close();
            inputStream.close(); 
 
        	 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }


}


}
