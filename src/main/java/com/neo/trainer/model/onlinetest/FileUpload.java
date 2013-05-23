package com.neo.trainer.model.onlinetest;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.*;

import com.neo.trainer.serviceimp.helper.Upload;

public class FileUpload implements Upload {

	
	
	private CommonsMultipartFile fileData;

	  
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

   
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}


	
}
