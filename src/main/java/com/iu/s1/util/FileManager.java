package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//File을 HDD에서 삭제
	public boolean fileDelete(String path, String fileName) throws Exception {
		File file = new File(path, fileName);
		
		//성공하면 true, 실패하면 false 리턴
		return  file.delete();
	}
	
   
 
   public String fileSave(MultipartFile multipartFile, String path) throws Exception {
     
      File file = new File(path);
  
      if(!file.exists()) {
         file.mkdirs();
      }
      
   
      String name = UUID.randomUUID().toString();

      name = name + "_" + multipartFile.getOriginalFilename();

   
      file = new File(file, name);
      
      FileCopyUtils.copy(multipartFile.getBytes(), file);
      
      return name;
   }

}
